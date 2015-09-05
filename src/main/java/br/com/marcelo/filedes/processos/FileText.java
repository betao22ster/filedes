package br.com.marcelo.filedes.processos;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Logger;

public class FileText {
	
	private static final Logger LOG = Logger.getLogger(FileText.class.getName());
	
	private Path arquivo;
	
	private FileText(ArquivoTextoBuilder builder) {
		arquivo = builder.path;
	}
	
	public Path getArquivo() {
		return arquivo;
	}

	public static class ArquivoTextoBuilder {
		
		private Path path;

		public ArquivoTextoBuilder lerResource(String nomeArquivo){
			
			LOG.info("Iniciando leitura de arquivo do resource: " + nomeArquivo);
			String file = getClass().getClassLoader().getResource(nomeArquivo).getFile();
			
			if( file.charAt(0) == '/' ){
				file = file.substring(1, file.length());
			}
			
			path = Paths.get(file);
			
			return this;
		}
		
		public FileText build(){
			return new FileText(this);
		}

		public ArquivoTextoBuilder ler(String file) {
			
			LOG.info("Iniciando leitura de arquivo externo: " + file);
			
			path = Paths.get(file);
			
			if( !Files.exists(path) ){
				LOG.info("Arquivo não encontrado.");
				path = null;
			}
			
			return this;
		}
		
	}
}
