package com.cs6083.nanoneck.forums.Controller;

import com.cs6083.nanoneck.forums.DAO.formsDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;

@Controller
public class forumController {
    @Autowired
    private formsDAO formsDAO;

    @GetMapping("/forums")
    public String forumListing(Model model) {
        List<Map<String, Object>> result =  formsDAO.listAllQuestions();
        model.addAttribute("questions",result);
    return "views/forums/forums";
    }
    @GetMapping("/csForums")
    public String csForums(Model model){
        return "views/forums/csForums";
    }

    @GetMapping("/artForums")
    public String artForums(Model Model){
        return "views/forums/artFourms";
    }
    @GetMapping("/algorithm")
    public String algorithm(Model model){
        return "views/forums/algorithm";
    }
    @GetMapping("/databaseDesign")
    public String dbDesign(Model model){
        return "views/forums/databaseDesign";
    }
    @GetMapping("/programmingLanguage")
    public String programmingLanguage(Model model){
        return "views/forums/programmingLanguage";
    }
    @GetMapping("/normalForums")
    public String normalForums(Model model){
        List<Map<String, Object>> result =  formsDAO.listAllQuestions();
        model.addAttribute("questions",result);
        return "views/forums/normalForums";
    }
}
