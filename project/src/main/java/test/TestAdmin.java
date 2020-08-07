package test;

import org.apache.rocketmq.acl.common.AclClientRPCHook;
import org.apache.rocketmq.acl.common.SessionCredentials;
import org.apache.rocketmq.common.MixAll;
import org.apache.rocketmq.tools.admin.DefaultMQAdminExt;
import org.apache.rocketmq.tools.command.SubCommandException;

import java.util.Set;

public class TestAdmin {
    public static void main(String[] args) throws Exception {
        System.setProperty(MixAll.NAMESRV_ADDR_PROPERTY, "10.196.96.63:9876;10.196.96.64:9876");
        DefaultMQAdminExt defaultMQAdminExt = new DefaultMQAdminExt(new AclClientRPCHook(new SessionCredentials("rocketmq2", "12345678")));
        defaultMQAdminExt.setInstanceName(Long.toString(System.currentTimeMillis()));
        //String topic = commandLine.getOptionValue('t').trim();
        String topic = "TopicTest";
        defaultMQAdminExt.start();
        Set<String> clusters = defaultMQAdminExt.getTopicClusterList(topic);
        for (String value : clusters) {
            System.out.printf("%s%n", value);
        }
    }
}
