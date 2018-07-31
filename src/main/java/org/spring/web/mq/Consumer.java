
package org.spring.web.mq;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;

import org.spring.web.entity.User;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

	@JmsListener(destination = "${queque.police}",containerFactory="jmsListenerContainerQueue")
	@SendTo("out.queue")
	public String receiveQueue(String text) {
		System.out.println("police消费者1接受到的消息");
		System.out.println(text);
		return "sample.queue接受的消息>>>>>" + text;
	}
    
	@JmsListener(destination = "${queque.police}",containerFactory="jmsListenerContainerQueue")
	public void receiveQueue2(String text){
	   System.out.println("police消费者2接受到的消息");
	   System.out.println(text);
	   
	}
	 
	@JmsListener(destination = "out.queue",containerFactory="jmsListenerContainerQueue")
	public void receiveOutQueue(String text) {
		System.out.println("out.Queue接受到的信息" + text);
	}
	
	@JmsListener(destination = "${topic.pbc}",containerFactory="jmsListenerContainerTopic")
	public void receiveTopic(String text){
		System.out.println("pbc1消费者接受的信息");
		System.out.println(text);
	}
	@JmsListener(destination = "${topic.pbc}",containerFactory="jmsListenerContainerTopic")
	public void receiveTopic2(String text){
		System.out.println("pbc2消费者接受的信息"+text);
	}
	
	@JmsListener(destination = "${topic.veh}",containerFactory="jmsListenerContainerTopic")
	public void receiveTopicUser(Message m){
		System.out.println("接受到的对象信息message>>>>"+m);
		User  user=new User();
		 if(m instanceof  ObjectMessage){
			 ObjectMessage objectMessage=(ObjectMessage) m;
			 System.out.println("objectMessage>>>>>>>"+objectMessage);
			 try {
				user=(User) objectMessage.getObject();
				
			} catch (JMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
		
		System.out.println("消费者接受的用户对象信息"+user);
	}
	
}
