package com.example.workshop_spring.repository;
/*
 *  @author diemdz
 */

import com.example.workshop_spring.entity.Hang_SanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface HangSpRepo extends JpaRepository<Hang_SanPham,Long> {
    @Transactional
    @Modifying
    @Query(value = "select sp from Hang_SanPham sp where sp.sanPham.id = ?1")
    List<Hang_SanPham> findByIdSinhVien(Long id);
}
