package sgpwebapi.sirhgestionpersonnel.entite;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CompteBanquaire {

	@Column
	private String banque;
	
	@Column
	private String iban;
	
	@Column
	private String bic;

	public CompteBanquaire() {}

	public CompteBanquaire(String banque, String iban, String bic) {
		this.banque = banque;
		this.iban = iban;
		this.bic = bic;
	}

	public String getBanque() {
		return banque;
	}

	public void setBanque(String banque) {
		this.banque = banque;
	}

	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	public String getBic() {
		return bic;
	}

	public void setBic(String bic) {
		this.bic = bic;
	}
}
