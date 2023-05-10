package com.example.workshop_spring.service;
/*
 *  @author diemdz
 */

import com.example.workshop_spring.entity.Hang_SanPham;

import java.util.List;

public interface HangSpService {
    List<Hang_SanPham> getBuIdSinhVien(Long id);

    List<Hang_SanPham> getAll();
}
