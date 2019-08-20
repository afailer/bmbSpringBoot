package com.tjwq.bmb.provider;

import com.tjwq.bmb.entity.Content;
import org.apache.ibatis.jdbc.SQL;

public class ContentProvider {

    public String updateContent(final Content content){
        return new SQL(){{
            UPDATE("content");

            if(content.getTitle() != null){
                SET("title=#{title}");
            }
            if(content.getContent() != null){
                SET("content=#{content}");
            }
            if(content.getContent_type() != null){
                SET("content_type=#{content_type}");
            }
            if(content.getIcon() != null){
                SET("icon=#{icon}");
            }
            if(content.getUpdate_time() != null){
                SET("update_time=#{update_time}");
            }

            WHERE("user_id=#{user_id} and id=#{id}");


        }}.toString();
    }

}
