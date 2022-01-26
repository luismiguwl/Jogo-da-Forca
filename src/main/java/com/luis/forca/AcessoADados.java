package com.luis.forca;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

public class AcessoADados {

	private String destino;
	
	public AcessoADados(String destino) {
		this.destino = destino;
	}
	
    public List<ElementoDaForca> obterPalavrasEDicas() {
    	List<ElementoDaForca> palavrasEDicas = new ArrayList<>();
    	
    	try {
            List<CSVRecord> records = lerArquivoCSV();
    		
            for (CSVRecord record : records) {
                String palavra = record.get("palavra");
                String dica = record.get("dica");
                
                palavrasEDicas.add(new ElementoDaForca(palavra, dica));
            }

            return palavrasEDicas;
        } catch (IOException ex) {
        	ex.printStackTrace();
        	throw new NullPointerException("Arquivo não foi encontrado!");
        }
    }
    
    public List<CSVRecord> lerArquivoCSV() throws IOException {
    	Reader in = new FileReader(destino);

        return CSVFormat.DEFAULT
                .withFirstRecordAsHeader()
                .parse(in)
                .getRecords();
    }
}
