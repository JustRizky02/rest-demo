package io.github.rizky.restdemo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProyekEntity {
    @Id
    @GeneratedValue

    private Long id;
    @Column(name = "nama_proyek") private String namaProyek;
    @Column(name = "client") private String client;
    @Column(name = "tgl_mulai") private LocalDate tglMulai;
    @Column(name = "tgl_selesai") private LocalDate tglSelesai;
    @Column(name = "pimpinan_proyek") private String pimpinanProyek;
    @Column(name = "keterangan") private String keterangan;
    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;

//    @ManyToMany
//    @JoinTable(
//            name = "proyek_lokasi",
//            joinColumns = @JoinColumn(name = "id"),
//            inverseJoinColumns = @JoinColumn(name = "id")
//
//    )
//    private Set<LocationEntity> lokasi;
}
