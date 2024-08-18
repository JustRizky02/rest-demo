package io.github.rizky.restdemo.controller;

import io.github.rizky.restdemo.response.ProyekCreateResponse;
import io.github.rizky.restdemo.service.ProyekDTO ;
import io.github.rizky.restdemo.service.ProyekService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proyek")
@CrossOrigin
public class ProyekController {
    @GetMapping("/{id}")
    public ResponseEntity<ProyekDTO> getProyek(@PathVariable Long id){
        return ResponseEntity.ok(proyekService.getProyekById(id));

    }

    @Autowired
    private ProyekService proyekService;

    @GetMapping
    public ResponseEntity<List<ProyekDTO>> getAllProyek() {
        List<ProyekDTO> proyekList = proyekService.getAllProyek();
        return new ResponseEntity<>(proyekList, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProyek(@PathVariable Long id) {
        proyekService.deleteProyek(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping
    public ResponseEntity<ProyekCreateResponse> createProyek(@RequestBody ProyekDTO proyekDTO) {
        try {
            ProyekDTO createdProyek = proyekService.createProyek(proyekDTO);
            return ResponseEntity.ok(ProyekCreateResponse.builder().proyek(createdProyek).build());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(ProyekCreateResponse.builder().message(e.getMessage()).build());

        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProyekDTO> updateProyek(@PathVariable Long id, @RequestBody ProyekDTO proyekDTO) {
        ProyekDTO updatedProyek = proyekService.updateProyek(id, proyekDTO);
        if (updatedProyek != null) {
            return new ResponseEntity<>(updatedProyek, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
