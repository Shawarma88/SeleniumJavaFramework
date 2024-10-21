package com.shawarma.tests;
import com.shawarma.pages.OrangeHRMHomePage;
import com.shawarma.pages.OrangeHRMLoginPage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public final class OrangeHRMTests extends BaseTest{
    private OrangeHRMTests(){}
    @Test
    public void LoginLogoutTest(){
        String title = new OrangeHRMLoginPage().enterUserName("Admin").enterPassword("admin123").clickLogin()
                .clickDropDown().clickLogout()
                .getTitle();
        Assertions.assertThat(title)
                .isEqualTo("OrangeHRM");
    }
}
