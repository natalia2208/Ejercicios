import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ejercicio2 {
    public static void main(String[] args){
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        try{
            driver.get("https://demoqa.com/radio-button");
            driver.manage().window().maximize();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("yesRadio")));
            WebElement Impressive = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("impressiveRadio")));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("noRadio")));
            Impressive.click();
            System.out.println("El boton esta seleccionado " + Impressive.isSelected());
            String texto = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("p"))).getText();
            System.out.println("mensaje:" + texto);
            if(texto.contains("Impressive")){
                System.out.println("Prueba exitosa");
            }else{
                System.out.println("Prueba no exitosa");
            }

        }finally {
            driver.quit();
        }
    }
}
