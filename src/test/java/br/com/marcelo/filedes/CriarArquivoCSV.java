package br.com.marcelo.filedes;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.junit.Assert;
import org.junit.Test;

import br.com.marcelo.filedes.enums.Out;
import br.com.marcelo.filedes.pojos.Address;
import br.com.marcelo.filedes.pojos.AddressInvalid;
import br.com.marcelo.filedes.process.GeneratorFile;
import br.com.marcelo.filedes.process.GeneratorFileFactory;

public class CriarArquivoCSV {

	private static final Logger LOG = Logger.getLogger(CriarArquivoCSV.class.getName());
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void criarArquivoNull(){
		
		List<Address> lista = null;
		
		GeneratorFile geradorArquivo = GeneratorFileFactory.getInstance(Out.CVS);
		try {
			geradorArquivo.process(lista);
		} catch (Exception e) {
			Assert.assertEquals(e.getMessage(), "Lista inválida!");
		}
		
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void criarArquivoRetornoVazia(){
		
		List<Address> lista = new ArrayList<Address>();
		GeneratorFile geradorArquivo = GeneratorFileFactory.getInstance(Out.CVS);
		try {
			geradorArquivo.process(lista);
			Assert.assertEquals(geradorArquivo.getFileOut().getContentString(), "");
		} catch (Exception e) {
			Assert.assertTrue(false);
		}
		
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void criarArquivo(){
		
		List<Address> lista = new ArrayList<Address>();
		lista.add(new Address.AddressBuilder().name("Rua arthur").city("Floripa").build());
		
		GeneratorFile geradorArquivo = GeneratorFileFactory.getInstance(Out.CVS);
		try {
			geradorArquivo.process(lista);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
		
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void cabecalhoCorreto(){
		
		List<Address> lista = new ArrayList<Address>();
		lista.add(new Address.AddressBuilder().name("Rua arthur").city("Floripa").build());
		
		GeneratorFile geradorArquivo = GeneratorFileFactory.getInstance(Out.CVS);
		try {
			geradorArquivo.process(lista);
			Assert.assertNotNull(geradorArquivo.getFileOut().getHeader("name"));
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
		
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void dadosLinhaCorreto(){
		
		List<Address> lista = new ArrayList<Address>();
		lista.add(new Address.AddressBuilder().name("Rua arthur").city("Floripa").build());
		lista.add(new Address.AddressBuilder().name("Rua arthur2").city("Floripa2").build());
		
		GeneratorFile geradorArquivo = GeneratorFileFactory.getInstance(Out.CVS);
		try {
			geradorArquivo.process(lista);
			Assert.assertEquals(geradorArquivo.getFileOut().getValueLine(1, "name").toString(), "Rua arthur2");
			Assert.assertEquals(geradorArquivo.getFileOut().getValueLine(0, "name").toString(), "Rua arthur");
			Assert.assertNull(geradorArquivo.getFileOut().getValueLine(10, "name"));
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
		
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void dadosConteudo(){
		
		List<Address> lista = new ArrayList<Address>();
		lista.add(new Address.AddressBuilder().name("Rua arthur").city("Floripa").build());
		
		GeneratorFile geradorArquivo = GeneratorFileFactory.getInstance(Out.CVS);
		try {
			geradorArquivo.process(lista);
			Assert.assertNotNull(geradorArquivo.getFileOut().getContentString());
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
		
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void dadosConteudoStream(){
		
		List<Address> lista = new ArrayList<Address>();
		lista.add(new Address.AddressBuilder().name("Rua arthur").city("Floripa").build());
		
		GeneratorFile geradorArquivo = GeneratorFileFactory.getInstance(Out.CVS);
		try {
			geradorArquivo.process(lista);
			Assert.assertNotNull(geradorArquivo.getFileOut().getContentStream());
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
		
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void dadosConteudoLerStream(){
		
		List<Address> lista = new ArrayList<Address>();
		lista.add(new Address.AddressBuilder().name("Rua arthur").city("Floripa").build());
		
		GeneratorFile geradorArquivo = GeneratorFileFactory.getInstance(Out.CVS);
		try {
			geradorArquivo.process(lista);
			
			ByteArrayOutputStream dados = (ByteArrayOutputStream) geradorArquivo.getFileOut().getContentStream();
			String out = new String(dados.toByteArray(), "UTF-8");
			Assert.assertNotNull(out);
			LOG.info("SAIDA: " + out);
			
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
		
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void pojoInvalido(){
		
		List<AddressInvalid> lista = new ArrayList<AddressInvalid>();
		lista.add(new AddressInvalid());
		
		GeneratorFile geradorArquivo = GeneratorFileFactory.getInstance(Out.CVS);
		try {
			geradorArquivo.process(lista);
			Assert.assertTrue(false);
		} catch (Exception e) {
			Assert.assertEquals(e.getMessage(), "POJO não é permitido.");
		}
		
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void dadosConteudoLerStream2(){
		
		List<Address> lista = new ArrayList<Address>();
		
		for( int loop=0; loop < 10000; loop++ ){
			lista.add(new Address.AddressBuilder().name("Rua arthur " + loop).city("Floripa").build());
		}
		
		GeneratorFile geradorArquivo = GeneratorFileFactory.getInstance(Out.CVS);
		try {
			geradorArquivo.process(lista);
			
			ByteArrayOutputStream dados = (ByteArrayOutputStream) geradorArquivo.getFileOut().getContentStream();
			String out = new String(dados.toByteArray(), "UTF-8");
			Assert.assertNotNull(out);
			LOG.info("SAIDA: " + out);
			
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
		
	}
}
