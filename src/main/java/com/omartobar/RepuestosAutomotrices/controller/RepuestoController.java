package com.omartobar.RepuestosAutomotrices.controller;

import com.omartobar.RepuestosAutomotrices.entity.Repuesto;
import com.omartobar.RepuestosAutomotrices.service.RepuestoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping ("/api/proveedores")

public class RepuestoController {
    private final RepuestoService repuestoService;

    public RepuestoController(RepuestoService repuestoService) {this.repuestoService = repuestoService;}

    @GetMapping
    public List<Repuesto> getAllRepuestos(){return repuestoService.getAllRepuestos();}

    @GetMapping ("/{id}")
    public  ResponseEntity<Object>  getAllProveedorById(Integer id){
        try {
            Repuesto repuestoSolicitado = repuestoService.getRepuestoById(id);
            return new ResponseEntity<>(repuestoSolicitado, HttpStatus.ACCEPTED);
        }catch (IllegalArgumentException e){
            return  ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<Object> createRepuesto(@Valid @RequestBody Repuesto repuesto){
        try {
            Repuesto createdRepuesto = repuestoService.saveRepuesto(repuesto);
            return  new ResponseEntity<>(createdRepuesto, HttpStatus.CREATED);
        }catch(IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping ("/{id}")
    public ResponseEntity<Object> updateRepuesto(
            @PathVariable Integer id,
            @Valid @RequestBody Repuesto repuesto) {

        try{
            repuestoService.updateRepuesto(id, repuesto);
            return ResponseEntity.ok("Repuesto actualizado correctamente");
        }catch (RuntimeException e){
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se pudo actualizar el Repuesto");
        }

    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<Object> deleteRepuesto(@PathVariable Integer id) {
        try {
            repuestoService.deleteRepuesto(id);
            return ResponseEntity.ok("Repuesto eliminado correctamente");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Repuesto no encontrado");
        }
    }

}