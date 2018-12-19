import org.openqa.selenium.By;

import java.io.*;
import java.util.Set;

public class AuthHelper extends HelperBase {

    public AuthHelper(ApplicationManager manager) {
        super(manager);
    }

    public UserLoginData createNewUser() throws IOException {
        String[] data = collectData();
        return new UserLoginData(data[1], data[2]);
    }

    public void auth(UserLoginData data) {
        if (isLoggedIn()) {
            if (isLoggedIn(data.getUsername(), "yourmusta@yandex.ru")) {
                System.out.println("Username is correct!");
            }
        }
        driver.findElement(By.name("login_email")).click();
        driver.findElement(By.name("login_email")).clear();
        driver.findElement(By.name("login_email")).sendKeys(data.getUsername());
        driver.findElement(By.name("login_password")).click();
        driver.findElement(By.name("login_password")).clear();
        driver.findElement(By.name("login_password")).sendKeys(data.getPassword());
        driver.findElement(By.name("remember_me")).click();
        driver.findElement(By.xpath("//div[@data-reactid=\"40\"]")).click();
    }

    public boolean isLoggedIn() {
        return true;
    }

    public boolean isLoggedIn(String username, String expected) {
        return expected.equals(username);
    }

    public String[] collectData() throws IOException {
        File xml = new File("settings.xml");
        Reader reader = new FileReader(xml);
        BufferedReader bufferedReader = new BufferedReader(reader);

        StringBuilder builder = new StringBuilder();
        String line = bufferedReader.readLine();
        while (line != null) {
            builder.append(line).append("\n");
            line = bufferedReader.readLine();
        }
        String result = builder.toString();
        return result.split("\n");
    }



}
