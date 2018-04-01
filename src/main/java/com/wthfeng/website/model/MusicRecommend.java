package com.wthfeng.website.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

/**
 * 歌曲推荐表实体类
 *
 * @author wangtonghe
 * @since 2018/3/31 17:09
 */
@Data
@Entity
public class MusicRecommend {

    @Id
    @GeneratedValue
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
