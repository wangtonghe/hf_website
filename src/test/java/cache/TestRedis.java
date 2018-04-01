package cache;

import com.wthfeng.website.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author wangtonghe
 * @since 2018/4/1 15:49
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class TestRedis {

    @Autowired
    StringRedisTemplate stringRedisTemplate;


    @Test
    public void testRedis() {
        String originKey = "test";
        String originResult = "website";
        stringRedisTemplate.opsForValue().set(originKey, originResult);
        String result = stringRedisTemplate.opsForValue().get(originKey);
        assert originResult.equals(result);

    }


}
