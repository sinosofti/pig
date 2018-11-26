package com.github.pig.admin.model.entity;

import java.sql.Blob;
import java.util.Date;

import org.springframework.data.annotation.Id;

import com.baomidou.mybatisplus.annotations.TableName;

import lombok.Data;

/**
 * 用户管理 - 实体类.
 * 
 * @author liufangwei@sinosoft.com.cn
 * @date: 2015年7月9日 下午2:25:06
 * @version V1.0
 */
@Data
@TableName("PERM_USERS")
public class UserView implements java.io.Serializable, Cloneable {

    // serialVersionUID.
    private static final long serialVersionUID = -5402045472458189965L;

    // varchar2(50) 主键.
    @Id
    private String id;

    // varchar2(50) 用户名（唯一索引）.
    private String username;

    // varchar2(50) 密码（md5加密）.
    private String password;

    // varchar2(4000) 角色id，多个之间以,号分隔.
    private String role;

    // varchar2(50) 姓名.
    private String name;

    // varchar2(50) 手机（唯一索引）.
    private String telephone;

    // varchar2(50) 电子邮箱（唯一索引）.
    private String email;

    // 电子签名.
    private Blob photo;

    // 头像.
    private Blob head;

    // varchar2(50) 机构id.
    private String orgcode;

    // varchar2(50) 地区id.
    private String zonecode;

    // date sysdate 注册时间.
    private Date addtime;

    // varchar2(1) 1 状态：1有效 0无效.
    private String state;

    // date sysdate 修改时间.
    private Date modytime;

    // 证书编号.
    private String key;

    // 操作级别 3科室级 2机构级 1地区级.
    private String zb;

    // 数据交换使用 省市配置.
    private String dataSource;

    // VARCHAR2(20) Y 科室.
    private String department;

    // VARCHAR2(50) Y 添加科室.
    private String addDepartment;

    // VARCHAR2(50) Y 修改科室.
    private String modyDepartment;

    // VARCHAR2(20) Y 录入人机构.
    private String addOrg;

    // VARCHAR2(50) Y 修改人.
    private String modyUser;

    // VARCHAR2(20) Y 修改人机构.
    private String modyOrg;

    // VARCHAR2(50) Y 录入人.
    private String addUser;

    // 职务.
    private String position;

    // 职称.
    private String title;

    // 关联的职工表主键.
    private String linkedId;

    // 分管科室，多个之间以逗号分隔.
    private String lineDep;
    
}
