package com.msdn.orm.hresh.repository;

import com.msdn.orm.hresh.model.SubUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface SubUserRepository extends JpaRepository<SubUser, Long>, JpaSpecificationExecutor<SubUser> {

}
