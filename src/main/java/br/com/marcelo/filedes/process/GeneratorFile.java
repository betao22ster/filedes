package br.com.marcelo.filedes.process;

import java.io.OutputStream;
import java.util.List;

import br.com.marcelo.filedes.exceptios.ErroException;
import br.com.marcelo.filedes.file.FileOut;

public interface GeneratorFile<T> {
	OutputStream process(List<T> list) throws ErroException;
	FileOut getFileOut(); 
}
