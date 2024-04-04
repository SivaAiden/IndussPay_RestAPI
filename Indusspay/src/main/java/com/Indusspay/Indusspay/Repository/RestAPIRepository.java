package com.Indusspay.Indusspay.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Indusspay.Indusspay.Entity.RestAPIEntity;

@Repository
public interface RestAPIRepository extends JpaRepository<RestAPIEntity, Long> {

	@Query("SELECT t FROM RestAPIEntity t WHERE t.amount BETWEEN :initialRange AND :finalRange")
    List<RestAPIEntity> findByAmountBetween(Float initialRange, Float finalRange);
}
