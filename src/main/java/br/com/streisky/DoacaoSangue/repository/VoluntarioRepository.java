package br.com.streisky.DoacaoSangue.repository;

import br.com.streisky.DoacaoSangue.model.Voluntario;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface VoluntarioRepository extends CrudRepository<Voluntario, Long> {

    @Override
    List<Voluntario> findAll();
}
