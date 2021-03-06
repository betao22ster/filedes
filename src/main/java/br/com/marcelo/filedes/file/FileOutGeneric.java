package br.com.marcelo.filedes.file;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import br.com.marcelo.filedes.exceptios.ErroException;

public abstract class FileOutGeneric implements FileOut{

	private static final Logger LOG = Logger.getLogger(FileOutGeneric.class.getName());
	protected static final String TAB = ";";
	protected static final String TAB_LINE = "\n";
	
	private Col[] headers;
	private List<Value[]> lines = new ArrayList<Value[]>();
	
	private StringBuilder content = new StringBuilder();
	
	@Override
	public String getContentString() {
		return content.toString();
	}

	@Override
	public void addHeader(Col[] headers) {
		this.headers = headers;
	}

	@Override
	public Col[] getHeader() {
		return headers;
	}

	@Override
	public void addLine(Value[] line) {
		lines.add(line);
	}

	@Override
	public Col getHeader(String name) {
		for (Col col : headers) {
			if( name.equals(col.getName())){
				return col;
			}
		}
		return null;
	}

	@Override
	public Object getValueLine(int numLine, String field) {
		
		if( lines.size() < numLine ){
			return null;
		}
		
		Col col = getHeader(field);
		return lines.get(numLine)[col.getCol()].getValue();
	}

	protected StringBuilder getContent() {
		return content;
	}

	protected void setContent(StringBuilder content) {
		this.content = content;
	}

	protected void setCabecalho(Col[] headers) {
		this.headers = headers;
	}

	protected List<Value[]> getLines() {
		return lines;
	}
	
	@Override
	public OutputStream getContentStream() throws ErroException  {

		try (ByteArrayOutputStream ret = new ByteArrayOutputStream()) {
			ret.write( getContentString().getBytes() );
			return ret;
		} catch (IOException e) {
			LOG.warning(e.getMessage());
           throw new ErroException("Erro ao gerar a saída em Stream.");
        }
		
	}
}
