package br.com.marcelo.filedes.file;

public class Value {
	private Object value;

	public Value(Object value) {
		super();
		this.value = value;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}


	public String getValueStr() {
		if( value == null ){
			return "";
		}
		return value.toString();
	}
}
