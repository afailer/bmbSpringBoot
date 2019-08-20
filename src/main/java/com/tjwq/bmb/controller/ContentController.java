package com.tjwq.bmb.controller;

import com.tjwq.bmb.entity.Content;
import com.tjwq.bmb.service.ContentService;
import com.tjwq.bmb.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;
import java.util.UUID;

@RestController
public class ContentController {

    @Value("${img_path}")
    private String filePath;

    @Autowired
    private ContentService contentService;

    @PostMapping(value = "/api/v1/content/content")
    private Object addContent(@RequestBody Content content, HttpServletRequest request){
        if(content.isContentRight()){
            content.setUser_id(Long.parseLong("" + request.getAttribute("user_id")));
            contentService.addContentRecord(content);
            return JsonData.buildSuccess("","添加内容成功");
        }else{
            return JsonData.buildError("请填写完整内容");
        }
    }

    @GetMapping(value = "/api/v1/content/content")
    private Object getContentsByUserId(HttpServletRequest request){
        long userId = Long.parseLong("" + request.getAttribute("user_id"));
        List<Content> contents = contentService.getContentsByUserId(userId);
        return JsonData.buildSuccess(contents);
    }

    @GetMapping(value = "/api/v1/content/getContentById")
    private Object getContentByContentId(String id){
        Content content = contentService.getContentByContentId(Long.parseLong(id));
        return JsonData.buildSuccess(content, "成功");
    }

    @DeleteMapping(value = "/api/v1/content/content")
    private Object deleteContentsByContentId(String id, HttpServletRequest request){
        String userId = "" + request.getAttribute("user_id");
        contentService.deleteContentByContentId(new Long(id), new Long(userId));
        return JsonData.buildSuccess("", "删除成功");
    }

    @PatchMapping(value = "/api/v1/content/content")
    private Object editContentByContentId(@RequestBody Content content, HttpServletRequest request){
        String userId = "" + request.getAttribute("user_id");
        content.setUser_id(Long.parseLong(userId));
        contentService.updateContent(content);
        return JsonData.buildSuccess(null,"修改成功");
    }



    @RequestMapping(value = "api/v2/content/{content_id}/upload_file/{file_type}", method = RequestMethod.POST)
    public Object uploadFile(@PathVariable("content_id") long content_id, @PathVariable("file_type") int file_type,  @RequestParam("targetFile") MultipartFile file, HttpServletRequest request){
        String name = request.getParameter("name");
        String fileName = file.getOriginalFilename();
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        fileName = UUID.randomUUID() + suffixName;
        File dest = new File(filePath + fileName);
        try {
            file.transferTo(dest);
            long userId = (long)request.getAttribute("user_id");
            contentService.addFileRecord(file_type, fileName, content_id, userId);
            return JsonData.buildSuccessMsg(fileName);
        }catch (Exception e){
            //e.printStackTrace();
            return JsonData.buildError(e.getMessage());
        }

    }

}
