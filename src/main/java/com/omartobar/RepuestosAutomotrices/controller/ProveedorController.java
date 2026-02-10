package com.omartobar.RepuestosAutomotrices.controller;

import com.omartobar.RepuestosAutomotrices.entity.Proveedor;
import com.omartobar.RepuestosAutomotrices.service.ProveedorService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping ("/api/proveedores")

public class ProveedorController {
    private final ProveedorService proveedorService;

    public ProveedorController(ProveedorService proveedorService) {this.proveedorService = proveedorService;}

    @GetMapping
    public List<Proveedor> getAllProveedores(){return proveedorService.getallProveedores();}

    @PostMapping
    public ResponseEntity<Object> createProveedor(@Valid @RequestBody Proveedor proveedor){
        try {
            Proveedor createdProveedor = proveedorService.saveProveedor(proveedor);
            return  new ResponseEntity<>(createdProveedor, HttpStatus.CREATED);
        }catch(IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping ("/{id}")
    public ResponseEntity<Object> updateProveedor(
            @PathVariable Integer id,
            @Valid @RequestBody Proveedor proveedor) {

        try{
            proveedorService.updateProveedor(id, proveedor);
            return ResponseEntity.ok("Proveedor actualizado correctamente");
        }catch (RuntimeException e){
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se pudo actualizar al proveedor");
        }

     }

    @DeleteMapping ("/{id}")
    public ResponseEntity<Object> deleteProveedor(@PathVariable Integer id) {
        try {
            proveedorService.deleteProveedor(id);
            return ResponseEntity.ok("Proveedor eliminado correctamente");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Empleado no encontrado");
        }
    }

}
