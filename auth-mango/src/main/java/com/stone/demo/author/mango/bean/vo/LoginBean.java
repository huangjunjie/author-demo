package com.stone.demo.author.mango.bean.vo;

/***
 *
 * @Descrip TODO
 * @author Stone
 * @data 21-1-24  下午8:14
 * @Version 1.0
 */
public class LoginBean {

    private String account;

    private String password;

    private String captcha;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }
}
