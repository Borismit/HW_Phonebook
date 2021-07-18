import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase{


 @Test
  public void loginTestPositive(){

    click(By.xpath("//a[.='LOGIN']"));

    type(By.xpath("//input[@placeholder='Email']"), "borismit@inbox.ru");
    type(By.xpath("//input[@placeholder='Password']"), "Aa123456$");
    click(By.xpath("//button[.=' Login']"));
    pause(3000);

     String SignOut=getText(By.xpath("//button[.='Sign Out']"));
     Assert.assertEquals(SignOut, "Sign Out");

 }
}
