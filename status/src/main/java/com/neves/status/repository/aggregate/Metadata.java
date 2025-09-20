package com.neves.status.repository.aggregate;

import com.neves.status.repository.EventEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

/**
 * Aggregate root for Metadata entities.
 */
@Entity
public class Metadata {
	@Id private String id;
	// TODO:
	public void apply(EventEntity entity) {

	}
}
