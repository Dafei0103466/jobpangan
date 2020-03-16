package com.pangan.page;

import com.pangan.model.PageElement;
import com.pangan.model.PageMethod;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Component
public class PageObjectModel {

    public HashMap<String, List<HashMap<String, String>>> elements = new HashMap<>();
    public HashMap<String, List<HashMap<String, Object>>> methods = new HashMap<>();
//    public PageMethod getMethod(String method) {
//        return methods.get(method);
//    }


//    public Object run(String method) {
//        return runAppium(method);
//    }
//
//    public Object runAppium(String method) {
//        methods.get(method).getSteps().forEach(step -> {
//            WebElement element = null;
//
//            //todo: 多个可能定位，多平台支持，多版本的支持
//            String id = step.get("id").toString();
//            if (id != null) {
//                element = BasePage.driver.findElement(By.id(id));
//            } else if (step.get("xpath") != null) {
//                element = BasePage.driver.findElement(By.xpath(step.get("xpath").toString()));
//            } else if (step.get("aid") != null) {
//                element = BasePage.driver.findElement(MobileBy.AccessibilityId(step.get("aid").toString()));
//            } else if (step.get("element") != null) {
//                element = BasePage.driver.findElement(elements.get(step.get("element")).getLocator());
//            }
//
//            String send = step.get("send").toString();
////            params.entrySet().forEach(kv->{
////                send=send.replace("{"+ kv.getKey() +"}", kv.getValue().toString());
////            });
//
//
//            if (send != null) {
//                //配置文件中的参数替换
//                for (Map.Entry<String, Object> kv : BasePage.getParams().entrySet()) {
//                    String matcher = "${" + kv.getKey() + "}";
//                    if (send.contains(matcher)) {
//                        System.out.println(kv);
//                        send = send.replace(matcher, kv.getValue().toString());
//                    }
//                }
//                element.sendKeys(send);
//
//            } else if (step.get("get") != null) {
//                String attribute = element.getAttribute(step.get("get").toString());
//                BasePage.getResults().put(step.get("dump").toString(), attribute);
//
//            } else {
//                element.click();
//            }
//
//        });
//        return null;
//    }


}
