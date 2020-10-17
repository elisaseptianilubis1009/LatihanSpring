package com.springboot.elisa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.elisa.model.Mahasiswa;


//extends JpaRepository gunanya untuk memudahkan proses query, soalnya
//kalo udah extends JpaRepository kita akan dikasih fitur findAll(select), save (insert) dll. 
public interface MahasiswaRepository extends JpaRepository<Mahasiswa, Long> {

}
