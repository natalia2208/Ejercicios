import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ejercicio1 {
    public static void main(String[] args){
     WebDriver driver = new ChromeDriver();
     WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
     try {
         driver.get("https://demoqa.com/text-box");
         driver.manage().window().maximize();
         WebElement nombreInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userName")));
         nombreInput.sendKeys("Laura Martínez");
         WebElement correoInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userEmail")));
         correoInput.sendKeys("laura@gmail.com");
         WebElement direccionActual = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("currentAddress")));
         direccionActual.sendKeys("Calle 25 # 10-20");
         WebElement direccionPermanente = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("permanentAddress")));
         direccionPermanente.sendKeys("Carrera 15 # 30-40");
         wait.until(ExpectedConditions.elementToBeClickable(By.id("submit"))).click();
         String nombre = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name"))).getText();
         String correo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email"))).getText();
          if (nombre.contains("Laura Martínez" ) && correo.contains("laura@gmail.com")){
              System.out.println("la prueba ha sido exitosa ");
          }else {
              System.out.println("La prueba no fue exitosa");
          }

     }finally {
        driver.quit();
     }
    }
}
