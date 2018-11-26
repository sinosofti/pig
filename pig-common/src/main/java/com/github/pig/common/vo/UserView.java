package com.github.pig.common.vo;

import java.io.Serializable;
import java.sql.Blob;
import java.util.Date;
import java.util.List;

import lombok.Data;

/**
 * 
 * @ClassName: UserView
 * @Description 保存用户信息的实体，可以根据具体业务往实体中添加相应的属性
 * @author: lfwer
 * @date: 2015年3月24日 下午6:13:57
 * @version: V1.0
 */
@Data
public class UserView implements Serializable {


	/**
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	*/
	private static final long serialVersionUID = 6671164929740096708L;
	/** 主键 (Not Null) */
	private String id;
	/** 用户名字 (Not Null) */
	private String username;
	/** 密码 (Not Null) */
	private String password;
	/** 职位 (Not Null) */
	private String role;
	/** 姓名 (Not Null) */
	private String name;
	/** 电话 */
	private String telephone;
	/** 邮箱 */
	private String email;
	/** 所属机构 (Not Null) */
	private String orgcode;
	/** 所属地区 */
	private String zonecode;
	/** 添加日期 (Not Null) */
	private Date addtime;
	/** 状态 (Not Null) */
	private String state;
	/** 修改日期 (Not Null) */
	private Date modytime;
	/** key证书 */
	private String key;
	/** 1直报账号2本级账号3管理员4全军CDC */
	private String zb;
	/** 数据来源 */
	private String dataSource;
	/** 部门名称 */
	private String department;
	/** 添加科室 */
	private String addDepartment;
	/** 修改科室 */
	private String modyDepartment;
	/** 录入人机构 */
	private String addOrg;
	/** 修改人 */
	private String modyUser;
	/** 修改人机构 */
	private String modyOrg;
	/** 录入人 */
	private String addUser;
	/** 职务(改为部职别，下面的jobtitle废弃） */
	private String position;
	/** 职称(改为固话) */
	private String title;
	/** 关联的职工表主键. */
	private String linkedId;
	/** 分管科室，多个之间以逗号分隔 */
	private String lineDep;
	/** 修改数据来源 */
	private String modySource;

	/**
	 * 角色列表
	 */
	private List<Role> roleList;

	@Override
	public String toString() {
		return "UserView [id=" + id + ", username=" + username + ", password=" + password + ", role=" + role + ", name="
				+ name + ", telephone=" + telephone + ", email=" + email + ", orgcode=" + orgcode + ", zonecode="
				+ zonecode + ", addtime=" + addtime + ", state=" + state + ", modytime=" + modytime + ", key=" + key
				+ ", zb=" + zb + ", dataSource=" + dataSource + ", department=" + department + ", addDepartment="
				+ addDepartment + ", modyDepartment=" + modyDepartment + ", addOrg=" + addOrg + ", modyUser=" + modyUser
				+ ", modyOrg=" + modyOrg + ", addUser=" + addUser + ", position=" + position + ", title=" + title
				+ ", linkedId=" + linkedId + ", lineDep=" + lineDep + ", modySource=" + modySource + ", roleList="
				+ roleList + "]";
	}

}
