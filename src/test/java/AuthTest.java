import org.junit.Test;

public class AuthTest extends TestBase {

    @Test
    public void testAuth() throws Exception {
        AuthHelper authHelper = manager.getAuthHelper();
        manager.getNavigationHelper().openLoginPage();
        UserLoginData userLoginData =  authHelper.createNewUser();
        authHelper.auth(userLoginData);
    }

}
