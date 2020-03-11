package base;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.ArrayList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

import server.deviceNumbers;
import server.startAppiumServer;
import utils.ReadProperties;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class driverBase {

    private AndroidDriver<?> driver;
    private List<String> UUIDList;
    private initDriver init;
    private ReadProperties rw;

    private static final Logger log = LogManager.getLogger(driverBase.class.getName());

    public driverBase() throws InterruptedException {
        rw = new ReadProperties("initDriver.properties");
        // 启动Appium-Server
        Map<Integer, Integer> portMap = startAppiumServer.start();

        /**
         * 重构UUIDList 去掉"device"
         */
        UUIDList = deviceNumbers.locateNumbers();
        for (int i = 0; i < UUIDList.size(); i++) {

            String str = UUIDList.get(i);
            String UUID = str.split("\t")[0];
            UUIDList.remove(i);
            UUIDList.add(UUID);
        }
        log.info("[Class-DriverBase] 当前连接上Appium-server的设备UUID是：" + UUIDList.toString());

        init = new initDriver();
        /**
         * 初始化driver
         */
        Set<Entry<Integer, Integer>> entrySet = portMap.entrySet();
        for (Entry<Integer, Integer> entry : entrySet) {

            int a = 0;

            Integer AppiumPort = entry.getKey();

            String UUID = UUIDList.get(a);

            log.info("[Class-DriverBase] 启动的UUID是:["+UUID+"],启动的Appium端口是：["+AppiumPort+"]");

            driver = init.getDriver(UUID, AppiumPort);

            a++;
        }
    }

    /**
     * 封装element方法
     */
    public MobileElement findMobileElement(By by) {

        // 隐式等待
        driver.manage().timeouts().implicitlyWait(Integer.parseInt(rw.getValue("implicitlyWait")), TimeUnit.SECONDS);

        return (MobileElement)driver.findElement(by);
    }

    /**
     * 封装返回element集合的方法
     * */
    @SuppressWarnings("unchecked")
    public List<MobileElement> findMobileElements(By by) {

        // 隐式等待
        driver.manage().timeouts().implicitlyWait(Integer.parseInt(rw.getValue("implicitlyWait")), TimeUnit.SECONDS);

        return (List<MobileElement>) driver.findElements(by);
    }

    /**
     * 封装closed方法
     */
    public void close() {

        driver.closeApp();
    }

    /**
     * 获取APP的宽和高 (获取APP的最大点坐标)
     */
    public List<Integer> getXY() {

        List<Integer> WidthAndHeight = new ArrayList<Integer>();

        int X = driver.manage().window().getSize().getWidth();
        int Y = driver.manage().window().getSize().getHeight();

        WidthAndHeight.add(X);
        WidthAndHeight.add(Y);
        log.info("x为"+X+"y为"+Y);
        return WidthAndHeight;
    }

    /**
     * drivr的滑动 全屏滑动
     */
    public void driverSwipe(int startx, int starty, int endx, int endy) {

        driver.swipe(startx, starty, endx, endy, 2000);
        log.info("全屏滑动操作  startx" + startx +" endx" + endx +" starty" +starty +" endy"+endy);
    }

    /**
     * 对坐标点位进行长按操作
     */
    public void LongPressPoint(int x, int y, int duration) {

        TouchAction touchAction = new TouchAction(driver);
        touchAction.longPress(x, y, duration);
    }

    /**
     * 对元素进行长按操作
     */
    public void LongPressElement(MobileElement element, int duration) {

        TouchAction touchAction = new TouchAction(driver);
        touchAction.longPress(element, duration);
    }

    /**
     * 封装tap 对坐标进行点击
     */
    public void driverTap(int fingers, int x, int y, int duration) {

        driver.tap(fingers, x, y, duration);
    }

    /**
     * 对元素进行点击
     */
    public void driverTap(int fingers, MobileElement element, int duration) {

        driver.tap(fingers, element, duration);
    }

    public static void main(String[] args) throws InterruptedException {
        new driverBase();
    }
}
