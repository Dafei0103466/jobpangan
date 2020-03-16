package com.pangan.app;

import com.pangan.SpringBaseTest;
import com.pangan.model.PageMethod;
import com.pangan.page.PageObjectModel;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.BeforeSuite;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class AppBaseTest extends SpringBaseTest {

//    @Autowired
//    PageObjectModel model;

    private  HashMap<String, Object> params=new HashMap<>();
    //定义执行结果
    public HashMap<String, Object> results=new HashMap<>();
    //定义安卓驱动
    public static AndroidDriver<WebElement> driver;
    //通用元素定位与异常处理机制 主要是弹窗
    public static WebElement findElement(By by) {
        //todo: 递归是更好的
        //todo: 如果定位的元素是动态变化位置

        System.out.println(by);
        try {
            return driver.findElement(by);
        } catch (Exception e) {
            handleAlert();
            return driver.findElement(by);
        }
    }
    private static void handleAlert() {
        //to-do 处理弹窗或者是弹框关闭情况
    }
    @BeforeSuite
    public void start() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "android");
        desiredCapabilities.setCapability("appPackage", "com.pangan.xjl");
        desiredCapabilities.setCapability("appActivity", "com.pingan.xjl.com.pingan.course.module.startup.activity.LoadingActivity");
        desiredCapabilities.setCapability(" ", false);
        desiredCapabilities.setCapability("autoGrantPermissions", true);
//        desiredCapabilities.setCapability("udid", System.getenv("UDID"));
        desiredCapabilities.setCapability("deviceName", "9YS5T19B28012473");
        URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        long start=System.currentTimeMillis();
        new WebDriverWait(driver, 40)
                .until(x -> {
                    String xml=driver.getPageSource();
                    Boolean exist=xml.contains("home_search") || xml.contains("image_cancel") ;
                    System.out.println((System.currentTimeMillis() - start)/1000);
                    System.out.println(exist);
                    return exist;
                });
//        //速度会比较慢
//        By adsLocator=By.id("xxx");
//        List<WebElement> ads=driver.findElements(adsLocator);
//        if(ads.size()>=1){
//            ads.get(0).click();
//        }
    }
    public void parseSteps(List<HashMap<String, Object>> steps){
        steps.forEach(step->{
            WebElement element = null;
            //todo: 多个可能定位，多平台支持，多版本的支持
            String id=step.get("id").toString();
            if(id!=null){
                element=findElement(By.id(id));
            }else if(step.get("xpath")!=null){
                element=findElement(By.xpath(step.get("xpath").toString()));
            }else if(step.get("aid")!=null){
                element=findElement(MobileBy.AccessibilityId(step.get("aid").toString()));
            }else if(step.get("element")!=null){
                //to-do 兼容多个版本定位方式不同
//                element=findElement(model.elements.get(step.get("element")).getLocator());
            }

            String send=step.get("send").toString();
//            params.entrySet().forEach(kv->{
//                send=send.replace("{"+ kv.getKey() +"}", kv.getValue().toString());
//            });
            if(send!=null){
                //配置文件中的参数替换
                for(Map.Entry<String, Object> kv: params.entrySet()){
                    String matcher="${"+kv.getKey()+"}";
                    if(send.contains(matcher)) {
                        System.out.println(kv);
                        send = send.replace(matcher, kv.getValue().toString());
                    }
                }
                element.sendKeys(send);
            }else if(step.get("get")!=null){
                String attribute=element.getAttribute(step.get("get").toString());
                results.put(step.get("field").toString(), attribute);
            }else{
                element.click();
            }

        });
    }


}
