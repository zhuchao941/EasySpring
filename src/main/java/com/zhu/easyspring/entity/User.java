package com.zhu.easyspring.entity;

public class User {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.id
     *
     * @mbggenerated Mon Mar 16 14:20:44 CST 2015
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.username
     *
     * @mbggenerated Mon Mar 16 14:20:44 CST 2015
     */
    private String username;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.password
     *
     * @mbggenerated Mon Mar 16 14:20:44 CST 2015
     */
    private String password;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.email
     *
     * @mbggenerated Mon Mar 16 14:20:44 CST 2015
     */
    private String email;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.salt
     *
     * @mbggenerated Mon Mar 16 14:20:44 CST 2015
     */
    private String salt;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.status
     *
     * @mbggenerated Mon Mar 16 14:20:44 CST 2015
     */
    private Integer status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.role_ids
     *
     * @mbggenerated Mon Mar 16 14:20:44 CST 2015
     */
    private String roleIds;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.id
     *
     * @return the value of user.id
     *
     * @mbggenerated Mon Mar 16 14:20:44 CST 2015
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.id
     *
     * @param id the value for user.id
     *
     * @mbggenerated Mon Mar 16 14:20:44 CST 2015
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.username
     *
     * @return the value of user.username
     *
     * @mbggenerated Mon Mar 16 14:20:44 CST 2015
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.username
     *
     * @param username the value for user.username
     *
     * @mbggenerated Mon Mar 16 14:20:44 CST 2015
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.password
     *
     * @return the value of user.password
     *
     * @mbggenerated Mon Mar 16 14:20:44 CST 2015
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.password
     *
     * @param password the value for user.password
     *
     * @mbggenerated Mon Mar 16 14:20:44 CST 2015
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.email
     *
     * @return the value of user.email
     *
     * @mbggenerated Mon Mar 16 14:20:44 CST 2015
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
     * @mbggenerated Mon Mar 16 14:20:44 CST 2015
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.salt
     *
     * @return the value of user.salt
     *
     * @mbggenerated Mon Mar 16 14:20:44 CST 2015
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
     * @mbggenerated Mon Mar 16 14:20:44 CST 2015
     */
    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.status
     *
     * @return the value of user.status
     *
     * @mbggenerated Mon Mar 16 14:20:44 CST 2015
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.status
     *
     * @param status the value for user.status
     *
     * @mbggenerated Mon Mar 16 14:20:44 CST 2015
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.role_ids
     *
     * @return the value of user.role_ids
     *
     * @mbggenerated Mon Mar 16 14:20:44 CST 2015
     */
    public String getRoleIds() {
        return roleIds;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.role_ids
     *
     * @param roleIds the value for user.role_ids
     *
     * @mbggenerated Mon Mar 16 14:20:44 CST 2015
     */
    public void setRoleIds(String roleIds) {
        this.roleIds = roleIds == null ? null : roleIds.trim();
    }
}