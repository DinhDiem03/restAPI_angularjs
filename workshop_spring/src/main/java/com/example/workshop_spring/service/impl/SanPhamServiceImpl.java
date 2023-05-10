package com.example.workshop_spring.service.impl;
/*
 *  @author diemdz
 */

import com.example.workshop_spring.entity.Hang_SanPham;
import com.example.workshop_spring.entity.SanPham;
import com.example.workshop_spring.repository.*;
import com.example.workshop_spring.request.SanPhamRequest;
import com.example.workshop_spring.respone.SanPhamRespone;
import com.example.workshop_spring.service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SanPhamServiceImpl implements SanPhamService {

    @Autowired
    private SanPhamRepo sanPhamRepo;

    @Autowired
    private TrangThaiRepo trangThaiRepo;

    @Autowired
    private SubLoaiSanPhamRepo subLoaiSanPhamRepo;
    @Autowired
    private HangRepo hangRepo;

    @Autowired
    private HangSpRepo hangSpRepo;

    @Override
    public List<SanPham> getAll() {
        return sanPhamRepo.findAll();
    }

    @Override
    public void add(SanPhamRequest sanPhamRequest) {
        SanPham sanPham = new SanPham();
        sanPham.setMau(sanPhamRequest.getMau());
        sanPham.setTenSp(sanPhamRequest.getTenSp());
        sanPham.setSoLuong(sanPhamRequest.getSoLuong());
        sanPham.setGiaNhap(sanPhamRequest.getGiaNhap());
        sanPham.setGiaBan(sanPhamRequest.getGiaBan());
        sanPham.setMoTa(sanPhamRequest.getMoTa());
        sanPham.setSubLoaiSanPham(subLoaiSanPhamRepo.getOne(sanPhamRequest.getIdSubLoaiSp()));
        sanPham.setTrangThai(trangThaiRepo.getOne(sanPhamRequest.getIdTrangThai()));
        sanPhamRepo.save(sanPham);
        Long idSanPham = sanPhamRepo.save(sanPham).getId();
        Hang_SanPham hangSanPham = new Hang_SanPham();
        hangSanPham.setHang(hangRepo.getOne(sanPhamRequest.getIdHang()));
        hangSanPham.setSanPham(sanPhamRepo.getOne(idSanPham));
        hangSpRepo.save(hangSanPham);


    }

    @Override
    public void update(SanPhamRequest sanPhamRequest, Long id) {
        Optional<SanPham> sp = sanPhamRepo.findById(id);
        SanPham sanPham = sp.get();
        sanPham.setMau(sanPhamRequest.getMau());
        sanPham.setTenSp(sanPhamRequest.getTenSp());
        sanPham.setSoLuong(sanPhamRequest.getSoLuong());
        sanPham.setGiaNhap(sanPhamRequest.getGiaNhap());
        sanPham.setGiaBan(sanPhamRequest.getGiaBan());
        sanPham.setMoTa(sanPhamRequest.getMoTa());
        sanPham.setSubLoaiSanPham(subLoaiSanPhamRepo.getById(sanPhamRequest.getIdSubLoaiSp()));
        sanPham.setTrangThai(trangThaiRepo.getById(sanPhamRequest.getIdTrangThai()));
        sanPhamRepo.save(sanPham);


        Hang_SanPham hangSanPham = new Hang_SanPham();
        List<Hang_SanPham> list = hangSpRepo.findByIdSinhVien(id);
        for (Hang_SanPham x: list) {
            hangSanPham.setId(x.getId());
        }
        hangSanPham.setSanPham(sanPhamRepo.getById(id));
        hangSanPham.setHang(hangRepo.getById(sanPhamRequest.getIdHang()));
        hangSpRepo.save(hangSanPham);


    }

    @Override
    public void delete(Long id) {
        List<Hang_SanPham> list = hangSpRepo.findByIdSinhVien(id);
        for (Hang_SanPham x: list) {
            hangSpRepo.deleteById(x.getId());
        }
        sanPhamRepo.deleteById(id);
    }

    @Override
    public SanPham getById(Long id) {
        Optional<SanPham> sanPham = sanPhamRepo.findById(id);
        return sanPham.get();
    }

    @Override
    public List<SanPhamRespone> getSanPham(Long id) {
        return sanPhamRepo.getSanPham(id);
    }

}
