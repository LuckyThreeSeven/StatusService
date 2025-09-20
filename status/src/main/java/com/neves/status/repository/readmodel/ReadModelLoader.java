package com.neves.status.repository.readmodel;

import com.neves.status.repository.EventRepository;
import com.neves.status.repository.aggregate.Aggregate;
import com.neves.status.repository.aggregate.Blackbox;
import com.neves.status.repository.aggregate.Metadata;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ReadModelLoader {
	private final EventRepository repository;
	private final BlackboxRepository blackboxRepository;
	private final MetadataRepository metadataRepository;

	public <T extends Aggregate> T load(Class<T> clazz, String aggregateId, Long version) {
		if (clazz.equals(Blackbox.class)) {
			return clazz.cast(loadBlackbox(aggregateId, version));
		} else if (clazz.equals(Metadata.class)) {
			return clazz.cast(loadMetadata(aggregateId, version));
		}
		throw new IllegalArgumentException("Unknown aggregate class: " + clazz);
	}
	private Blackbox loadBlackbox(String aggregateId, Long version) {
		Blackbox blackbox = blackboxRepository.findById(aggregateId).orElse(null);
		return null;
	}

	private Metadata loadMetadata(String aggregateId, Long version) {
		// TODO:
		return null;
	}

}
