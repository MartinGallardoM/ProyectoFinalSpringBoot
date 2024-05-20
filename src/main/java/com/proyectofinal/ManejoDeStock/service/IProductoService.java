package com.proyectofinal.ManejoDeStock.service;

import com.proyectofinal.ManejoDeStock.model.Producto;
import java.util.List;

public interface IProductoService {
    
    public void saveProductos(Producto produc);
    
    public List<Producto> getProductos();
    
    public void deleteProducto(Long codigo_producto);
    
    public void editProducto(Long codigoOriginal, Long nuevoCodigo, String nuevoNombre, 
                            String nuevaMarca, Double nuevoCosto, int nuevaCantidad);
    
    public Producto findProducto(Long codigo_producto);
    
    public List<Producto> faltaStock();
    
    
}
