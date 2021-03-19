package com.stone.demo.author.mango.controller;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import com.stone.demo.author.mango.bean.po.SysUser;
import com.stone.demo.author.mango.bean.vo.HttpResult;
import com.stone.demo.author.mango.bean.vo.LoginBean;
import com.stone.demo.author.mango.security.JwtAuthenticationToken;
import com.stone.demo.author.mango.serivce.SysUserService;
import com.stone.demo.author.mango.utils.PasswordUtils;
import com.stone.demo.author.mango.utils.SecurityUtils;
import com.stone.demo.author.common.utils.IOUtils;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/***
 *
 * @Class SysLoginController
 * @Descrip 登入验证码
 * @author Stone
 * @data 21-1-24  上午12:11
 * @Version 1.0
 */

@Api(tags = "登入验证码")
@RestController
public class SysLoginController {

    @Autowired
    private Producer producer;

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/captcha.jpg")
    public void captcha(HttpServletResponse response, HttpServletRequest request) throws IOException {
        response.setHeader("Cache-Controller", "no-store, no-cache");
        response.setContentType("image/jpeg");
        //生成文字验证码
        String text = producer.createText();
        //生成图片验证码
        BufferedImage image = producer.createImage(text);
        //保存验证码到 Session
        request.getSession().setAttribute(Constants.KAPTCHA_SESSION_KEY, text);
        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(image, "jpg", out);
        IOUtils.closeQuietly(out);

    }

    @PostMapping("/login")
    public HttpResult login(@RequestBody LoginBean loginBean, HttpServletRequest request) throws IOException {
        String username = loginBean.getAccount();
        String password = loginBean.getPassword();
        String captcha = loginBean.getCaptcha();
        //从 session 中获取保存的验证码，跟前台传来的验证码进行匹配
        Object kaptcha = request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
        if (kaptcha == null) {
            return HttpResult.error("验证码失效");
        }

        if (!captcha.equals(kaptcha)) {
            return HttpResult.error("验证码不正确");
        }

        SysUser user = sysUserService.findByName(username);

        if (user == null) {
            return HttpResult.error("账号不存在");
        }

        if(!PasswordUtils.matches(user.getSalt(), password, user.getPassword())) {
            return HttpResult.error("密码不正确");
        }
        if(user.getStatus() == 0) {
            return HttpResult.error("账号已经被锁定,请联系管理员");
        }

        JwtAuthenticationToken token = SecurityUtils.login(request, username, password, authenticationManager);
        return HttpResult.ok(token);
    }
}
