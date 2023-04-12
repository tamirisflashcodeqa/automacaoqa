import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;

public class Bancointer {

	WebDriver driver;
	@Before
	public void setUp() throws Exception {
	  System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
	// comando para chamar o driver dentro do before
			driver = new ChromeDriver();

			
			// comando para indicar URL
			driver.get("https://www.4devs.com.br/gerador_de_pessoas");

			// comando para maximizar a tela
			driver.manage().window().maximize();
			Thread.sleep(5000);
			
			

			// comando para interagir com o elemento
			WebElement elemento = driver.findElement(By.id("bt_gerar_pessoa"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView (true);", elemento);
			driver.findElement(By.id("bt_gerar_pessoa")).click();
			Thread.sleep(1000);
			String nome = driver.findElement(By.id("nome")).getText();
			Thread.sleep(1000);
			String celular = driver.findElement(By.id("celular")).getText();
			Thread.sleep(1000);
			String email = driver.findElement(By.id("email")).getText();
			Thread.sleep(1000);
			String cpf = driver.findElement(By.id("cpf")).getText();
			Thread.sleep(1000);
			String dataNascimento = driver.findElement(By.id("data_nasc")).getText();

			//driver.quit();

			// comando para chamar o driver dentro do before
			driver = new ChromeDriver();

			// comando para indicar URL
			
			driver.get("https://www.bancointer.com.br/");
			driver.manage().window().maximize();

			// comando para interagir com o elemento
			driver.findElement(By.cssSelector(
					"#gatsby-focus-wrapper > div > header > section > div > div > div > div > div.styles__LogoNIcons-sc-1gbjc3e-6.gjJzHM > "
							+ "div.styles__SearchNFlags-sc-1gbjc3e-8.yVPnY > div.styles__ButtonsWrapper-sc-1gbjc3e-9.PKrxs > button:nth-child(1)"))
					.click();
			Thread.sleep(5000);
			driver.findElement(By.id("onetrust-accept-btn-handler")).click();
			driver.findElement(By.name("nome")).sendKeys(nome);
			driver.findElement(By.id("celular")).sendKeys(celular);
			driver.findElement(By.name("email")).sendKeys(email);
			driver.findElement(By.id("cpf")).sendKeys(cpf);
			driver.findElement(By.id("dataNascimento")).sendKeys(dataNascimento);
			driver.findElement(By.cssSelector(
					"body > div.style__ModalContent-wuavw4-0.hOXgJK > div.style__Container-sc-138k8xa-0.dlLgSU.d-flex.align-items-center > div > div:nth-child(2) > form > div > div:nth-child(6) > div"))
					.click();
			driver.findElement(By.cssSelector(
					"body > div.style__ModalContent-wuavw4-0.hOXgJK > div.style__Container-sc-138k8xa-0.dlLgSU.d-flex.align-items-center > div > div:nth-child(2) > form > div > div.col-12.text-center > button"))
					.click();

		}

	
	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void test() throws InterruptedException, IOException {
		Thread.sleep(5000);
		String texto = driver.findElement(By.cssSelector(
				"body > div.style__ModalContent-wuavw4-0.hOXgJK > div.style__Container-sc-138k8xa-0.dlLgSU.d-flex.align-items-center.sent > div > p"))
				.getText();
		Screenshot  screenshot = new AShot().takeScreenshot(driver);
        ImageIO.write(screenshot.getImage() , "PNG", new File("C:\\Users\\tamir\\eclipse-workspace\\automacaojunit\\Br.com.inter\\Evidencia de Teste\\evidencia1.png"));
		System.out.println(texto);
		assertEquals(texto, "Prontinho! Recebemos os seus dados.");

	}

}
