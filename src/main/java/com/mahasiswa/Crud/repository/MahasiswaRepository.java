package com.mahasiswa.Crud.repository;

import com.mahasiswa.Crud.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MahasiswaRepository extends JpaRepository<Profile, Integer> {

}
