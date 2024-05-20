package com.proyectofinal.ManejoDeStock.controller;

import com.proyectofinal.ManejoDeStock.dto.ventaProductoDTO;
import com.proyectofinal.ManejoDeStock.model.Cliente;
import com.proyectofinal.ManejoDeStock.model.Producto;
import com.proyectofinal.ManejoDeStock.model.Venta;
import com.proyectofinal.ManejoDeStock.service.IVentaService;
import java.time.LocalDate;
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
public class VentaController {
    @Autowired
    private IVentaService ventaServi;
    
    @PostMapping("/ventas/crear")
    public String saveVentas(@RequestBody Venta ven){
        ventaServi.saveVentas(ven);
        return "La venta se creo correctamente";
    }
    
    @GetMapping("/ventas")
    public List<Venta> getVentas(){
        List<Venta> listaVentas = ventaServi.getVentas();
        return listaVentas;
    }
    
    @GetMapping("/ventas/{id_ventas}")
    public Venta getVenta(@PathVariable Long id_ventas){
        return ventaServi.findVenta(id_ventas);
    }
    
    @DeleteMapping("/ventas/eliminar/{codigo_venta}")
    public String deleteVenta(@PathVariable Long codigo_venta){
        ventaServi.deleteVenta(codigo_venta);
        return "La venta se elimino correctamente";
    }
    
    @PutMapping("/ventas/editar/{codigo_venta}")
    public String editVenta(@PathVariable Long codigo_venta, @RequestBody Venta venta){
    Venta editVenta = ventaServi.findVenta(codigo_venta);
    editVenta.setFecha_venta(venta.getFecha_venta());
    editVenta.setTotal(venta.getTotal());
    editVenta.setListaProductos(venta.getListaProductos());
    editVenta.setUnCliente(venta.getUnCliente());
    ventaServi.saveVentas(editVenta);
    return "Se actualizo correctamente";
    }
    
    @GetMapping("/ventas/productos/{codigo_venta}")
    public List<Producto> getVentasProductos(@PathVariable Long codigo_venta){
        return ventaServi.listaProductosVentas(codigo_venta);
    }
    
    @GetMapping("/ventas/fecha/{fecha_venta}")
    public String sumTotalDia(@PathVariable LocalDate fecha_venta){
        return ventaServi.sumTotalDia(fecha_venta);
    }
    
    @GetMapping("/ventas/mayor_venta")
    public List<ventaProductoDTO> traerDTO(){
        return ventaServi.traerDTO();
    }
}
