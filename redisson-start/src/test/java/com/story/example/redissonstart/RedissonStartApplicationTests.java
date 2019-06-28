package com.story.example.redissonstart;

import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedissonStartApplicationTests {

  @Autowired
  RedissonClient redissonClient;

  @Test
  public void contextLoads() {}

  @Test
  public void testRedisson(){
    RBucket<String> strBucket = redissonClient.getBucket("name");
    strBucket.set("redisson",10, TimeUnit.SECONDS);
    String name = strBucket.get();
    Assert.assertEquals(name,"redisson");
    try {
      Thread.sleep(10000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    Assert.assertNull(strBucket.get());
  }
}
