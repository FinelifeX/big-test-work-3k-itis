import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase {

    public NavigationHelper(ApplicationManager manager) {
        super(manager);
    }

    //    Is used in AuthTest
    void openLoginPage() {
        driver.get("https://www.dropbox.com/login");
    }

    //    Is used in UploadingTest
    void openMainPage() {
        driver.get("https://www.dropbox.com/h");
    }


}
