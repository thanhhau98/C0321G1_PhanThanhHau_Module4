package com.codegym.sp_jpa.model.repository;

import com.codegym.sp_jpa.model.bean.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ICustomerRepository extends JpaRepository<Customer,Long> {


    @Query(value = "{call Insert_Customer(:firstName,:lastName)}" , nativeQuery = true)
    void saveBySp (@Param("firstName") String firstName , @Param("lastName") String lastName );
}
