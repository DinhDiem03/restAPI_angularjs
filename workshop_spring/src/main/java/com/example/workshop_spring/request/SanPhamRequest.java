package com.example.workshop_spring.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/*
 *  @author diemdz
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class SanPhamRequest {

    private String tenSp;

    private String mau;

    private int soLuong;

    private BigDecimal giaNhap;
    private BigDecimal giaBan;
    private String moTa;

    private Long idSubLoaiSp;
    private Long idTrangThai;
    private Long idHang;
}
