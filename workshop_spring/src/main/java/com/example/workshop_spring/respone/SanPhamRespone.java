package com.example.workshop_spring.respone;
/*
 *  @author diemdz
 */

import com.example.workshop_spring.entity.Hang;
import com.example.workshop_spring.entity.SubLoaiSanPham;
import com.example.workshop_spring.entity.TrangThai;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SanPhamRespone {
    private Long id;
    private String tenSp;
    private String mau;
    private int soLuong;
    private BigDecimal giaNhap;
    private BigDecimal giaBan;
    private String moTa;
    private SubLoaiSanPham subLoaiSanPham;
    private TrangThai trangThai;
    private Hang hang;

}
