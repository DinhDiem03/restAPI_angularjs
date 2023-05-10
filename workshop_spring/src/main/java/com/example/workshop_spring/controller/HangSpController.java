package com.example.workshop_spring.controller;

import com.example.workshop_spring.entity.Hang_SanPham;
import com.example.workshop_spring.service.HangSpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
 *  @author diemdz
 */
@RestController
@RequestMapping("hangsp/")
@CrossOrigin(origins = "*", maxAge = -1)
public class HangSpController {
    @Autowired
    HangSpService hangSpService;
    @GetMapping("hien-thi/{id}")
    public List<Hang_SanPham> hienThibyid(@PathVariable Long id){

        return hangSpService.getBuIdSinhVien(id);
    }
    @GetMapping("hien-thi")
    public List<Hang_SanPham> hienThi(){
        return hangSpService.getAll();
    }

}
