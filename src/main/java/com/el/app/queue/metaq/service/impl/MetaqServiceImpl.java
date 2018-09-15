package com.el.app.queue.metaq.service.impl;

import com.el.app.queue.metaq.common.TopicEnum;
import com.el.app.queue.metaq.service.MetaqService;
import com.taobao.metamorphosis.Message;
import com.taobao.metamorphosis.client.producer.MessageProducer;
import com.taobao.metamorphosis.client.producer.SendResult;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Danfeng
 * @since 2018/9/11
 */
@Slf4j
@Service
public class MetaqServiceImpl implements MetaqService {

    @Autowired
    private MessageProducer messageProducer;

    @SneakyThrows
    @Override
    public void pubMsg() {
        messageProducer.publish(TopicEnum.test.name());
        final SendResult sendResult = messageProducer.sendMessage(new Message(TopicEnum.test.name(), "hello,MetaQ!".getBytes()));
        if (!sendResult.isSuccess()) {
            System.err.println("Send message failed,error message:" + sendResult.getErrorMessage());
        }
        else {
            System.out.println("Send message successfully,sent to " + sendResult.getPartition());
        }
    }

}
