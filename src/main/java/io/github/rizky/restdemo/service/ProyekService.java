package io.github.rizky.restdemo.service;

import io.github.rizky.restdemo.entity.ProyekEntity;
import io.github.rizky.restdemo.repository.ProyekRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProyekService {


    @Autowired
    private ProyekRepository proyekRepository;
    public ProyekDTO getProyekById(Long id) {
        ProyekEntity proyekEntity = proyekRepository.findById(id).orElse(null);
        return ProyekMapper.toDTO(proyekEntity);
    }

    public List<ProyekDTO> getAllProyek() {
        List<ProyekEntity> entities = proyekRepository.findAll();
        return entities.stream()
                .map(ProyekMapper::toDTO)
                .collect(Collectors.toList());
    }

    public ProyekDTO createProyek(ProyekDTO proyekDTO) {
        validateProyek(proyekDTO);
        ProyekEntity entity = ProyekMapper.toEntity(proyekDTO);
        entity = proyekRepository.save(entity);
        return ProyekMapper.toDTO(entity);
    }

    public ProyekDTO updateProyek(Long id, ProyekDTO proyekDTO) {
        ProyekEntity existingProyek = proyekRepository.findById(id).orElse(null);
        if (existingProyek != null) {
            proyekDTO.setCreatedAt(existingProyek.getCreatedAt()); // Keep the original creation time
            ProyekEntity updatedProyek = ProyekMapper.toEntity(proyekDTO);
            updatedProyek.setId(id); // Set the ID to ensure update
            proyekRepository.save(updatedProyek);
            return ProyekMapper.toDTO(updatedProyek);
        }
        return null;
    }

    public void deleteProyek(Long id) {
        proyekRepository.deleteById(id);
    }

    private void validateProyek(ProyekDTO proyekDTO) {
        if (proyekDTO.getNamaProyek() == null || proyekDTO.getNamaProyek().isEmpty()) {
            throw new IllegalArgumentException("Nama proyek tidak boleh kosong");
        }
        // Validasi lainnya
    }
}
