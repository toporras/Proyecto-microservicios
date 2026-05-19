package com.example.ms_estadistica.Service;

import com.example.ms_estadistica.Model.Estadistica;
import com.example.ms_estadistica.Repository.EstadisticaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class EstadisticaService {
    @Autowired
    private EstadisticaRepository estadisticaRepository;

    public Estadistica crear (Estadistica estadistica){
        return estadisticaRepository.save(estadistica);
    }

    public List <Estadistica> obtenerEstadisticas(){
        return estadisticaRepository.findAll();
    }

    public Estadistica actualizar (Estadistica estadistica){
        return estadisticaRepository.save(estadistica);
    }

    public String delete(int id){
        estadisticaRepository.deleteById(id);
        return "Se ha eliminado correctamente";
    }

}
