package com.wthfeng.website.dao;

import com.wthfeng.website.model.MusicRecommend;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

/**
 * @author wangtonghe
 * @since 2018/3/31 17:36
 */
@Component
public class MusicRecommendDAO {

    /**
     * 根据日期获取推荐歌曲
     *
     * @param date
     * @return
     */
   public List<MusicRecommend> getMusicRecommendsByPushDate(LocalDate date) {
        return null;
    }


    /**
     * 根据歌曲名称获取歌曲
     *
     * @param name
     * @return
     */
   public List<MusicRecommend> getMusicRecommendByName(String name) {
        return null;
    }


}
