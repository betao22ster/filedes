package br.com.marcelo.filedes.processos;

import java.util.logging.Logger;

import br.com.marcelo.filedes.arquivo.FileOut;
import br.com.marcelo.filedes.arquivo.FileOutCSV;

/**
 * 
 * Classe que vai ser responsávil por criar o arquivo em CSV
 * 
 * @author Marcelo
 *
 */
class GeneratorFileCSV extends GeneratorFileGeneric {

	private static final Logger LOG = Logger.getLogger(GeneratorFileCSV.class.getName());
	
	public GeneratorFileCSV() {
		LOG.info("Iniciado processo de CSV");
	}

	@Override
	protected FileOut createFileOut() {
		LOG.info("Criando tratamento CSV...");
		return new FileOutCSV();
	}

}
