package page;

import base.by;
import base.driverBase;
import io.appium.java_client.MobileElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import javax.swing.text.Element;

public class bangumiTabPage extends basePage {
    private static final Logger log = LogManager.getLogger(homePgae.class.getName());
    private MobileElement bangumiBanner = null;
    private MobileElement bangumi = null;
    private MobileElement chchu = null;
    private MobileElement time = null;
    private MobileElement hot = null;
    private base.by by;

    /**
     * 构造方法 初始化DriverBase对象
     *
     * @param driver
     */
    public bangumiTabPage(driverBase driver) {
        super(driver);
        this.by = new by("bangumitab.properties");
    }

    public void clickBangumiTabBanner() {
        bangumiBanner = super.element(by.by("bangumiBanner"));
        click(bangumiBanner);
    }
    public void clickBangumi(){
        bangumi = super.element(by.by("bangumi"));
        click(bangumi);
    }

}
