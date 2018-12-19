import junit.framework.Assert;
import org.junit.Test;

public class FolderTest extends TestBase {

    @Test
    public void testCreatingNewSharedFolder() throws Exception {
        manager.getNavigationHelper().openLoginPage();
        manager.getAuthHelper().auth(new UserLoginData("yourmusta@yandex.ru", "123456qwerty"));
        Thread.sleep(5000);
        manager.getNavigationHelper().openMainPage();
        FolderData newFolder =  manager.getFolderHelper().createFolder();
        Thread.sleep(5000);
        manager.getNavigationHelper().openMainPage();
        FolderData folderToCompare = manager.getFolderHelper().getCreatedFolderData();
        Assert.assertEquals(folderToCompare.getName(), newFolder.getName());
        Thread.sleep(2000);
    }
}
