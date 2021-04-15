package it.polito.regine.model;

import java.util.ArrayList;
import java.util.List;

public class Regine {

	// N = numero di righe e colonne della scacchiera
	// righe e colonne = {0, . . . , N-1}
	// ad ogni livello, posizioniamo una regina in una nuova riga
	// soluzione parziale: lista delle colonne in cui mettere
	// le regine (prime righe) 
	
	// livello = 0 --> nessuna riga piena (devo mettere la 
	// regina nella riga 0)
	// livello = 3 --> 3 righe piene (devo mettere la regina
	// nella riga 3
	
	// la soluzione è creo un vettore come lista di posizioni, 
	// lista delle colonne dove sono posizionate le regine
	// [0, 6, 4, 7, 1, 3, 5, 2] : vuol dire che nella riga 
	// 0 ho la regina in posizione 0, nella riga 1 ho la regina 
	// in posizione 6, nella riga 2 ho la regina in posizione 4, ..
	
	// quando il livello è x bisogna riempire la posizione 
	// x del vettore
	
	// nella procedura ricorsiva non so se la parte già 
	// fatta sia la soluzione giusta, si assume che sia così
	
	private int N ;
	private List<Integer> soluzione;
	
	
	public List<Integer> risolvi (int N){
		this.N = N;
		List<Integer> parziale = new ArrayList<Integer>();
		this.soluzione=null;
		
		cerca(parziale,0);
		
		return this.soluzione;
	}
	
	// cerca=true -> trovato
	// cerca=false -> continua a cercare
	public boolean cerca (List<Integer> parziale, int livello) {  // [0,6,4,7]
		if (livello==N) {
			// caso terminale
			System.out.println(parziale);
			this.soluzione = new ArrayList<>(parziale);
			return true;
		}
		
		else {
			for (int colonna=0; colonna<N; colonna++) {
				// in tutte le colonne possibili (da 0 a N)
				
				if(posValida(parziale, colonna)==true) {
					parziale.add(colonna);  // [0, 6, 4, 7, 1]
					boolean trovato= cerca(parziale, livello+1);
					if(trovato==true)
						return true;
					parziale.remove(parziale.size()-1); // backtracking
				}
			}
		}
		return false;
	}

	private boolean posValida(List<Integer> parziale, int colonna) {
		int livello = parziale.size();
		
		// controlla se esiste già una delle regine precedenti 
		// sulla mia colonna, se viene cioè mangiata in verticale
		if(parziale.contains(colonna))
			return false;
		
		// controllo le diagonali: confronto la posizione 
		// (livello, colonna) con (r,c) delle regine esistenti
		for(int r=0; r<livello; r++) {
			int c=parziale.get(r);
			
			if(r+c == livello+colonna || r-c == livello-colonna) {
				return false;
			}
		}
		
		return true;
	}
	
	
}
