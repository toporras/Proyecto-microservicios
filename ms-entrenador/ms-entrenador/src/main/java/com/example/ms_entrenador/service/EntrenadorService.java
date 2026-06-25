package com.example.ms_entrenador.service;

import com.example.ms_entrenador.client.EquipoFeignClient;
import com.example.ms_entrenador.model.DTO.EquipoDTO;
import com.example.ms_entrenador.model.Entrenador;
import com.example.ms_entrenador.repository.EntrenadorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntrenadorService {

    @Autowired
    private EntrenadorRepository entrenadorRepository;

    @Autowired
    private EquipoFeignClient equipoFeignClient;

    public List<Entrenador> listar(){
        return entrenadorRepository.findAll();
    }

    public Entrenador guardar(Entrenador entrenador){
        return entrenadorRepository.save(entrenador);
    }

    public Entrenador buscarPorId(Integer id){
        return entrenadorRepository.findById(id).orElse(null);
    }

    public EquipoDTO obtenerEquipo(Integer id){
        return equipoFeignClient.obtenerEquipoPorId(id);
    }

    public Entrenador actualizar(Integer id, Entrenador entrenador){

        Entrenador e = entrenadorRepository.findById(id).orElse(null);

        if(e != null){

            e.setNombre(entrenador.getNombre());
            e.setEdad(entrenador.getEdad());
            e.setEquipoId(entrenador.getEquipoId());

            return entrenadorRepository.save(e);
        }

        return null;
    }

    public void eliminar(Integer id){
        entrenadorRepository.deleteById(id);
    }
}