package sgpwebapi.sirhgestionpersonnel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sgpwebapi.sirhgestionpersonnel.entite.Collaborateur;

public interface CollaborateursRepository extends JpaRepository<Collaborateur, Integer>{

	public Collaborateur getByMatricule(String matricule);
}
