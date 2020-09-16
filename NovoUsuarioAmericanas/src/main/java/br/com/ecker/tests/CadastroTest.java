package br.com.ecker.tests;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.ecker.core.BaseTest;
import br.com.ecker.pages.CadastroPage;
 

public class CadastroTest extends BaseTest {
	private CadastroPage cadastroPege = new CadastroPage();

	@Test
	public void testEmailJaCadastrado(){
		cadastroPege.acessarTelaCadastro();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		cadastroPege.setEmail("teste@hotmail.com");
		cadastroPege.setSenha("12345678");
		cadastroPege.setCpf("67602018095");
		cadastroPege.setNome("Teste da Silva");
		cadastroPege.setNascimento("01/01/1990");
		cadastroPege.setSexoMasculino();
		cadastroPege.setTelefone("41987654321");
		cadastroPege.clicaBotãoCadastrar();
		
		List<String> erros = cadastroPege.obterErros();
		
		Assert.assertTrue(erros.contains("E-mail já cadastrado"));
		Assert.assertEquals(1, erros.size());
	}
	
	@Test
	public void testSenhaDoisDigitos(){
		cadastroPege.acessarTelaCadastro();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		cadastroPege.setEmail("teste12111111@hotmail.com");
		cadastroPege.setSenha("12");
		cadastroPege.setCpf("67602018095");
		cadastroPege.setNome("Teste da Silva");
		cadastroPege.setNascimento("01/01/1990");
		cadastroPege.setSexoMasculino();
		cadastroPege.setTelefone("41987654321");
		cadastroPege.clicaBotãoCadastrar();
		
		List<String> erros = cadastroPege.obterErros();
		
		Assert.assertTrue(erros.contains("Senha precisa ter entre 6 a 50 caracteres."));
		Assert.assertEquals(1, erros.size());
	}
	
	@Test
	public void testCpfInvalido(){
		cadastroPege.acessarTelaCadastro();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		cadastroPege.setEmail("teste13333333@hotmail.com");
		cadastroPege.setSenha("12345678");
		cadastroPege.setCpf("12345678901");
		cadastroPege.setNome("Teste da Silva");
		cadastroPege.setNascimento("01/01/1990");
		cadastroPege.setSexoMasculino();
		cadastroPege.setTelefone("41987654321");
		cadastroPege.clicaBotãoCadastrar();
		
		List<String> erros = cadastroPege.obterErros();
		
		Assert.assertTrue(erros.contains("CPF inválido."));
		Assert.assertEquals(1, erros.size());
	}
	
	
	@Test
	public void testCadastro(){
		cadastroPege.acessarTelaCadastro();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		cadastroPege.setEmail("teste13333133@hotmail.com");
		cadastroPege.setSenha("12345678");
		cadastroPege.setCpf("75665040029");
		cadastroPege.setNome("Teste da Silva");
		cadastroPege.setNascimento("01/01/1990");
		cadastroPege.setSexoMasculino();
		cadastroPege.setTelefone("41987654321");
		cadastroPege.clicaBotãoCadastrar();

		String url = cadastroPege.retornaUrl();
		Assert.assertEquals("https://www.americanas.com.br/", url  );
		
	}
}
