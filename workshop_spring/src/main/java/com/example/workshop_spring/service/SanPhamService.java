package com.example.workshop_spring.service;
/*
 *  @author diemdz
 */

import com.example.workshop_spring.entity.SanPham;
import com.example.workshop_spring.request.SanPhamRequest;
import com.example.workshop_spring.respone.SanPhamRespone;

import java.util.List;

public interface SanPhamService {
    List<SanPham> getAll();
    void add(SanPhamRequest sanPhamRequest);
    void update(SanPhamRequest sanPhamRequest,Long id);
    void delete(Long id);
    SanPham getById(Long id);
    List<SanPhamRespone> getSanPham(Long id);
}
