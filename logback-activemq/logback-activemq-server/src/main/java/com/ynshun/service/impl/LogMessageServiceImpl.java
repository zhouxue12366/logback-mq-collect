package com.ynshun.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ynshun.config.base.service.BaseService;
import com.ynshun.domain.LogMessage;
import com.ynshun.service.ILogMessageService;

@Service
@Transactional
public class LogMessageServiceImpl extends BaseService<LogMessage> implements ILogMessageService {

}
