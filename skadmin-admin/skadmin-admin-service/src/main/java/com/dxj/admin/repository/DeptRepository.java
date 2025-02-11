package com.dxj.admin.repository;

import com.dxj.admin.domain.Dept;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Set;

/**
 * @author dxj
 * @date 2019-03-25
 */
public interface DeptRepository extends JpaRepository<Dept, Long>, JpaSpecificationExecutor<Dept> {

    /**
     * findByPid
     *
     * @param id
     * @return
     */
    List<Dept> findByPid(Long id);

    @Query(value = "select name from dept where id = ?1", nativeQuery = true)
    String findNameById(Long id);

    Set<Dept> findByRoles_Id(Long id);

}
