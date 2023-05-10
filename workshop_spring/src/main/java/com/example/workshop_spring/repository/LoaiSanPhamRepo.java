package com.example.workshop_spring.repository;
/*
 *  @author diemdz
 */

import com.example.workshop_spring.entity.LoaiSanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LoaiSanPhamRepo extends JpaRepository<LoaiSanPham,Long> {
    @Query("update LoaiSanPham lsp set lsp.maLoai =?1, lsp.tenLoai =?2 where lsp.id =?3")
    void updateLoaiSP(String maLsp,String tenLsp,Long id);
}
