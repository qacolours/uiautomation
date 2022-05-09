package uiautomation.main;

import org.testng.annotations.*;

public class TestCases_TestNG {
	
	/*
	 * 	@BeforeSuite :: Setup system properties for the browser
		@BeforeTest :: Launch the browser
		@BeforeClass :: Login to application
		@BeforeMethod :: Enter the URL
		@Test :: Test google logo
		@AfterMethod :: Logout of application
		@BeforeMethod :: Enter the URL
		@Test :: Test google title
		@AfterMethod :: Logout of application
		@AfterClass :: Close the browser
		@AfterTest :: Delete all the cookies
		
		@AfterSuite :: Generate final HTML report
	 * 
	 */
	
	//Pre-Condition i.e. starting with @Before
	@BeforeSuite //Precedence 1
	public void setUp() {
		System.out.println("@BeforeSuite :: Setup system properties for the browser");
	}
	
	@BeforeTest //Precedence 2
	public void launchBrowser() {
		System.out.println("@BeforeTest :: Launch the browser");
	}
	
	@BeforeClass //Precedence 3
	public void loginToApplication() {
		System.out.println("@BeforeClass :: Login to application");
	}
	
	@BeforeMethod //Precedence 4 - always gets executed before the test case with @Test annotation
	public void enterURL() {
		System.out.println("@BeforeMethod :: Enter the URL");
	}
	
	//Test Cases i.e. Starting with @Test
	@Test //Precedence 5
	public void googleTitleTest() {
		System.out.println("@Test :: Test google title");
	}
	
	@Test //Precedence 5
	public void googleLogoTest() {
		System.out.println("@Test :: Test google logo");
	}
	
	//Post-Condition i.e. starting with @After
	@AfterMethod //Precedence 6 - always gets executed after the test case with @Test annotation. i.e. the @BeforeMethod,@Test and @AfterMethid acts as a pair.
	public void logoutOfApplication() {
		System.out.println("@AfterMethod :: Logout of application");
	}
	
	/*
	 * in case of multiple test the @BeforeMethod and @AfterMethod annotation will run after every testcase with @Test annotation
	 * 
	 * Let we have like below - 
	 * @BeforeMethod
	 * @Test - 1
	 * @Test - 2
	 * @AfterMethod
	 * 
	 * Then while running it will execute in below sequence - 
	 * @BeforeMethod
	 * @Test - 1
	 * @AfterMethod
	 * 
	 * @BeforeMethod
	 * @Test - 2
	 * @AfterMethod
	 * 
	 * i.e it works in a pair and the pair with @Test will only be created with @BeforeMethod and @AfterMethod
	 * Note: in case no priority is set for the test class, tests will be run randomly
	 * to set the priority if test cases we need to set the priority and write the annotation like @Test(priority = 1)
	 */
	
	@AfterClass //Precedence 7
	public void closeBrowser() {
		System.out.println("@AfterClass :: Close the browser");
	}
	
	@AfterTest //Precedence 8
	public void deleteCookies() {
		System.out.println("@AfterTest :: Delete all the cookies");
	}
	
	@AfterSuite //Precedence 9
	public void generateTestReport() {
		System.out.println("@AfterSuite :: Generate final HTML report");
	}

}
