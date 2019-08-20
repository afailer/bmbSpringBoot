package com.tjwq.bmb.entity;

public class User {
    public User() {
    }

    private long id;
    private String phone_num;
    private String password;
    private String user_level;
    private String email;
    private String user_name;
    private String wechat_id;
    private int sex;
    private String iccard_num;
    private String img;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", phone_num='" + phone_num + '\'' +
                ", password='" + password + '\'' +
                ", user_level='" + user_level + '\'' +
                ", email='" + email + '\'' +
                ", user_name='" + user_name + '\'' +
                ", wechat_id='" + wechat_id + '\'' +
                ", sex=" + sex +
                ", iccard_num='" + iccard_num + '\'' +
                ", img='" + img + '\'' +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPhone_num() {
        return phone_num;
    }

    public void setPhone_num(String phone_num) {
        this.phone_num = phone_num;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUser_level() {
        return user_level;
    }

    public void setUser_level(String user_level) {
        this.user_level = user_level;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getWechat_id() {
        return wechat_id;
    }

    public void setWechat_id(String wechat_id) {
        this.wechat_id = wechat_id;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getIccard_num() {
        return iccard_num;
    }

    public void setIccard_num(String iccard_num) {
        this.iccard_num = iccard_num;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

}
