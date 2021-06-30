package br.com.streisky.DoacaoSangue;

import br.com.streisky.DoacaoSangue.Utils.Constantes;
import br.com.streisky.DoacaoSangue.model.Voluntario;
import br.com.streisky.DoacaoSangue.repository.VoluntarioRepository;
import br.com.streisky.DoacaoSangue.service.VoluntarioService;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 *
 * @author Streisky
 */
@DataJpaTest
@ExtendWith(SpringExtension.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class VoluntarioServiceTests {

    @Mock
    private VoluntarioRepository repository;

    @InjectMocks
    private VoluntarioService service;

    private static final Voluntario voluntario = new Voluntario("Test", 10, Constantes.MASCULINO, Constantes.O, "Nenhuma");

    @Test
    void testSaveVoluntario1() {
        Mockito.when(repository.save(voluntario)).thenReturn(voluntario);

        Assertions.assertDoesNotThrow(() -> service.save(voluntario));
    }
    
    @Test
    void testSaveVoluntario2() {
        Voluntario v = voluntario;
        v.setNome("");
        Mockito.when(repository.save(voluntario)).thenReturn(voluntario);

        Assertions.assertThrows(Exception.class, () -> service.save(voluntario));
    }
    
    @Test
    void testSaveVoluntario3() {
        Voluntario v = voluntario;
        v.setNome("Testttttttttttttttttttttttttttttttttttttttttttttttttt");
        Mockito.when(repository.save(voluntario)).thenReturn(voluntario);

        Assertions.assertThrows(Exception.class, () -> service.save(voluntario));
    }
    
    @Test
    void testSaveVoluntario4() {
        Voluntario v = voluntario;
        v.setIdade(-5);
        Mockito.when(repository.save(voluntario)).thenReturn(voluntario);

        Assertions.assertThrows(Exception.class, () -> service.save(voluntario));
    }
    
    @Test
    void testSaveVoluntario5() {
        Voluntario v = voluntario;
        v.setNome("Testttttttttttttttttttttttttttttttttttttttttttttttttttttttttt"
                + "ttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttt"
                + "ttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttt"
                + "ttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttt"
                + "ttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttt"
                + "ttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttt"
                + "ttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttt"
                + "ttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttt"
                + "tttttttttttt");
        Mockito.when(repository.save(voluntario)).thenReturn(voluntario);

        Assertions.assertThrows(Exception.class, () -> service.save(voluntario));
    }
    
    @Test
    void testFindById() {
        Voluntario v = voluntario;
        v.setId(99l);
        Mockito.when(repository.findById(99l)).thenReturn(Optional.of(v));
        
        Assertions.assertDoesNotThrow(() -> service.findById(99l));
        Assertions.assertThrows(Exception.class, () -> service.findById(100l));
    }
    
}
