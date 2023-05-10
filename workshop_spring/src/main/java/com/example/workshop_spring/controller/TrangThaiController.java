package com.example.workshop_spring.controller;


import com.example.workshop_spring.entity.TrangThai;
import com.example.workshop_spring.service.TrangThaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/*
 *  @author diemdz
 */

@RestController
@RequestMapping("trang-thai/")
@CrossOrigin(origins = "*", maxAge = -1)
public class TrangThaiController {
    @Autowired
     TrangThaiService trangThaiService;

    @GetMapping("hien-thi")
    public List<TrangThai> hienThi(){
        return trangThaiService.getAll();
    }
}
