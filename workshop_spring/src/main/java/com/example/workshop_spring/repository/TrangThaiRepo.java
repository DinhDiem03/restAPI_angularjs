package com.example.workshop_spring.repository;


import com.example.workshop_spring.entity.TrangThai;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/*
 *  @author diemdz
 */
@Repository
public interface TrangThaiRepo extends JpaRepository<TrangThai,Long> {
    @Transactional
    @Modifying
    @Query("update TrangThai tt set tt.tenTrangThai =?1 where tt.id=?2")
    void updateTrangThai(String tenTrangThai,Long id);
    @Transactional
    @Modifying
    @Query("select tt from TrangThai  tt where tt.tenTrangThai like ?1")
    TrangThai getByTen(String ten);
}
