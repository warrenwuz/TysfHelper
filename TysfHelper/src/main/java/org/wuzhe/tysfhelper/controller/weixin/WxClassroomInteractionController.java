package org.wuzhe.tysfhelper.controller.weixin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("wx")
public class WxClassroomInteractionController {
	@RequestMapping("doClassroomInteraction.do")
   public ModelAndView doClassroomInteraction(){
	   ModelAndView mv=new ModelAndView();
	   mv.setViewName("student/doClassroomInteraction");
	         return mv;
   }
}
