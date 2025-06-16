package webdriver_singleton.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import webdriver_singleton.WebDriverManager;

public class Home {
    WebDriver driver;

    public Home() {
        this.driver = WebDriverManager.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[contains(text(), 'all that you deserve.')]")
    WebElement rewardsText;

    public String getRewardsText() {
        return rewardsText.getText();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }
}
