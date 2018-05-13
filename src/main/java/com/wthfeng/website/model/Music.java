package com.wthfeng.website.model;

import lombok.Data;

import java.time.LocalDate;

/**
 * @author wangtonghe
 * @since 2018/4/1 11:42
 */
@Data
public class Music {


    private Integer id;

    private Integer originId;

    private String name;

    private String album;

    private String origin;

    private String link;

    private String cover;

    private String singer;

    private LocalDate createDate;

    private Integer commentNum;
}
