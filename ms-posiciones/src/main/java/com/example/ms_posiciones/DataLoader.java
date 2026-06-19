package main.java.com.example.ms_posiciones;

import com.example.ms_posiciones.Model.*;
import com.example.ms_posiciones.Repository.*;

import net.datafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Random;

@Profile("dev")
@Component
public class DataLoader implements CommandLineRunner{
    
    @Autowired
    private PosicionesRepository posicionesRepository;
    
    @Override
    public void run(String...args) throws Exception{
        
    Faker faker = new Faker();
    Random random = new Random();

    for(int i = 0; i < 5; i++){
        Posiciones posiciones = new Posiciones();
        posiciones.setId(i + 1);
        posiciones.setGrupo("Grupo" + faker.number().numberBetween(1, 5));
        posiciones.setTipo_clasificacion("Clasificacion" + faker.number().numberBetween(1, 5));
        posiciones.setPosicion("Posicion" + faker.number().numberBetween(1, 5));

        posicionesRepository.save(posiciones);
    }

    System.out.println("Datos guardados con exito");
    }
}
