package UI.testcases;

import UI.factory.BrowserFactory;
import UI.factory.DataProviderFactory;
import UI.webpages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestMeApp_LoginTest {

    WebDriver driver;


        @BeforeMethod
        public void init() {
            driver = BrowserFactory.getBrowser("chrome");

        }


        @Test
        public void LoginTest1() {
            try {
                driver.navigate().to(DataProviderFactory.getConfig().getApplicationUrl());

                LoginPage lp= PageFactory.initElements(driver, LoginPage.class);

                lp.clickOnAccountLink();


                lp.loginToApplication(DataProviderFactory.getExcel().getData(0,0,0),DataProviderFactory.getExcel().getData(0,0,1));


                lp.clickOnLoginButton();

                lp.clickOnLogOutLink();




            } catch (Exception e) {
                System.out.println("The exception is in Test "+e.getMessage());
                e.printStackTrace();
            }

        }

        @AfterTest
        public void end() {
            BrowserFactory.closeDriver(driver);
        }






}
