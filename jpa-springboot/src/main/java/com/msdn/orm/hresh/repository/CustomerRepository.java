package com.msdn.orm.hresh.repository;

import com.msdn.orm.hresh.model.Customer;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>,
    JpaSpecificationExecutor<Customer> {

  @Modifying
  @Query(value = "update customer set age = :age where name = :name and del_flag=0", nativeQuery = true)
  void updateByName(@Param("name") String name, @Param("age") int age);

  Customer findByName(String name);

  @Override
  @EntityGraph(
      attributePaths = {"subUsers"}
  )
  List<Customer> findAll(Specification<Customer> spec);

  @Override
  @EntityGraph(
      attributePaths = {"subUsers"}
  )
  Page<Customer> findAll(Specification<Customer> spec, Pageable pageable);

  @Override
  @EntityGraph(
      attributePaths = {"subUsers"}
  )
  List<Customer> findAll(Specification<Customer> spec, Sort sort);
}
