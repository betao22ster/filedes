package br.com.marcelo.filedes.arquivo;


public class FileOutCSV extends FileOutGeneric {

	public void createContent(){
		setContent(new StringBuilder());
		
		for (int loop=0; loop < getHeader().length; loop++) {
			Col col = getHeader()[loop];
			getContent().append(col.getName()).append(TAB);
		}
		
		getContent().append(TAB_LINE);
		
		for (Value[] vals : getLines()) {
			
			for (int loop=0; loop < getHeader().length; loop++) {
				Value val = vals[loop];
				getContent().append(val.getValueStr()).append(TAB);
			}
			getContent().append(TAB_LINE);
		}
	}
	
}
