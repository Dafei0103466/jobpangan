package com.pangan.app;

import com.pangan.page.app.LoginPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.TestConstructor;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class LoginTest extends AppBaseTest {
    /*
    验证ap端登录功能界面
     */
    @Autowired
    LoginPage loginPage;
    @Test
    public void login(){
        parseSteps(loginPage.login());
        assertThat(results.get("").toString(),equals(""));
    }
}
