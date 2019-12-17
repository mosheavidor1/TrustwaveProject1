package Tests;

import Actions.CloudActions;;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;



public class PolicyTest extends GenericTest {

    private static WebDriver driver;

    private CloudActions action;

    @Factory(dataProvider = "getData")
    public PolicyTest(Object dataToSet) {
        super(dataToSet);
        action = new CloudActions();


    }


    @Test
    public void PolicyTest1() throws Exception {
//Policy test - login page
        OpenPolicyTestPage();


//Sets the Tenant in the policy test page.
        policyTestSetUser();

//Run's the policyTest test
        policyTestRunTest();






    }







    public void OpenPolicyTestPage() throws Exception {


        action.LaunchApplication(data.get("Browser"));

        action.SetApplicationUrl(data.get("URL"));

        action.Login(data.get("UserName"), data.get("Password"));

        action.GotoSWGPolicyTestPage(data.get("URL"));




    }


    public void policyTestSetUser() {


        action.ClickOnPolicyTestCofigureUser();


//Set tenant ID
      action.TypeInTrustWave123(data.get("CustomerName"));

    }

public void policyTestRunTest() throws Exception {




    action.PolicyTestTypeURL(data.get("URL TO BLOCK"));

    action.PolicyTestTypeIP(data.get("IP TO BLOCK"));
        action.ClickOnGo();
        action.PageIsBlocked();



        }





        @BeforeClass
        public void beforeClass () {


        }
//
//        @AfterClass
//        public void afterClass() {
//
//            action.CloseApplication();

    }



