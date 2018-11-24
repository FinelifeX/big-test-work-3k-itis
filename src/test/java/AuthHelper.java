import org.openqa.selenium.By;

public class AuthHelper extends HelperBase {

    public AuthHelper(ApplicationManager manager) {
        super(manager);
    }

    public UserLoginData createNewUser(String login, String password) {
        return new UserLoginData(login, password);
    }

    public void auth(UserLoginData data) {
        if (isLoggedIn()) {
            if (isLoggedIn(data.getUsername(), "yourmusta@yandex.ru")) {
                return;
            }
        }
        driver.findElement(By.xpath("//input[@name='login_email']")).click();
        driver.findElement(By.xpath("//input[@name='login_email']")).clear();
        driver.findElement(By.xpath("//input[@name='login_email']")).sendKeys(data.getUsername());
        driver.findElement(By.xpath("//input[@name='login_password']")).click();
        driver.findElement(By.xpath("//input[@name='login_password']")).clear();
        driver.findElement(By.xpath("//input[@name='login_password']")).sendKeys(data.getPassword());
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Terms of service'])[1]/following::span[1]")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Remember me'])[1]/following::button[1]")).click();
    }

    public boolean isLoggedIn() {
        return true;
    }

    public boolean isLoggedIn(String username, String expected) {
        return expected.equals(username);
    }



}
