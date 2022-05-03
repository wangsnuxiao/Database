package com.cs6083.nanoneck.forums.Controller;

import com.cs6083.nanoneck.User.pojo.User;
import com.cs6083.nanoneck.User.pojo.answer;
import com.cs6083.nanoneck.forums.DAO.formsDAO;
import com.cs6083.nanoneck.forums.DAO.formsMapper;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Map;

@Controller
public class forumController {
    @Autowired
    private formsDAO formsDAO;
    @Autowired
    private formsMapper formsMapper;

    @GetMapping("/paint")
    public  String paint(Model model){
        List<Map<String, Object>> result =  formsDAO.listPaintQuestions();
        model.addAttribute("questions",result);
        return "views/forums/normalForums";
    }
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

        List<Map<String, Object>> result =  formsDAO.listAlgorithmQuestions();
        model.addAttribute("questions",result);
        return "views/forums/normalForums";
    }
    @GetMapping("/databaseDesign")
    public String dbDesign(Model model){

        List<Map<String, Object>> result =  formsDAO.listDbDesignQuestions();
        model.addAttribute("questions",result);
        return "views/forums/normalForums";
    }
    @GetMapping("/programmingLanguage")
    public String programmingLanguage(Model model){

        List<Map<String, Object>> result =  formsDAO.listProgrammingLanguageQuestions();
        model.addAttribute("questions",result);
        return "views/forums/normalForums";
    }
    @GetMapping("/normalForums")
    public String normalForums(Model model){
        List<Map<String, Object>> result =  formsDAO.listAllQuestions();
        model.addAttribute("questions",result);
        return "views/forums/normalForums";
    }

    @GetMapping("/answerPage/{qid}")
    public String answerPage(@PathVariable("qid") int qid, Model model){
        //List<Map<String, Object>> result =  formsDAO.listCurrentAnswers(qid);
        List<answer> result = formsMapper.getAnswerByQuestionId(qid);
        model.addAttribute("answers",result);
        return "views/forums/answerPage";
    }

    @GetMapping("/forums/newpost")
    public String newPost(){
        return "views/forums/newPost";
    }
    @PostMapping("/forums/newpost")
    public String submit_newPost(String qTitle,int tid, String qBody, Model model){
        System.out.println(qTitle);
        System.out.println(tid);
        System.out.println(qBody);
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        // Inser the post into the DB
        formsMapper.insertPost(tid,user.getUid(),qTitle,qBody);
        model.addAttribute("msg","New Post submit successfully!!");
        return "views/index";
    }
}
