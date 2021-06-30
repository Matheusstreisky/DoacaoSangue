package br.com.streisky.DoacaoSangue;

import br.com.streisky.DoacaoSangue.Utils.Constantes;
import br.com.streisky.DoacaoSangue.model.Voluntario;
import br.com.streisky.DoacaoSangue.repository.VoluntarioRepository;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
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
public class VoluntarioRepositoryTests {

    @Autowired
    private VoluntarioRepository repository;
    
    private static final Voluntario voluntario = new Voluntario("Test", 10, Constantes.MASCULINO, Constantes.O, "Nenhuma");

    @Test
    void testSaveVoluntario1() {
        Voluntario v = repository.save(voluntario);
        Assertions.assertNotNull(repository.findById(v.getId()));
    }
    
    @Test
    void testEditVoluntario() {
        Voluntario v = repository.save(voluntario);
        v.setNome("Test2");
        v.setIdade(20);
        Voluntario v2 = repository.save(v);
        
        Assertions.assertEquals("Test2", v2.getNome());
        Assertions.assertEquals(20, v2.getIdade());
        Assertions.assertEquals(Constantes.MASCULINO, v2.getSexo());
        Assertions.assertEquals(Constantes.O, v2.getTipoSanguineo());
        Assertions.assertEquals("Nenhuma", v2.getObservacao());
    }
    
    @Test
    void testDeleteVoluntario() {
        Voluntario v = repository.save(voluntario);
        repository.delete(v);
        
        Assertions.assertTrue(repository.findById(v.getId()).isEmpty());
    }
    
    @Test
    void testFindById() {
        Voluntario v = repository.save(voluntario);
        
        Assertions.assertTrue(repository.findById(v.getId()).isPresent());
    }
    
    @Test
    void testFindAll() {
        Voluntario v1 = voluntario;
        repository.save(v1);

        Voluntario v2 = new Voluntario("Test2", 20, Constantes.FEMININO, Constantes.O, "Nenhuma");
        repository.save(v2);

        Voluntario v3 = new Voluntario("Test3", 30, Constantes.FEMININO, Constantes.AB, "Nenhuma");
        repository.save(v3);
        
        List<Voluntario> list = repository.findAll();
        Assertions. assertTrue(list.size() == 3 || list.size() == 8);
    }
}
