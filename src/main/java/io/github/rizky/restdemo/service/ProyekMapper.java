package io.github.rizky.restdemo.service;

import io.github.rizky.restdemo.entity.ProyekEntity;

public class ProyekMapper {
    public static ProyekDTO toDTO(ProyekEntity entity) {
        ProyekDTO dto = new ProyekDTO();
        dto.setId(entity.getId());
        dto.setNamaProyek(entity.getNamaProyek());
        dto.setClient(entity.getClient());
        dto.setTglMulai(entity.getTglMulai());
        dto.setTglSelesai(entity.getTglSelesai());
        dto.setPimpinanProyek(entity.getPimpinanProyek());
        dto.setKeterangan(entity.getKeterangan());
        dto.setCreatedAt(entity.getCreatedAt());
        return dto;
    }

    public static ProyekEntity toEntity(ProyekDTO dto) {
        ProyekEntity entity = new ProyekEntity();
        entity.setId(dto.getId());
        entity.setNamaProyek(dto.getNamaProyek());
        entity.setClient(dto.getClient());
        entity.setTglMulai(dto.getTglMulai());
        entity.setTglSelesai(dto.getTglSelesai());
        entity.setPimpinanProyek(dto.getPimpinanProyek());
        entity.setKeterangan(dto.getKeterangan());
        entity.setCreatedAt(dto.getCreatedAt());
        return entity;
    }
}

