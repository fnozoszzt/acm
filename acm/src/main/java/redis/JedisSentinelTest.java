package redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisSentinelPool;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class JedisSentinelTest {

    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub

        Set<String> sentinels = new HashSet<String>();
        sentinels.add("10.196.96.66:26379");
        sentinels.add("10.196.96.66:26380");
        sentinels.add("10.196.96.66:26381");

        JedisSentinelPool jedisSentinelPool = new JedisSentinelPool("10.196.96.66-7xxx", sentinels, "myredis");
        Jedis jedis = null;

        //ShardedJedisSentinelPool a;

        while (true) {
            Thread.sleep(1000);

            try {
                jedis = jedisSentinelPool.getResource();


                Date now = new Date();
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                String format_now = dateFormat.format(now);

                jedis.select(4);
                jedis.set("hello", "world");
                String value = jedis.get("hello");
                System.out.println(format_now + ' ' + value);

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (jedis != null)
                    try {
                        jedis.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
            }
        }


    }
}