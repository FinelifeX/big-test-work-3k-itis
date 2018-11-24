import junit.framework.Assert;
import org.junit.Test;

public class FolderTest extends TestBase {

    @Test
    public void testCreatingNewSharedFolder() throws Exception {
        NavigationHelper navigationHelper = manager.getNavigationHelper();
        navigationHelper.openLoginPage();
        manager.getAuthHelper().auth(new UserLoginData("yourmusta@yandex.ru", "123456qwerty"));
        Thread.sleep(2000);
        navigationHelper.openMainPage();
        FolderData newFolder =  manager.getFolderHelper().createFolder();
        Thread.sleep(5000);
        navigationHelper.openMainPage();
        FolderData folderToCompare = manager.getFolderHelper().getCreatedFolderData();
        Assert.assertEquals(folderToCompare.getName(), newFolder.getName());
        Thread.sleep(2000);
    }
}
