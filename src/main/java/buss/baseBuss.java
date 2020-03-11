package buss;

import base.driverBase;
import page.homePgae;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class baseBuss {
    static homePgae hp;
    private driverBase driver;

    public baseBuss(driverBase driver){
        this.driver = driver;
        hp = new homePgae(driver);
    }

    public void intoBangumiTab() throws InterruptedException {
        hp.clickAgreeElement();
        Thread.sleep(6000);
        hp.clickKownElement();
        Thread.sleep(6000);
        hp.driverSwipeLeftToRight();
        Thread.sleep(3000);
        hp.driverSwipeLeftToRight();
        Thread.sleep(6000);
    }
}
