package application;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    WebDriver wd;
    UserHelper userHelper;

    public void init(){
        wd = new ChromeDriver();
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wd.navigate().to("https://contacts-app.tobbymarshall815.vercel.app/home");
        userHelper = new UserHelper(wd);//инициализируем userHalper
    }

    public void stop() {
        wd.quit(); }
    //сгенерируем гетер по полю UserHalper, чтобы метод (поле) UserHalper был доступен (потом getUserHalper переименуем для краткости в userHalper ) его наследникам
    public application.UserHelper userHalper() {
        return userHelper;
    }
}
