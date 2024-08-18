package io.github.rizky.restdemo.response;

import io.github.rizky.restdemo.service.ProyekDTO;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
public class ProyekCreateResponse {
    private String message;
    private ProyekDTO proyek;

}
