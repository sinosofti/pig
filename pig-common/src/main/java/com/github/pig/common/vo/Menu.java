package com.github.pig.common.vo;


/**
 * @ClassName: Menu
 * @Description: 首页左侧导航菜单属性
 * @author: Administrator
 * @date: 2015年5月21日 下午1:58:05
 * @version: V1.0
 */
public class Menu implements java.io.Serializable {
	private static final long serialVersionUID = -2602837632490955195L;

	private String id; // 主键，对应perm_sysfunc表funccode
	private String text;// 名称，对应perm_sysfunc表FUNCNAME
	private String pid;// 父级id， 对应perm_sysfunc表PARENTID
	private String iconCls;// 图标名称，对应perm_sysfunc表LEFTIMG
	private String iconPosition;// 图标布局方式，对应perm_sysfunc表LEFTIMG_POSITION
	private String url;// 链接地址， 对应perm_sysfunc表url
	private String istarget;// 是否在新窗口中打开， 对应perm_sysfunc表ISTARGET

	public String getIconPosition() {
		return iconPosition;
	}

	public void setIconPosition(String iconPosition) {
		this.iconPosition = iconPosition;
	}

	public String getIstarget() {
		return istarget;
	}

	public void setIstarget(String istarget) {
		this.istarget = istarget;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getIconCls() {
		return iconCls;
	}

	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
