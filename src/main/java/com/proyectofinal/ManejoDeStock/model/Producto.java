package com.proyectofinal.ManejoDeStock.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Producto {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long codigo_producto;
    private String nombre, marca;
    private Double costo;
    private int cantidad_disponible;
    //@ManyToOne
    //@JoinColumn (name = "id_venta")
    //private Venta venta;

    public Producto() {
    }

    public Producto(Long codigo_producto, String nombre, String marca, Double costo, int cantidad_disponible) {
        this.codigo_producto = codigo_producto;
        this.nombre = nombre;
        this.marca = marca;
        this.costo = costo;
        this.cantidad_disponible = cantidad_disponible;
        //this.venta = venta;
    }
    
}
