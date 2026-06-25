package com.example.jugador.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jugador.client.EquipoFeignClient;
import com.example.jugador.model.Jugador;
import com.example.jugador.model.DTO.EquipoDTO;
import com.example.jugador.repository.JugadorRepository;

@Service
public class JugadorService {

    @Autowired
    private JugadorRepository jugadorRepository;

    @Autowired
    private EquipoFeignClient equipoFeignClient;

    /*Lista todos en el get */
    public List<Jugador> listar(){
        return jugadorRepository.findAll();
    }

    /*lista por id */
    public Jugador buscarPorId(Integer id){
        return jugadorRepository.findById(id).orElse(null);
    }

    /*añade jugadores  */
    public Jugador guardar(Jugador jugador){
        return jugadorRepository.save(jugador);
    }

    /* actualiza */
    public Jugador actualizar(Integer id, Jugador jugador){

        Jugador j = jugadorRepository.findById(id).orElse(null);

        if(j != null){

            j.setNombre(jugador.getNombre());
            j.setPosicion(jugador.getPosicion());
            j.setEquipo_id(jugador.getEquipo_id());

            return jugadorRepository.save(j);
        }

        return null;
    }

    
    public void eliminar(Integer id){
        jugadorRepository.deleteById(id);
    }


    public EquipoDTO obtenerEquipo(Integer id){
        return equipoFeignClient.obtenerEquipoPorId(id);
    }
}