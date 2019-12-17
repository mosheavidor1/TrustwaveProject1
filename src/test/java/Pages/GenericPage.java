package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Applications.SeleniumBrowser;

public class GenericPage {

    protected WebDriver driver;

    public GenericPage() {
        driver = (WebDriver) SeleniumBrowser.GetDriver();
        PageFactory.initElements(driver, this);
    }


    public void WaitUntilObjectClickable(By byElement) {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.elementToBeClickable(byElement));

    }

    public void WaitUntilObjectDisappear(By byElement) {
        List<WebElement> list1 = this.driver.findElements(byElement);
        if (list1.size() > 0) {
            WebDriverWait wait = new WebDriverWait(SeleniumBrowser.GetDriver(), 120);
            wait.until(ExpectedConditions.invisibilityOf(list1.get(0)));
        }

    }


    public void WaitUntilPageLoad() {
        WebDriverWait wait = new WebDriverWait(driver, 60);

        JavascriptExecutor js = (JavascriptExecutor) driver;

        wait.until(webDriver -> js.executeScript("return document.readyState").equals("complete"));

    }

    public void WaitUntilTitleAppearAndPageLoad(String title) {

        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.titleContains(title));

        WaitUntilPageLoad();
    }


}
