package it.emanuel;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

@Entity
@Inheritance (strategy = InheritanceType.SINGLE_TABLE)
@NamedQuery(name = "elementoPerISBN" , query = " SELECT e FROM ElementoCatalogo e WHERE e.isbn LIKE :isbn ")
@NamedQuery(name = "elementoPerTitolo" , query = " SELECT e FROM ElementoCatalogo e WHERE e.titolo LIKE :titolo ")
@NamedQuery(name = "elementoPerPubblicazione" , query = " SELECT e FROM ElementoCatalogo e WHERE e.data LIKE :data ")
public abstract class ElementoCatalogo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "ISBN")
	private String isbn;
	
	@Column(name = "Titolo")
	private String titolo;
	
	@Column(name = "Pubblicazione")
	private String data;
	
	@Column(name = "Pagine")
	private int numeroPagine;
	
	@ManyToOne
	@JoinColumn(name = "Prestito")
	private Prestito prestito;
	
	public ElementoCatalogo() {
		
	}
	
	public ElementoCatalogo(String isbn, String titolo, String data, int numeroPagine) {
		this.isbn = isbn;
		this.titolo = titolo;
		this.data =  data;
		this.numeroPagine = numeroPagine;
	}
	
	public Prestito getPrestito() {
		return prestito;
	}

	public void setPrestito(Prestito prestito) {
		this.prestito = prestito;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public int getNumeroPagine() {
		return numeroPagine;
	}

	public void setNumeroPagine(int numeroPagine) {
		this.numeroPagine = numeroPagine;
	}

	@Override
	public String toString() {
		return "ElementoCatalogo [id=" + id + ", isbn=" + isbn + ", titolo=" + titolo + ", data=" + data
				+ ", numeroPagine=" + numeroPagine + "]";
	}
	
}
