package yangpu;//自己修改包

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import u.frame.common.Page;
import u.frame.common.Result;

/**
 * @Controller<br>
 * @className：NewerYield<br> 
 * @auto-generated<br>
 */
@Controller
@RequestMapping("/companyInfoRf")
public class NewerYieldCtrRestful {

	private static final Logger log = LogManager.getLogger(NewerYieldCtr.class.getName());
	
	@Autowired
	private NewerYieldSer newerYieldSer;
	
	/**
	 * @insert
	 * @Describtion：新增NewerYield<br>
	 * @auto-generated<br>
	 */
	@RequestMapping(value = "/newerYield", method = RequestMethod.POST)
	@ResponseBody
	public Result<NewerYield> post(@RequestBody NewerYield newerYield, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Result<NewerYield> result = new Result<>();
		newerYieldSer.insert(newerYield);
		result.setData(newerYield);
		return result;
	}

	/**
	 * @delete
	 * @Describtion：根据Id删除<br>
	 * @auto-generated<br>
	 */
	@RequestMapping(value = "/newerYield/{Id}", method = RequestMethod.DELETE)
	@ResponseBody
	public Result<String> delete(@PathVariable("Id") String newerYieldId, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Result<String> result = new Result<String>();
		newerYieldSer.deleteById(newerYieldId);
		return result;
	}

	/**
	 * @select
	 * @Describtion：根据Id查询<br>
	 * @auto-generated<br>
	 */
	@RequestMapping(value = "/newerYield/{Id}", method = RequestMethod.GET)
	@ResponseBody
	public Result<NewerYield> get(@PathVariable("Id") String newerYieldId, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Result<NewerYield> result = new Result<NewerYield>();
		result.setData(newerYieldSer.getById(newerYieldId));
		return result;
	}

	/**
	 * @update
	 * @Describtion：根据Id更新NewerYield<br>
	 * @auto-generated<br>
	 */
	@RequestMapping(value = "/newerYield/{Id}", method = RequestMethod.PUT)
	@ResponseBody
	public Result<NewerYield> put(@PathVariable("Id") String newerYieldId,
			@RequestBody NewerYield newerYield, HttpServletRequest request, HttpServletResponse response)
					throws Exception {
		Result<NewerYield> result = new Result<NewerYield>();
		newerYieldSer.update(newerYield);
		result.setData(newerYield);
		return result;
	}

	/**
	 * @select
	 * @Describtion：根据NewerYield查询list<br>
	 * @auto-generated<br>
	 */
	@RequestMapping(value = "/newerYield/list", method = RequestMethod.POST)
	@ResponseBody
	public Result<List<NewerYield>> selectByMoreInfo(@RequestBody NewerYield newerYield,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		Result<List<NewerYield>> result = new Result<List<NewerYield>>();
		result.setData(newerYieldSer.getList(newerYield));
		return result;
	}
	
	/**
	 * @select
	 * @Describtion：根据NewerYield查询page<br>
	 * @auto-generated<br>
	 */
	@RequestMapping(value = "/newerYield/page", method = RequestMethod.POST)
	@ResponseBody
	public Result<Page> page(@RequestBody NewerYield newerYield, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Result<Page> result = new Result<Page>();
		result.setData(newerYieldSer.getPage(newerYield));
		return result;
	}

	/**
	 * @delete
	 * @Describtion：根据NewerYield删除<br>
	 * @auto-generated<br>
	 */
	@RequestMapping(value = "/newerYield", method = RequestMethod.DELETE)
	@ResponseBody
	public Result<NewerYield> deleteByEntity(@RequestBody NewerYield newerYield, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Result<NewerYield> result = new Result<NewerYield>();
		newerYieldSer.deleteByEntity(newerYield);
		return result;
	}

}
