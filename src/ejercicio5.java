import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ejercicio5 {
    public static void main(String[] args){
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        try {
            driver.get("https://demoqa.com/webtables");
            driver.manage().window().maximize();
            wait.until(ExpectedConditions.elementToBeClickable(By.id("addNewRecordButton"))).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("firstName"))).sendKeys("Carlos");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("lastName"))).sendKeys("Ramírez");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userEmail"))).sendKeys("carlos@gmail.com");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("age"))).sendKeys("25");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("salary"))).sendKeys("2500000");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("department"))).sendKeys("Sistemas");
            wait.until(ExpectedConditions.elementToBeClickable(By.id("submit"))).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("searchBox"))).sendKeys("Carlos");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("table")));
            Boolean nombre = wait.until(ExpectedConditions.textToBePresentInElementLocated(By.tagName("tbody"), "Carlos"));
            Boolean segundo_nombre = wait.until(ExpectedConditions.textToBePresentInElementLocated(By.tagName("tbody"), "Ramírez"));
            if(nombre && segundo_nombre){
                System.out.println("Prueba exitosa");
            }else{
                System.out.println("Prueba no exitosa");
            }

        }finally {
            driver.quit();
        }
    }
}
