package com.tjwq.bmb.entity;

import java.util.Date;

public class Content {
    private Long id;
    private long user_id;
    private String title;
    private String icon;
    private String content;
    private String content_type;
    private String btn_info;
    private Long create_time;
    private Long update_time;

    public Content() {
        this.create_time = new Date().getTime();
        this.update_time = new Date().getTime();
    }

    public Boolean isContentRight(){
        if(this.title == "" && this.content_type == ""){
            return false;
        }else {
            return true;
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUpdate_time(Long update_time) {
        this.update_time = update_time;
    }

    public long getUser_id() {
        return user_id;
    }

    public String getContent_type() {
        return content_type;
    }

    public void setContent_type(String content_type) {
        this.content_type = content_type;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getBtn_info() {
        return btn_info;
    }

    public void setBtn_info(String btn_info) {
        this.btn_info = btn_info;
    }

    public Long getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Long create_time) {
        this.create_time = create_time;
    }

    public Long getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(long update_time) {
        this.update_time = update_time;
    }

    @Override
    public String toString() {
        return "Content{" +
                "user_id=" + user_id +
                ", title='" + title + '\'' +
                ", icon='" + icon + '\'' +
                ", content='" + content + '\'' +
                ", content_type='" + content_type + '\'' +
                ", btn_info='" + btn_info + '\'' +
                ", create_time=" + create_time +
                ", update_time=" + update_time +
                '}';
    }
}
