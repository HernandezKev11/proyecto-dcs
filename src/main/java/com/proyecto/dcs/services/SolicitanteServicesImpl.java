package com.proyecto.dcs.services;

import com.proyecto.dcs.domain.Solicitante;
import com.proyecto.dcs.repositories.SolicitanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class SolicitanteServicesImpl implements  SolicitanteServices{

    @Autowired
    SolicitanteRepository soliRepo;

    @Override
    public List<Solicitante> getAll() {
        return soliRepo.findAll();
    }

    @Override
    public Optional<Solicitante> findById(long id) {
        return soliRepo.findById(id).map(record -> Optional.of(record)).orElse(Optional.empty());
    }

    @Override
    public  Optional<Solicitante> save(Solicitante soli) {
        Optional<Solicitante> nuevoSolicitante = Optional.of(soliRepo.save(soli));
        return nuevoSolicitante;
    }

    @Override
    public  Optional<Solicitante> update(Solicitante soli) {
        Optional<Solicitante> record = soliRepo.findById(soli.getId());
        if (record.isPresent()) {

        }
        return Optional.empty();
    }

}
