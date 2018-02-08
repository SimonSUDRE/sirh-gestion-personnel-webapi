package sgpwebapi.sirhgestionpersonnel.service;

import java.time.LocalDate;
import java.time.ZonedDateTime;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sgpwebapi.sirhgestionpersonnel.entite.Collaborateur;
import sgpwebapi.sirhgestionpersonnel.entite.CompteBanquaire;
import sgpwebapi.sirhgestionpersonnel.entite.Departement;

@Service
@Transactional
public class InitialiserDonneesServiceDev implements InitialiserDonneesService {

	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional
	public void initialiser() {
		Departement d = new Departement("info");
		em.persist(d);
		em.persist(new Departement("RH"));
		em.persist(new Departement("direction"));
		
		Collaborateur c = new Collaborateur();
		c.setMatricule("M01");
		c.setActif(true);
		c.setAdresse("50 rue de sevre");
		c.setDateDeNaissance(LocalDate.of(1996, 04, 05));
		c.setBanque(new CompteBanquaire("banque postal", "BIC 121321321", "IBAN 46546546"));
		c.setDateHeureCreation(ZonedDateTime.now());
		c.setDepartement(d);
		c.setEmailPro("ae.aze@pro.fr");
		c.setIntitulePoste("poste");
		c.setNom("aze");
		c.setNumeroDeSecuriteSociale("654657465465465");
		c.setPhoto("aze.jpg");
		c.setPrenom("aze");
		c.setTelephone("0645787878");
		em.persist(c);
	}
}