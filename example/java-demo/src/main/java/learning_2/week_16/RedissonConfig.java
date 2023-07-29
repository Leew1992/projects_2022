package learning_2.week_16;


import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.codec.JsonJacksonCodec;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// @Configuration
public class RedissonConfig {

    @Bean(destroyMethod = "shutdown",name = "stringRedisson")
    public RedissonClient getStringClient(){
        Config config = new Config();
        config.useMasterSlaveServers()
                .setMasterAddress("127.0.0.1:6379")
                .addSlaveAddress("127.0.0.1:6389", "127.0.0.1:6332", "127.0.0.1:6419")
                .addSlaveAddress("127.0.0.1:6399");
        return Redisson.create(config);
    }

    @Bean(destroyMethod = "shutdown",name = "stringRedisson")
    public RedissonClient getSentinelClient() {
        Config config = new Config();
        config.useSentinelServers()
                .setMasterName("mymaster")
                .addSentinelAddress("127.0.0.1:26389", "127.0.0.1:26379")
                .addSentinelAddress("127.0.0.1:26319");
        return Redisson.create(config);
    }

    @Bean(destroyMethod = "shutdown",name = "jsonRedisson")
    public RedissonClient getJsonClient(){
        Config config = new Config();
        config.useClusterServers()
                //3000毫秒扫描一次集群
                .setScanInterval(3000);
        //序列化处理
        config.setCodec(new JsonJacksonCodec());
        RedissonClient redissonClient = Redisson.create(config);
        return redissonClient;
    }
}
