package test;


import org.apache.rocketmq.acl.common.AclClientRPCHook;
import org.apache.rocketmq.acl.common.SessionCredentials;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.RPCHook;
import org.apache.rocketmq.remoting.common.RemotingHelper;

public class SyncProducer {

    public static void main(String[] args) throws Exception {
        // 构造Producer
        DefaultMQProducer producer = new DefaultMQProducer("ProducerGroupName", getAclRPCHook());
        producer.setNamesrvAddr("10.196.96.63:9876;10.196.96.64:9876");
        // 初始化Producer，整个应用生命周期内，只需要初始化1次
        producer.start();
        for (int i = 0; i < 10; i++) {
            Message msg = new Message("TopicTest", "Tag " + i,
                    ("Hello RocketMQ " + i).getBytes(RemotingHelper.DEFAULT_CHARSET));
            SendResult sendResult = producer.send(msg);
            System.out.println(sendResult);
        }
        producer.shutdown();
    }

    static RPCHook getAclRPCHook() {
        return new AclClientRPCHook(new SessionCredentials("rocketmq3","12345678"));
    }
}


