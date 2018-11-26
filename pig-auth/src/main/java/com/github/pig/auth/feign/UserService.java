package com.github.pig.auth.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.github.pig.auth.feign.fallback.UserServiceFallbackImpl;
import com.github.pig.common.vo.UserVO;
import com.github.pig.common.vo.UserView;

/**
 * @ClassName: UserService
 * @Description: TODO feign 远程拉取数据
 * @author dfd
 * @date 2018年11月22日 上午11:39:15
 */
@FeignClient(name = "pig-upms-service", fallback = UserServiceFallbackImpl.class)
public interface UserService {
	/**
	 * 通过用户名查询用户、角色信息
	 *
	 * @param username
	 *            用户名
	 * @return UserVo
	 */
	@GetMapping("/user/findUserByUsername/{username}")
	UserView findUserByUsername(@PathVariable("username") String username);
	/**
	 * 通过手机号查询用户、角色信息
	 *
	 * @param mobile
	 *            手机号
	 * @return UserVo
	 */
	@GetMapping("/user/findUserByMobile/{mobile}")
	UserVO findUserByMobile(@PathVariable("mobile") String mobile);

	/**
	 * 通过手机号查询用户、角色信息
	 *
	 * @param mobile
	 *            手机号 （待开发）
	 * @return UserView
	 */
	@GetMapping("/user/findUserViewByMobile/{mobile}")
	UserView findUserViewByMobile(@PathVariable("mobile") String mobile);

	/**
	 * 根据OpenId查询用户信息
	 * 
	 * @param openId
	 *            openId
	 * @return UserVo
	 */
	@GetMapping("/user/findUserByOpenId/{openId}")
	UserVO findUserByOpenId(@PathVariable("openId") String openId);
}
