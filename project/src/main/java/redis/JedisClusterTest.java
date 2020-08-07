package redis;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class JedisClusterTest {
    public static void main(String[] args) throws IOException {
        Set<HostAndPort> jedisClusterNode = new HashSet<HostAndPort>();
        jedisClusterNode.add(new HostAndPort("datastream102.jd.163.org",36379));//添加对应机器的ip地址和端口号
        jedisClusterNode.add(new HostAndPort("datastream102.jd.163.org",36380));
        jedisClusterNode.add(new HostAndPort("datastream102.jd.163.org",36380));
        jedisClusterNode.add(new HostAndPort("datastream102.jd.163.org",36389));
        jedisClusterNode.add(new HostAndPort("datastream102.jd.163.org",36390));
        jedisClusterNode.add(new HostAndPort("datastream102.jd.163.org",36391));
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(100);//设置最大连接数
        config.setMaxIdle(10);//设置最大空闲连接
        JedisCluster jedisCluster = new JedisCluster(jedisClusterNode,5000,10,config);

        JedisCluster a;
        //jedisClusterNode 服务节点信息
        //5000 设置连接超时的最大时间
        //10 循环尝试连接次数
        //config jedis连接池配置

        // TODO codeing Redis Opreate

        for (int i = 0; i < 10000; i++) {
            System.out.println(jedisCluster.set(i + "", i + ""));
            System.out.println(jedisCluster.get(i + ""));
        }


        jedisCluster.close();
    }
}
