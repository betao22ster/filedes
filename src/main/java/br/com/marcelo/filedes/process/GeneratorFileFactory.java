package br.com.marcelo.filedes.process;

import br.com.marcelo.filedes.enums.Out;

/**
 * 
 * Factory que vai ser usada para criar a classe para a geração do conteudo final.
 * POde ser implementado outras classes posteriores com saidas diferentes.
 * 
 * @author Marcelo
 *
 */
public class GeneratorFileFactory {

	private GeneratorFileFactory() {
	}
	
	@SuppressWarnings("rawtypes")
	public static GeneratorFile getInstance(Out out){
		
		if( out == Out.CVS ){
			return new GeneratorFileCSV();
		}
		
		return null;
	}
	
}
