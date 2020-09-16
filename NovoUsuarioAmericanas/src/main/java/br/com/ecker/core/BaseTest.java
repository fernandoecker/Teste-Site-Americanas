package br.com.ecker.core;

import static br.com.ecker.core.DriverFactory.killDriver;

import java.io.IOException;

import org.junit.After;
import org.junit.Rule;
import org.junit.rules.TestName;

import br.com.ecker.pages.CadastroPage;

public class BaseTest {
	@Rule
	public TestName testName = new TestName();
	
	private CadastroPage page = new CadastroPage();
	
	
	@After
	public void finaliza() throws IOException{
		
		if(Propriedades.FECHAR_BROWSER) {
			killDriver();
		}
	}

}
