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

public class PushConsumer {

    public static void main(String[] args) throws MQClientException {
//        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("group", new AclClientRPCHook(new SessionCredentials("RocketMQ_TEST","12345678")), new AllocateMessageQueueAveragely());
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("easyds_78", new AclClientRPCHook(new SessionCredentials("42c9a3287a65447ea4d080f30301edfe","3c5a76a6a29f4a929888bc01e5ab24dc")), new AllocateMessageQueueAveragely());
        consumer.setNamesrvAddr("10.196.96.63:9876;10.196.96.64:9876");
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_MIN_OFFSET);
        consumer.subscribe("test-1", "*");
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