package io.github.rizky.restdemo.service;


import java.time.LocalDateTime;

public class LocationDTO {
    private Long id;
    private String namaLokasi;
    private String provinsi;
    private String kota;
    private String negara;
    private LocalDateTime createdAt;

    // Constructor default
    public LocationDTO() {}

    // Constructor dengan semua fields
    public LocationDTO(Long id, String namaLokasi, String provinsi, String kota , String negara, LocalDateTime createdAt) {
        this.id = id;
        this.namaLokasi = namaLokasi;
        this.provinsi = provinsi;
        this.kota = kota;
        this.negara = negara;
        this.createdAt = createdAt;
    }

    // Getter dan Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNamaLokasi() {
        return namaLokasi;
    }

    public void setNamaLokasi(String namaLokasi) {
        this.namaLokasi = namaLokasi;
    }

    public String getProvinsi() {
        return provinsi;
    }

    public void setProvinsi(String provinsi) {
        this.provinsi = provinsi;
    }

    public String getKota() {
        return kota;
    }

    public void setKota(String kota) {
        this.kota = kota;
    }



    public String getNegara() {
        return negara;
    }

    public void setNegara(String negara) {
        this.negara = negara;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}

