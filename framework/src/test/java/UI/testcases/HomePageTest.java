package UI.testcases;

import UI.dbutil.DbOps;
import UI.dbutil.SQLQueryConstatnts;
import UI.factory.BrowserFactory;
import UI.factory.DataBaseFactory;
import UI.factory.DataProviderFactory;
import UI.webpages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HomePageTest {

	WebDriver driver;
	Connection con;
	
	@BeforeMethod
	public void init() throws ClassNotFoundException {
		driver = BrowserFactory.getBrowser("Chrome");
		// driver.get(DataProviderFactory.getConfig().getApplicationUrl());
		con = DataBaseFactory.getDB("hsqldb");
	}

	@Test
	public void homePagetest() throws SQLException {
		driver.navigate().to(DataProviderFactory.getConfig().getApplicationUrl());
		HomePage hp = PageFactory.initElements(driver, HomePage.class);
		String homePageTitle = hp.getHomePageTitle();
		ResultSet result = DbOps.executeStmntsSelect(con, SQLQueryConstatnts.SELECT_QUERY_DETAILS_PAGE_TITLE);
		System.out.println("Actual home page Title is "+ homePageTitle);
		System.out.println("Expected home page Title is "+ result.getString(1));
		org.testng.Assert.assertTrue(homePageTitle.equalsIgnoreCase(result.getString(1)), "Home page title successfully not verified ");

	}



	@AfterTest
	public void end() throws SQLException {
		BrowserFactory.closeDriver(driver);
		con.commit();
		con.close();
	}
}
