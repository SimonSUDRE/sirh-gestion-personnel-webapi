package sgpwebapi.sirhgestionpersonnel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sgpwebapi.sirhgestionpersonnel.entite.Departement;
import sgpwebapi.sirhgestionpersonnel.repository.DepartementsRepository;

@RestController
@RequestMapping("/api/departements")
public class DepartementsApiController {
	
	@Autowired
	private DepartementsRepository exempleRepo;

	@GetMapping
	public List<Departement> listerexemples() {
		return this.exempleRepo.findAll();
	}
}
