package com.takata.login;

import com.takata.system.menu.service.SystemMenuService;
import com.takata.system.user.domain.SystemUser;
import com.takata.system.user.service.SystemUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lzf
 **/
@Slf4j
@Controller
public class LoginController {

    @Resource(name = "systemUserService")
    private SystemUserService systemUserService;

    @Resource(name = "systemMenuService")
    private SystemMenuService systemMenuService;

    /**
     * 获取登录页面
     * @return 返回登录页面
     */
    @RequestMapping("/login.do")
    public String login(){
        return "login/login";
    }

    /**
     * 登录认证（第三方）
     * @param request 请求参数
     * @return 返回结果
     */
    @RequestMapping("/loginAuthenticate.do")
    @ResponseBody
    public Object loginAuthenticate(HttpServletRequest request){
        Map<String, Object> map = new HashMap<String, Object>(2);
        try {
            String userCode = request.getParameter("userName");
            String password = request.getParameter("password");
            SystemUser systemUser = new SystemUser();
            systemUser.setUserCode(userCode);
            boolean isExist = this.systemUserService.checkUserCode(systemUser);
            if(isExist){
                try {
                    Subject currentUser = SecurityUtils.getSubject();
                    UsernamePasswordToken token = new UsernamePasswordToken(userCode, password);
                    currentUser.login(token);
                    map.put("loginState", "success");
                }catch (Exception e){
                    log.error(e.getMessage());
                    map.put("loginState", "WrongPassword");
                }
            }else {
                map.put("loginState", "UnknowUser");
            }
        }catch (Exception e){
            log.error(e.getMessage());
            map.put("loginState", "error");
        }
        return map;
    }

    /**
     * 退出登录
     * @return 返回登录页面
     */
    @RequestMapping("/loginOut.do")
    public Object loginOut(){
        Subject currentUser = SecurityUtils.getSubject();
        currentUser.logout();
        return "login/login";
    }

    /**
     * 获取主页面
     * @return 返回主页面
     */
    @RequestMapping("/main.do")
    public String getMainframeDialog(){
        return "mainframe/mainframe";
    }

}
