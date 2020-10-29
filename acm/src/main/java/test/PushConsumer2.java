package test;


import org.apache.rocketmq.acl.common.AclClientRPCHook;
import org.apache.rocketmq.acl.common.SessionCredentials;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.consumer.rebalance.AllocateMessageQueueAveragely;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.List;

public class PushConsumer2 {

    public static void main(String[] args) throws MQClientException {
//        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("group", new AclClientRPCHook(new SessionCredentials("RocketMQ_TEST","12345678")), new AllocateMessageQueueAveragely());
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("easyds_83", new AclClientRPCHook(new SessionCredentials("e57d61b45b864e0ca4a744a01e03c988","57dde0b3f2cf4c76ab61f00e8281c6a0")), new AllocateMessageQueueAveragely());
        consumer.setNamesrvAddr("10.196.96.63:9876;10.196.96.64:9876");
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_MIN_OFFSET);
        consumer.subscribe("test-3", "*");
        consumer.registerMessageListener(new MessageListenerConcurrently() {
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs,
                                                            ConsumeConcurrentlyContext context) {
                System.out.printf(Thread.currentThread().getName() + " Receive New Messages :" + msgs + "%n");
                for (MessageExt m: msgs) {
                    System.out.println("\t" + new String(m.getBody()) + "\t" + m.getTags());
                }
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });
        consumer.start();
    }
}