package com.example.workshop_spring.controller;
/*
 *  @author diemdz
 */

import com.example.workshop_spring.entity.SanPham;
import com.example.workshop_spring.request.SanPhamRequest;
import com.example.workshop_spring.service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("san-pham/")
@CrossOrigin(origins = "*", maxAge = -1)
public class SanPhamController {
    @Autowired
     SanPhamService sanPhamService;
    @GetMapping("hien-thi")
    public List<SanPham> hienThi(){
        return sanPhamService.getAll();
    }
    @GetMapping("hien-thi/{id}")
    public SanPham detail(@PathVariable Long id){
        return sanPhamService.getById(id);
    }
    @PostMapping("add")
    public void add(@RequestBody SanPhamRequest sanPham){
        sanPhamService.add(sanPham);
    }
    @PutMapping("update/{id}")
    public void update(@RequestBody SanPhamRequest sanPham,@PathVariable Long id){
        sanPhamService.update(sanPham,id);
    }

    @DeleteMapping("delete/{id}")
    public void update(@PathVariable Long id){
        sanPhamService.delete(id);
    }
}
