package com.wthfeng.website.dao;

import com.wthfeng.website.model.MusicRecommend;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

/**
 * @author wangtonghe
 * @since 2018/3/31 17:36
 */
public interface MusicRecommendDAO extends JpaRepository<MusicRecommend, Integer> {

    /**
     * 根据日期获取推荐歌曲
     *
     * @param date
     * @return
     */
    List<MusicRecommend> getMusicRecommendsByPushDate(LocalDate date);


    /**
     * 根据歌曲名称获取歌曲
     *
     * @param name
     * @return
     */
    List<MusicRecommend> getMusicRecommendByName(String name);





}
