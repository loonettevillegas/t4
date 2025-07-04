package com.t4.t4.models;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface notasRepository extends JpaRepository<Notas, Long> {
    List<Notas> findByActividadId(Integer actividadId);

}