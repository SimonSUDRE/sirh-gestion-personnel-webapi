package sgpwebapi.sirhgestionpersonnel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sgpwebapi.sirhgestionpersonnel.entite.Departement;

public interface DepartementsRepository extends JpaRepository<Departement, Integer>{

}