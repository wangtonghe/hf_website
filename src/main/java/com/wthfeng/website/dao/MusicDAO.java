package com.wthfeng.website.dao;

import com.wthfeng.website.model.Music;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author wangtonghe
 * @since 2018/4/1 12:02
 */
public interface MusicDAO extends JpaRepository<Music, Integer> {

    /**
     * 获取评论数达到指定数的歌曲
     *
     * @param num 指定数
     * @return List<Music>
     */
    public List<Music> getTop100ByCommentNumGreaterThan(int num);
}
