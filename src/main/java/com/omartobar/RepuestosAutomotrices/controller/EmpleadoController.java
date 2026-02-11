package com.omartobar.RepuestosAutomotrices.controller;

import com.omartobar.RepuestosAutomotrices.entity.Empleado;
import com.omartobar.RepuestosAutomotrices.service.EmpleadoService;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/api/empleados")

public class EmpleadoController {
    private final EmpleadoService empleadoService;
    public EmpleadoController(EmpleadoService empleadoService){this.empleadoService = empleadoService;
    }
    @GetMapping
    public List<Empleado> getAllEmpleados(){return empleadoService.getAllEmpleados();}

    @GetMapping
    public ResponseEntity<Object> getEmpleadoById(Integer id){
        try{
        Empleado empleadoSolicitado = empleadoService.getEmpleadoById(id);
        return new ResponseEntity<>(empleadoSolicitado , HttpStatus.ACCEPTED);
        }catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<Object> createEmpleado(@Valid @RequestBody Empleado empleado){
        try{
            Empleado createdEmpleado = empleadoService.saveEmpleado(empleado);
            return new ResponseEntity<>(createdEmpleado, HttpStatus.CREATED);
        }catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping ("/{id}")
    public ResponseEntity<Object> updateEmpleado(
            @PathVariable Integer id,
            @Valid @RequestBody Empleado empleado) {

        try {
            empleadoService.updateEmpleado(id, empleado);
            return ResponseEntity.ok("Empleado actualizado correctamente");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Empleado no encontrado");
        }
    }
    @DeleteMapping ("/{id}")
    public ResponseEntity<Object> deleteEmpleado(@PathVariable Integer id) {
        try {
            empleadoService.deleteEmpleado(id);
            return ResponseEntity.ok("Empleado eliminado correctamente");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Empleado no encontrado");
        }
    }

}


