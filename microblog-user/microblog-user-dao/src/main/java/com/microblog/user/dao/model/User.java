package com.microblog.user.dao.model;

import lombok.ToString;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table user
 */

@ToString
@Document(indexName="index_user")
public class User {
    /**
     * Database Column Remarks:
     *   用户ID
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.user_id
     *
     * @mbg.generated
     */
    @Field(type = FieldType.Long)
    private Long userId;

    /**
     * Database Column Remarks:
     *   用户编号
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.user_number
     *
     * @mbg.generated
     */
    private Long userNumber;

    /**
     * Database Column Remarks:
     *   昵称
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.nick_name
     *
     * @mbg.generated
     */
    private String nickName;

    /**
     * Database Column Remarks:
     *   登录密码
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.login_password
     *
     * @mbg.generated
     */
    private String loginPassword;

    /**
     * Database Column Remarks:
     *   登录密码盐
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.salt
     *
     * @mbg.generated
     */
    private String salt;

    /**
     * Database Column Remarks:
     *   真实姓名
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.actual_name
     *
     * @mbg.generated
     */
    private String actualName;

    /**
     * Database Column Remarks:
     *   性别
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.gender
     *
     * @mbg.generated
     */
    private String gender;

    /**
     * Database Column Remarks:
     *   年龄
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.age
     *
     * @mbg.generated
     */
    private Byte age;

    /**
     * Database Column Remarks:
     *   头像URL
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.header_url
     *
     * @mbg.generated
     */
    private String headerUrl;

    /**
     * Database Column Remarks:
     *   状态
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.status
     *
     * @mbg.generated
     */
    private Byte status;

    /**
     * Database Column Remarks:
     *   电子邮箱
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.email
     *
     * @mbg.generated
     */
    private String email;

    /**
     * Database Column Remarks:
     *   邮箱是否激活
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.email_active
     *
     * @mbg.generated
     */
    private Byte emailActive;

    /**
     * Database Column Remarks:
     *   电话号码
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.phone_num
     *
     * @mbg.generated
     */
    private String phoneNum;

    /**
     * Database Column Remarks:
     *   注册时间
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.register_time
     *
     * @mbg.generated
     */
    private Date registerTime;

    /**
     * Database Column Remarks:
     *   最后登录时间
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.last_login_time
     *
     * @mbg.generated
     */
    private Date lastLoginTime;

    /**
     * Database Column Remarks:
     *   注册时间
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.update_time
     *
     * @mbg.generated
     */
    @Field(type = FieldType.Date, format = DateFormat.custom,pattern = "yyyy-MM-dd")
    private Date updateTime;

    /**
     * Database Column Remarks:
     *   登录次数
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.login_nums
     *
     * @mbg.generated
     */
    private Integer loginNums;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.user_id
     *
     * @return the value of user.user_id
     *
     * @mbg.generated
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.user_id
     *
     * @param userId the value for user.user_id
     *
     * @mbg.generated
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.user_number
     *
     * @return the value of user.user_number
     *
     * @mbg.generated
     */
    public Long getUserNumber() {
        return userNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.user_number
     *
     * @param userNumber the value for user.user_number
     *
     * @mbg.generated
     */
    public void setUserNumber(Long userNumber) {
        this.userNumber = userNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.nick_name
     *
     * @return the value of user.nick_name
     *
     * @mbg.generated
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.nick_name
     *
     * @param nickName the value for user.nick_name
     *
     * @mbg.generated
     */
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.login_password
     *
     * @return the value of user.login_password
     *
     * @mbg.generated
     */
    public String getLoginPassword() {
        return loginPassword;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.login_password
     *
     * @param loginPassword the value for user.login_password
     *
     * @mbg.generated
     */
    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.salt
     *
     * @return the value of user.salt
     *
     * @mbg.generated
     */
    public String getSalt() {
        return salt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.salt
     *
     * @param salt the value for user.salt
     *
     * @mbg.generated
     */
    public void setSalt(String salt) {
        this.salt = salt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.actual_name
     *
     * @return the value of user.actual_name
     *
     * @mbg.generated
     */
    public String getActualName() {
        return actualName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.actual_name
     *
     * @param actualName the value for user.actual_name
     *
     * @mbg.generated
     */
    public void setActualName(String actualName) {
        this.actualName = actualName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.gender
     *
     * @return the value of user.gender
     *
     * @mbg.generated
     */
    public String getGender() {
        return gender;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.gender
     *
     * @param gender the value for user.gender
     *
     * @mbg.generated
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.age
     *
     * @return the value of user.age
     *
     * @mbg.generated
     */
    public Byte getAge() {
        return age;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.age
     *
     * @param age the value for user.age
     *
     * @mbg.generated
     */
    public void setAge(Byte age) {
        this.age = age;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.header_url
     *
     * @return the value of user.header_url
     *
     * @mbg.generated
     */
    public String getHeaderUrl() {
        return headerUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.header_url
     *
     * @param headerUrl the value for user.header_url
     *
     * @mbg.generated
     */
    public void setHeaderUrl(String headerUrl) {
        this.headerUrl = headerUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.status
     *
     * @return the value of user.status
     *
     * @mbg.generated
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.status
     *
     * @param status the value for user.status
     *
     * @mbg.generated
     */
    public void setStatus(Byte status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.email
     *
     * @return the value of user.email
     *
     * @mbg.generated
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.email
     *
     * @param email the value for user.email
     *
     * @mbg.generated
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.email_active
     *
     * @return the value of user.email_active
     *
     * @mbg.generated
     */
    public Byte getEmailActive() {
        return emailActive;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.email_active
     *
     * @param emailActive the value for user.email_active
     *
     * @mbg.generated
     */
    public void setEmailActive(Byte emailActive) {
        this.emailActive = emailActive;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.phone_num
     *
     * @return the value of user.phone_num
     *
     * @mbg.generated
     */
    public String getPhoneNum() {
        return phoneNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.phone_num
     *
     * @param phoneNum the value for user.phone_num
     *
     * @mbg.generated
     */
    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.register_time
     *
     * @return the value of user.register_time
     *
     * @mbg.generated
     */
    public Date getRegisterTime() {
        return registerTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.register_time
     *
     * @param registerTime the value for user.register_time
     *
     * @mbg.generated
     */
    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.last_login_time
     *
     * @return the value of user.last_login_time
     *
     * @mbg.generated
     */
    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.last_login_time
     *
     * @param lastLoginTime the value for user.last_login_time
     *
     * @mbg.generated
     */
    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.update_time
     *
     * @return the value of user.update_time
     *
     * @mbg.generated
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.update_time
     *
     * @param updateTime the value for user.update_time
     *
     * @mbg.generated
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.login_nums
     *
     * @return the value of user.login_nums
     *
     * @mbg.generated
     */
    public Integer getLoginNums() {
        return loginNums;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.login_nums
     *
     * @param loginNums the value for user.login_nums
     *
     * @mbg.generated
     */
    public void setLoginNums(Integer loginNums) {
        this.loginNums = loginNums;
    }
}