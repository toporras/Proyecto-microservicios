package com.example.ms_arbitro.Service;

import com.example.ms_arbitro.Model.Arbitro;
import com.example.ms_arbitro.Repository.ArbitroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArbitroService {
    @Autowired
    private ArbitroRepository arbitroRepository;

    public Arbitro AñadirArbitro(Arbitro arbitro){return arbitroRepository.save(arbitro);
    }

    public List<Arbitro> obtenerArbitros(){
        return arbitroRepository.findAll();
    }

    public Arbitro obtenerPorId(int id){
        return arbitroRepository.findById(id).orElse(null);
    }

    public Arbitro actualizar(Arbitro arbitro){
        return arbitroRepository.save(arbitro);
    }

    public String eliminar(int id){
        arbitroRepository.deleteById(id);
        return "Se ha eliminado correctamente";
    }
}
