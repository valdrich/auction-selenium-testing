package br.com.auctionTesting;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UsersSystemTesting {
	
	private ChromeDriver driver;
	
	@Before	
	
	public void setEnv() {
		System.setProperty("webdriver.chrome.driver", "C:/selenium-master/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.get("http://localhost:8080/usuarios/new");		
	}
	
	@Test
	
	public void addNewUser() {	
		
		//ADD area to declare elements
		WebElement txtUserName = driver.findElement(By.name("usuario.nome"));
		WebElement txtUserEmail = driver.findElement(By.name("usuario.email"));
		WebElement saveButton = driver.findElement(By.id("btnSalvar"));
				
		//ADD area		
		txtUserName.sendKeys("Bruce Wayne");
		txtUserEmail.sendKeys("batman@berichismypower.com");		
		saveButton.click();		
		
		//ADD assertion area
		boolean assertNameTrue = driver.getPageSource().contains("Bruce Wayne");
		boolean assertEmailTrue = driver.getPageSource().contains("batman@berichismypower.com");
		
		assertTrue(assertNameTrue);
		assertTrue(assertEmailTrue);
		
	}
	
	public void deleteUser() {	
		
	
		//DELETE declare area
		//TODO: improve the way to find button Delete.
		/*WebElement btnDelete = driver.findElement(By.xpath("//*[@id=\"content\"]/table/tbody/tr[5]/td[3]/form/button"));
		
		int posicao = 1; // 1o link de editar que aparecer
		List<WebElement> elements = driver.findElementsByLinkText("excluir");
		
		Object size = len(elements);
		target_element = elements[size -1];
		
		btnDelete2.submit();
		//btnDelete.submit();*/

						
}

	public void closeDriver() {				
		//close the test
		//TODO: create a @after
		driver.close();				
	}
}
