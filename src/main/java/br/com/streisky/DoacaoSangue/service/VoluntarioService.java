package br.com.streisky.DoacaoSangue.service;

import br.com.streisky.DoacaoSangue.model.Voluntario;
import br.com.streisky.DoacaoSangue.repository.VoluntarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VoluntarioService {

    @Autowired
    private VoluntarioRepository repository;

    private boolean validate(Voluntario voluntario) throws Exception {
        String msgError = "Erro ao salvar o Voluntário. ";

        if (voluntario.getNome().isEmpty() || voluntario.getNome().isBlank()) {
            throw new Exception(msgError + "O nome não pode ser vazio!");
        }

        if (voluntario.getNome().length() > 50) {
            throw new Exception(msgError + "O nome não pode possuir mais de 50 caracteres!");
        }

        if (voluntario.getIdade() < 0) {
            throw new Exception(msgError + "A idade não pode ser menor que zero!");
        }

        if (voluntario.getObservacao().length() > 500) {
            throw new Exception(msgError + "A observação não pode possuir mais de 500 caracteres!");
        }

        return true;
    }

    public void save(Voluntario voluntario) throws Exception {
        if (validate(voluntario)) {
            repository.save(voluntario);
        }
    }

    public void edit(Long id, Voluntario voluntario) throws Exception {
        if (repository.findById(id).isPresent()) {
            save(voluntario);
        } else {
            throw new Exception("Erro ao editar o Voluntário. Não existe registro com o ID = " + voluntario.getId());
        }
    }

    public void delete(Voluntario voluntario) throws Exception {
        if (repository.findById(voluntario.getId()).isPresent()) {
            repository.delete(voluntario);
        } else {
            throw new Exception("Erro ao deletar o Voluntário. Não existe registro com o ID = " + voluntario.getId());
        }
    }

    public Voluntario findById(Long id) throws Exception {
        Optional<Voluntario> o = repository.findById(id);

        if (o.isPresent()) {
            return o.get();
        } else {
            throw new Exception("Erro ao localizar o Voluntário. Não existe registro com o ID = " + id);
        }
    }

    public List<Voluntario> findAll() {
        return repository.findAll();
    }
}
