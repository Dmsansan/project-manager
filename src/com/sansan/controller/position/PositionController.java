package com.sansan.controller.position;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sansan.dao.Position;
import com.sansan.service.PositionService;




/**
 * 职位管理控制类
 * @author Sisansan
 * @date 2018-05-11
 */
@Controller
@RequestMapping("/position")
public class PositionController {
	//日志
	private static final Logger log = Logger.getLogger(Position.class);
	
	//职位接口
	@Autowired
	private  PositionService positionSrv;
	/**
	 * 获取职位信息控制器
	 * @param request
	 * @param model
	 * @return positionID,name
	 */
	@RequestMapping("/getAllPosition")
	public @ResponseBody Object getAllPositon(HttpServletRequest request, Model model){
		try{
			List<Position> positions = positionSrv.getAllPosition();
			
			model.addAttribute("data", positions);
			model.addAttribute("code", 1);
			return model;
		}catch(Exception e){
			log.info(e);
			model.addAttribute("msg", "service error!");
			model.addAttribute("code", 0);
		}
		return model;
	}
}

