package cache;

import com.wthfeng.website.Application;
import com.wthfeng.website.model.MusicRecommend;
import com.wthfeng.website.service.MusicService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author wangtonghe
 * @since 2018/4/1 16:20
 */
@SpringBootTest(classes = Application.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class TestMusicCache {

    @Autowired
    private MusicService musicService;

    @Test
    public void testMusic() {

        List<MusicRecommend> list = musicService.getTodayRecommend();
        System.out.println(list);
        list = musicService.getTodayRecommend();
        System.out.println(list);


    }
}
