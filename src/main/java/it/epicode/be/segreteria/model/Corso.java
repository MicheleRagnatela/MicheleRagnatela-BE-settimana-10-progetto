package it.epicode.be.segreteria.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Corso {
	
	
	private int codice;
	
	private String indirizzo;
	
	private String nome;
	
	@Min(10)
	private int numeroEsami;

}
