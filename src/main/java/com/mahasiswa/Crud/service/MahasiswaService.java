package com.mahasiswa.Crud.service;

import com.mahasiswa.Crud.model.Profile;
import com.mahasiswa.Crud.repository.MahasiswaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MahasiswaService {

    @Autowired
    private MahasiswaRepository mahasiswaRepository;

    public List<Profile> getAllMahasiswa() {
        return mahasiswaRepository.findAll();
    }

    public Optional<Profile> getMahasiswaById(Integer id) {
        return mahasiswaRepository.findById(id);
    }

    public Profile saveMahasiswa(Profile mahasiswa) {
        return mahasiswaRepository.save(mahasiswa);
    }

    public Profile updateMahasiswa(Integer id, Profile updatedMahasiswa) {
        return mahasiswaRepository.findById(id).map(mahasiswa -> {
            mahasiswa.setName(updatedMahasiswa.getName());
            mahasiswa.setAlamat(updatedMahasiswa.getAlamat());
            return mahasiswaRepository.save(mahasiswa);
        }).orElseThrow(() -> new RuntimeException("Mahasiswa not found with id " + id));
    }

    public void deleteMahasiswa(Integer id) {
        mahasiswaRepository.deleteById(id);
    }
}
