package com.tree.mydemo.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tree.mydemo.domain.User;
import com.tree.mydemo.service.impl.UserServiceImpl;
import com.tree.mydemo.utils.JsonData;
import org.thymeleaf.util.StringUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter(urlPatterns = "/api/v1/pri/*", filterName = "loginFilter")
public class LoginFilter implements Filter {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    private void renderJson(HttpServletResponse response, String json) {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        try (PrintWriter writer = response.getWriter()) {
            writer.print(json);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

        System.out.println(1);

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

        String token = httpServletRequest.getHeader("token");
//        if (StringUtils.isEmpty(token)){
//            token = httpServletRequest.getParameter("token");
//        }

        if (!StringUtils.isEmpty(token)) {
            User user = UserServiceImpl.sessionMap.get(token);
            if (user != null) {
                filterChain.doFilter(servletRequest, servletResponse);
            } else {
                JsonData jsonData = JsonData.buildError("token无效");
                String s = objectMapper.writeValueAsString(jsonData);
                renderJson(httpServletResponse, s);

            }


        } else {
            JsonData jsonData = JsonData.buildError("未登录");
            String s = objectMapper.writeValueAsString(jsonData);
            renderJson(httpServletResponse, s);
        }


    }

    @Override
    public void destroy() {

        System.out.println(2);

    }
}

