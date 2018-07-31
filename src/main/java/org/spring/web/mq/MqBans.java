package org.spring.web.mq;

import javax.jms.Queue;
import javax.jms.Topic;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;

/**
 *
 * 项目名称：spring-web 类名称：MqBans 类描述： 创建人：john 创建时间：2018年7月30日 上午7:30:18 修改人：john
 * 修改时间：2018年7月30日 上午7:30:18 修改备注：
 * 
 * @version
 *
 */
@Configuration
@EnableJms
public class MqBans {
	@Value("${queque.police}")
	private String policeQueue;
	@Value("${queue.edu}")
	private String eduQueue;
	@Value("${topic.pbc}")
	private String pbcTopic;
	@Value("${topic.veh}")
	private String vehTopic;

	@Bean
	public Queue policeQueue() {
		return new ActiveMQQueue(policeQueue);
	}

	@Bean
	public Queue eduQueue() {
		return new ActiveMQQueue(eduQueue);
	}

	@Bean
	public Topic pbcTopic() {
		return new ActiveMQTopic(pbcTopic);
	}

	@Bean
	public Topic vehTopic() {
		return new ActiveMQTopic(vehTopic);
	}

}
