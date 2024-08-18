package io.github.rizky.restdemo.service;


import io.github.rizky.restdemo.service.LocationDTO ;
import io.github.rizky.restdemo.entity.LocationEntity;

public class LocationMapper {
    public static LocationDTO toDTO(LocationEntity entity) {
        return new LocationDTO(
                entity.getId(),
                entity.getNamaLokasi(),
                entity.getProvinsi(),
                entity.getKota(),
                entity.getNegara(),
                entity.getCreatedAt()
        );
    }

    public static LocationEntity toEntity(LocationDTO dto) {
        LocationEntity entity = new LocationEntity();
        entity.setId(dto.getId());
        entity.setNamaLokasi(dto.getNamaLokasi());
        entity.setProvinsi(dto.getProvinsi());
        entity.setKota(dto.getKota());
        entity.setNegara(dto.getNegara());
        entity.setCreatedAt(dto.getCreatedAt());
        return entity;
    }
}

