package com.proyectofinal.ManejoDeStock.service;

import com.proyectofinal.ManejoDeStock.dto.ventaProductoDTO;
import com.proyectofinal.ManejoDeStock.model.Cliente;
import com.proyectofinal.ManejoDeStock.model.Producto;
import com.proyectofinal.ManejoDeStock.model.Venta;
import java.time.LocalDate;
import java.util.List;

public interface IVentaService {
    
    public void saveVentas(Venta ven);
    
    public List<Venta> getVentas();
    
    public void deleteVenta(Long codigo_venta);
    
    public Venta findVenta(Long codigo_venta);
    
    public void editVenta(Long codigo_venta, Long nuevoCodigo, LocalDate nuevaFecha,
                            Double nuevoTotal, List<Producto> nuevaLista, Cliente nuevoCliente);
    
    public List<Producto> listaProductosVentas(Long codigo_venta);
    
    public String sumTotalDia(LocalDate fecha_venta);
    
    public List<ventaProductoDTO> traerDTO();
    
}
