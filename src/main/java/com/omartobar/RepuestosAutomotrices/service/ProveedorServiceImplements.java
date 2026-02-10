package com.omartobar.RepuestosAutomotrices.service;

import com.omartobar.RepuestosAutomotrices.entity.Proveedor;
import com.omartobar.RepuestosAutomotrices.repository.ProveedorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProveedorServiceImplements implements ProveedorService {
    private final ProveedorRepository proveedorRepository;

    public ProveedorServiceImplements(ProveedorRepository proveedorRepository) {
        this.proveedorRepository = proveedorRepository;
    }

    @Override
    public List<Proveedor> getallProveedores() {
        return proveedorRepository.findAll();
    }

    @Override
    public Proveedor getAllProveedorById(Integer id) {
        return proveedorRepository.findById(id).orElse(null);
    }

    @Override
    public Proveedor saveProveedor(Proveedor proveedor) throws RuntimeException {
        return proveedorRepository.save(proveedor);
    }

    @Override
    public Proveedor updateProveedor(Integer id, Proveedor proveedor) {
        Optional<Proveedor> proveedorExistente = proveedorRepository.findById(id);
        if (proveedorExistente.isPresent()){
            Proveedor newProveedor = proveedorExistente.get();
            newProveedor.setNombreProveedor(proveedor.getNombreProveedor());
            newProveedor.setEmailProveedor(proveedor.getEmailProveedor());
            newProveedor.setDireccionProveedor(proveedor.getDireccionProveedor());
            newProveedor.setTelefonoProveedor(proveedor.getTelefonoProveedor());
            return proveedorRepository.save(newProveedor);
        }else{
            return  null;
        }
    }

    @Override
    public void deleteProveedor(Integer id) {
        proveedorRepository.deleteById(id);
    }
}
