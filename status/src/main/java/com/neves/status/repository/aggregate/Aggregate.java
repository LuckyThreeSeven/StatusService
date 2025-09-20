package com.neves.status.repository.aggregate;

import com.neves.status.repository.EventEntity;
import java.util.List;

public interface Aggregate {
	void apply(List<EventEntity> event);
}
