package com.proyectofinal.ManejoDeStock.service;

import com.proyectofinal.ManejoDeStock.model.Cliente;
import java.util.List;

public interface IClienteService {
    
    public void saveClientes(Cliente clie);
    
    public List<Cliente> getClientes();
    
    public void deleteCliente(Long id_cliente);
    
    public Cliente findCliente(Long id_cliente);
    
    public void editCliente(Long idOriginal, Long nuevaId, String nuevoNombre, String nuevoApellido
                            , String nuevoDni);
    
}
