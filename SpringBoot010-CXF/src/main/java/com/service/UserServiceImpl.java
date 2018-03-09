package com.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jws.WebService;

import com.domain.User;
import com.domain.Users;

@WebService(name = "usersService", // 暴露服务名称
		targetNamespace = "http://service.com/", // 命名空间,一般是接口的包名倒序
		endpointInterface = "com.service.UserService") // 接口地址
public class UserServiceImpl implements UserService {

	private Map<String, User> userMap = new HashMap<String, User>();

	public UserServiceImpl() {
		System.out.println("向实体类插入数据");
		User user = new User();
		user.setUserId("411001");
		user.setUsername("zhansan");
		user.setAge("20");
		user.setUpdateTime(new Date());
		userMap.put(user.getUserId(), user);

		user = new User();
		user.setUserId("411002");
		user.setUsername("lisi");
		user.setAge("30");
		user.setUpdateTime(new Date());
		userMap.put(user.getUserId(), user);

		user = new User();
		user.setUserId("411003");
		user.setUsername("wangwu");
		user.setAge("40");
		user.setUpdateTime(new Date());
		userMap.put(user.getUserId(), user);
	}

	@Override
	public String getName(String userId) {
		return "liyd-" + userId;
	}

	@Override
	public Users getAllUser() {
		System.out.println("userMap是:" + userMap);
		List<User> userList = new ArrayList<User>(userMap.values());
		Users users = new Users();
		users.setUsers(userList);
		return users;
	}

}
