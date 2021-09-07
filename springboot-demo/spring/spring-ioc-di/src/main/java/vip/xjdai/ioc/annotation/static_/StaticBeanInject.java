package vip.xjdai.ioc.annotation.static_;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/myPath")
public class StaticBeanInject {

	@Autowired
	private MongoFileOperationUtil mongoFileOperationUtil;

	@RequestMapping(value = "/test.json", method = RequestMethod.GET)
	@ResponseBody
	public void test() {
		System.out.println(mongoFileOperationUtil.getDsForRW());

	}
}
