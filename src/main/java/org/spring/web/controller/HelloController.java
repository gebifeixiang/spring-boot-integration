package org.spring.web.controller;


import javax.jms.Topic;
import org.spring.web.entity.User;
import org.spring.web.service.MqSendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
*
* 项目名称：spring-web
* 类名称：HelloController
* 类描述：
* 创建人：john
* 创建时间：2018年7月28日 上午11:21:12
* 修改人：john
* 修改时间：2018年7月28日 上午11:21:12
* 修改备注：
* @version
*
*/
@RestController
@RequestMapping(value="/hello",produces="text/plain;charset=UTF-8")
@ConfigurationProperties(prefix = "application")
@PropertySource(value = "classpath:application.properties", encoding = "UTF-8")
public class HelloController {
	@Value("${com.interview.question}")
	private String interviewQuestion;
	@Autowired
	private MqSendService mqSendService;
	@Autowired
	private Topic pbcTopic;
	@Autowired
	private Topic vehTopic;
	
	@RequestMapping("/hello")
	public String hello(){
		System.out.println(">>>>>>>>>>>>>>>>"+interviewQuestion);
		return interviewQuestion;
	}
	@RequestMapping("/sendMQ")
	public  String sendMsg(){
		mqSendService.sendMsg(pbcTopic, "nihao");
		return "sendMQ";
	}
	@RequestMapping("/sendUser")
	public User sendUser(){
		User user=new User();
		user.setAge(11);
		user.setId(1);
		user.setPassword("password");
		user.setUserName("userName");
		/*ActiveMQObjectMessage msg=new ActiveMQObjectMessage();
		try {
			msg.setObject((Serializable)user);
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	    mqSendService.sendObject(vehTopic, user);
		return user;
	}

}
