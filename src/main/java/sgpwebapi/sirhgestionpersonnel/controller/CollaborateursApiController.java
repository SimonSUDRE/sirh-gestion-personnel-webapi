package sgpwebapi.sirhgestionpersonnel.controller;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sgpwebapi.sirhgestionpersonnel.entite.Collaborateur;
import sgpwebapi.sirhgestionpersonnel.entite.CompteBanquaire;
import sgpwebapi.sirhgestionpersonnel.entite.Departement;
import sgpwebapi.sirhgestionpersonnel.repository.CollaborateursRepository;

@RestController
@RequestMapping("/collaborateurs")
public class CollaborateursApiController {

	@Autowired
	private CollaborateursRepository collabRepo;

	@GetMapping
	public List<Collaborateur> lister() {
		return collabRepo.findAll();
	}

	@GetMapping(path = "?departement={id}")
	public List<Collaborateur> listerParDepartement(@RequestParam("departement") Integer id) {
		return collabRepo.findAll().stream().filter(c -> c.getDepartement().getId() == id).collect(Collectors.toList());
	}

	@GetMapping(path = "/{matricule}")
	public Collaborateur afficherCollaborateur(@PathVariable String matricule) {
		return collabRepo.getByMatricule(matricule);
	}

	@PutMapping(path = "/{matricule}")
	public void modifierCollaborateur(@PathVariable String matricule) {
		Collaborateur collab = collabRepo.getByMatricule(matricule);
		collab.setActif(true);
		collab.setAdresse("");
		collab.setDateDeNaissance(LocalDate.now());
		collab.setBanque(new CompteBanquaire("", "", ""));
		collab.setDateHeureCreation(ZonedDateTime.now());
		collab.setDepartement(new Departement(""));
		collab.setEmailPro("");
		collab.setIntitulePoste("");
		collab.setNom("");
		collab.setNumeroDeSecuriteSociale("");
		collab.setPhoto("");
		collab.setPrenom("");
		collab.setTelephone("");
		collabRepo.save(collab);
	}

	@GetMapping(path = "/{matricule}/banque")
	public CompteBanquaire afficherBanqueCollaborateur(@PathVariable String matricule) {
		return collabRepo.getByMatricule(matricule).getBanque();
	}

	@PutMapping(path = "/{matricule}/banque")
	public void modifierBanqueCollaborateur(@PathVariable String matricule) {
		Collaborateur collab = collabRepo.getByMatricule(matricule);
		collab.setBanque(new CompteBanquaire("", "", ""));
		collabRepo.save(collab);
	}
}
