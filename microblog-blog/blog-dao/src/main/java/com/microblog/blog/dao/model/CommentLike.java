package com.microblog.blog.dao.model;

import java.util.Date;

public class CommentLike {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column comment_like.like_id
     *
     * @mbggenerated
     */
    private Long likeId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column comment_like.comment_id
     *
     * @mbggenerated
     */
    private Long commentId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column comment_like.user_id
     *
     * @mbggenerated
     */
    private Long userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column comment_like.create_time
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column comment_like.like_id
     *
     * @return the value of comment_like.like_id
     *
     * @mbggenerated
     */
    public Long getLikeId() {
        return likeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column comment_like.like_id
     *
     * @param likeId the value for comment_like.like_id
     *
     * @mbggenerated
     */
    public void setLikeId(Long likeId) {
        this.likeId = likeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column comment_like.comment_id
     *
     * @return the value of comment_like.comment_id
     *
     * @mbggenerated
     */
    public Long getCommentId() {
        return commentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column comment_like.comment_id
     *
     * @param commentId the value for comment_like.comment_id
     *
     * @mbggenerated
     */
    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column comment_like.user_id
     *
     * @return the value of comment_like.user_id
     *
     * @mbggenerated
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column comment_like.user_id
     *
     * @param userId the value for comment_like.user_id
     *
     * @mbggenerated
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column comment_like.create_time
     *
     * @return the value of comment_like.create_time
     *
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column comment_like.create_time
     *
     * @param createTime the value for comment_like.create_time
     *
     * @mbggenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}