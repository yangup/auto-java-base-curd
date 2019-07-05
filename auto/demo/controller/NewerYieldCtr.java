package u.frame.web.demotra.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import u.frame.common.CommonCtr;
import u.frame.common.Page;
import u.frame.common.Result;


/**
 * <br>
 * @Controller<br>
 * @className：NewerYieldCtr<br> 
 * @auto-generated<br>
 */
@Controller
@RequestMapping("/newerYield")
public class NewerYieldCtr extends BaseRestSpringController {

	private static final Logger log = LogManager.getLogger(NewerYieldCtr.class.getName());
	
	@Autowired
	private NewerYieldSer newerYieldSer;

	/**
	 * @Describtion：根据Id查询<br>
	 * @auto-generated<br>
	 */
	@RequestMapping("/getById")
	@ResponseBody
	public ReturnEntity<NewerYield> getById(@RequestBody NewerYield newerYield, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ReturnEntity<NewerYield> result = new ReturnEntity<NewerYield>();
		// result.setData(newerYieldSer.getById(newerYield.getNewerYieldId()));
		return result;
	}

	/**
	 * @Describtion：根据entity查询返回list<br>
	 * @auto-generated<br>
	 */
	@RequestMapping("/list")
	@ResponseBody
	public ReturnEntity<List<NewerYield>> list(@RequestBody NewerYield newerYield, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ReturnEntity<List<NewerYield>> result = new ReturnEntity<List<NewerYield>>();
		// result.setData(newerYieldSer.getList(newerYield));
		return result;
	}
	
	/**
	 * @Describtion：根据entity查询返回page,分页数据<br>
	 * @auto-generated<br>
	 */
	@RequestMapping("/page")
	@ResponseBody
	public ReturnEntity<Page> page(@RequestBody NewerYield newerYield, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ReturnEntity<Page> result = new ReturnEntity<Page>();
		// result.setData(newerYieldSer.pageQuery(newerYield));
		return result;
	}

}
