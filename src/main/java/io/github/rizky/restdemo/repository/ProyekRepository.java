package io.github.rizky.restdemo.repository;

import io.github.rizky.restdemo.entity.ProyekEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProyekRepository extends JpaRepository<ProyekEntity, Long> {
    // Custom query jika diperlukan
}
