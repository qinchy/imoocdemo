package com.qinchy.imoocdemo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.io.Serializable;

//@ConfigurationProperties(prefix = "wechat")
@Configuration
@Component
public class WechatConfig implements Serializable{

    @Value("${wechat.url}")
    private String url;

    @Value("${wechat.token}")
    private String token;

    @Value("${wechat.encodingaeskey}")
    private String encodingaeskey;

    @Value("${wechat.appid}")
    private String appid;

    @Value("${wechat.appsecret}")
    private String appsecret;

    @Value("${wechat.accessToken.server.class}")
    private String accessTokenServerClass;

    @Value("${wechat.ticket.jsapi.server.class}")
    private String ticketJsapiServerClass;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getEncodingaeskey() {
        return encodingaeskey;
    }

    public void setEncodingaeskey(String encodingaeskey) {
        this.encodingaeskey = encodingaeskey;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getAppsecret() {
        return appsecret;
    }

    public void setAppsecret(String appsecret) {
        this.appsecret = appsecret;
    }

    public String getAccessTokenServerClass() {
        return accessTokenServerClass;
    }

    public void setAccessTokenServerClass(String accessTokenServerClass) {
        this.accessTokenServerClass = accessTokenServerClass;
    }

    public String getTicketJsapiServerClass() {
        return ticketJsapiServerClass;
    }

    public void setTicketJsapiServerClass(String ticketJsapiServerClass) {
        this.ticketJsapiServerClass = ticketJsapiServerClass;
    }
}
