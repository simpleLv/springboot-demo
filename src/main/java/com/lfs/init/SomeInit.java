package com.lfs.init;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;


@Component
public class SomeInit implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        //文件初始化
        InterfaceUrlInit.init();
        System.out.println("file init...");
        System.out.println("file init success!");
    }
}
