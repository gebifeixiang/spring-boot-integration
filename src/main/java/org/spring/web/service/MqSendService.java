package org.spring.web.service;

import javax.jms.Destination;

import org.springframework.stereotype.Service;

/**
*
* 项目名称：spring-web
* 类名称：MqSendService
* 类描述：
* 创建人：john
* 创建时间：2018年7月29日 下午11:00:01
* 修改人：john
* 修改时间：2018年7月29日 下午11:00:01
* 修改备注：
* @version
*
*/
//@Service
public interface MqSendService {
	public void sendMsg(Destination destination, String msg);
    public void sendObject(Destination destination, Object obj);
}
