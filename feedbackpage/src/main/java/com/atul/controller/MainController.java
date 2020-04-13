package com.atul.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.atul.entity.Feedback;
import com.atul.entity.Queans;
import com.atul.entity.Question;
import com.atul.service.FeedbackDAOService;
import com.atul.service.QuestionDAOService;


@Controller
public class MainController {
	
	@Autowired
	FeedbackDAOService fdao;

	@Autowired
	QuestionDAOService qdao;
	
	@RequestMapping("/")
	public String home() {
		return "index.jsp";
	}

	@RequestMapping("/feedback.htm")
	public String feedback() {
		return "feedback.jsp";
	}
	
	@RequestMapping("/addFeedback")
	public String addFeedback(@ModelAttribute("feedback") Feedback feedback) {
		fdao.addFeedback(feedback);
		return "index.jsp";
	}
	
	@RequestMapping("/getFeedbacks")
	public ModelAndView getFeedbacks(){
		ModelAndView mv = new ModelAndView("feedbacks.jsp");
		mv.addObject("feedbacks", fdao.getFeedback());
		return mv;
	}
	
	@RequestMapping("/questions.htm")
	public String questions() {
		return "question.jsp";
	}
	
	@RequestMapping("/saveQuestion.htm")
	public String saveQuestion(@ModelAttribute("question") Question question) {
		qdao.saveQuestion(question);
		return "index.jsp";
	}
	
	@RequestMapping("/getQuestions")
	@ResponseBody
	public List<Question> getQuestions() {
		List<Question> questions = qdao.getTestQuestions();
		return questions;
	}
	
	@RequestMapping("/test.htm")
	public ModelAndView test() {
		ModelAndView mv = new ModelAndView("test.jsp");
		return mv;
	}
	
	@RequestMapping("/verify")
	@ResponseBody
	public String verify(@ModelAttribute("queans") Queans queans) {
		int score = qdao.verifyAnswers(queans);
		return "Your result is : "+score;
	}

}
