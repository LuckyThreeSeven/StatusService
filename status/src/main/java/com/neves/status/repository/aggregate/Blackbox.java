package com.neves.status.repository.aggregate;

import com.neves.status.repository.EventEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.util.List;

/**
 * Aggregate root for Blackbox entities.
 */
@Entity
public class Blackbox implements Aggregate {
	@Id private String id;
	// TODO:
	@Override public void apply(List<EventEntity> event) {

	}
}
