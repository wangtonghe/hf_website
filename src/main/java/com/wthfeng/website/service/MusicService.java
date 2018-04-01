package com.wthfeng.website.service;

import com.wthfeng.website.dao.MusicDAO;
import com.wthfeng.website.dao.MusicRecommendDAO;
import com.wthfeng.website.model.MusicRecommend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

/**
 * @author wangtonghe
 * @since 2018/3/31 15:43
 */
@Service
public class MusicService {

    @Autowired
    private MusicRecommendDAO musicRecommendDAO;

    public List<MusicRecommend> getTodayRecommend() {
        LocalDate localDate = LocalDate.now().plusDays(1);

        return musicRecommendDAO.getMusicRecommendsByPushDate(localDate);

    }


    public List<MusicRecommend> getMusicByName(String name) {
        return musicRecommendDAO.getMusicRecommendByName(name);
    }


}
