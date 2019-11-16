package framework.test;

import framework.page.MailPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class EmailTotalCostTest extends CommonConditions {

    @Test
    public void checkForEmailTotalCost() {
        String calculatorTotalCost = calculatePage.searchTotalCost();
        MailPage mailPage = new MailPage(driver).openPage();
        String emailTotalCost = mailPage.searchEmailTotalCost();
        Assert.assertEquals(calculatorTotalCost, emailTotalCost);
    }

}
