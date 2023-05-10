package com.example.workshop_spring.entity;
/*
 *  @author diemdz
 */

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "hang_san_pham")
@Entity
public class Hang_SanPham implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne()
    @JoinColumn(name = "id_san_pham")
    private SanPham sanPham;
    @ManyToOne()
    @JoinColumn(name = "id_hang")
    private Hang hang;

}
