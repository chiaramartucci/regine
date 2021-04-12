package it.polito.regine.model;

import java.util.List;

public class Regine {

	// N = numero di righe e colonne della scacchiera
	// righe e colonne = {0, . . . , N-1}
	// ad ogni livello, posizioniamo una regina in una nuova riga
	// soluzione parziale: lista delle colonne in cui mettere
	// le regine (prime righe) 
	// livello = quante righe sono già piene
	
	// livello = 0 --> nessuna riga piena (devo mettere la 
	// regina nella riga 0)
	// livello = 3 --> 3 righe piene (devo mettere la regina
	// nella riga 3
	
	// la soluzione è creo un vettore come lista di posizioni, 
	// lista delle colonne dove sono posizionate le regine
	// [0, 6, 4, 7, 1, 3, 5, 2] : vuol dire che nella colonna 
	// 0 ho la regina in posizione 0, nella colonna 1 ho la regina 
	// in posizione 6, nella colonna 2 ho la regina in posizione 4, ..
	
	
}
