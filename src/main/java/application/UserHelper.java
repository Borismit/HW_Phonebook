package application;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserHelper extends HelperBase{
    //передадим (создадим) конструктор от суперкласса HelperBase, чтобы HelperBase стал его наследником: ставим курсор на строчку HelperBase->alt+enter-> Grate constractor ...
    public UserHelper(WebDriver wd) { super(wd); }

    public void openLoginForm() {
        click(By.xpath("//a[.='LOGIN']"));//кликаем на кнопку Log in, т. е. открываем LoginForm

    }

    public void fillLoginForm(String email, String password) {
        type(By.xpath("//input[@placeholder='Email']"),email);
        type(By.xpath("//input[@placeholder='Password']"),password);
    }

    public void fillLoginForm(User user) {
        type(By.xpath("//input[@placeholder='Email']"),user.getEmale());
        type(By.xpath("//input[@placeholder='Password']"),user.getPassword());
    }

    public void logIn(){
        click(By.xpath("//button[.=' Login']"));
    }

    public boolean isLogged() {
        return wd.findElements(By.xpath("//a[.='LOGIN']")).size()>0;//если размер списка findElements >0, то элемент (кнопка) LOGIN есть,
                                                                    //если <0, то её нет и вернётся не ошибка а falls
    }

    public void logout() {
        click(By.xpath("//button[.='Sign Out']"));
    }
}
