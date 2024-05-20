package com.proyectofinal.ManejoDeStock.controller;

import com.proyectofinal.ManejoDeStock.model.Cliente;
import com.proyectofinal.ManejoDeStock.service.IClienteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClienteController {
    @Autowired
    private IClienteService clieServi;
    
    @PostMapping("/clientes/crear")
    public String saveClientes(@RequestBody Cliente clie){
        clieServi.saveClientes(clie);
        return "El cliente se creo correctamente";
    }
    
    @GetMapping("/clientes")
    public List<Cliente> getClientes(){
        List<Cliente> listaClientes = clieServi.getClientes();
        return listaClientes;
    }
    
    @GetMapping("/clientes/{id_cliente}")
    public Cliente getCliente(@PathVariable Long id_cliente){
        return clieServi.findCliente(id_cliente);
    }
    
    @DeleteMapping("/clientes/eliminar/{id_cliente}")
    public String deleteCliente(@PathVariable Long id_cliente){
        clieServi.deleteCliente(id_cliente);
        return "El cliente se elimino correctamente";
    }
    
    @PutMapping("/clientes/editar/{codigo_cliente}")
    public String editCliente(@PathVariable Long codigo_cliente, @RequestBody Cliente clie){
    Cliente editCliente = clieServi.findCliente(codigo_cliente);
    editCliente.setNombre(clie.getNombre());
    editCliente.setApellido(clie.getApellido());
    editCliente.setDni(clie.getDni());
    clieServi.saveClientes(editCliente);
    return "Se actualizo correctamente";
    }
}
