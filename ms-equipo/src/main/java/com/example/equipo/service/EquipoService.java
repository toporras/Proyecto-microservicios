package com.example.equipo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.equipo.model.Equipo;
import com.example.equipo.repository.EquipoRepository;

@Service
public class EquipoService {

    @Autowired
    private EquipoRepository equipoRepository;

    
    public List<Equipo> listar(){
        return equipoRepository.findAll();
    }

    
    public Equipo buscarPorId(Integer id){
        return equipoRepository.findById(id).orElse(null);
    }

    
    public Equipo guardar(Equipo equipo){
        return equipoRepository.save(equipo);
    }

    
    public Equipo actualizar(Integer id, Equipo equipo){

        Equipo equipo1 = equipoRepository.findById(id).orElse(null);

        if(equipo1 != null){

            equipo1.setNombre(equipo1.getNombre());
            equipo1.setCiudad(equipo1.getCiudad());

            return equipoRepository.save(equipo1);
        }

        return null;
    }

   
    public void eliminar(Integer id){
        equipoRepository.deleteById(id);
    }
}