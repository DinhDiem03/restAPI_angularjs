package com.example.workshop_spring.service.impl;
/*
 *  @author diemdz
 */


import com.example.workshop_spring.entity.TrangThai;
import com.example.workshop_spring.repository.TrangThaiRepo;
import com.example.workshop_spring.service.TrangThaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TrangThaiServiceImpl implements TrangThaiService {
    @Autowired
    private TrangThaiRepo trangThaiRepo;
    @Override
    public List<TrangThai> getAll() {
       return trangThaiRepo.findAll();
    }

    @Override
    public void add(TrangThai trangThai) {
        trangThaiRepo.save(trangThai);
    }

    @Override
    public void delete(Long id) {
        trangThaiRepo.deleteById(id);
    }

    @Override
    public void update(TrangThai trangThai, Long id) {
    trangThaiRepo.updateTrangThai(trangThai.getTenTrangThai(),id);
    }

    @Override
    public TrangThai getByTen(String ten) {
        return trangThaiRepo.getByTen(ten);
    }


}
