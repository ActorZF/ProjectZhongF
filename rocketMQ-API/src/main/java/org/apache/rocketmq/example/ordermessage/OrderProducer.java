package org.apache.rocketmq.example.ordermessage;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.MessageQueueSelector;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageQueue;
import org.apache.rocketmq.remoting.common.RemotingHelper;

import java.util.List;

/**
 * Author： roy
 * Description：
 **/
public class OrderProducer {

    public static void main(String[] args) throws MQClientException{
        try {
            DefaultMQProducer producer = new DefaultMQProducer("please_rename_unique_group_name");
            producer.setNamesrvAddr("192.168.1.4:9876");
            producer.start();

            for (int i = 0; i < 20; i++) {
                int orderId = i;
                for(int j = 0 ; j < 5; j++){
                    Message msg =
                            new Message("OrderTopic", "order_"+orderId, "KEY" + orderId,
                                    ("order_" + orderId + " step " + j).getBytes(RemotingHelper.DEFAULT_CHARSET));
                    SendResult sendResult = producer.send(msg, new MessageQueueSelector() {
                        @Override
                        public MessageQueue select(List<MessageQueue> mqs, Message msg, Object arg) {
                            Integer id = (Integer) arg;
                            int index = id % mqs.size();
                            return mqs.get(index);
                        }
                    }, orderId);
                    System.out.printf("%s%n", sendResult);
                }
            }

            producer.shutdown();
        } catch (Exception e) {
            e.printStackTrace();
            throw new MQClientException(e.getMessage(), null);
        }
    }
}
