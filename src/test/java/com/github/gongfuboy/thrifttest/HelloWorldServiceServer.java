package com.github.gongfuboy.thrifttest;

import com.github.gongfuboy.thrifttest.impl.HelloWorldServiceImpl;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;

import java.io.IOException;

/**
 *
 * helloWorld thrift简单实现服务器端
 *
 * @author GongFuBoy
 * @date 2018/4/11
 * @time 15:07
 */
public class HelloWorldServiceServer {

    /**
     * main方法启动服务器
     * @param args
     */
    public static void main(String[] args) throws IOException, TTransportException {
        // 绑定端口号，引导创建服务器
        TServerSocket tServerSocket = new TServerSocket(9090);

        // 根据HelloWorldServiceImpl实现引导是创建处理器
        HelloWorldService.Processor processor = new HelloWorldService.Processor(new HelloWorldServiceImpl());

        TServer.Args args1 = new TServer.Args(tServerSocket);
        args1.processor(processor).protocolFactory(new TBinaryProtocol.Factory());

        TServer tServer = new TSimpleServer(args1);

        System.out.println("服务器开始启动。。。。");

        tServer.serve();

        System.out.println("服务器结束");

    }

}