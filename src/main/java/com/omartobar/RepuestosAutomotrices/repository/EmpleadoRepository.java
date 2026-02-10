package com.omartobar.RepuestosAutomotrices.repository;

import com.omartobar.RepuestosAutomotrices.entity.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Integer> {


}
