package com.example.ms_torneo.Service;

import com.example.ms_torneo.Model.Torneo;
import com.example.ms_torneo.Repository.TorneoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TorneoService {
    @Autowired
    private TorneoRepository torneoRepository;

    public Torneo crearTorneo(Torneo torneo){
        return torneoRepository.save(torneo);
    }
    
    public List<Torneo> obtenerTorneos(){
        return torneoRepository.findAll();
    }
    
    public Torneo obtenerPorId(int id){
        return torneoRepository.findById(id).orElse(null) ;
    }
    
   public Torneo actualizar(Integer id, Torneo torneo){

        Torneo torneo1 = torneoRepository.findById(id).orElse(null);

        if(torneo1 != null){

            torneo1.setNombre(torneo1.getNombre());
            torneo1.setFecha_inicio(torneo1.getFecha_inicio());
            torneo1.setFecha_fin(torneo1.getFecha_fin());
            torneo1.setCantidad_equipos(torneo1.getCantidad_equipos());

            return torneoRepository.save(torneo1);
        }

        return null;
    }

    public String eliminar(int id){
        torneoRepository.deleteById(id);
        return "Se ha eliminado correctamente";
    }
}
