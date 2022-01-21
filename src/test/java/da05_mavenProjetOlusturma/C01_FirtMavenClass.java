package da05_mavenProjetOlusturma;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C01_FirtMavenClass {
    public static void main(String[] args) {
        //1- https://www.amazon.com/ sayfasina gidelim
        //2- arama kutusunu locate edelim
        //3- “Samsung headphones” ile arama yapalim
        //4- Bulunan sonuc sayisini yazdiralim
        //5- Ilk urunu tiklayalim
        //6- bir önceki sayfaya dönüp, Sayfadaki tum basliklari yazdiralim

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.amazon.com/");
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));

        aramaKutusu.sendKeys("Samsung headphones" + Keys.ENTER);
        WebElement sonucSayisi=driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        System.out.println(sonucSayisi.getText());

        driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")).click();

        driver.navigate().back();

        List<WebElement> baslik=driver.findElements(By.xpath("//a[@class='a-link-normal s-navigation-item']"));

        System.out.println("Sayfadaki başlik sayisi : "+ baslik.size());


    }

}
