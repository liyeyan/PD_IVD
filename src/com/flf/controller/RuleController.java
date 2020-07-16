package com.flf.controller;
import com.alibaba.fastjson.JSON;
import com.flf.entity.TbRule;
import com.flf.entity.User;
import com.flf.entity.District;
import com.flf.service.RuleService;
import com.flf.service.SampleService;
import com.flf.util.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Controller
@RequestMapping(value="/rule")
public class RuleController {
	
	@Autowired
	private  RuleService ruleService;
	@Autowired
	private SampleService sampleService;
	
	/**
	 * 显示批次列表
	 * @return
	 */
	@RequestMapping
	public ModelAndView list(HttpSession session,HttpServletRequest request,TbRule rule){
		List<TbRule> list = ruleService.listPageRule(rule);

		ModelAndView mv = new ModelAndView();
		mv.setViewName("rule/batchs");
		mv.addObject("list", list);
		mv.addObject("rule", rule);
		return mv;
	}
	

	@RequestMapping(value="/add")
	public String toAdd(Model model){
		return "rule/info";
	}
	@RequestMapping(value="/update")
	public String update(Integer id,Model model){
		TbRule rule = ruleService.getRuleById(id);
		model.addAttribute("rule",rule);
		return "rule/info";
	}


	@RequestMapping(value="/district")
	@ResponseBody
	public String district(District district,HttpServletResponse response) throws Exception{
		List<District> list = ruleService.listDistrict(district);
		// TODO 处理
		response.setContentType("application/json;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");

		String districtStr = JSON.toJSONString(list);
		response.getWriter().print(districtStr);
		return null;
	}
	//List<TbRule> list = ruleService.listPageRule(rule);
	@RequestMapping(value="/listRule")
	@ResponseBody
	public String listRule(TbRule rule,HttpServletResponse response) throws Exception{
		List<TbRule> list = ruleService.listRule(rule);
		// TODO 处理
		response.setContentType("application/json;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");

		String districtStr = JSON.toJSONString(list);
		response.getWriter().print(districtStr);
		return null;
	}

	/**
	 * 保存规则
	 */
	@RequestMapping(value="/save")
	public String save(TbRule rule,HttpSession session ) throws Exception{
		User user = (User)session.getAttribute(Const.SESSION_USER);
		rule.setCreator(user.getUsername());
		rule.setCreatTime(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		ruleService.updateRule(rule);
		return "redirect:../rule.html";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder){
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(format,true));
	}
	
}
