package com.proyectofinal.ManejoDeStock.repository;

import com.proyectofinal.ManejoDeStock.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClienteRepository extends JpaRepository <Cliente, Long>{
    
}
