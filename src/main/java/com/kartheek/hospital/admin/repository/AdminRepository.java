package com.kartheek.hospital.admin.repository;

import com.kartheek.hospital.admin.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository  extends JpaRepository<Admin, Long> {
}
