package com.tjwq.bmb.service;

import com.tjwq.bmb.entity.Content;

import java.util.List;

public interface ContentService {

    void addFileRecord(int file_type, String file_name, long content_id, long user_id);

    void addContentRecord(Content content);

    List<Content> getContentsByUserId(long user_id);

    Content getContentByContentId(long contentId);

    void deleteContentByContentId(long contentId, Long user_id);

    void updateContent(Content content);
}
