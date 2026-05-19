package com.example.ms_posiciones.Service;

import com.example.ms_posiciones.Model.Posiciones;
import com.example.ms_posiciones.Repository.PosicionesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PosicionesService {
    @Autowired
    private PosicionesRepository posicionesRepository;

    public Posiciones crear(Posiciones posiciones){
        return posicionesRepository.save(posiciones);
    }

    public List<Posiciones> listarPosiciones(){
        return posicionesRepository.findAll();
    }

    public Posiciones listarPorId(int id){
        return posicionesRepository.findById(id).orElse(null);
    }

    public String eliminar(int id){
        posicionesRepository.deleteById(id);
        return "La posicion se ha eliminado correctamente";
    }

}
