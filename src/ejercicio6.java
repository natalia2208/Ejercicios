import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class ejercicio6 {
    public static void main(String[] args){
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        try {
           driver.get("https://www.selenium.dev/selenium/web/dynamic.html");
           driver.manage().window().maximize();
           wait.until(ExpectedConditions.elementToBeClickable(By.id("adder"))).click();
           wait.until(ExpectedConditions.elementToBeClickable(By.id("reveal"))).click();
           WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("revealed")));
           input.sendKeys("Prueba Selenium ADSO");
           String mensaje = input.getDomProperty("value");
           System.out.println(mensaje);
           if (mensaje.equals("Prueba Selenium ADSO")){
               System.out.println("Prueba exitosa " + mensaje);
           }else {
               System.out.println("Prueba no exitosa");
           }
           File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
           File guardado = new File(" evidencia_selenium.png");
           FileHandler.copy(screenshot, guardado);


        }catch (Exception e) {
            System.out.println("error: " + e);
        }
        finally {
            driver.quit();
        }
    }
}
