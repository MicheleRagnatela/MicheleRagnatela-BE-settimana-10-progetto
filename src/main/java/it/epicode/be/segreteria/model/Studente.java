package it.epicode.be.segreteria.model;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Studente {

	
	private int matricola;
	private String nome;
	private String cognome;
	private String dataDiNascita;
	private String email;
	private String indirizzo;
	private String citta;
	private Corso corso;

}
