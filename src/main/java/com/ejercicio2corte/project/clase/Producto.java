package com.ejercicio2corte.project.clase;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Producto{
private Integer idproducto;
public String nombre;
public double valor;
public int cantidad;

}
