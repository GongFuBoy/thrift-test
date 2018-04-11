package com.github.gongfuboy.thrifttest;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

/**
 *
 * helloWorld thrift简单实现客户端实现
 *
 * @author GongFuBoy
 * @date 2018/4/11
 * @time 15:47
 */
public class HelloWorldServiceClient {

    public static void main(String[] args) {
        TTransport transport = null;

        try {
            transport = new TSocket("localhost", 9090, 30000);
            TProtocol protocol = new TBinaryProtocol(transport);
            HelloWorldService.Client client = new HelloWorldService.Client(protocol);
            transport.open();
            String sourceString = "\"我是客户端发来的字符串\"";
            System.out.println(sourceString);
            client.send_repayAndPrintString(sourceString);
        } catch (TTransportException e) {
            e.printStackTrace();
        } catch (TException e) {
            e.printStackTrace();
        } finally {
            if (transport != null) {
                transport.close();
            }
        }
    }

}