package com.pangan.page.app;

import com.pangan.page.PageObjectModel;
import com.pangan.utils.ParseYml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

@Component
public class LoginPage {

    @Autowired
    PageObjectModel pageObjectModel;
    String fileName = "src/main/resources/pageobject/apppage/login.yml";
    public LoginPage(){
        //初始化模型
        pageObjectModel = ParseYml.parseMoudle(PageObjectModel.class,fileName);
    }
    public List<HashMap<String, Object>> login(){
        return pageObjectModel.methods.get("login");
    }

    public void findPwd(){}

}
