package it.emanuel;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Magazine extends ElementoCatalogo {
	
	@Column(name = "periodicita")
	private Periodicity periodicita;
	
	public Magazine() {
		
	}

	public Magazine(String isbn, String titolo, String data, int numeroPagine, Periodicity periodicita) {
		super(isbn, titolo, data, numeroPagine);
		this.periodicita = periodicita;
	}

	public Periodicity getPeriodicita() {
		return periodicita;
	}

	public void setPeriodicita(Periodicity periodicita) {
		this.periodicita = periodicita;
	}
	
	
	
}
