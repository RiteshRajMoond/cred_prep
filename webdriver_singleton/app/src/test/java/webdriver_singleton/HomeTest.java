package webdriver_singleton;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import webdriver_singleton.pages.Home;

public class HomeTest {
    Home homePage;

    @BeforeEach
    public void setUp() {
        WebDriverManager.getDriver().get("https://cred.club");
        homePage = new Home();
    }

    @Test
    public void testPageTitle() {
        assertEquals("CRED. not everyone gets it.", homePage.getPageTitle(), "Page title should match");
    }

    @Test
    public void testRewardsText() {
        String reward = homePage.getRewardsText().toLowerCase();
        assertTrue(reward.contains("all that you deserve."),
                "Rewards text should contain 'rewards for paying your credit card bills'");
    }
}
