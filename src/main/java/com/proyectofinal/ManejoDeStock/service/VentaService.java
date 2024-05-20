package com.proyectofinal.ManejoDeStock.service;

import com.proyectofinal.ManejoDeStock.dto.ventaProductoDTO;
import com.proyectofinal.ManejoDeStock.model.Cliente;
import com.proyectofinal.ManejoDeStock.model.Producto;
import com.proyectofinal.ManejoDeStock.model.Venta;
import com.proyectofinal.ManejoDeStock.repository.IVentaRepository;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VentaService implements IVentaService{

    @Autowired
    private IVentaRepository ventaRepo;
    
    @Override
    public void saveVentas(Venta ven) {
        ventaRepo.save(ven);
    }

    @Override
    public List<Venta> getVentas() {
        return ventaRepo.findAll();
    }

    @Override
    public void deleteVenta(Long codigo_venta) {
        ventaRepo.deleteById(codigo_venta);
    }

    @Override
    public Venta findVenta(Long codigo_venta) {
        return ventaRepo.findById(codigo_venta).orElse(null);
    }

    @Override
    public void editVenta(Long codigo_venta, Long nuevoCodigo, LocalDate nuevaFecha, Double nuevoTotal, List<Producto> nuevaLista, Cliente nuevoCliente) {
        Venta ven = this.findVenta(codigo_venta);
        ven.setCodigo_venta(nuevoCodigo);
        ven.setFecha_venta(nuevaFecha);
        ven.setTotal(nuevoTotal);
        ven.setListaProductos(nuevaLista);
        ven.setUnCliente(nuevoCliente);
        
        this.saveVentas(ven);
    }

    @Override
    public List<Producto> listaProductosVentas(Long codigo_venta) {
        Venta ven = this.findVenta(codigo_venta); 
        List<Producto> lista = ven.getListaProductos();
        return lista;
    }

    @Override
    public String sumTotalDia(LocalDate fecha_venta) {
        List<Venta> ven = this.getVentas();
        Double sumaTotal = 0.0;
        int cont = 0;
        for (Venta venta : ven) {
            int fechaInicial = venta.getFecha_venta().getDayOfMonth();
            if(fechaInicial == fecha_venta.getDayOfMonth()){
                sumaTotal = sumaTotal + venta.getTotal();
                cont++;
            }
        }
        return "El monto total es: " + sumaTotal + " y la cantidad de venta es: " +
                cont;
    }

    @Override
    public List<ventaProductoDTO> traerDTO() {
        List<ventaProductoDTO> listaDTO = new ArrayList<ventaProductoDTO>();
        ventaProductoDTO dto = new ventaProductoDTO();
        List<Venta> ven = this.getVentas();
        Double montoMay = 0.0;
        Double montoActual = 0.0;
        
        for (Venta venta : ven) {
            montoActual = venta.getTotal();
            dto.setCodigo_venta(venta.getCodigo_venta());
            dto.setTotal(venta.getTotal());
            dto.setCantidad_producto(venta.getListaProductos().size());
            dto.setNombre_cliente(venta.getUnCliente().getNombre());
            dto.setApellido_cliente(venta.getUnCliente().getApellido());
            if(montoActual > montoMay){
                montoMay = montoActual;
                dto.setMonto_alto(montoMay);
            }
            listaDTO.add(dto);
            dto = new ventaProductoDTO();
        }
        return listaDTO;
    }
    
}