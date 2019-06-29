package com.microblog.points.dao.model;

import java.util.Date;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table sign
 */
public class Sign {
    /**
     * Database Column Remarks:
     *   ID
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sign.id
     *
     * @mbg.generated
     */
    private Long id;

    /**
     * Database Column Remarks:
     *   用户ID
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sign.user_id
     *
     * @mbg.generated
     */
    private Long userId;

    /**
     * Database Column Remarks:
     *   签到历史
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sign.sign_history
     *
     * @mbg.generated
     */
    private String signHistory;

    /**
     * Database Column Remarks:
     *   连续签到次数
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sign.sign_count
     *
     * @mbg.generated
     */
    private Integer signCount;

    /**
     * Database Column Remarks:
     *   年份
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sign.year
     *
     * @mbg.generated
     */
    private Integer year;

    /**
     * Database Column Remarks:
     *   最后签到时间
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sign.last_sign_time
     *
     * @mbg.generated
     */
    private Date lastSignTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sign.id
     *
     * @return the value of sign.id
     *
     * @mbg.generated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sign.id
     *
     * @param id the value for sign.id
     *
     * @mbg.generated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sign.user_id
     *
     * @return the value of sign.user_id
     *
     * @mbg.generated
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sign.user_id
     *
     * @param userId the value for sign.user_id
     *
     * @mbg.generated
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sign.sign_history
     *
     * @return the value of sign.sign_history
     *
     * @mbg.generated
     */
    public String getSignHistory() {
        return signHistory;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sign.sign_history
     *
     * @param signHistory the value for sign.sign_history
     *
     * @mbg.generated
     */
    public void setSignHistory(String signHistory) {
        this.signHistory = signHistory;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sign.sign_count
     *
     * @return the value of sign.sign_count
     *
     * @mbg.generated
     */
    public Integer getSignCount() {
        return signCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sign.sign_count
     *
     * @param signCount the value for sign.sign_count
     *
     * @mbg.generated
     */
    public void setSignCount(Integer signCount) {
        this.signCount = signCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sign.year
     *
     * @return the value of sign.year
     *
     * @mbg.generated
     */
    public Integer getYear() {
        return year;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sign.year
     *
     * @param year the value for sign.year
     *
     * @mbg.generated
     */
    public void setYear(Integer year) {
        this.year = year;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sign.last_sign_time
     *
     * @return the value of sign.last_sign_time
     *
     * @mbg.generated
     */
    public Date getLastSignTime() {
        return lastSignTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sign.last_sign_time
     *
     * @param lastSignTime the value for sign.last_sign_time
     *
     * @mbg.generated
     */
    public void setLastSignTime(Date lastSignTime) {
        this.lastSignTime = lastSignTime;
    }
}