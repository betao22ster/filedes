package br.com.marcelo.filedes.file;

import java.io.OutputStream;

import br.com.marcelo.filedes.exceptios.ErroException;

public interface FileOut {
	String getContentString();
	OutputStream getContentStream() throws ErroException;
	void addHeader(Col[] header);
	void addLine(Value[] line);
	Col[] getHeader();
	Col getHeader(String name);
	Object getValueLine(int numLine, String field);
	void createContent();
}
