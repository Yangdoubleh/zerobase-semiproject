package com.zerobase.semiproject.repository;

import com.zerobase.semiproject.entity.UserPwdEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPwdRepository extends JpaRepository<UserPwdEntity, Long> {
}
