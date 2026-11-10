import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ejercicio4 {
    public static void main(String[] args){
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        Actions accion = new Actions(driver);
        try {
            driver.get("https://demoqa.com/buttons");
            driver.manage().window().maximize();
            WebElement boton = wait.until(ExpectedConditions.elementToBeClickable(By.id("doubleClickBtn")));
            accion.doubleClick(boton).perform();
            String mensaje = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("doubleClickMessage"))).getText();
            if (mensaje.equals("You have done a double click")){
                System.out.println("Prueba exitosa");
            }else {
                System.out.println("Prueba no exitosa");
            }

        }finally {
            driver.quit();
        }
    }
}
