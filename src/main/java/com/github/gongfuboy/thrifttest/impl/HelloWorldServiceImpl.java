package com.github.gongfuboy.thrifttest.impl;

import com.github.gongfuboy.thrifttest.HelloWorldService;
import org.apache.thrift.TException;

/**
 * helloWorld thrift简单实现
 *
 * @author GongFuBoy
 * @date 2018/4/11
 * @time 15:02
 */
public class HelloWorldServiceImpl implements HelloWorldService.Iface{

    /**
     * 简单执行操作
     * @param tempString
     * @return
     * @throws TException
     */
    @Override
    public String repayAndPrintString(String tempString) throws TException {
        System.out.println("服务器接收到的数据：" + tempString);
        String requestString = tempString + "：服务器已经接收到";
        return requestString;
    }
}