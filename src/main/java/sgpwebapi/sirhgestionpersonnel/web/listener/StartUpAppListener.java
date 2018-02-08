package sgpwebapi.sirhgestionpersonnel.web.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import sgpwebapi.sirhgestionpersonnel.service.InitialiserDonneesService;

@Component
public class StartUpAppListener {

	@Autowired
	private InitialiserDonneesService initService;

	@EventListener(ContextRefreshedEvent.class)
	public void contextRefreshedEvent() {
		initService.initialiser();
	}
}