package ru.otus.loadbalancer;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Main {
    public static void main(String[] args) {
        LoadBalancer loadBalancer = new LoadBalancer(1,7777);
        loadBalancer.createND(1,7778);
        loadBalancer.createND(2,7779);
        loadBalancer.createND(3,7785);
        loadBalancer.createND(4,7791);
        loadBalancer.createND(5,1234);
        loadBalancer.createND(6,1189);
        loadBalancer.createND(7,7382);

        for(int i = 0; i< loadBalancer.getNodeList().size(); i++){
            Thread NDThread = new Thread(loadBalancer.getNodeList().get(i));
            NDThread.start();}

        Thread loadBalancerThread = new Thread(loadBalancer);
        loadBalancerThread.start();

    }
    }

