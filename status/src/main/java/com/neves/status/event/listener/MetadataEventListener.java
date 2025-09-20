package com.neves.status.event.listener;

import com.neves.status.event.domain.MetadataCreatedEvent;
import com.neves.status.event.domain.MetadataDeletedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

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
