import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.fail;

public class ApplicationManager {

    private WebDriver driver;
    private  String baseUrl;
    private StringBuffer verificationErrors;
    private boolean acceptNextAlert = true;

    private NavigationHelper navigationHelper;
    private FolderHelper folderHelper;
    private AuthHelper authHelper;

    private static ThreadLocal<ApplicationManager> app = new ThreadLocal<>();

    public ApplicationManager() {
        this.driver = new FirefoxDriver();
        driver.manage().window().maximize();
        this.baseUrl = "http://dropbox.com";
        this.verificationErrors = new StringBuffer();
        this.navigationHelper = new NavigationHelper(this);
        this.folderHelper = new FolderHelper(this);
        this.authHelper = new AuthHelper(this);
    }

    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    public AuthHelper getAuthHelper() {
        return authHelper;
    }

    public void setAuthHelper(AuthHelper authHelper) {
        this.authHelper = authHelper;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public StringBuffer getVerificationErrors() {
        return verificationErrors;
    }

    public void setVerificationErrors(StringBuffer verificationErrors) {
        this.verificationErrors = verificationErrors;
    }

    public boolean isAcceptNextAlert() {
        return acceptNextAlert;
    }

    public void setAcceptNextAlert(boolean acceptNextAlert) {
        this.acceptNextAlert = acceptNextAlert;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }

    public void setNavigationHelper(NavigationHelper navigationHelper) {
        this.navigationHelper = navigationHelper;
    }

    public FolderHelper getFolderHelper() {
        return folderHelper;
    }

    public void setFolderHelper(FolderHelper folderHelper) {
        this.folderHelper = folderHelper;
    }

    public static ThreadLocal<ApplicationManager> getApp() {
        return app;
    }

    public static void setApp(ThreadLocal<ApplicationManager> app) {
        ApplicationManager.app = app;
    }
}
