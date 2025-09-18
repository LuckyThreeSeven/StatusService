package com.neves.status.event;

import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class BlackboxEventListener {
	@EventListener
	public void handleRegisteredEvent(BlackboxRegisteredEvent e) {

	}

	@EventListener
	public void handleUpdatedEvent(BlackboxUpdatedEvent e) {

	}
}
