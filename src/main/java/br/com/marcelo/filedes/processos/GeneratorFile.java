package br.com.marcelo.filedes.processos;

import java.io.OutputStream;
import java.util.List;

import br.com.marcelo.filedes.arquivo.FileOut;

public interface GeneratorFile<T> {
	OutputStream process(List<T> list) throws Exception;
	FileOut getFileOut(); 
}
