package com.ryo.clouddemo.Listener;

import com.netflix.appinfo.InstanceInfo;
import org.springframework.cloud.netflix.eureka.server.event.*;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class EurekaStateChangeListener {
    @EventListener
    public void listen(EurekaInstanceCanceledEvent event) {
        //处理Eureka集群监听多次问题
        if(!event.isReplication()) {
            System.err.println(event.getServerId() + "\t" + event.getAppName() + " 服务下线");
        }
    }
    @EventListener
    public void listen(EurekaInstanceRegisteredEvent event) {
        if(!event.isReplication())
        {
            InstanceInfo instanceInfo = event.getInstanceInfo();
            System.err.println(instanceInfo.getAppName() + "进行注册");
        }
    }
    @EventListener
    public void listen(EurekaInstanceRenewedEvent event) {
        if(!event.isReplication()) {
            System.err.println(event.getServerId() + "\t" + event.getAppName() + " 服务进行续约");
        }
    }
    @EventListener
    public void listen(EurekaRegistryAvailableEvent event) {
            System.err.println("注册中心 启动");
    }
    @EventListener
    public void listen(EurekaServerStartedEvent event) {
            System.err.println("Eureka Server 启动");
    }

}
