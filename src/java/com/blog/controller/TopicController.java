package com.blog.controller;

import com.blog.model.Topic;
import com.blog.model.TopicDAO;
import com.blog.randomStringGenerator.pattern.Chars;
import com.blog.randomStringGenerator.pattern.Size;
import com.blog.randomStringGenerator.pattern.StringPatterns;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Controller
public class TopicController {

    @Autowired
    TopicDAO topicDAO;

    private static final Logger logger = LoggerFactory
            .getLogger(TopicController.class);

    @RequestMapping(value = "/topic/{category}/{subcategory}/{id}")
    public String readTopic(@PathVariable String id, @PathVariable String subcategory, Model model) {

        Topic topic = topicDAO.getTopicById(id);
        List<Topic> releatedTopics = topicDAO.getReleatedTopics(subcategory, id);
        model.addAttribute("topic", topic);
        model.addAttribute("releatedTopics", releatedTopics);
        model.addAttribute("style", "readtopic");

        return "readtopic";
    }

    @RequestMapping(value = "/topic/newtopic", method = RequestMethod.GET)
    public String newTopicGET(Model model) {

        return "newtopic";
    }

    @RequestMapping(value = "/topic/newtopic", method = RequestMethod.POST)
    public String newTopicPOST(Model model,
            @RequestParam(value = "title") String title,
            @RequestParam(value = "category") String category,
            @RequestParam(value = "subcategory") String subCategory,
            @RequestParam(value = "description") String description,
            @RequestParam(value = "content") String content,
            @RequestParam(value = "author") String author) throws IOException {

        

        return "newtopic";
    }
    
    
    
    @RequestMapping(value="/topic/upload", method=RequestMethod.POST)
    @ResponseBody
    public String uploadImage(@RequestParam CommonsMultipartFile[] fileUpload) throws IOException{
        
        //ovde upises putanju do svog projekta tj. na svom kompu
        String saveDir = "C:\\Users\\Stefan\\Documents\\GitHub\\blog\\web\\resource\\img\\topic_resources";

        fileUploadHandler(fileUpload, saveDir, "test");
  
        return "testtt";
        
    }

    
    //upload fajla na server
    private void fileUploadHandler(CommonsMultipartFile[] fileUpload, String saveDirectory, String topicTitle) throws IOException {

        if (fileUpload != null && fileUpload.length > 0) {
            for (CommonsMultipartFile aFile : fileUpload) {

            

                if (!aFile.getOriginalFilename().equals("")) {
                    try {
                        
                        //ovo je neko moje sranje za generisanje random stringa :) da ne bi bilo 2 fajla sa istim nazivom
                        StringPatterns sp = new StringPatterns();
                        String generate = sp.generate(Chars.LETTER_CHARS, Size.MEDIUM_SIZE);
                        StringBuilder sb = new StringBuilder();
                        
                        sb.append(saveDirectory);
                        sb.append("\\");
                        sb.append(topicTitle);
                        File dir = new File(sb.toString());
                        if (!dir.exists()) {
                            dir.mkdirs();
                        }
                        sb.append("\\");
                        sb.append(generate);
                        sb.append("_");
                        sb.append(aFile.getOriginalFilename());

                        System.out.println(sb.substring(5, 7));
                        
                        aFile.transferTo(new File( sb.toString()));
                    } catch (IllegalStateException | IOException e) {
                    }
                }
            }
        }
    }
}
