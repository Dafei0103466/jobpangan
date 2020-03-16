package com.pangan.utils;

import org.yaml.snakeyaml.Yaml;

public class ParseYml {
    /*
    解析yml文件
    序列化对象
     */
    public static <T> T parseMoudle(Class<T> clazz,String fileName){
        Yaml yaml = new Yaml();
        T obj = (T) yaml.load(fileName) ;
        return obj;
    }
}
