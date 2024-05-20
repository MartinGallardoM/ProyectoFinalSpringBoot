package com.proyectofinal.ManejoDeStock.controller;

import com.proyectofinal.ManejoDeStock.model.Producto;
import com.proyectofinal.ManejoDeStock.service.IProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductoController {
    @Autowired
    private IProductoService productoServi;
    
    @PostMapping("/productos/crear")
    public String saveProductos(@RequestBody Producto produc){
        productoServi.saveProductos(produc);
        return "El producto se creo correctamente";
    }
    
    @GetMapping("/productos")
    public List<Producto> getProductos(){
        List<Producto> listaProductos = productoServi.getProductos();
        return listaProductos;
    }
    
    @GetMapping("/productos/{codigo_producto}")
    public Producto getProducto(@PathVariable Long codigo_producto){
        return productoServi.findProducto(codigo_producto);
    }
    
    @DeleteMapping("/productos/eliminar/{codigo_producto}")
    public String deleteProducto(@PathVariable Long codigo_producto){
        productoServi.deleteProducto(codigo_producto);
        return "El producto se elimino correctamente";
    }
    
    @PutMapping("/productos/editar/{codigo_producto}")
    public String editProducto(@PathVariable Long codigo_producto, @RequestBody Producto producto){
    Producto editProducto = productoServi.findProducto(codigo_producto);
    editProducto.setNombre(producto.getNombre());
    editProducto.setMarca(producto.getMarca());
    editProducto.setCosto(producto.getCosto());
    editProducto.setCantidad_disponible(producto.getCantidad_disponible());
    productoServi.saveProductos(editProducto);
    return "Se actualizo correctamente";
    }
    
    @GetMapping("/productos/falta_stock")
    public List<Producto> faltaStock(){
        return productoServi.faltaStock();
    }
    
}
