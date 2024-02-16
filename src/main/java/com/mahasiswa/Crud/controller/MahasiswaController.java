package com.mahasiswa.Crud.controller;

import com.mahasiswa.Crud.model.Profile;
import com.mahasiswa.Crud.service.MahasiswaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("crud/mahasiswa")
public class MahasiswaController {


    private MahasiswaService mahasiswaService;

    @Autowired
    public void setMahasiswaService(MahasiswaService mahasiswaService) {
        this.mahasiswaService = mahasiswaService;
    }

    @PostMapping
    public ResponseEntity<Profile> createmhs(@RequestBody Profile profile){
        Profile saveprofile = mahasiswaService.saveMahasiswa(profile);
        return ResponseEntity.status(HttpStatus.CREATED).body(saveprofile);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Profile> updatemhs(@PathVariable Integer id, @RequestBody Profile profile){
        mahasiswaService.updateMahasiswa(id , profile);
        return ResponseEntity.status(HttpStatus.OK).body(profile);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Profile> deletemhs(@PathVariable Integer id){
        mahasiswaService.deleteMahasiswa(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Profile> getmhsByID(@PathVariable Integer id){
        Optional<Profile> mhs = mahasiswaService.getMahasiswaById(id);
        if (mhs.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(mhs.get());
    }

    @GetMapping
    public ResponseEntity<List<Profile>> getmhs(){
        List<Profile> mhs = mahasiswaService.getAllMahasiswa();
        if (mhs.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(mhs);
    }

}
