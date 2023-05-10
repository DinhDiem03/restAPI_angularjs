package com.example.workshop_spring.repository;
/*
 *  @author diemdz
 */


import com.example.workshop_spring.entity.SubLoaiSanPham;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubLoaiSanPhamRepo extends JpaRepository<SubLoaiSanPham,Long> {
//    @Transactional
//    @Modifying
//    @Query("update SubLoaiSanPham subLsp set subLsp.maSubLoai=?1,subLsp.tenSubLoai=?2,subLsp.loaiSanPham=?3 where subLsp.id=?4")
//    void updateSubLsp(String maSub, String tenSub, LoaiSanPham loaiSanPham, Long id);
//
//    @Transactional
//    @Modifying
//    @Query("select sub from SubLoaiSanPham  sub where sub.tenSubLoai like ?1")
//    SubLoaiSanPham getByTen(String ten);
}
