package com.wthfeng.website.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

/**
 * @author wangtonghe
 * @since 2018/4/1 11:42
 */
@Data
@Entity
public class Music {

    @Id
    @GeneratedValue
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
