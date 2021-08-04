package com.lfs.init;




import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * ClassName: InterfaceUrlInit
 * @Description: 项目启动初始化方法
 * @author
 * @date
 */
public class InterfaceUrlInit {

    public synchronized static void init(){
        System.out.println("项目一些工作初始化了");
    }

}