package org.spring.web.service.serviceImpl;

import javax.jms.Destination;

import org.spring.web.mq.MegProducer;
import org.spring.web.service.MqSendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
*
* 项目名称：spring-web
* 类名称：MqSendServiceImpl
* 类描述：
* 创建人：john
* 创建时间：2018年7月29日 下午11:01:52
* 修改人：john
* 修改时间：2018年7月29日 下午11:01:52
* 修改备注：
* @version
*
*/
@Service
public class MqSendServiceImpl  implements MqSendService{
    @Autowired
	private MegProducer megProducer;
	@Override
	public void sendMsg(Destination destination, String msg) {
		megProducer.sendMessage(destination, msg);
	}
	
	@Override
	public void sendObject(Destination destination, Object obj) {
		
		megProducer.sendObject(destination, obj);
	}

}
