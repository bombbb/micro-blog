package com.cloud.microblog.gateway.dao.model;

public class BlogImg {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column blog_img.img_id
     *
     * @mbggenerated
     */
    private Byte imgId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column blog_img.blog_id
     *
     * @mbggenerated
     */
    private Long blogId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column blog_img.img_url
     *
     * @mbggenerated
     */
    private String imgUrl;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column blog_img.img_id
     *
     * @return the value of blog_img.img_id
     *
     * @mbggenerated
     */
    public Byte getImgId() {
        return imgId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column blog_img.img_id
     *
     * @param imgId the value for blog_img.img_id
     *
     * @mbggenerated
     */
    public void setImgId(Byte imgId) {
        this.imgId = imgId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column blog_img.blog_id
     *
     * @return the value of blog_img.blog_id
     *
     * @mbggenerated
     */
    public Long getBlogId() {
        return blogId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column blog_img.blog_id
     *
     * @param blogId the value for blog_img.blog_id
     *
     * @mbggenerated
     */
    public void setBlogId(Long blogId) {
        this.blogId = blogId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column blog_img.img_url
     *
     * @return the value of blog_img.img_url
     *
     * @mbggenerated
     */
    public String getImgUrl() {
        return imgUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column blog_img.img_url
     *
     * @param imgUrl the value for blog_img.img_url
     *
     * @mbggenerated
     */
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}