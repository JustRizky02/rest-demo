package io.github.rizky.restdemo.service;

import io.github.rizky.restdemo.entity.LocationEntity;
import io.github.rizky.restdemo.repository.LocationRepository;
import io.github.rizky.restdemo.service.LocationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LocationService {

    @Autowired
    private LocationRepository locationRepository;

    public LocationDTO getLocationById(Long id) {
        LocationEntity locationEntity = locationRepository.findById(id).orElse(null);
        return LocationMapper.toDTO(locationEntity);

    }

    public List<LocationDTO> getAllLocations() {
        List<LocationEntity> entities = locationRepository.findAll();
        return entities.stream()
                .map(LocationMapper::toDTO)
                .collect(Collectors.toList());
    }

    public LocationDTO createLocation(LocationDTO locationDTO) {
        validateLocation(locationDTO);
        LocationEntity entity = LocationMapper.toEntity(locationDTO);
        entity = locationRepository.save(entity);
        return LocationMapper.toDTO(entity);
    }

    public LocationDTO updateLocation(Long id, LocationDTO locationDTO) {
        LocationEntity existingLocation = locationRepository.findById(id).orElse(null);
        if (existingLocation != null) {
            locationDTO.setCreatedAt(existingLocation.getCreatedAt()); // Keep the original creation time
            LocationEntity updatedLocation = LocationMapper.toEntity(locationDTO);
            updatedLocation.setId(id); // Set the ID to ensure update
            locationRepository.save(updatedLocation);
            return LocationMapper.toDTO(updatedLocation);
        }
        return null;
    }

    public void deleteLocation(Long id) {
        locationRepository.deleteById(id);
    }

    private void validateLocation(LocationDTO locationDTO) {
        if (locationDTO.getNamaLokasi() == null || locationDTO.getNamaLokasi().isEmpty()) {
            throw new IllegalArgumentException("Nama lokasi tidak boleh kosong");
        }
        // Validasi lainnya
    }
}
