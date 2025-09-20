package com.neves.status.repository.jpa;

import com.neves.status.repository.aggregate.AggregateType;
import com.neves.status.repository.EventEntity;
import com.neves.status.repository.EventRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;

/**
 * EventJpaRepository를 사용하여 EventRepository를 구현하는 어댑터
 */
@RequiredArgsConstructor
public class EventRepositoryJpaAdapter implements EventRepository {
	// TODO:
	private final EventJpaRepository jpaRepository;

	@Override
	public EventEntity save(EventEntity entity) {
		return null;
	}

	@Override
	public EventEntity findById(String id) {
		return null;
	}

	@Override
	public List<EventEntity> findByAggregateId(String aggregateId, AggregateType type) {
		return List.of();
	}

	@Override
	public List<EventEntity> findByAggregateIdAfterVersion(String aggregateId,
			AggregateType type, Long afterVersion) {
		return List.of();
	}
}
