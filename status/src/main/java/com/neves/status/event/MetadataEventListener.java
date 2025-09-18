package com.neves.status.event;

import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Component
public class MetadataEventListener {
	@Async @EventListener
	public void handleCreatedEvent(MetadataCreatedEvent e) {

	}

	@EventListener
	public void handleDeletedEvent(MetadataDeletedEvent e) {

	}
}
