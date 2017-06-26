package com.choa.home;

import java.util.List;

import javax.inject.Inject;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.choa.memo.MemoDTO;
import com.choa.memo.MemoService;
import com.choa.util.ListInfo;

@Controller
@RequestMapping("/memo/**")
public class MemoController {

	@Inject
	private MemoService memoService;
	
	@RequestMapping(value="memoList")
	public void memoList(){
		
	}
	
	
	// LIST NORMAL
	
/*	@RequestMapping(value="getMemoList")
	public String getMemoList(Model model, ListInfo listInfo){
		
		List<MemoDTO> ar = memoService.list(listInfo);
		
		model.addAttribute("list", ar);
		
		return "memo/getMemoList";
	}*/
	
	
	// LIST JSON -----------------------------------------------------------------
	
/*	@RequestMapping(value="getMemoList")
	public void getMemoList(Model model, ListInfo listInfo){
		
		List<MemoDTO> ar = memoService.list(listInfo);
		JSONArray jar = new JSONArray();
		
		for(MemoDTO m:ar){
			JSONObject json = new JSONObject();
			json.put("num", m.getNum()+"");
			json.put("writer", m.getWriter());
			json.put("contents", m.getContents());
			json.put("date", m.getReg_date().toString());
			jar.add(json);
		}
		
		
		model.addAttribute("list", jar.toJSONString());
		
	}*/

	
	//LIST JACKSON---------------------------------------------------------------
	
	@RequestMapping(value="getMemoList")
	@ResponseBody //요청한 페이지로 결과를 바로 보내기
	public List<MemoDTO> getMemoList(Model model, ListInfo listInfo){
		
		return memoService.list(listInfo);
	}
	
	
	

	
	//첫번째 방법-----------------------------------------------------------------
/*	@RequestMapping(value="memoWrite" , method=RequestMethod.POST)
	public ModelAndView memoWrite(MemoDTO memoDTO) throws Exception{
		
		int result = memoService.write(memoDTO);
		
		String message = "FAIL";
		if(result>0){
			message = "SECCESS";
		}
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("common/ajaxResult");
		mv.addObject("message", message);
		
		return mv;
	}*/
	
	
	//2번째 방법 -----------------------------------------------------------------
/*	@RequestMapping(value="memoWrite" , method=RequestMethod.POST)
	public ModelAndView memoWrite(MemoDTO memoDTO) throws Exception{
		
		int result = memoService.write(memoDTO);
		
		ListInfo listInfo = new ListInfo();
		listInfo.setCurPage(1);
		
		List<MemoDTO> ar = memoService.list(listInfo);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("memo/getMemoList");
		mv.addObject("list", ar);
		
		return mv;
	}*/
	
	// WRITE JACKSON -----------------------------------------------------------------

	@RequestMapping(value="memoWrite" , method=RequestMethod.POST)
	@ResponseBody
	public List<MemoDTO> memoWrite(MemoDTO memoDTO) throws Exception{
		
		int result = memoService.write(memoDTO);
		
		ListInfo listInfo = new ListInfo();
		listInfo.setCurPage(1);
		
		return memoService.list(listInfo);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
