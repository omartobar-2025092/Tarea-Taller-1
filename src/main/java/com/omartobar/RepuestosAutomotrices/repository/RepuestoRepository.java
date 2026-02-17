package com.omartobar.RepuestosAutomotrices.repository;

import com.omartobar.RepuestosAutomotrices.entity.Empleado;
import com.omartobar.RepuestosAutomotrices.entity.Repuesto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepuestoRepository extends JpaRepository<Repuesto, Integer> {
    
}
