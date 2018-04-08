package com.ynshun.config.mq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.ynshun.config.websocket.WsPool;
import com.ynshun.domain.LogMessage;
import com.ynshun.service.ILogMessageService;

import net.sf.json.JSONObject;


@Component
public class Receiver {
	@Autowired
	private ILogMessageService logMessageService;

	@JmsListener(destination = "sms.topic.message", containerFactory = "jmsListenerContainerTopic") // 监听指定消息主题
	public void receiveTopic(String message) {
		System.err.println("接受到Topic消息: " + message);
	}

	@JmsListener(destination = "sms.queue.message", containerFactory = "jmsListenerContainerQueue") // 监听指定消息主题
	public void receiveQueue(String message) {
		WsPool.sendMessageToAll(message);
		
		JSONObject jsonObject = JSONObject.fromObject(message);
		
		LogMessage logMessage = (LogMessage) JSONObject.toBean(jsonObject, LogMessage.class);
		
		logMessageService.insert(logMessage);
		
	}

}