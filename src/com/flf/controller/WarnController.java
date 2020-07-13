package com.flf.controller;

import com.alibaba.fastjson.JSON;
import com.flf.Enmu.WarnTypeEnmu;
import com.flf.entity.District;
import com.flf.entity.Warn;
import com.flf.service.MenuService;
import com.flf.service.RoleService;
import com.flf.service.WarnService;
import com.flf.vo.WarnVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping(value="/warn")
public class WarnController {
	
	@Autowired
	private WarnService warnService;

	@RequestMapping
	public ModelAndView list(Warn warn,HttpSession session){
		List<Warn> warnList = warnService.listPageWarn(warn);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("warn/warns");
		mv.addObject("warnList", warnList);
		mv.addObject("warn", warn);
		return mv;
	}
	

	@RequestMapping(value="/updateWarn")
	public ModelAndView update(Warn warn){
		ModelAndView mv = new ModelAndView();
		warn.setDealTime(new Date());
		warnService.updateWarn(warn);
		mv.setViewName("warn/save_result");
		return mv;
	}
    @RequestMapping(value="/dashboard")
    public ModelAndView dashboard(Warn warn){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("warn/dashboard");
        return mv;
    }

    @ResponseBody
	@RequestMapping(value="/dome")
	public String dome(){
		List<WarnVo> warnVos = new ArrayList<>();
		List<Map<String, Object>> list = WarnTypeEnmu.selectAll();
		for (Map<String, Object> map : list) {
			int level = (int) map.get("value");
			List<Integer> data = warnService.selectWarnByLevel(level);
			WarnVo warnVo = new WarnVo();
			WarnTypeEnmu byValue = WarnTypeEnmu.findByValue(level);
			warnVo.setName(byValue.getTitle());
			warnVo.setColor(byValue.getColourNumber());
			warnVo.setData(data);
			warnVo.setType("bar");
			warnVos.add(warnVo);
		}

		return JSON.toJSONString(warnVos);
	}

	@ResponseBody
	@RequestMapping(value="/dome1")
	public String dome1(){
		List<District> listD = warnService.listWarnDistrict();
		List<Map<String, String>> list = new ArrayList<Map<String, String>>() ;
		for (District district : listD) {
			Map<String, String> map= new HashMap<>();
			map.put("name",district.getDistrict());
			map.put("value",district.getWarnCount().toString());
			list.add(map);
		}
		return JSON.toJSONString(list);
	}

	@InitBinder
	public void initBinder(WebDataBinder binder){
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(format,true));
	}

}
