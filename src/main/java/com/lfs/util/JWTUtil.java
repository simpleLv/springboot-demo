

package com.lfs.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.*;


/**
 * JWT工具类
 *
 * @author SimpleLv
 */
public class JWTUtil {


    private static String SECRET_KEY = "XX#$%()(#*!()!KL<><MQLMNQNQJQK sdfkjsdrow32234545fdf>?N<:{LWPW";


    /**
     * 生成token
     *
     * @param map
     * @return
     */

    public static String getToken(Map<String, String> map) {

        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.DATE, 7);
        JWTCreator.Builder builder = JWT.create();
        map.forEach((k, v) -> {
            builder.withClaim(k, v);
        });
        String token = builder.withExpiresAt(instance.getTime())
                .sign(Algorithm.HMAC256(SECRET_KEY));


        return token;
    }


    /**
     * 验证token
     */

    public static boolean verify(String token) {
        try {
            JWT.require(Algorithm.HMAC256(SECRET_KEY)).build().verify(token);
        } catch (Exception e) {
            return false;
        }
        return true;
    }


    /**
     * 得到token中的payload信息
     *
     * @param token
     * @return
     */

    public static String getTokenInfo(String key, String token) {
        DecodedJWT verify = JWT.require(Algorithm.HMAC256(SECRET_KEY)).build().verify(token);
        String value = verify.getClaim(key).asString();
        return value;

    }


}

