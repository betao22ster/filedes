package br.com.marcelo.filedes.processos;

import java.io.OutputStream;
import java.util.List;
import java.util.logging.Logger;

import br.com.marcelo.filedes.arquivo.FileOut;
import br.com.marcelo.filedes.pojos.Pojo;
import br.com.marcelo.filedes.utils.ReaderObject;

/**
 * 
 * Clase generica com o processamento dos dados e geração do arquivo.<br>
 * Aos métodos que são específicos para o tipo de saida, está definido como abstract para ser implementado
 * na classe correta.
 * 
 * @author Marcelo
 *
 */
abstract class GeneratorFileGeneric implements GeneratorFile<Pojo> {

	private static final Logger LOG = Logger.getLogger(GeneratorFileGeneric.class.getName());
	private FileOut fileOut;
	
	protected abstract FileOut createFileOut();
	
	@Override
	public OutputStream process(List<Pojo> list) throws Exception {
		
		LOG.info("Iniciando processo...");
		
		valid(list);

		initFileOut();
		generatorHeader(list);
		if( list != null && list.size() <= 0 ){
			return null;
		}
		
		generatorLines(list);
		formatContent();
		
		return fileOut.getContentStream();
	}

	protected void formatContent(){
		LOG.info("GErando conteudo final do arquivo...");
		fileOut.createContent();
	}

	private void generatorLines(List<Pojo> list) throws Exception {
		LOG.info("Gerando as linhas...");
		
		for( Pojo item : list ){
			fileOut.addLine(ReaderObject.getInstance().getData(fileOut.getHeader(), item));
		}
		
	}

	private void generatorHeader(List<Pojo> list) {
		
		LOG.info("Gerando o cabeçalho...");
		
		if( list.size() <= 0 ){
			LOG.info("Cancelado porque a lista está vazia.");
			return;
		}

		Pojo item = list.get(0);
		
		fileOut.addHeader(ReaderObject.getInstance().getHeaders(item));
	}

	private void initFileOut() {
		LOG.info("Iniciando arquivo de sainda...");
		this.fileOut = createFileOut();
	}

	private void valid(List<Pojo> list) throws Exception {
		
		LOG.info("Validando lista...");
		
		if( list == null ){
			LOG.warning("Lista inválida!");
			throw new Exception("Lista inválida!");
		}
		
		ReaderObject.getInstance().valid(list);
	}
	
	@Override
	public FileOut getFileOut() {
		return fileOut;
	}
}
