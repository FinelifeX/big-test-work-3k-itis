import org.junit.BeforeClass;

public class TestBase {

    static ApplicationManager manager;

    @BeforeClass
    public static void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "D:\\University\\java libs\\chromedriver_win32\\chromedriver.exe");
        manager = new ApplicationManager();
    }

//    @After
//    public void endTest() throws Exception {
//        manager.tearDown();
//    }
}
