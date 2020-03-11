package testcase;


import base.driverBase;
import buss.test1;

import org.testng.annotations.Test;

public class homeTestCase extends caseBase{
    private driverBase driver;
    private test1 buss;

    public homeTestCase() throws InterruptedException {
        this.driver = initDriver();
        buss = new test1(driver);
    }

    @Test
    public void BannerCase() throws InterruptedException {
        buss.click();
        Thread.sleep(4000);
        driver.close();
    }
}
