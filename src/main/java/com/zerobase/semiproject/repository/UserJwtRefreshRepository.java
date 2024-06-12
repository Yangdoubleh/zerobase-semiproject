package com.zerobase.semiproject.repository;

import com.zerobase.semiproject.entity.UserJwtRefreshEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserJwtRefreshRepository extends JpaRepository<UserJwtRefreshEntity, Long> {
}
