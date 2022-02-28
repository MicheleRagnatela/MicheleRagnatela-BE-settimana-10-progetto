package it.epicode.be.segreteria.model;

import java.util.Collection;
import java.util.HashMap;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Segreteria {

	private Map<Integer, Studente> studentiLista = new HashMap<Integer, Studente>();
	private Map<Integer, Corso> corsiLista = new HashMap<Integer, Corso>();

//	public void aggiungiStudente(Studente s) {
//		studenti.put(s.getMatricola(), s);
//	}
	
	public boolean aggiungiStudente(Studente s) {
        if (!studentiLista.containsKey(s.getMatricola())) {
            studentiLista.put(s.getMatricola(), s);
        } else {
            return false;
        }

        return true;
    }

	public void cancellaStudente(int matricola) {
		studentiLista.remove(matricola);
	}

	public Collection<Studente> visualizzaStudenti() {
		return studentiLista.values();
	}
	
	public Collection<Corso> visualizzaCorsi() {
		return corsiLista.values();
	}
	
//	public void aggiungiCorso(Corso c) {
//		corsiLista.put(c.getCodice(), c);
//	}
	
	public boolean aggiungiCorso(Corso corso) {
		if (!corsiLista.containsKey(corso.getCodice())) {
			corsiLista.put(corso.getCodice(), corso);
		} else {
			return false;
		}

		return true;
	}

	
	public void aggiornaStudente(Studente s) {
			studentiLista.replace(s.getMatricola(), s);
	}
	

	public void aggiornaCorso(Corso c) {
		corsiLista.replace(c.getCodice(), c);
	}
	
	public void cancellaCorso(int codice) {
		corsiLista.remove(codice);
	}

}