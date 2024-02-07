package com.kartheek.hospital.user.repository;

import com.kartheek.hospital.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
