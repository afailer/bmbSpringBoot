package com.tjwq.bmb.intercepters;

import com.google.gson.Gson;
import com.tjwq.bmb.utils.JsonData;
import com.tjwq.bmb.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class TokenIntercepter implements HandlerInterceptor {

    private static Gson gson = new Gson();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        if(token == null){
            token = request.getParameter("token");
        }
        if(token != null){
            Claims claims = JwtUtils.checkJWT(token);
            if(claims != null){
                Integer userId =(Integer) claims.get("id");
                String name = (String) claims.get("name");
                System.out.println(userId+" "+name);
                request.setAttribute("user_id", userId);
                request.setAttribute("name", name);
                return true;
            }else{
                sendJsonMessage(response, JsonData.buildTokenError("token已过期"));
                return false;
            }
        }
        sendJsonMessage(response, JsonData.buildError("请登陆"));
        return false;
    }

    public static void sendJsonMessage(HttpServletResponse response, Object obj) throws Exception{
        response.setContentType("application/json; charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.print(gson.toJson(obj));
        writer.close();
        response.flushBuffer();
    }
}
