package com.neves.status.service;

import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class BlackboxService {
	private final ApplicationEventPublisher publisher;

}
