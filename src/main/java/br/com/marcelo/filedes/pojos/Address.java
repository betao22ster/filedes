package br.com.marcelo.filedes.pojos;

public class Address implements Pojo {
	private String name;
	private String street;
	private String cep;
	private Long number;
	private String city;

	public Address(String name, String street, String cep, Long number,
			String city) {
		super();
		this.name = name;
		this.street = street;
		this.cep = cep;
		this.number = number;
		this.city = city;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public static class AddressBuilder {
		private String name;
		private String street;
		private String cep;
		private Long number;
		private String city;

		public AddressBuilder name(String name) {
			this.name = name;
			return this;
		}

		public AddressBuilder street(String street) {
			this.street = street;
			return this;
		}

		public AddressBuilder cep(String cep) {
			this.cep = cep;
			return this;
		}

		public AddressBuilder street(Long number) {
			this.number = number;
			return this;
		}

		public AddressBuilder city(String city) {
			this.city = city;
			return this;
		}

		public Address build() {
			return new Address(name, street, cep, number, city);
		}
	}
}
