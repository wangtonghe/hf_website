package com.wthfeng.website.dao;

import com.wthfeng.website.model.Music;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author wangtonghe
 * @since 2018/4/1 12:02
 */
@Component
public class MusicDAO {

    /**
     * 获取评论数达到指定数的歌曲
     *
     * @param num 指定数
     * @return List<Music>
     */
    public List<Music> getTop100ByCommentNumGreaterThan(int num) {
        return null;
    }
}
