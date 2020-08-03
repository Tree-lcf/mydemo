package com.tree.mydemo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = "classpath:pay.properties")
public class DemoConfig {

    @Value("${appid}")
    private String appid;

    @Value("${appsec}")
    private String appsec;

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getAppsec() {
        return appsec;
    }

    public void setAppsec(String appsec) {
        this.appsec = appsec;
    }
}
