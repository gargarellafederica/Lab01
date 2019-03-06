package it.polito.tdp.parole;

/**
 * Sample Skeleton for 'Parole.fxml' Controller Class
 */


import it.polito.tdp.parole.model.Parole;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ParoleController {
	
	Parole elenco ;
	String parola;

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

    @FXML
    void doInsert(ActionEvent event) {
    	//TODO
    	parola=txtParola.getText();
    	if(parola.length()==0) 
    	{
    		txtResult.appendText("Parola non valida! \n");
    		parola=null;
    	}
    	else {
    		elenco.addParola(parola);
    		txtResult.clear();
    		for(String nome: elenco.getElenco())
    			txtResult.appendText(nome+"\n");
    	}
    	txtParola.clear();
    }
    
    @FXML
    void doReset(ActionEvent event) {
    	// TODO
    	elenco.reset();
    	txtResult.clear();
    }

    @FXML
    void doCancella(ActionEvent event) {
    	String paro;
    	paro=txtResult.getSelectedText();
    	elenco.removeParola(paro);
    	
    	txtResult.clear();
		for(String nome: elenco.getElenco())
			txtResult.appendText(nome+"\n");

    }
    
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Parole.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Parole.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Parole.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Parole.fxml'.";

        elenco = new Parole() ;
        
    }
}
