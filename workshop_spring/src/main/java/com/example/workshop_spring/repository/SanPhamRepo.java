package com.example.workshop_spring.repository;


import com.example.workshop_spring.entity.SanPham;
import com.example.workshop_spring.respone.SanPhamRespone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/*
 *  @author diemdz
 */
@Repository
public interface SanPhamRepo extends JpaRepository<SanPham,Long> {
    @Transactional
    @Modifying
    @Query("select new com.example.workshop_spring.respone.SanPhamRespone(sp.id,sp.tenSp,sp.mau,sp.soLuong,sp.giaNhap,sp.giaBan,sp.moTa,sp.subLoaiSanPham,sp.trangThai,hsp.hang)  from SanPham sp join Hang_SanPham hsp on sp.id = hsp.sanPham.id where sp.id =?1" )
    List<SanPhamRespone> getSanPham(Long id);


}
