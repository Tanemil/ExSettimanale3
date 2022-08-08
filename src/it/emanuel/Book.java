package it.emanuel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "elementoPerAutore" , query = " SELECT e FROM Book e WHERE e.autore LIKE :autore ")
public class Book extends ElementoCatalogo {

	@Column(name = "autore")
	private String autore;
	
	@Column(name = "genere")
	private String genere;
	
	public Book() {
		
	}

	public Book(String isbn, String titolo, String data, int numeroPagine, String autore, String genere) {
		super(isbn, titolo, data, numeroPagine);
		this.autore = autore;
		this.genere = genere;
	}



	public String getAutore() {
		return autore;
	}

	public void setAutore(String autore) {
		this.autore = autore;
	}

	public String getGenere() {
		return genere;
	}

	public void setGenere(String genere) {
		this.genere = genere;
	}
	
	
}
