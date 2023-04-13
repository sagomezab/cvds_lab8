package edu.eci.cvds.servlet.model;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface RepositoryGuess extends JpaRepository<ConfigurationBean, Long>{
    boolean existsById(String propiedadId);

    ConfigurationBean findById(String propiedadId);
}
