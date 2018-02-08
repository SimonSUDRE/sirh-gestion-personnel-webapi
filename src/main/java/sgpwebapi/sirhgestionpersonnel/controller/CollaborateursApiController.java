package sgpwebapi.sirhgestionpersonnel.controller;

import java.lang.reflect.Field;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sgpwebapi.sirhgestionpersonnel.entite.Collaborateur;
import sgpwebapi.sirhgestionpersonnel.entite.CompteBanquaire;
import sgpwebapi.sirhgestionpersonnel.repository.CollaborateursRepository;
import sgpwebapi.sirhgestionpersonnel.repository.DepartementsRepository;

@RestController
@RequestMapping("/collaborateurs")
public class CollaborateursApiController {

	@Autowired
	private CollaborateursRepository collabRepo;

	@Autowired
	private DepartementsRepository departRepo;

	@GetMapping
	public List<Collaborateur> lister(@RequestParam("departement") Optional<Integer> id) {
		if (id.isPresent()) {
			return collabRepo.getByDepartement(departRepo.findOne(id.get()));
		}
		return collabRepo.findAll();
	}

	@GetMapping(path = "/{matricule}")
	public Collaborateur afficherCollaborateur(@PathVariable String matricule) {
		return collabRepo.getByMatricule(matricule);
	}

	@PutMapping(path = "/{matricule}")
	public Collaborateur modifierCollaborateur(@PathVariable String matricule, @RequestBody Collaborateur collab)
			throws IllegalAccessException {
		Collaborateur collabModif = collabRepo.getByMatricule(matricule);
		if (collabModif != null) {
			collab.setDateHeureCreation(ZonedDateTime.now());
			if(collab.getDepartement() != null) {
				collab.setDepartement(departRepo.findOne(collab.getDepartement().getId()));
			}			
			for (Field f : collab.getClass().getDeclaredFields()) {
				f.setAccessible(true);
				if (f.get(collab) != null) {
					f.set(collabModif, f.get(collab));
				}
			}
			collabRepo.save(collabModif);
			return collabRepo.getByMatricule(matricule);
		}
		return null;
	}

	@GetMapping(path = "/{matricule}/banque")
	public CompteBanquaire afficherBanqueCollaborateur(@PathVariable String matricule) {
		return collabRepo.getByMatricule(matricule).getBanque();
	}

	@PutMapping(path = "/{matricule}/banque")
	public CompteBanquaire modifierBanqueCollaborateur(@PathVariable String matricule, @RequestBody Collaborateur collab) throws IllegalAccessException {
		Collaborateur collabModif = collabRepo.getByMatricule(matricule);
		if (collabModif != null) {
			for (Field f : collab.getBanque().getClass().getDeclaredFields()) {
				f.setAccessible(true);
				if (f.get(collab.getBanque()) != null) {
					f.set(collabModif.getBanque(), f.get(collab.getBanque()));
				}
			}
			collabRepo.save(collabModif);
			return collabRepo.getByMatricule(matricule).getBanque();
		}
		return null;
	}
}
