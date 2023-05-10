package com.example.workshop_spring.repository;

import com.example.workshop_spring.entity.Hang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/*
 *  @author diemdz
 */
@Repository
public interface HangRepo extends JpaRepository<Hang,Long> {
    @Transactional
    @Modifying
    @Query("UPDATE Hang hang set hang.tenHang =?1 where hang.id =?2")
    void updatehang(String tenHang,Long id);
}
