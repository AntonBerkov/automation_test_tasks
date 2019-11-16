package framework.test;

import framework.page.MailPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ShouldFailTest extends CommonConditions {
    @Test
    public void checkForTestFails() {
        String calculatorTotalCost = calculatePage.searchTotalCost();
        MailPage mailPage = new MailPage(driver).openPage();
        String emailTotalCost = mailPage.searchEmailTotalCost();
        Assert.assertNotEquals(emailTotalCost, calculatorTotalCost);
    }
}
