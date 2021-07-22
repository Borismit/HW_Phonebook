import application.ApplicationManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class TestBase {
protected static ApplicationManager app = new ApplicationManager();//ссылка на класс ApplicationManager, protected - чтобы ApplicationManager был доступен только здесь
                                                                   //static - чтобы ApplicationManager одир раз создался (прогнался). Все методы в классе ApplicationManager теперь доступны


    @BeforeClass
    public void start() {
        app.init();

    }
    @AfterClass
    public void tearDown() {
         app.stop();
    }


}
