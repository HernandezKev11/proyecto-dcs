package com.proyecto.dcs.repositories;

import com.proyecto.dcs.domain.Solicitante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SolicitanteRepository extends JpaRepository<Solicitante, Long> {
}
