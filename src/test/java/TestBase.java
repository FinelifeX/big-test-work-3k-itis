import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestBase {

    static ApplicationManager manager;

    @BeforeClass
    public static void setUp() throws Exception {
        System.setProperty("webdriver.gecko.driver", "/home/finelifex/Documents/University/Quality control and testing/Tests/geckodriver");
        manager = new ApplicationManager();
    }

//    @After
//    public void endTest() throws Exception {
//        manager.tearDown();
//    }
}
