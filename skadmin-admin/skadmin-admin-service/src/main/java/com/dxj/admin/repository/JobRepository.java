package com.dxj.admin.repository;

import com.dxj.admin.domain.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
* @author dxj
* @date 2019-03-29
*/
public interface JobRepository extends JpaRepository<Job, Long>, JpaSpecificationExecutor<Job> {
}
