package com.example.workshop_spring.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/*
 *  @author diemdz
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "sub_loai_san_pham")
public class SubLoaiSanPham implements Serializable {
//    private static final long serialVersionUID = -297553281792804396L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "ma_sub_loai")
    private String maSubLoai;
    @Column(name = "ten_sub_loai")
    private String tenSubLoai;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_loai_san_pham")
    @JsonIgnore
    private  LoaiSanPham loaiSanPham;
}
