package com.wenjun.recsys.config;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetAddress;

/**
 * @Author: wenjun
 * @Date: 2020/1/7 23:49
 */
@Configuration
public class ESConfig {

    @Bean
    public TransportClient getClient() {
        TransportClient transportClient = null;
        try {
            Settings settings = Settings.builder()
                    .put("cluster.name", "cluster").build();
            transportClient = new PreBuiltTransportClient(settings);
            TransportAddress firstAddress = new TransportAddress(InetAddress.getByName("192.168.37.142"), Integer.parseInt("9300"));
            TransportAddress secondAddress = new TransportAddress(InetAddress.getByName("192.168.37.143"), Integer.parseInt("9300"));
            TransportAddress thirdAddress = new TransportAddress(InetAddress.getByName("192.168.37.145"), Integer.parseInt("9300"));
            transportClient.addTransportAddress(firstAddress);
            transportClient.addTransportAddress(secondAddress);
            transportClient.addTransportAddress(thirdAddress);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return transportClient;
    }
}
