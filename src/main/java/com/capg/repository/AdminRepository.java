package com.capg.repository;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.capg.entity.Admin;
public interface AdminRepository extends JpaRepository<Admin,Integer> {


}
