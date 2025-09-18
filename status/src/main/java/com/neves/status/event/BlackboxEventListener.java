package com.neves.status.event;


import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class BlackboxEventListener {
	@EventListener
	public void handleCreatedEvent(BlackboxCreatedEvent e) {

	}

	@EventListener
	public void handleDeletedEvent(BlackboxRenamedEvent e) {

	}
}
