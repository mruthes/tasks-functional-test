package br.pr.rutesm.task.functional;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TaskTest {

	public WebDriver acessarAplicação() {
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("http://localhost:8001/tasks");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
	@Test
	public void deveSalvarTarefaComSucesso() {
		WebDriver driver = acessarAplicação();
		try {
				
			//clicar em Add Todo
			driver.findElement(By.id("addTodo")).click();
			
			//Escrever descrição
			driver.findElement(By.id("task")).sendKeys("Teste via Selenium");
			
			//Escrever data
			driver.findElement(By.id("dueDate")).sendKeys("10/10/2030");
			
			//Clicar em salvar
			driver.findElement(By.id("saveButton")).click();
			
			//Validar mensagem de sucesso
		//	String message = driver.findElement(By.id("message")).getText();
		//	Assert.assertEquals("Success!", message);
		} finally {	
			//Fechar o browser
			driver.quit();
		}
	}
		@Test
		public void naoDeveSalvarTarefaSemDescricao() {
			WebDriver driver = acessarAplicação();
			try {
					
				//clicar em Add Todo
				driver.findElement(By.id("addTodo")).click();
				
				//Escrever data
				driver.findElement(By.id("dueDate")).sendKeys("10/10/2030");
				
				//Clicar em salvar
				driver.findElement(By.id("saveButton")).click();
				
				//Validar mensagem de erro
				String message = driver.findElement(By.id("message")).getText();
				Assert.assertEquals("Fill the task description", message);
			} finally {	
				//Fechar o browser
				driver.quit();
			}
		}
			
			@Test
			public void naoDeveSalvarTarefaSemData() {
				WebDriver driver = acessarAplicação();
				try {
						
					//clicar em Add Todo
					driver.findElement(By.id("addTodo")).click();
					
					//Escrever descrição
					driver.findElement(By.id("task")).sendKeys("Teste via Selenium");
										
					//Clicar em salvar
					driver.findElement(By.id("saveButton")).click();
					
					//Validar mensagem de erro
					String message = driver.findElement(By.id("message")).getText();
					Assert.assertEquals("Fill the due date", message);
				} finally {	
					//Fechar o browser
					driver.quit();
				}
			}

			@Test
			public void naoDeveSalvarTarefaComDataPassada() {
				WebDriver driver = acessarAplicação();
				try {
						
					//clicar em Add Todo
					driver.findElement(By.id("addTodo")).click();
					
					//Escrever descrição
					driver.findElement(By.id("task")).sendKeys("Teste via Selenium");
					
					//Escrever data
					driver.findElement(By.id("dueDate")).sendKeys("10/10/2000");
					
					//Clicar em salvar
					driver.findElement(By.id("saveButton")).click();
					
					//Validar mensagem de erro
					String message = driver.findElement(By.id("message")).getText();
					Assert.assertEquals("Due date must not be in past", message);
				} finally {	
					//Fechar o browser
					driver.quit();
				}

			}

}

