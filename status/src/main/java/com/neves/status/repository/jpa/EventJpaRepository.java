package com.neves.status.repository.jpa;

import com.neves.status.repository.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 프록시로 구현될 실제 JPA Repository
 */
public interface EventJpaRepository extends JpaRepository<EventEntity, Long> {
	//TODO:
}
