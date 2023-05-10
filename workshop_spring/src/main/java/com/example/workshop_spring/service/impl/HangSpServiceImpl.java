package com.example.workshop_spring.service.impl;
/*
 *  @author diemdz
 */

import com.example.workshop_spring.entity.Hang_SanPham;
import com.example.workshop_spring.repository.HangSpRepo;
import com.example.workshop_spring.service.HangSpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HangSpServiceImpl implements HangSpService {
    @Autowired
    private HangSpRepo hangSpRepo;
    @Override
    public List<Hang_SanPham> getBuIdSinhVien(Long id) {
        return hangSpRepo.findByIdSinhVien(id);
    }

    @Override
    public List<Hang_SanPham> getAll() {
        return hangSpRepo.findAll();
    }
}
