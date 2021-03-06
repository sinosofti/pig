package com.github.pig.auth.feign.fallback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.github.pig.auth.feign.UserService;
import com.github.pig.common.vo.UserVO;
import com.github.pig.common.vo.UserView;

/**
 * @ClassName: UserServiceFallbackImpl
 * @Description: TODO(用户服务的fallback)
 * @author dfd
 * @date 2018年11月22日 上午11:38:52
 */
@Service
public class UserServiceFallbackImpl implements UserService {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public UserView findUserByUsername(String username) {
		logger.error("调用{}异常:{}", "findUserByUsername", username);
		return null;
	}

	/**
	 * 通过手机号查询用户、角色信息
	 *
	 * @param mobile
	 *            手机号
	 * @return UserVo
	 */
	@Override
	public UserVO findUserByMobile(String mobile) {
		logger.error("调用{}异常:{}", "通过手机号查询用户", mobile);
		return null;
	}

	/**
	 * 根据OpenId查询用户信息
	 *
	 * @param openId
	 *            openId
	 * @return UserVo
	 */
	@Override
	public UserVO findUserByOpenId(String openId) {
		logger.error("调用{}异常:{}", "通过OpenId查询用户", openId);
		return null;
	}

	@Override
	public UserView findUserViewByMobile(String mobile) {
		logger.error("调用{}异常:{}", "findUserViewByMobile", mobile);
		return null;
	}
}
