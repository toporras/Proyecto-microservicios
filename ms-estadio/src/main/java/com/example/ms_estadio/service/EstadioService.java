package com.example.ms_estadio.service;

import com.example.ms_estadio.model.Estadio;
import com.example.ms_estadio.repository.EstadioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadioService {

    @Autowired
    private EstadioRepository estadioRepository;

    /*listar todos los estadios */
    public List<Estadio> listar(){
        return estadioRepository.findAll();
    }

    /*lsta estado por id */
    public Estadio buscarPorId(Integer id){
        return estadioRepository.findById(id).orElse(null);
    }

    /*agregar estadio */
    public Estadio guardar(Estadio estadio){
        return estadioRepository.save(estadio);
    }

    /*actualza estadio ya creado */
    public Estadio actualizar(Integer id, Estadio estadio){

        Estadio estadio1 = estadioRepository.findById(id).orElse(null);

        if(estadio1 != null){

            estadio1.setNombre(estadio.getNombre());
            estadio1.setCapacidad(estadio.getCapacidad());
            estadio1.setCiudad(estadio.getCiudad());

            return estadioRepository.save(estadio1);
        }

        return null;
    }

    /*borrar estadio */
    public void eliminar(Integer id){
        estadioRepository.deleteById(id);
    }
}