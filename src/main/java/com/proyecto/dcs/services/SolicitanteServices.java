package com.proyecto.dcs.services;

import com.proyecto.dcs.domain.Solicitante;

import java.util.List;
import java.util.Optional;

public interface SolicitanteServices {

    public List<Solicitante> getAll();
    public Optional<Solicitante> findById(long id);
    public  Optional<Solicitante> save(Solicitante soli);
    public  Optional<Solicitante> update(Solicitante soli);

}
