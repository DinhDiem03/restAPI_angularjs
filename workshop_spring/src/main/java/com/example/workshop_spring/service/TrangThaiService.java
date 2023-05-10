package com.example.workshop_spring.service;
/*
 *  @author diemdz
 */


import com.example.workshop_spring.entity.TrangThai;

import java.util.List;

public interface TrangThaiService {
    List<TrangThai> getAll();
    void add(TrangThai trangThai);
    void delete(Long id);
    void update(TrangThai trangThai, Long id);

        TrangThai getByTen(String ten);

}
