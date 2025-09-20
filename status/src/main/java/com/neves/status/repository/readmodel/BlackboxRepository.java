package com.neves.status.repository.readmodel;

import com.neves.status.repository.aggregate.Blackbox;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlackboxRepository extends JpaRepository<Blackbox, String> {

}
