package utils;

import java.io.*;
import java.util.Properties;

public class ReadProperties {
    private String filePath;
    private Properties properties;

    /**
     * 构造方法 创建对象时自动返回pro对象  在new该对象的时候会自动加载readProperties()方法
     * */

    public ReadProperties(String filePath){
        this.filePath = filePath;
        //在new该对象的时候会自动加载readProperties()方法
        this.properties = readProperties();
    }

    /**
     * 返回已经加载properties文件的pro对象
     * */
    public Properties readProperties(){
        //创建对象
        Properties pro = new Properties();
        try {
            InputStream in = getClass().getClassLoader().getResourceAsStream(filePath);
            BufferedReader bf = new BufferedReader(new InputStreamReader(in));
            pro.load(bf);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //返回pro对象
        return pro;
    }

    /**
     * 使用全局的properties对象获取key对应的value值
     * @return
     * */
    public String getValue(String key) {
        return properties.getProperty(key);
    }

    public static void main(String[] args) {
        ReadProperties readProperties = new ReadProperties("homepage.properties");
        String str =  readProperties.getValue("bangumiTab");
        System.out.println(str);
    }
}
