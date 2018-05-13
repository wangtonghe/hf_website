package com.wthfeng.website.model;

import lombok.Data;


import java.io.Serializable;
import java.time.LocalDate;

/**
 * 歌曲推荐表实体类
 *
 * @author wangtonghe
 * @since 2018/3/31 17:09
 */
@Data
public class MusicRecommend implements Serializable {


    private Integer id;

    private Integer musicId;

    private String name;

    private String album;

    private String origin;

    private String link;

    private String cover;

    private String singer;

    private LocalDate pushDate;


}
