package com.czinwen.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: ytjia
 * @Create: 2020-05-31 16:24
 */
//自定义负载均衡策略，该配置类不能被@componentscan所扫面的当前包及子包下，所以不能再启动类的包和子包下

@Configuration
public class MySelfRule {
        @Bean
    public IRule myRule(){
            return new RandomRule();  //定义为随机
        }
}
