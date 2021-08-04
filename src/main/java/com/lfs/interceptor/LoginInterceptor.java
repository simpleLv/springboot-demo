package com.lfs.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.lfs.util.JWTUtil;
import com.lfs.util.ResultCode;
import com.lfs.util.ResultMsg;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;


import static com.alibaba.fastjson.serializer.SerializerFeature.WriteMapNullValue;


@Slf4j
public class LoginInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {

        ResultMsg result = new ResultMsg();
        response.setCharacterEncoding("utf-8");
        String token = request.getHeader("token");
        if (StringUtils.hasLength(token)) {
            if (JWTUtil.verify(token)) {
                String username = JWTUtil.getTokenInfo("username", token);
                if (StringUtils.hasLength(username)) {
                    return true;
                } else {
                    result.setStatus(ResultCode.UNAUTHORIZED.getStatus());
                    result.setMessage("请求失败：无法识别的token");
                    responseMessage(response, response.getWriter(), result);
                    return false;
                }
            } else {
                result.setStatus(ResultCode.UNAUTHORIZED.getStatus());
                result.setMessage("请求失败：无法识别的token");
                responseMessage(response, response.getWriter(), result);
                return false;
            }
        } else {
            result.setStatus(ResultCode.UNAUTHORIZED.getStatus());
            result.setMessage("请求失败：没有token");
            result.setErrorCode("-1");
            responseMessage(response, response.getWriter(), result);
            return false;
        }
    }

    //请求不通过，返回错误信息给客户端
    private void responseMessage(HttpServletResponse response, PrintWriter out, ResultMsg responseData) {

        response.setContentType("application/json; charset=utf-8");
        String json = JSONObject.toJSONString(responseData, WriteMapNullValue);
        if (responseData != null) {
            if (responseData.getStatus() == -1) {
                response.setStatus(401);
            }
        }
        out.print(json);
        out.flush();
        out.close();
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
    }


}
