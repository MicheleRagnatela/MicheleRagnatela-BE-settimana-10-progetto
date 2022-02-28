package it.epicode.be.segreteria.util;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import it.epicode.be.segreteria.model.Corso;
import it.epicode.be.segreteria.model.Segreteria;
import it.epicode.be.segreteria.model.Studente;

@Component
public class SegreteriaLoader implements CommandLineRunner {

	@Autowired
	ApplicationContext ctx;
	
	@Override
	public void run(String... args) throws Exception {
		Segreteria segreteria = ctx.getBean(Segreteria.class);
		visualizzaDB(segreteria);
	}

	private void visualizzaDB(Segreteria segreteria) {
		Corso corso1 = new Corso();
		corso1.setCodice(3);
		corso1.setNome("Scienze");
		corso1.setIndirizzo("Informatica");
		corso1.setNumeroEsami(15);
		
		Corso corso2 = new Corso();
		corso2.setCodice(1);
		corso2.setNome("Lettere");
		corso2.setIndirizzo("Storia della Filosofia");
		corso2.setNumeroEsami(18);
		
		Corso corso3 = new Corso();
		corso3.setCodice(2);
		corso3.setNome("Giurisprudenza");
		corso3.setIndirizzo("Giurisprudenza d'impresa");
		corso3.setNumeroEsami(25);
		
		
		
		Studente studente1 = new Studente();
		studente1.setMatricola(1);
		studente1.setNome("Francesco");
		studente1.setCognome("Giannini");
		studente1.setDataDiNascita("1995-10-21");
		studente1.setIndirizzo("Via Garibaldi");
		studente1.setEmail("francesco@hotmail.it");
		studente1.setCitta("Roma");
		studente1.setCorso(corso2);
		
		Studente studente2 = new Studente();
		studente2.setMatricola(2);
		studente2.setNome("Filippo");
		studente2.setCognome("Damato");
		studente2.setDataDiNascita("1998-03-25");
		studente2.setIndirizzo("Via Roma");
		studente2.setEmail("filippo@hotmail.it");
		studente2.setCitta("Barletta");
		studente2.setCorso(corso3);
		
		segreteria.aggiungiStudente(studente1);
		segreteria.aggiungiStudente(studente2);
		
		segreteria.aggiungiCorso(corso1);
		segreteria.aggiungiCorso(corso2);
		segreteria.aggiungiCorso(corso3);
		
	}
}
