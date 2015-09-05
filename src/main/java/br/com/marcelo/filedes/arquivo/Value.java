package br.com.marcelo.filedes.arquivo;

public class Value {
	private Object value;

	public Value(Object valor) {
		super();
		this.value = valor;
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
