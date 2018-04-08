package com.ynshun.log;

import java.util.HashMap;
import java.util.Map;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.AppenderBase;
import net.sf.json.JSONObject;

public class ActiveMQAppender extends AppenderBase<ILoggingEvent> {
	// 是否已经实例化
	private static boolean inited = false;

	private String service_id = "MyAPP";
	private String disname = "ynshun.log.collect.quene";
	private String username;
	private String password;
	private String broken_url = "tcp://192.168.72.129:61616";

	// 链接工厂
	private static ConnectionFactory connectionFactory;
	// 链接对象
	private static Connection connection;
	// 事务管理
	private static Session session;
	// 消息生产者
	private static MessageProducer messageProducer;

	@Override
	protected void append(ILoggingEvent arg0) {
		StackTraceElement stackTraceElement = arg0.getCallerData()[0];
		
		Map<String, Object> message = new HashMap<String, Object>();
		
		message.put("from_host", null);
		message.put("service_id", this.service_id);
		message.put("thread_name", arg0.getThreadName());
		message.put("level", arg0.getLevel().levelStr);
		message.put("message", arg0.getMessage());
		message.put("formatted_message", arg0.getFormattedMessage());
		message.put("logger_name", arg0.getLoggerName());
		message.put("class_name", arg0.getThrowableProxy() == null ? null : arg0.getThrowableProxy().getClassName());
		message.put("throwable_message", arg0.getThrowableProxy() == null ? null : arg0.getThrowableProxy().getClassName());
		message.put("time_stamp", arg0.getTimeStamp());
		message.put("declaring_class", stackTraceElement.getClassName());
		message.put("line_number", stackTraceElement.getLineNumber());
		message.put("file_name", stackTraceElement.getFileName());
		message.put("method_name", stackTraceElement.getMethodName());

		this.sendMessage(JSONObject.fromObject(message).toString());
	}

	public void init() {
		try {
			// 创建一个链接工厂
			connectionFactory = new ActiveMQConnectionFactory(username, password, broken_url);
			// 从工厂中创建一个链接
			connection = connectionFactory.createConnection();
			// 开启链接
			connection.start();
			// 创建一个事务（这里通过参数可以设置事务的级别）
			session = connection.createSession(true, Session.SESSION_TRANSACTED);
			// 创建通道
			Queue queue = session.createQueue(disname);
			// 创建消息生产者
			messageProducer = session.createProducer(queue);
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

	public void sendMessage(String message) {
		try {
			if (!inited) {
				init();
				inited = true;
			}
			messageProducer.send(session.createTextMessage(message));
			session.commit();
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

	public void setDisname(String disname) {
		this.disname = disname;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setBroken_url(String broken_url) {
		this.broken_url = broken_url;
	}

	public void setService_id(String service_id) {
		this.service_id = service_id;
	}

}
