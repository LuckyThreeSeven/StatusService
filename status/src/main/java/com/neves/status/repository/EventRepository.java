package com.neves.status.repository;

import com.neves.status.repository.aggregate.AggregateType;
import java.util.List;

public interface EventRepository {

	/**
	 * 이벤트를 저장하고 저장한 이벤트를 반환
	 */
	EventEntity save(EventEntity entity);

	/**
	 * 이벤트 ID로 이벤트 조회
	 */
	EventEntity findById(String id);

	/**
	 * 특정 애그리게이트의 id에 해당하는 모든 이벤트 조회
	 */
	List<EventEntity> findByAggregateId(String aggregateId, AggregateType type);

	/**
	 * 특정 애그리게이트의 id에 해당하는 이벤트 중 특정 버전 이후의 이벤트 조회
	 * afterVersion을 포함하지 않음
	 */
	List<EventEntity> findByAggregateIdAfterVersion(String aggregateId, AggregateType type, Long afterVersion);
}
