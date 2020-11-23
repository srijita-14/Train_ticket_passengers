package com.areteans.ticketbooking.repository;

import com.areteans.ticketbooking.models.PassengerJPA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface PassengerRepository extends JpaRepository<PassengerJPA, Long> {
    Optional<PassengerJPA> deletePassengerByID(Long id);

   /* @Query("update Employee set address=$address where employeeID=$id")
    @Modifying
    @Transactional
    int updateAddress(@Param("id") Long id, @Param("address") String address);*/
}

