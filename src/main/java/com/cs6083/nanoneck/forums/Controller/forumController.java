package com.cs6083.nanoneck.forums.Controller;

import com.cs6083.nanoneck.forums.DAO.formsDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;

@Controller
public class forumController {
    @Autowired
    private formsDAO formsDAO;
    @GetMapping("/forums")
    public String forumListing() {
        List<Map<String, Object>> result =  formsDAO.listAllQuestions();
        
    }
}
