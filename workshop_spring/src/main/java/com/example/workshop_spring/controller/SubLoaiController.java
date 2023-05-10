package com.example.workshop_spring.controller;

import com.example.workshop_spring.entity.SubLoaiSanPham;
import com.example.workshop_spring.service.SubLoaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
 *  @author diemdz
 */
@RestController
@RequestMapping("sub-loai/")
@CrossOrigin(origins = "*", maxAge = -1)
public class SubLoaiController {
    @Autowired
    SubLoaiService subLoaiService;

    @GetMapping("hien-thi")
    public List<SubLoaiSanPham> hienThi(){
        return subLoaiService.getAll();
    }

    @GetMapping("getone/{id}")
    public SubLoaiSanPham getOne(@PathVariable("id") Long id){
        return subLoaiService.getOne(id);
    }
}
