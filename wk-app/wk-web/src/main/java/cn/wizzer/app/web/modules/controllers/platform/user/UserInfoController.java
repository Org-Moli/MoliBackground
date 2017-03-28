package cn.wizzer.app.web.modules.controllers.platform.user;

import cn.wizzer.app.user.modules.models.User_Info;
import cn.wizzer.app.user.modules.services.UserInfoService;
import cn.wizzer.app.web.commons.slog.annotation.SLog;
import cn.wizzer.framework.base.Result;
import cn.wizzer.framework.page.datatable.DataTableColumn;
import cn.wizzer.framework.page.datatable.DataTableOrder;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.nutz.dao.Cnd;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.lang.Strings;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.nutz.mvc.adaptor.WhaleAdaptor;
import org.nutz.mvc.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@IocBean
@At("/platform/user/info")
public class UserInfoController {
	private static final Log log = Logs.get();
	@Inject
	private UserInfoService userInfoService;

    @At
    @Ok("json:full")
    @RequiresAuthentication
    public Object data(@Param("length") int length, @Param("start") int start, @Param("draw") int draw, @Param("::order") List<DataTableOrder> order, @Param("::columns") List<DataTableColumn> columns) {
        Cnd cnd = Cnd.NEW();
        cnd.and("userStatus","=","1");
        return userInfoService.data(length, start, draw, order, columns, cnd, null);
    }

    @At("/audit")
    @Ok("beetl:/platform/user/info/audit.html")
    @RequiresAuthentication
    public void audit() {

    }

    @At
    @Ok("json:full")
    @RequiresAuthentication
    public Object auditData(@Param("length") int length, @Param("start") int start, @Param("draw") int draw, @Param("::order") List<DataTableOrder> order, @Param("::columns") List<DataTableColumn> columns) {
        Cnd cnd = Cnd.NEW();
        cnd.and("userStatus","=","0");
        return userInfoService.data(length, start, draw, order, columns, cnd, null);
    }

	@At("")
	@Ok("beetl:/platform/user/info/index.html")
	@RequiresAuthentication
	public void index() {

	}

    @At
    @Ok("beetl:/platform/user/info/add.html")
    @RequiresPermissions("user.manager.driver.add")
    @RequiresAuthentication()
    public void add() {
    }

    @At
    @Ok("json")
    @SLog(tag = "新建司机工号[${args[0].jobNumber}]", msg = "")
    @AdaptBy(type = WhaleAdaptor.class)
    public Object addDo(@Param("..") User_Info userInfo, HttpServletRequest req) {
		try {
            userInfo.setUploadTime(new Date());
            userInfo.setBalance(0.00);
            userInfo.setUserStatus(1);
			userInfoService.insert(userInfo);
            String jobNumber = "DR" + String.format("%6d", userInfo.getId()).replace(" ", "0");
            userInfo.setJobNumber(jobNumber);
            userInfoService.updateIgnoreNull(userInfo);
			return Result.success("system.success");
		} catch (Exception e) {
            e.printStackTrace();
			return Result.error("system.error");
		}
    }

    @At("/edit/?")
    @Ok("beetl:/platform/user/info/edit.html")
    @RequiresAuthentication
    public Object edit(Integer id) {
		return userInfoService.fetch(id);
    }

    @At
    @Ok("json")
    @SLog(tag = "修改User_Info", msg = "ID:${args[0].id}")
    @AdaptBy(type = WhaleAdaptor.class)
    public Object editDo(@Param("..") User_Info userInfo, HttpServletRequest req) {
		try {
			userInfoService.updateIgnoreNull(userInfo);
			return Result.success("system.success");
		} catch (Exception e) {
			return Result.error("system.error");
		}
    }


    @At({"/delete","/delete/?"})
    @Ok("json")
    @SLog(tag = "删除User_Info", msg = "ID:${args[2].getAttribute('id')}")
    public Object delete(Integer id, @Param("ids") String[] ids ,HttpServletRequest req) {
		try {
			if(ids!=null&&ids.length>0){
				userInfoService.delete(ids);
    			req.setAttribute("id", org.apache.shiro.util.StringUtils.toString(ids));
			}else{
				userInfoService.deleteUserById(id);
    			req.setAttribute("id", id);
			}
			return Result.success("system.success");
		} catch (Exception e) {
			return Result.error("system.error");
		}
    }


    @At("/detail/?")
    @Ok("beetl:/platform/user/info/detail.html")
    @RequiresAuthentication
	public Object detail(Integer id) {
		if (id != null) {
			return userInfoService.findById(id);
		}
		return null;
    }

    @At("/password/?")
    @Ok("beetl:/platform/user/info/password.html")
    @RequiresAuthentication
    public Object password(Integer id) {
        if (id != null) {
            return userInfoService.findById(id);
        }
        return null;
    }

    @At("/retPsd")
    @Ok("json")
    @SLog(tag = "修改密码User_Info", msg = "ID:${args[0]}")
    public Object retPsd(@Param("id") String id ,@Param("password")String password ,HttpServletRequest req) {
        try {
            if(StringUtils.isNotBlank(id))
            {
                User_Info user_info = userInfoService.fetch(Integer.valueOf(id));
                if(user_info == null)
                {
                    return Result.error("system.error");
                }
                user_info.setPassword(password);
                userInfoService.updateIgnoreNull(user_info);
            }
            else
            {
                return Result.error("system.error");
            }
            return Result.success("system.success");
        } catch (Exception e) {
            return Result.error("system.error");
        }
    }

    @At("/work/?")
    @Ok("json")
    @SLog(tag = "操作司机", msg = "ID:${args[0]};userStatus:${args[1]};workStatus:${args[2]}")
    public Object work(Integer id ,@Param("userStatus")Integer userStatus ,@Param("workStatus")Integer workStatus, HttpServletRequest req) {
        try {
            if(id != null)
            {
                User_Info user_info = userInfoService.fetch(id);
                if(user_info == null)
                {
                    return Result.error("system.error");
                }
                if(userStatus != null)
                {
                    user_info.setUserStatus(userStatus);
                }
                if(workStatus != null)
                {
                    user_info.setWorkStatus(workStatus);
                }
                userInfoService.updateIgnoreNull(user_info);
            }
            else
            {
                return Result.error("system.error");
            }
            return Result.success("system.success");
        } catch (Exception e) {
            return Result.error("system.error");
        }
    }

    @At("/pay/?")
    @Ok("beetl:/platform/user/info/pay.html")
    @RequiresAuthentication
    public Object pay(Integer id) {
        if (id != null) {
            return userInfoService.findById(id);
        }
        return null;
    }

    @At("/balance")
    @Ok("json")
    @SLog(tag = "充值User_Info", msg = "ID:args[0],金额:${args[1]}")
    public Object balance(@Param("id") String id ,@Param("balance")Double balance ,@Param("remark") String remark,HttpServletRequest req) {
        try {
            if(StringUtils.isNotBlank(id))
            {
                User_Info user_info = userInfoService.fetch(Integer.valueOf(id));
                if(user_info == null)
                {
                    return Result.error("system.error");
                }
                Double oldBalance = user_info.getBalance();
                user_info.setBalance(oldBalance + balance);
                if(StringUtils.isNotBlank(remark))
                {
                    user_info.setRemark(remark);
                }
                userInfoService.updateIgnoreNull(user_info);
            }
            else
            {
                return Result.error("system.error");
            }
            return Result.success("system.success");
        } catch (Exception e) {
            return Result.error("system.error");
        }
    }

    @At("/free/?")
    @Ok("json:full")
    @RequiresAuthentication
    public Object data(Integer sysUnitId) {
        return userInfoService.listUserInfoBySysUnitId(sysUnitId);
    }
}