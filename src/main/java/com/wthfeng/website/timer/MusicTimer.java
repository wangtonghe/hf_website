package com.wthfeng.website.timer;

import com.wthfeng.website.dao.MusicDAO;
import com.wthfeng.website.dao.MusicRecommendDAO;
import com.wthfeng.website.model.Music;
import com.wthfeng.website.model.MusicRecommend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 歌曲定时任务
 *
 * @author wangtonghe
 * @since 2018/4/1 11:53
 */
@Service
public class MusicTimer {

    @Autowired
    private MusicDAO musicDAO;

    @Autowired
    private MusicRecommendDAO musicRecommendDAO;

    public void generateMusicRecommend(LocalDate localDate) {
        List<Music> list = musicDAO.getTop100ByCommentNumGreaterThan(5000);
        Collections.shuffle(list);
        List<MusicRecommend> result = list.stream().limit(10)
                .map(music -> {
                    MusicRecommend recommend = new MusicRecommend();
                    recommend.setName(music.getName());
                    recommend.setSinger(music.getSinger());
                    recommend.setCover(music.getCover());
                    recommend.setAlbum(music.getAlbum());
                    recommend.setLink(music.getLink());
                    recommend.setOrigin(music.getOrigin());
                    recommend.setPushDate(localDate);
                    recommend.setMusicId(music.getId());
                    System.out.println(localDate);
                    return recommend;

                }).collect(Collectors.toList());

        result.forEach(musicRecommend -> System.out.println(musicRecommend.getName()));

//        musicRecommendDAO.saveAll(result);
    }




}
