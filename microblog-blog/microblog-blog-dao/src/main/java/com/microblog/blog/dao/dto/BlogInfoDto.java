package com.microblog.blog.dao.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Data
@Builder
public class BlogInfoDto {

    private Long  blogId;
    private Long userId;
    private String headerUrl;
    private String nickName;

   // @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
   // @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Date publishTime;
    private String content;
    private List<String> blogImg;
    private long collectNum;
    private long repostNum;
    private long commentNum;
    private long likeNum;
    private boolean likeFlag;

}
