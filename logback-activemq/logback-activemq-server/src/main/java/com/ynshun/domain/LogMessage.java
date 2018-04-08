package com.ynshun.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "log_message")
public class LogMessage implements Serializable {
	private static final long serialVersionUID = -4145468040051676108L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "Mysql")
	private Integer id;
	private String from_host;
	private String service_id;
	private Date time_stamp;
	private String formatted_message;
	private String level;
	private String message;
	private String logger_name;
	private String thread_name;
	private String file_name;
	private int line_number;
	private String class_name;
	private String declaring_class;
	private String throwable_message;

	private String method_name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFrom_host() {
		return from_host;
	}

	public void setFrom_host(String from_host) {
		this.from_host = from_host;
	}

	public String getService_id() {
		return service_id;
	}

	public void setService_id(String service_id) {
		this.service_id = service_id;
	}

	public String getThread_name() {
		return thread_name;
	}

	public void setThread_name(String thread_name) {
		this.thread_name = thread_name;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getFormatted_message() {
		return formatted_message;
	}

	public void setFormatted_message(String formatted_message) {
		this.formatted_message = formatted_message;
	}

	public String getLogger_name() {
		return logger_name;
	}

	public void setLogger_name(String logger_name) {
		this.logger_name = logger_name;
	}

	public String getClass_name() {
		return class_name;
	}

	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}

	public String getThrowable_message() {
		return throwable_message;
	}

	public void setThrowable_message(String throwable_message) {
		this.throwable_message = throwable_message;
	}

	public Date getTime_stamp() {
		return time_stamp;
	}

	public void setTime_stamp(Date time_stamp) {
		this.time_stamp = time_stamp;
	}

	public int getLine_number() {
		return line_number;
	}

	public void setLine_number(int line_number) {
		this.line_number = line_number;
	}

	public String getFile_name() {
		return file_name;
	}

	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}

	public String getMethod_name() {
		return method_name;
	}

	public void setMethod_name(String method_name) {
		this.method_name = method_name;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDeclaring_class() {
		return declaring_class;
	}

	public void setDeclaring_class(String declaring_class) {
		this.declaring_class = declaring_class;
	}

}
