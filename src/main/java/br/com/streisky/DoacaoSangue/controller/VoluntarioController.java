package br.com.streisky.DoacaoSangue.controller;

import br.com.streisky.DoacaoSangue.Utils.Constantes;
import br.com.streisky.DoacaoSangue.model.Voluntario;
import br.com.streisky.DoacaoSangue.service.VoluntarioService;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "session")
public class VoluntarioController {

    @Autowired
    private VoluntarioService service;
    private final List<String> listaSexos, listaTiposSanguineos;

    private Voluntario voluntario;
    private boolean enabled, btnNew, btnEdit, btnSave, btnDelete, btnCancel;
    private String message;

    public VoluntarioController() {
        this.listaSexos = new ArrayList<>();
        this.listaSexos.add(Constantes.MASCULINO);
        this.listaSexos.add(Constantes.FEMININO);
        this.listaSexos.add(Constantes.OUTRO);

        this.listaTiposSanguineos = new ArrayList<>();
        this.listaTiposSanguineos.add(Constantes.A);
        this.listaTiposSanguineos.add(Constantes.B);
        this.listaTiposSanguineos.add(Constantes.AB);
        this.listaTiposSanguineos.add(Constantes.O);

        enableFields(false);
    }

    private void enableFields(boolean enable) {
        if (!enable) {
            voluntario = new Voluntario();
        }

        enabled = enable;
        btnNew = !enable;
        btnEdit = !enable;
        btnSave = enable;
        btnDelete = enable;
        btnCancel = enable;
    }

    public void newVoluntario() {
        enableFields(true);

        voluntario = new Voluntario();
        btnDelete = false;
        clearMessage();
    }

    public void saveVoluntario() {
        try {
            service.save(voluntario);
        } catch (Exception ex) {
            message = ex.getMessage();
            Logger.getLogger(VoluntarioController.class.getName()).log(Level.SEVERE, null, ex);
        }

        enableFields(false);
    }

    public void editVoluntario(Long id) {
        findVoluntario(id);
        enableFields(true);
        clearMessage();
    }

    public void cancelVoluntario() {
        enableFields(false);
    }

    public void deleteVoluntario() {
        try {
            service.delete(voluntario);
        } catch (Exception ex) {
            message = ex.toString();
            Logger.getLogger(VoluntarioController.class.getName()).log(Level.SEVERE, null, ex);
        }

        enableFields(false);
    }

    public void findVoluntario(Long id) {
        try {
            voluntario = service.findById(id);
        } catch (Exception ex) {
            message = ex.toString();
            Logger.getLogger(VoluntarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Voluntario> findAllVoluntarios() {
        return service.findAll();
    }

    private void clearMessage() {
        message = "";
    }

    // <editor-fold defaultstate="collapsed" desc="GETS and SETS">
    public Voluntario getVoluntario() {
        return voluntario;
    }

    public void setVoluntario(Voluntario voluntario) {
        this.voluntario = voluntario;
    }

    public List<String> getListaSexos() {
        return listaSexos;
    }

    public List<String> getListaTiposSanguineos() {
        return listaTiposSanguineos;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isBtnNew() {
        return btnNew;
    }

    public void setBtnNew(boolean btnNew) {
        this.btnNew = btnNew;
    }

    public boolean isBtnEdit() {
        return btnEdit;
    }

    public void setBtnEdit(boolean btnEdit) {
        this.btnEdit = btnEdit;
    }

    public boolean isBtnSave() {
        return btnSave;
    }

    public void setBtnSave(boolean btnSave) {
        this.btnSave = btnSave;
    }

    public boolean isBtnDelete() {
        return btnDelete;
    }

    public void setBtnDelete(boolean btnDelete) {
        this.btnDelete = btnDelete;
    }

    public boolean isBtnCancel() {
        return btnCancel;
    }

    public void setBtnCancel(boolean btnCancel) {
        this.btnCancel = btnCancel;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    // </editor-fold>
}
