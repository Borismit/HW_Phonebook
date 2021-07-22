import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase{

@BeforeMethod
public void pricondition(){
    if(!app.userHalper().isLogged()){
        app.userHalper().logout();
    }
}
 @Test
  public void loginTestPositive(){
     //будем вызывать методы реализованные (созданные) в классе UserHalper
     //ApplicationManager хранит ссылку на userHalper, внутри userHalper доступны его методы и его родителей
     //наведя на метод (он красный, т. к. его ещё нет) openLoginForm(), создадим его (alt+enter) в классе UserHalper
     app.userHalper().openLoginForm();
     app.userHalper().fillLoginForm("borismit@inbox.ru","Aa123456$");
     app.userHalper().logIn();
     app.userHalper().pause(3000);//метод pause() хранится в HelperBase, куда мы достаём через его ребёнка userHalper

     String SignOut=app.userHalper().getText(By.xpath("//button[.='Sign Out']"));//метод getText() тоже хранится в HelperBase, куда мы достаём через его ребёнка userHalper
     Assert.assertEquals(SignOut, "Sign Out");//если после логина появляется кнопка SignOut (узнаём её по тексту на ней), значит мы залогинились
 }
 @Test
 //метод, который принимает объект User, которому надо залогиниться
 public void loginTestPositiveDto(){
     User user = new User().withEmale("borismit@inbox.ru").withPassword("Aa123456$");//через "." выбираем только те поля, которые нам надо заполнить

     app.userHalper().openLoginForm();
     app.userHalper().fillLoginForm(user);//в классе UserHelper создадим метод fillLoginForm(User user)
     app.userHalper().logIn();
     app.userHalper().pause(3000);//метод pause() хранится в HelperBase, куда мы достаём через его ребёнка userHalper

     String SignOut=app.userHalper().getText(By.xpath("//button[.='Sign Out']"));//метод getText() тоже хранится в HelperBase, куда мы достаём через его ребёнка userHalper
     Assert.assertEquals(SignOut, "Sign Out");//если после логина появляется кнопка SignOut (узнаём её по тексту на ней), значит мы залогинились
 }

 @Test
    public void loginTestWithWrongPassword(){
    User user = new User()
            .withEmale("borismit@inbox.ru")
            .withPassword("Aa123456");//вводим не правильный Password
    app.userHalper().openLoginRegForm();//написал старый метод с ноым названием openLoginRegForm()
    app.userHalper().fillLoginForm(user);//использовал старый метод со старым названим (уже был написан мною)
    app.userHalper().clickLoginButton();//написал старый метод с ноым названием clickLoginButton()
    //app.userHalper().pause(3000);//чтобы успела отрисоваться картинка. Удобно использовать для отладки
    app.userHalper().acceptAlert();
     //проверяем есть ли кнопка LOGIN, если есть, то не залогинились
    Assert.assertTrue(app.userHalper().isLogged());//использовал старый метод со старым названим (уже был написан мною)
}

}
