package com.gb.didgen;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.net.NetworkInterface;
import java.net.SocketException;
import java.security.SecureRandom;
import java.util.Enumeration;

import static com.gb.didgen.common.Constants.NODE_ID_BIT_LEN;

@Component
public class BeanDefinition {
    @Bean
    public Integer generatingNodeId() {
        int maxNodeVal = (int) Math.pow(2, NODE_ID_BIT_LEN);
        int nodeId;
        try {
            StringBuilder sb = new StringBuilder();
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterface = networkInterfaces.nextElement();
                byte[] mac = networkInterface.getHardwareAddress();
                if (mac != null) {
                    for (int i = 0; i < mac.length; i++) {
                        sb.append(String.format("%02X", mac[i]));
                    }
                }
            }
            nodeId = sb.toString().hashCode();
        } catch (SocketException ex) {
            //in case of exception get a random number limited by max node size
            nodeId = (int) (new SecureRandom().nextInt() % Math.pow(2, 10));
        }
        nodeId = nodeId & maxNodeVal;
        return nodeId;
    }
}
