package br.com.marcelo.filedes.arquivo;

import java.io.OutputStream;

public interface FileOut {
	String getContentString();
	OutputStream getContentStream() throws Exception;
	void addHeader(Col[] header);
	void addLine(Value[] line);
	Col[] getHeader();
	Col getHeader(String name);
	Object getValueLine(int numLine, String field);
	void createContent();
}
