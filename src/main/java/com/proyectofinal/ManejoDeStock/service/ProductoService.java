package com.proyectofinal.ManejoDeStock.service;

import com.proyectofinal.ManejoDeStock.model.Producto;
import com.proyectofinal.ManejoDeStock.repository.IProductoRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService implements IProductoService{

    @Autowired
    private IProductoRepository productoRepo;
    
    @Override
    public void saveProductos(Producto produc) {
        productoRepo.save(produc);
    }

    @Override
    public List<Producto> getProductos() {
        return productoRepo.findAll();
    }

    @Override
    public void deleteProducto(Long codigo_producto) {
        productoRepo.deleteById(codigo_producto);
    }

     @Override
    public void editProducto(Long codigoOriginal, Long nuevoCodigo, String nuevoNombre, String nuevaMarca, Double nuevoCosto, int nuevaCantidad) {
        Producto produc = this.findProducto(codigoOriginal);
        produc.setCodigo_producto(nuevoCodigo);
        produc.setNombre(nuevoNombre);
        produc.setMarca(nuevaMarca);
        produc.setCosto(nuevoCosto);
        produc.setCantidad_disponible(nuevaCantidad);
        
        this.saveProductos(produc);
    }

    @Override
    public Producto findProducto(Long codigo_producto) {
        return productoRepo.findById(codigo_producto).orElse(null);
    }

    @Override
    public List<Producto> faltaStock() {
        List<Producto> listaProductos = new ArrayList<Producto>();
        List<Producto> listaDosProductos = this.getProductos();
        int cantidadDisponible;
        for (Producto lista : listaDosProductos) {
            cantidadDisponible = lista.getCantidad_disponible();
            if(cantidadDisponible < 5){
                listaProductos.add(lista);
            }
        }
        return listaProductos;
    }
    
}
