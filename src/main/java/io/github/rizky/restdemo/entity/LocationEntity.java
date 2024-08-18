package io.github.rizky.restdemo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LocationEntity {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "nama_lokasi") private String namaLokasi;
    @Column(name = "negara") private String negara;
    @Column(name = "provinsi") private String provinsi;
    @Column(name = "kota") private String kota;
    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;


}
