package com.wthfeng.website.controller.music;

import com.wthfeng.website.model.MusicRecommend;
import com.wthfeng.website.constant.ResultMsg;
import com.wthfeng.website.service.MusicService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 歌单 controller
 *
 * @author wangtonghe
 * @since 2018/3/31 14:34
 */
@RestController
@RequestMapping(value = "/music")
public class MusicController {

    @Autowired
    private MusicService musicService;


    /**
     * 获取每日推荐的歌曲
     *
     * @return ResultMsg
     */
    @ApiOperation(value = "获取每日推荐歌曲")
    @RequestMapping(value = "/daily/recommend", method = RequestMethod.GET)
    public ResultMsg getDailyRecommend() {
        ResultMsg resultMsg = new ResultMsg();
        List<MusicRecommend> list = musicService.getTodayRecommend();
        resultMsg.setData(list);
        resultMsg.setCode(ResultMsg.OK);
        return resultMsg;
    }

    /**
     * 获取每日排行榜
     *
     * @return ResultMsg
     */
    @ApiOperation(value = "获取每日排行榜")
    @RequestMapping(value = "/daily/hot", method = RequestMethod.GET)
    public ResultMsg getDailyHot() {
        ResultMsg resultMsg = new ResultMsg();
        resultMsg.setCode(ResultMsg.OK);
        resultMsg.setData(null);
        return resultMsg;

    }

}
