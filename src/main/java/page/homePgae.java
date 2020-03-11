package page;

import base.driverBase;
import io.appium.java_client.MobileElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import base.by;
import org.testng.annotations.Test;

public class homePgae extends basePage {

    private static final Logger log = LogManager.getLogger(homePgae.class.getName());
    private MobileElement agreeElement = null;
    private MobileElement kownElement = null;
    private MobileElement bangumiTabElement = null;
    private MobileElement bangumiTabBanner = null;
    private by by;


    /**
     * 构造方法 初始化DriverBase对象
     *
     * @param driver
     */
    public homePgae(driverBase driver) {
        super(driver);
        this.by = new by("homepage.properties");
    }

    /**
     * 进入Home页面前的用户隐私协议操作-同意的element对象
     */
    public void clickAgreeElement() {
        agreeElement = super.element(by.by("isAgree"));
        click(agreeElement);
    }

    public void clickKownElement() {
        kownElement = super.element(by.by("kown"));
        click(kownElement);
    }

    public void clickBangumiTabElement() {
        bangumiTabElement = super.element(by.by("bangumiTab"));
        click(bangumiTabElement);
    }

}
