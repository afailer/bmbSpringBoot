package com.tjwq.bmb.service.impl;

import com.tjwq.bmb.entity.Content;
import com.tjwq.bmb.mapper.ContentMapper;
import com.tjwq.bmb.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContentServiceImpl implements ContentService {

    @Autowired
    ContentMapper contentMapper;

    @Override
    public void addFileRecord(int file_type, String file_name, long content_id, long user_id) {
        contentMapper.addFileRecord(file_type, file_name, content_id, user_id);
    }

    @Override
    public void addContentRecord(Content content) {
        contentMapper.addContentRecord(content);
    }

    @Override
    public List<Content> getContentsByUserId(long user_id) {
        return contentMapper.getContents(0,0,user_id);
    }

    @Override
    public void deleteContentByContentId(long contentId, Long user_id) {
        contentMapper.deleteContentByContentId(contentId, user_id);
    }

    @Override
    public void updateContent(Content content) {
        contentMapper.updateContent(content);
    }

    @Override
    public Content getContentByContentId(long contentId) {
        List<Content> contents = contentMapper.getContentByContentId(contentId);
        if(contents.size() > 0){
            return contents.get(0);
        }else {
            return null;
        }
    }
}
