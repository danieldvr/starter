package com.senac.starter.repositorys;

import com.senac.starter.models.Candidato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidatoRepository extends JpaRepository<Candidato,Long> {

    Candidato findCandidatoById(Long id);
}
