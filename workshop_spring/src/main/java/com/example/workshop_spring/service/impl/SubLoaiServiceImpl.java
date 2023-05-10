package com.example.workshop_spring.service.impl;
/*
 *  @author diemdz
 */

import com.example.workshop_spring.entity.SubLoaiSanPham;
import com.example.workshop_spring.repository.SubLoaiSanPhamRepo;
import com.example.workshop_spring.service.SubLoaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubLoaiServiceImpl implements SubLoaiService {
    @Autowired
    private SubLoaiSanPhamRepo subLoaiSanPhamRepo;

    @Override
    public List<SubLoaiSanPham> getAll() {
        return subLoaiSanPhamRepo.findAll();
    }

    @Override
    public SubLoaiSanPham getOne(Long id) {
        Optional<SubLoaiSanPham> loaiSanPham = subLoaiSanPhamRepo.findById(id);
        return loaiSanPham.get();
    }


}
