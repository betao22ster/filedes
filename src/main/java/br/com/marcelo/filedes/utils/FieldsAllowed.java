package br.com.marcelo.filedes.utils;

import java.lang.reflect.Field;

import br.com.marcelo.filedes.exceptios.ErroException;

public class FieldsAllowed {

	private static final FieldsAllowed INSTANCE = new FieldsAllowed();
	private static final String[] ALLOWED = {"String", "Long", "Double", "Integer", "Number", "Boolean"};
	
	private FieldsAllowed() {
	}
	
	public static FieldsAllowed getInstance(){
		return INSTANCE;
	}
	
	public boolean isNotPermitido(Field field) throws ErroException{
		
		if( field == null ){
			return false;
		}
		
		if( field.getType().isPrimitive() ){
			return false;
		}
		
		boolean verf = true;
		for(String item : ALLOWED){
			if( item.equals(field.getType().getSimpleName()) ){
				verf = false;
			}
		}
		
		return verf;
	}
	
}
