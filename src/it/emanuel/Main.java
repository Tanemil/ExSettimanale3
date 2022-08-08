package it.emanuel;

public class Main {

	public static void main(String[] args) {
		
		Utente utente = new Utente("Emanuel","Tancau","12/03/49","12345");
		Prestito prestito = new Prestito(utente,(long) 2,"12/03/23","12/03/26","");
		
		Book libro = new Book("1233432","casa","12/07/23",120,"io","horror");
		Book libro1 = new Book("1453532","leone","12/07/23",120,"io","storico");
		Book libro2 = new Book("6457437","lucertola","12/07/23",120,"io","drama");
		Book libro3 = new Book("7342785","rinoceronte","12/07/23",120,"io","romantico");
		Book libro4 = new Book("8436528","bradipo","12/07/23",120,"io","thriller");
		Archivio ar = new Archivio();
		ar.insertEntity(libro);
		ar.insertEntity(libro1);
		ar.insertEntity(libro2);
		ar.insertEntity(libro3);
		ar.insertEntity(libro4);
		ar.removeEntity(libro.getIsbn());
		//System.out.println(ar.search(libro1.getIsbn()).toString());
		//System.out.println(ar.searchByAuthor(libro1.getAutore()).toString());
		//System.out.println(ar.searchByTitle(libro1.getTitolo()).toString());
		//System.out.println(ar.searchByYear(libro1.getData()).toString());
	}

}
