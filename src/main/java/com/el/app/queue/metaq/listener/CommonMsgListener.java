package com.el.app.queue.metaq.listener;


import com.taobao.metamorphosis.Message;
import com.taobao.metamorphosis.client.consumer.MessageListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executor;

/**
 * @author Danfeng
 * @since 2018/9/11
 */
@Component
public class CommonMsgListener implements MessageListener {

    @Override
    public void recieveMessages(Message message) {
        System.out.println("Receive message " + new String(message.getData()));
    }

    @Override
    public Executor getExecutor() {
        return null;
    }
}
