package com.senac.starter.repositorys;

import com.senac.starter.models.Resultado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultadoRepository extends JpaRepository<Resultado,Long> {

    Resultado findResultadoByid(Long id);
}
