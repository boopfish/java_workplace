package com.fisher.service.impl;

import com.fisher.service.MessageService;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description
 * @Author fisher
 * @Date 2021-02-24 10:21
 */

public class MessageServiceImpl implements MessageService {
	@Override
	@Transactional
	public String getMessage() {
		return "Hello World";
	}
}
