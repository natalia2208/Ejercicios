import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ejercicio3 {
    public static void main(String[] args){
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        try {
            driver.get("https://www.selenium.dev/selenium/web/web-form.html");
            driver.manage().window().maximize();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("my-text-id"))).sendKeys("Prueba ADSO");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("my-password"))).sendKeys("Sena2026");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("my-textarea"))).sendKeys("Automatización con Selenium");
            wait.until(ExpectedConditions.elementToBeClickable(By.tagName("button"))).click();
            Boolean mensaje = wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("message"), "Received!"));
            if (mensaje){
                System.out.println("Prueba exitosa");
            }else {
                System.out.println("Prueba no exitosa");
            }

        }finally {
            driver.quit();
        }
    }
}
