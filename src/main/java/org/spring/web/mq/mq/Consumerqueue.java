/*package org.spring.web.mq.mq;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

*//**
*
* 项目名称：spring-web
* 类名称：Consumerqueue
* 类描述：
* 创建人：john
* 创建时间：2018年7月30日 上午9:47:17
* 修改人：john
* 修改时间：2018年7月30日 上午9:47:17
* 修改备注：
* @version
*
*//*
@Component
public class Consumerqueue {
    @JmsListener(destination = "mvp.topic",containerFactory="jmsListenerContainerTopic")
    public void receiveTopic(String text){
        System.out.println("Topic Consumer1:"+text);
    }
    @JmsListener(destination = "mvp.topic",containerFactory="jmsListenerContainerTopic")
    public void receiveTopic2(String text){
        System.out.println("Topic Consumer2:"+text);
    }
    @JmsListener(destination = "mvp.queue",containerFactory="jmsListenerContainerQueue")
    public void reviceQueue(String text){
        System.out.println("Queue Consumer:"+text);
    }
}*/