package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LoginPage {
    @FindBy(name = "username")
    WebElement txtUsername;
    @FindBy(name="password")
    WebElement txtPassword;
    @FindBy(css = "[type=submit]")
    WebElement btnLogin;
    @FindBy(className = "oxd-text")
    List<WebElement> lblErrorMessage;
    @FindBy(className="oxd-userdropdown-name")
    WebElement lblUsername;
    @FindBy(css = "[role=\"menuitem\"]")
    List<WebElement> cbUserMenu;

    public LoginPage(WebDriver driver) {

        PageFactory.initElements(driver, this);
    }
    public String doLoginWithWrongCreds(String username, String password) {
        txtUsername.sendKeys(username);
        txtPassword.sendKeys(password);
        btnLogin.click();
        return lblErrorMessage.get(1).getText();
    }
    public void doLogin(String username, String password) {
        txtUsername.sendKeys(username);
        txtPassword.sendKeys(password);
        btnLogin.click();
    }

    public void doLogout(){
        lblUsername.click();
        cbUserMenu.get(3).click();

    }
}