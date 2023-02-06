package com.gmail.dmitryzin.rudata.rudatadb.repository;

import com.gmail.dmitryzin.rudata.rudatadb.entity.RequiredSecurity;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface RequiredSecurityRepository extends CrudRepository<RequiredSecurity, Integer> {
    @Modifying
    @Query("""
            call rudata.required_security_save(:dto)
            """)
    void saveRequiredSecurityFromDto(@Param("dto") String dto);

    @Modifying
    @Query("""
            call rudata.required_security_delete(:isin)
            """)
    void deleteIsin(@Param("isin") String isin);

    @Query("""
        select * from rudata.required_security_get(:isin)
        """)
    Optional<List<RequiredSecurity>> getByIsin(@Param("isin") String isin);

    @Query("""
        select * from rudata.required_security_get_paginated(:page_num, :page_count)
        """)
    Optional<List<RequiredSecurity>> getByPageNum(@Param("page_num") int page_num, @Param("page_count") int page_count);

}
