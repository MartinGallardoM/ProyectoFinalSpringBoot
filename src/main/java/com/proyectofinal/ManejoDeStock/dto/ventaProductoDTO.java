package com.proyectofinal.ManejoDeStock.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ventaProductoDTO {
    private Long codigo_venta;
    private Double total;
    private int cantidad_producto;
    private String nombre_cliente, apellido_cliente;
    private Double monto_alto;

    public ventaProductoDTO() {
    }

    public ventaProductoDTO(Long codigo_venta, Double total, int cantidad_producto, String nombre_cliente, String apellido_cliente, Double monto_alto) {
        this.codigo_venta = codigo_venta;
        this.total = total;
        this.cantidad_producto = cantidad_producto;
        this.nombre_cliente = nombre_cliente;
        this.apellido_cliente = apellido_cliente;
        this.monto_alto = monto_alto;
    }
    
}
