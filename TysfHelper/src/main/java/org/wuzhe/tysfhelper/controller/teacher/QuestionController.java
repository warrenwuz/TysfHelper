package org.wuzhe.tysfhelper.controller.teacher;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.wuzhe.tysfhelper.controller.websocket.ClassroomInteractionWebSocket;
import org.wuzhe.tysfhelper.pojo.Option;
import org.wuzhe.tysfhelper.pojo.Question;
import org.wuzhe.tysfhelper.service.IOptionService;
import org.wuzhe.tysfhelper.service.IQuestionService;
import org.wuzhe.tysfhelper.utils.GsonUtils;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Controller
@RequestMapping("/teacher")
public class QuestionController {
    @Resource
    private IQuestionService questionService;
    @Resource
    private IOptionService iOptionService;

    @RequestMapping(value = "/question/{ciid}.do", method = RequestMethod.GET)
    public String queryQuestion(@PathVariable("ciid") String ciid, Model model) {
        model.addAttribute("ciid", ciid);
        return "teacher/question";
    }

    @RequestMapping(value = "/question/{ciid}.do", method = RequestMethod.POST)
    @ResponseBody
    public String queryQuestion(@PathVariable("ciid") String ciid, @RequestParam(defaultValue = "1") Integer pageNumber
            , @RequestParam(defaultValue = "10") Integer pageSize) {
        PageHelper.startPage(pageNumber, pageSize);
        List<QuestionController> questions = questionService.findQuestionByCiid(ciid);
        PageInfo<QuestionController> page = new PageInfo<QuestionController>(questions);
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("total", page.getTotal());
        data.put("rows", page.getList());
        String question = GsonUtils.getJsonStr(data);
        return question;
    }

    @RequestMapping(value = "/addQuestion.do", method = RequestMethod.POST)
    @ResponseBody
    public String addQuestion(String questionContent, String[] questionOptions, int questionOptionIndex, String ciid) {
        Question question = new Question();
        question.setQuestionContent(questionContent);
        question.setCiid(ciid);
        questionService.addQuestion(question);
        for (int i = 0; i < questionOptions.length; i++) {
            Option option = new Option(questionOptions[i], question.getId());
            if (i == questionOptionIndex) {
                iOptionService.addOptionGetQuestionOptionId(option);//直接将主键返回到映射对象里面
                question.setCorrectOption(option);
                questionService.setCorrectOptionByQuestionId(question);//设置正确答案
            } else {
                iOptionService.addOption(option);
            }
        }

        return "success";
    }
    @RequestMapping(value = "answerQuestion.do",method = RequestMethod.POST)
    public  String answerQuestion(Long id,String studentId,Long selectOption){
        Long   correctOption=questionService.findCorrectOptionById();

        return null;
    }
}
