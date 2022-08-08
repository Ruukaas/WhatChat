package com.example.Whatchat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Whatchat.model.usuario;

@Repository
public interface usuarioRepo extends JpaRepository<usuario,Long> {
    
}
