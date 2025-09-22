package com.neves.status.service;

import com.neves.status.controller.dto.blackbox.MetadataRegisterRequest;
import com.neves.status.controller.dto.metadata.MetadataResponse;
import com.neves.status.repository.Metadata;
import com.neves.status.repository.MetadataRepository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MetadataService {
	private final MetadataRepository repository;

	public void create(UUID metadataId, MetadataRegisterRequest request) {
		Metadata metadata = Metadata.builder()
				.id(metadataId.toString())
				.blackboxUuid(request.getBlackboxUuid())
				.streamStartedAt(request.getStreamStartedAt())
				.createdAt(request.getCreatedAt())
				.fileSize(request.getFileSize())
				.duration(request.getDuration())
				.objectKey(request.getObjectKey())
				.fileType(request.getFileType())
				.build();
		repository.save(metadata);
	}

	public List<MetadataResponse> list(String blackboxId, LocalDateTime startOfDay) {
		LocalDateTime endOfDay = startOfDay.plusDays(1);
		List<Metadata> metadataList = repository.findMetadataByBlackboxUuidAndCreatedAtBetween(
				blackboxId,
				startOfDay,
				endOfDay
		);
		return metadataList.stream()
				.map(data -> MetadataResponse.builder()
						.objectKey(data.getObjectKey())
						.duration(data.getDuration())
						.createdAt(data.getCreatedAt())
						.fileSize(data.getFileSize())
						.fileType(data.getFileType()).build()
				).toList();
	}

	public void delete(String metadataId) {
		repository.deleteById(metadataId);
	}
}
