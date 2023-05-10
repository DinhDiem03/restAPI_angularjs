package com.example.workshop_spring.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

/*
 *  @author diemdz
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "san_pham")
public class SanPham implements Serializable {
//    private static final long serialVersionUID = -297553281792804396L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ten_san_pham")
    private String tenSp;
    @Column(name = "mau")
    private String mau;

    @Column(name = "so_luong")
    private int soLuong;

    @Column(name = "gia_nhap")
    private BigDecimal giaNhap;
    @Column(name = "gia_ban")
    private BigDecimal giaBan;
    @Column(name = "mo_ta")
    private String moTa;

    @ManyToOne()
    @JoinColumn(name = "id_sub_loai")
    private SubLoaiSanPham subLoaiSanPham;

    @ManyToOne()
    @JoinColumn(name = "id_trang_thai")
    private TrangThai trangThai;

}
