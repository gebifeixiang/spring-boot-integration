package org.spring.web.mq;

import javax.jms.Destination;

import org.spring.web.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

/**
*
* 项目名称：spring-web
* 类名称：MegProducer
* 类描述：
* 创建人：john
* 创建时间：2018年7月28日 下午9:30:50
* 修改人：john
* 修改时间：2018年7月28日 下午9:30:50
* 修改备注：
* @version
*
*/
@Service("megProducer")
public class MegProducer {
	@Autowired
  private JmsMessagingTemplate jmsTemplate;
  
	public void sendMessage(Destination destination, String msg){
		jmsTemplate.convertAndSend(destination, msg);
	}
  
	public void sendObject(Destination destination,Object Obj){	
		jmsTemplate.convertAndSend(destination, Obj);
	}
}
