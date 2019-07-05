package u.frame.web.demotra.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import u.frame.common.CommonSer;
import u.frame.common.Page;

/**
 * <br>
 * @Service<br>
 * @className：NewerYieldSer<br> 
 * @auto-generated<br>
 */
@Service
public class NewerYieldSer extends BaseManager<NewerYield,String>{

	private static final Logger log = LogManager.getLogger(NewerYieldSer.class.getName());
	
	@Autowired
	private NewerYieldDao newerYieldDao;
	
	@Override
	public NewerYieldDao getEntityMapper(){
    	return newerYieldDao;
    }
    
    public Page pageQuery(NewerYield newerYield) {
		return pageQuery(newerYieldDao, newerYield, NewerYieldDao.class.getName());
	}
	
}
