package com.neves.status.service;

import com.neves.status.repository.EventRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class BlackboxService {
	private final ApplicationEventPublisher publisher;
	private final EventRepository repository;

}
