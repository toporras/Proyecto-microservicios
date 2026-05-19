package com.example.ms_partido.Service;
import com.example.ms_partido.Model.Partido;
import com.example.ms_partido.Repository.PartidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartidoService {
    @Autowired
    private PartidoRepository partidoRepository;

    public Partido crearPartido(Partido partido){
        return partidoRepository.save(partido);
    }

    public List<Partido> verPartidos(){
        return partidoRepository.findAll();
    }

    public Partido buscarPorId(int id){
        return partidoRepository.findById(id).orElse(null);
    }

    public Partido actualizar(Partido partido){
        return partidoRepository.save(partido);
    }

    public String eliminar(int id){
        partidoRepository.deleteById(id);
        return "Se ha eliminado correctamente";
    }

}
