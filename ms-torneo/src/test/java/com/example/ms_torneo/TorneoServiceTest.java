package test.java.com.example.ms_torneo;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.example.ms_torneo.Model.*;
import com.example.ms_torneo.Repository.*;
import com.example.ms_torneo.Service.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockitoBean;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class TorneoServiceTest {

    @Autowired
    private TorneoService torneoService;

}
