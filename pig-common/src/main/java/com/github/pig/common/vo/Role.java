package com.github.pig.common.vo;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/** (PERM_ROLE) **/
@Data
public class Role implements Serializable {

	private static final long serialVersionUID = 1L;

	/** 主键 (Not Null) */
	private String id;
	/** 类别名称（唯一索引） (Not Null) */
	private String name;
	/** 说明 */
	private String note;
	/** 状态：1有效 0无效 (Not Null) */
	private String state;
	/** 最后一次修改时间 */
	private Date modytime;
	/** 数据交换使用 */
	private String dataSource;
	/** 录入人 */
	private String addUser;
	/** 工作流标识 */
	private String roleKey;
	/** 系统id */
	private String sysid;
	/** 添加地区 */
	private String addZone;
	/** 添加机构 */
	private String addOrgcode;
	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + ", note=" + note + ", state=" + state + ", modytime=" + modytime
				+ ", dataSource=" + dataSource + ", addUser=" + addUser + ", roleKey=" + roleKey + ", sysid=" + sysid
				+ ", addZone=" + addZone + ", addOrgcode=" + addOrgcode + "]";
	}

}