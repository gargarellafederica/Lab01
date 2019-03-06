package it.polito.tdp.parole.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Parole {
	List<String> par;
	public Parole() {
		par= new ArrayList<String>();
	}
	
	public void addParola(String p) {
				par.add(p);
	}
	
	public List<String> getElenco() {
		Collections.sort(par);
		
		return par;
	}
	
	public void reset() {
		par.clear();
	}

	public void removeParola(String parola) {
		
		par.remove(parola);
	}

}
