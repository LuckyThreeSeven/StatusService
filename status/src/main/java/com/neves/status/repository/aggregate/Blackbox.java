package com.neves.status.repository.aggregate;

import com.neves.status.repository.EventEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

/**
 * Aggregate root for Blackbox entities.
 */
@Entity
public class Blackbox {
	@Id private String id;
	// TODO:
	public void apply(EventEntity entity) {
		// TODO:
	}
}
