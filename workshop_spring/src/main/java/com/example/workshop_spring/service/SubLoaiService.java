package com.example.workshop_spring.service;
/*
 *  @author diemdz
 */

import com.example.workshop_spring.entity.SubLoaiSanPham;

import java.util.List;

public interface SubLoaiService {
    List<SubLoaiSanPham> getAll();
    SubLoaiSanPham getOne(Long id);

}
