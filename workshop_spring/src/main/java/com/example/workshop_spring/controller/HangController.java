package com.example.workshop_spring.controller;
/*
 *  @author diemdz
 */

import com.example.workshop_spring.entity.Hang;
import com.example.workshop_spring.service.HangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("hang/")
@CrossOrigin(origins = "*", maxAge = -1)
public class HangController {
    @Autowired
    HangService hangService;

    @GetMapping("hien-thi")
    public List<Hang> hienThi(){
        return hangService.getAll();
    }
}
