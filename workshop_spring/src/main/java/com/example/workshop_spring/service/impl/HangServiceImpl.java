package com.example.workshop_spring.service.impl;
/*
 *  @author diemdz
 */

import com.example.workshop_spring.entity.Hang;
import com.example.workshop_spring.repository.HangRepo;
import com.example.workshop_spring.service.HangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HangServiceImpl implements HangService {

    @Autowired
    private HangRepo hangRepo;

    @Override
    public List<Hang> getAll() {
        return hangRepo.findAll();
    }
}
