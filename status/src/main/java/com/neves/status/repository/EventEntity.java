package com.neves.status.repository;

import com.neves.status.repository.aggregate.AggregateType;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;
import lombok.Getter;

/**
 * 경쟁 상태(Race Condition) 방지를 위한 <strong>낙관적 동시성 제어(Optimistic Concurrency Control)</strong> 전략입니다.
 * <p>
 * 이 전략은 여러 요청이 동시에 같은 어그리거트(Aggregate)를 수정하려고 할 때,
 * 데이터 무결성을 보장하며 오직 하나의 요청만 성공하도록 만듭니다.
 *
 * <h3>동작 방식</h3>
 * <ol>
 * <li>어그리거트의 마지막 버전(<code>version</code>)을 기반으로 현재 상태를 불러옵니다.</li>
 * <li>새 이벤트는 '마지막 버전 + 1'을 다음 버전으로 하여 생성됩니다.</li>
 * <li>
 * 데이터베이스 테이블의 <code>(aggregateId, version)</code> 조합에 걸린 <strong>UNIQUE 제약 조건</strong>이
 * 잠금(Lock) 메커니즘의 핵심 역할을 수행합니다.
 *
 * </li>
 * <li>이벤트를 저장할 때, 해당 버전의 이벤트를 가장 먼저 저장하는 요청만 성공합니다.</li>
 * <li>
 * 그 이후에 동일한 버전으로 저장을 시도하는 다른 모든 요청은 DB의 UNIQUE 제약 조건 위반으로
 * 실패하며, <code>DataIntegrityViolationException</code> 같은 예외를 발생시킵니다.
 * </li>
 * <li>
 * 이 실패는 "내가 작업을 처리하는 동안 다른 요청이 먼저 상태를 변경했다"는 신호이며,
 * 해당 작업은 처음부터 <strong>다시 재시도(retry)</strong>되어야 합니다.
 * </li>
 * </ol>
 */
@Getter
public class EventEntity {
	/** Event Id */
	private UUID id;
	private String aggregateId;
	private AggregateType type;
	private LocalDateTime createdAt;
	private Map<String, Object> payload;
	/** for Optimistic Locking */
	private Long version;
}
