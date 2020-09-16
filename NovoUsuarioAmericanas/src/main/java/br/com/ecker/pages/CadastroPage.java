package br.com.ecker.pages;

import static br.com.ecker.core.DriverFactory.getDriver;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.ecker.core.BasePage;
import br.com.ecker.core.DriverFactory;

public class CadastroPage extends BasePage {
	
	public void acessarTelaCadastro(){
		DriverFactory.getDriver().get("https://cliente.americanas.com.br/simple-login/cadastro/");
		
	}
	
	public void setEmail(String email) {
		escrever("email-input", email);
	}
	
	public void setSenha(String senha) {
		escrever("password-input", senha);
	}
	
	public void setCpf (String cpf) {
		escrever("cpf-input", cpf);
	}
	
	public void setNome(String nome) {
		escrever("name-input", nome);
	}
	
	public void setNascimento(String data) {
		escrever("birthday-input", data);
		
	}
	
	public void setSexoMasculino() {
		clicarRadio(By.xpath("//label[@for='gender_M']"));
	}
	
	public void setSexoFeminino() {
		clicarRadio(By.xpath("//label[@for='gender_F']"));
	}
	
	public void setTelefone(String tel) {
		escrever("phone-input", tel);
	}
	
	public void clicaBotãoCadastrar(){
		clicarBotaoPorTexto("Criar seu cadastro");
	}
	
	
	public List<String> obterErros(){
		WebDriverWait wait = new WebDriverWait(getDriver(), 90);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[starts-with(@class, 'inputGroup-error')]")));
		
		List<WebElement> erros = getDriver().findElements(By.xpath("//div[starts-with(@class, 'inputGroup-error')]"));
		List<String> retorno = new ArrayList<String>();
		for(WebElement erro: erros) {
			retorno.add(erro.getText());
		}
		return retorno;
	}
	
	public String retornaUrl() {
		WebDriverWait wait = new WebDriverWait(getDriver(), 90);
		Boolean element = wait.until(ExpectedConditions.urlToBe("https://www.americanas.com.br/") );
		return validaUrl();
	}
	
	
	
}
