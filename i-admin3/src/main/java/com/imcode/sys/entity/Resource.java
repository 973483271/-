package com.imcode.sys.entity;

import java.io.Serializable;
import java.sql.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * <p>
 * 菜单管理
 * </p>
 *
 * @author jack
 * @since 2019-12-21
 */
@TableName("sys_resource")
public class Resource implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "resource_id", type = IdType.AUTO)
    private Integer resourceId;

    /**
     * 父资源ID，一级资源ID为0
     */
    private Integer parentId;

    /**
     * 资源名称
     */
    private String name;

    private String path;

    /**
     * 菜单URL
     */
    private String url;

    /**
     * 授权(多个用逗号分隔，如：user:list,user:create)
     */
    private String permission;

    /**
     * 类型  -1：根目录  0：目录   1：菜单   2：按钮
     */
    private Integer type;

    /**
     * 资源图标
     */
    private String icon;

    /**
     * 排序
     */
    private Integer orderNum;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GTM+8")
    private Date createTime;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GTM+8")
    private Date updateTime;

    public Integer getResourceId() {
        return resourceId;
    }

    public void setResourceId(Integer resourceId) {
        this.resourceId = resourceId;
    }
    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }
    public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	@Override
	public String toString() {
		return "Resource [resourceId=" + resourceId + ", parentId=" + parentId
				+ ", name=" + name + ", path=" + path + ", url=" + url
				+ ", permission=" + permission + ", type=" + type + ", icon="
				+ icon + ", orderNum=" + orderNum + ", createTime="
				+ createTime + ", updateTime=" + updateTime + "]";
	}

	
}
