package com.ejercicio2corte.project.clase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Producto")
public class ProductoController {

   private List<Producto> productos = new ArrayList<>(
        Arrays.asList(new Producto(123,"huevos",1000,12))
    );

@GetMapping("")
public List<Producto> getproductos() {
    return productos;
}


@PostMapping("/new")
public Producto creaproducto(@RequestBody Producto producto) {
    productos.add(producto);
    return producto;
}
@PutMapping("/mod")
public Producto putproducto(@RequestBody Producto producto) {
   for (Producto p: productos)
   if (p.getIdproducto() == producto.getIdproducto()) {
        p.setNombre(producto.getNombre());
        p.setValor(producto.getValor());
        p.setCantidad(producto.getCantidad());
        return p;
    
   }
    
    return null;
}
@DeleteMapping("dele/{idproducto}")
public Producto deleteProductos(@PathVariable int idproducto){
    for(Producto p : productos){
        if(p.getIdproducto() == idproducto){
            productos.remove(p);
            return p;
        }
    }
    return null;
}

}
