package br.com.marcelo.filedes.process;

import java.util.logging.Logger;

import br.com.marcelo.filedes.file.FileOut;
import br.com.marcelo.filedes.file.FileOutCSV;

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
