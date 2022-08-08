package it.emanuel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "elementoPerTesseraUtente" , query = " SELECT e FROM Prestito e WHERE e.utente.numeroTessera LIKE :numeroTessera ")
public class Prestito {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "utente")
	private Utente utente;
	
	@Column(name = "elementoPrestato")
	private Long idElementoPrestato;
	
	@Column(name = "dataInizio")
	private String dataInizio;
	
	@Column(name = "dataFine")
	private String dataFine;
	
	@Column(name = "dataRestituzione")
	private String dataRestituzione;

	public Prestito(Utente utente, Long idElementoPrestato, String dataInizio, String dataFine,
			String dataRestituzione) {
		this.utente = utente;
		this.idElementoPrestato = idElementoPrestato;
		this.dataInizio = dataInizio;
		this.dataFine = dataFine;
		this.dataRestituzione = dataRestituzione;
	}

	public Prestito() {

	}

	public Long getId() {
		return id;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	public Long getElementoPrestato() {
		return idElementoPrestato;
	}

	public void setElementoPrestato(Long idElementoPrestato) {
		this.idElementoPrestato = idElementoPrestato;
	}

	public String getDataInizio() {
		return dataInizio;
	}

	public void setDataInizio(String dataInizio) {
		this.dataInizio = dataInizio;
	}

	public String getDataFine() {
		return dataFine;
	}

	public void setDataFine(String dataFine) {
		this.dataFine = dataFine;
	}

	public String getDataRestituzione() {
		return dataRestituzione;
	}

	public void setDataRestituzione(String dataRestituzione) {
		this.dataRestituzione = dataRestituzione;
	}
	
	
}
