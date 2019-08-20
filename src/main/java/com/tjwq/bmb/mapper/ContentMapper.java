package com.tjwq.bmb.mapper;

import com.tjwq.bmb.entity.Content;
import com.tjwq.bmb.provider.ContentProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ContentMapper {

    @Insert("insert into files (file_type, file_name, content_id, user_id) values (#{file_type}, #{file_name}, #{content_id}, #{user_id})")
    void addFileRecord(int file_type, String file_name, long content_id, long user_id);

    @Insert("insert into content(user_id,title,icon,content,content_type,btn_info,create_time,update_time) values (#{user_id},#{title},#{icon},#{content},#{content_type},#{btn_info},#{create_time},#{update_time})")
    void addContentRecord(Content myContent);

    @Select("select * from content where user_id = #{user_id}")
    List<Content> getContents(int pageNo, int pageSize, long user_id);

    @Delete("delete from content where id = #{contentId} and user_id = #{user_id}")
    void deleteContentByContentId(long contentId, long user_id);

    @UpdateProvider(type = ContentProvider.class, method = "updateContent")
    void updateContent(Content content);

    @Select("select * from content where id = #{id}")
    List<Content> getContentByContentId(long id);

}
