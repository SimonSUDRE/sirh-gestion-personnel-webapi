package sgpwebapi.sirhgestionpersonnel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import sgpwebapi.sirhgestionpersonnel.entite.Collaborateur;
import sgpwebapi.sirhgestionpersonnel.entite.Departement;

public interface CollaborateursRepository extends JpaRepository<Collaborateur, Integer>{

	public List<Collaborateur> getByDepartement(Departement departement);
	public Collaborateur getByMatricule(String matricule);
}
