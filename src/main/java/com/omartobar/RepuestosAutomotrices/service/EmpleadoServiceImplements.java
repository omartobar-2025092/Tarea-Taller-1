package com.omartobar.RepuestosAutomotrices.service;

import com.omartobar.RepuestosAutomotrices.entity.Empleado;
import com.omartobar.RepuestosAutomotrices.repository.EmpleadoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoServiceImplements implements  EmpleadoService{
    private final EmpleadoRepository empleadoRepository;

    public EmpleadoServiceImplements(EmpleadoRepository empleadoRepository){
        this.empleadoRepository = empleadoRepository;
    }


    @Override
    public List<Empleado> getAllEmpleados() {
        return empleadoRepository.findAll();
    }

    @Override
    public Empleado getEmpleadoById(Integer id) {
        return empleadoRepository.findById(id).orElse(null);
    }

    @Override
    public Empleado saveEmpleado(Empleado empleado) throws RuntimeException {
        return empleadoRepository.save(empleado);
    }

    @Override
    public Empleado updateEmpleado(Integer id, Empleado empleado) {
        Optional<Empleado> empleadoExistente = empleadoRepository.findById(id);
        if (empleadoExistente.isPresent()){
            Empleado newEmpleado = empleadoExistente.get();
            newEmpleado.setApellidoEmpleado(empleado.getApellidoEmpleado());
            newEmpleado.setEmailEmpleado(empleado.getEmailEmpleado());
            newEmpleado.setNombreEmpleado(empleado.getNombreEmpleado());
            newEmpleado.setPuestoEmpleado(empleado.getPuestoEmpleado());
        return empleadoRepository.save(newEmpleado);
        }else{
            return null;
        }
    }

    @Override
    public void deleteEmpleado(Integer id) {
        empleadoRepository.deleteById(id);
    }
}
