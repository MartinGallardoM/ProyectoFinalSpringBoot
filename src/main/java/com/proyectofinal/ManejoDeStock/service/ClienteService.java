package com.proyectofinal.ManejoDeStock.service;

import com.proyectofinal.ManejoDeStock.model.Cliente;
import com.proyectofinal.ManejoDeStock.repository.IClienteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService implements IClienteService{

    @Autowired
    private IClienteRepository clieRepo;
    
    @Override
    public void saveClientes(Cliente clie) {
        clieRepo.save(clie);
    }

    @Override
    public List<Cliente> getClientes() {
        return clieRepo.findAll();
    }

    @Override
    public void deleteCliente(Long id_cliente) {
        clieRepo.deleteById(id_cliente);
    }
    
    @Override
    public Cliente findCliente(Long id_cliente) {
        return clieRepo.findById(id_cliente).orElse(null);
    }
    
    @Override
    public void editCliente(Long idOriginal, Long nuevaId, String nuevoNombre, String nuevoApellido, String nuevoDni) {
        Cliente clie = this.findCliente(idOriginal);
        clie.setId_cliente(nuevaId);
        clie.setNombre(nuevoNombre);
        clie.setApellido(nuevoApellido);
        clie.setDni(nuevoDni);
        this.saveClientes(clie);
    }
    
}
