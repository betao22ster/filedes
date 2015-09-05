package br.com.marcelo.filedes.utils;

import java.lang.reflect.Field;
import java.util.List;

import br.com.marcelo.filedes.exceptios.ErroException;
import br.com.marcelo.filedes.file.Col;
import br.com.marcelo.filedes.file.Value;
import br.com.marcelo.filedes.pojos.Pojo;

public class ReaderObject {

	private final static ReaderObject READER_OBJECT = new ReaderObject();

	private ReaderObject() {
	}

	public static ReaderObject getInstance() {
		return READER_OBJECT;
	}

	public Col[] getHeaders(Pojo item) {

		Col[] ret = new Col[item.getClass().getDeclaredFields().length];
		int pos = 0;

		for (Field col : item.getClass().getDeclaredFields()) {
			ret[pos] = new Col(col.getName(), pos);
			pos++;
		}

		return ret;
	}

	public Value[] getData(Col[] headers, Pojo item) throws ErroException {

		try {
			Value[] line = new Value[headers.length];
			for (Col col : headers) {
				Field field;
				field = item.getClass().getDeclaredField(col.getName());
				field.setAccessible(true);
				line[col.getCol()] = new Value(field.get(item));
			}
			return line;
		} catch (Exception e) {
			throw new ErroException(e.getMessage());
		}

	}

	public void valid(List<? extends Pojo> list) throws ErroException {

		if (list == null || list.isEmpty()) {
			return;
		}

		Pojo item = list.get(0);
		for (Field col : item.getClass().getDeclaredFields()) {

			if (FieldsAllowed.getInstance().isNotPermitido(col)) {
				throw new ErroException("POJO não é permitido.");
			}

		}
	}

}
