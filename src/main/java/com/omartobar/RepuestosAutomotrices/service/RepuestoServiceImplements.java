package com.omartobar.RepuestosAutomotrices.service;

import com.omartobar.RepuestosAutomotrices.entity.Repuesto;
import com.omartobar.RepuestosAutomotrices.repository.RepuestoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RepuestoServiceImplements implements RepuestoService{
    private final RepuestoRepository repuestoRepository;

    public RepuestoServiceImplements(RepuestoRepository repuestoRepository){
        this.repuestoRepository = repuestoRepository;
    }


    @Override
    public List<Repuesto> getAllRepuestos() {
        return repuestoRepository.findAll();
    }

    @Override
    public Repuesto getRepuestoById(Integer id) {
        return repuestoRepository.findById(id).orElse(null);
    }

    @Override
    public Repuesto saveRepuesto(Repuesto repuesto) throws RuntimeException {
        return repuestoRepository.save(repuesto);
    }

    @Override
    public Repuesto updateRepuesto(Integer id, Repuesto repuesto) {
        Optional<Repuesto> repuestoExistente = repuestoRepository.findById(id);
        if (repuestoExistente.isPresent()){
            Repuesto newRepuesto = repuestoExistente.get();
            newRepuesto.setIdCategoria(repuesto.getIdCategoria());
            newRepuesto.setDescripcionCategoria(repuesto.getDescripcionCategoria());
            newRepuesto.setNombreCategoria(repuesto.getNombreCategoria());
            return repuestoRepository.save(newRepuesto);
        }else{
            return null;
        }
    }

    @Override
    public void deleteRepuesto(Integer id) {

    }
}
