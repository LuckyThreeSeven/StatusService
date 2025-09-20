package com.neves.status.repository.aggregate;

import com.neves.status.repository.EventEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.util.List;

/**
 * Aggregate root for Metadata entities.
 */
@Entity
public class Metadata implements Aggregate {
	@Id private String id;

	@Override public void apply(List<EventEntity> event) {

	}
	// TODO:
}
