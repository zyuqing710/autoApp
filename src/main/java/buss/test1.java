package buss;

import base.driverBase;
import page.bangumiTabPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class test1 extends baseBuss {
    static bangumiTabPage bp;

    public test1(driverBase driver){

        super(driver);
        bp = new bangumiTabPage(driver);
    }

    public void click() throws InterruptedException {
        super.intoBangumiTab();
        bp.clickBangumiTabBanner();
    }

}



