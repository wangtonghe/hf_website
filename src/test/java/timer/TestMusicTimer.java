package timer;

import com.wthfeng.website.Application;
import com.wthfeng.website.timer.MusicTimer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;

/**
 * 测试音乐定时器
 *
 * @author wangtonghe
 * @since 2018/4/1 12:25
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class TestMusicTimer {

    @Autowired
    private MusicTimer musicTimer;

    @Test
    public void testRecommendMusic() {

//        musicTimer.generateMusicRecommend(LocalDate.of(2018, 1, 2));


    }


}
