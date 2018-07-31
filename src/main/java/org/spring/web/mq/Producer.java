
package org.spring.web.mq;
import javax.jms.Queue;
import javax.jms.Topic;

import org.spring.web.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
public class Producer implements CommandLineRunner {
	
	@Autowired
	private JmsMessagingTemplate jmsMessagingTemplate;

	@Autowired
	private Queue policeQueue;
	
	@Autowired
	private Topic pbcTopic;
	
	@Autowired
	private Topic vehTopic;
	
	@Override
	public void run(String... args) throws Exception {
		for(int i=0;i<1;i++){	
			send("Sample message"+i);
		}
		sendTopic("topic send");
	}

	public void send(String msg) {
		this.jmsMessagingTemplate.convertAndSend(this.policeQueue, msg);
		System.out.println("Message was sent to the policeQueue");

	}

	public void sendTopic(String msg){
		System.out.println("消费者发送topic消息");
		this.jmsMessagingTemplate.convertAndSend(this.pbcTopic,msg);
		System.out.println("Message was sent to the pbcTopic");
	}
	
	
}
