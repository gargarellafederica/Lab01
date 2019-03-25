package it.polito.tdp.parole;

/**
 * Sample Skeleton for 'Parole.fxml' Controller Class
 */


import it.polito.tdp.parole.model.Parole;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ParoleController {
	
	Parole elenco ;
	String parola;
	long startTime, estimatedTime;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtParola"
    private TextField txtParola; // Value injected by FXMLLoader

    @FXML // fx:id="txtResult"
    private TextArea txtResult; // Value injected by FXMLLoader
    
    @FXML
    private Button btnReset;

    @FXML // fx:id="btnInserisci"
    private Button btnInserisci; // Value injected by FXMLLoader

    @FXML // fx:id="txtTemp"
    private TextArea txtTemp; // Value injected by FXMLLoader
    
    @FXML
    void doInsert(ActionEvent event) {
       	parola=txtParola.getText();
    	parola=parola.trim();  //tolgo gli spazi precedenti e successivi la parola
    	if(parola.length()==0) 
    	{
    		txtResult.appendText("Parola non valida! \n");
    		parola=null;
    	}
    	else {
    		
    		startTime= System.nanoTime();
    		
    		elenco.addParola(parola);
    		txtResult.clear();
    		
    		estimatedTime=System.nanoTime() - startTime;
    		
    		//stampo l'elenco di parole
    		for(String nome: elenco.getElenco())
    			txtResult.appendText(nome+"\n");
    		
    		//stampo il tempo impiegato per inserire la parola
        	txtTemp.appendText("Il tempo impiegato per inserire " + parola + " è: " + estimatedTime+ " nanosecondi.\n");
    	}
    	txtParola.clear();
    	
    }
    
    @FXML
    void doReset(ActionEvent event) {
    	if(elenco.getElenco().isEmpty())
    	{
    		txtResult.clear();
    		txtTemp.setText("Elenco vuoto, niente da resettare!\n");
    	} 
    	else {
    		startTime =System.nanoTime();
        	
        	elenco.reset();
        	txtResult.clear();
        	
        	estimatedTime =System.nanoTime() - startTime;
        	
        	//stampo il tempo impiegato per resettare l'elenco
        	txtTemp.appendText("Il tempo impiegato per resettare l'elenco è: " + estimatedTime + " nanosecondi.\n");
    	}
    }

    @FXML
    void doCancella(ActionEvent event) {
    	if(elenco.getElenco().isEmpty())
    	{
    		txtResult.clear();
    		txtTemp.setText("Elenco vuoto, niente da cancellare!\n");
    	}	
    	else {
    		
        	if(txtResult.getSelectedText().isEmpty())
        		txtResult.appendText("Nessuna parola selezionata, selezionare la parola da cancellare dall'elenco!\n");
        	else {
        		startTime =System.nanoTime();
        		
        		String paro;
            	paro=txtResult.getSelectedText();
            	elenco.removeParola(paro);
            	
             	estimatedTime =System.nanoTime() - startTime;
             	
             	//stampo il nuovo elenco
            	txtResult.clear();
        		for(String nome: elenco.getElenco())
        			txtResult.appendText(nome+"\n");
        		
        		//stampo il tempo impiegato per rimuovere la parola
        		txtTemp.appendText("Il tempo impiegato per rimuovere " + paro + " è: " + estimatedTime+ " nanosecondi.\n");
        	}
    	}
    }
  
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Parole.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Parole.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Parole.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Parole.fxml'.";
        assert txtTemp != null : "fx:id=\"txtTemp\" was not injected: check your FXML file 'Parole.fxml'.";
        elenco = new Parole() ;
        
    }
}
