package org.ecommerce.web.action;

import java.util.Date;
import java.util.List;

import org.ecommerce.entity.User;
import org.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/user")
public class UserContrller {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="list",method = RequestMethod.GET)
	public String login(Model model) {
		
		/*User user = new User();
		user.setLoginName("gyzhang");
		user.setName("gyzhang");
		user.setPassword("gyzhang");
		user.setRegisterDate(new Date());
		user.setRoles("admin_role");
		user.setSalt("salt");
		user.setPlainPassword("gyzhang");
		
		userService.save(user);
		
		User user1 = new User();
		user1.setLoginName("gyzhang");
		user1.setName("张光云");
		user1.setPassword("gyzhang");
		user1.setRegisterDate(new Date());
		user1.setRoles("admin_role");
		user1.setSalt("salt");
		user1.setPlainPassword("gyzhang");
		
		userService.save(user1);*/
		
		List<User> users = userService.getAllUser();
		PageRequest pageable = new PageRequest(0, 20, new Sort(Direction.DESC, "id"));
		Page<User> pageUsers = userService.findUserByPage(pageable);
		System.out.println(users);
		System.out.println(pageUsers.getContent());
		model.addAttribute("users", users);
		
		return "user/list";
	}
	
}
