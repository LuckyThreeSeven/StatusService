package com.neves.status.event.listener;


import com.neves.status.event.domain.BlackboxCreatedEvent;
import com.neves.status.event.domain.BlackboxRenamedEvent;
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
