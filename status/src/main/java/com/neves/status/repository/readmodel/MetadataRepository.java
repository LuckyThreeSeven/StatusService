package com.neves.status.repository.readmodel;

import com.neves.status.repository.aggregate.Metadata;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MetadataRepository extends JpaRepository<Metadata, String> {

}
