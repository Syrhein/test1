package com.smhrd.src.repository;

import com.smhrd.src.entity.UserInterest;
import com.smhrd.src.entity.UserInterestId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserInterestRepository extends JpaRepository<UserInterest, UserInterestId> {
    // 기본 CRUD 지원
}