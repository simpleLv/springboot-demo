package com.lfs.util;

import java.lang.reflect.Field;
import java.time.LocalDateTime;

/**
 * 实体工具类
 * @author SimpleLv
 */
public class EntityUtil {


    /**
     * 插入数据库的实体设置完整属性 包括
     * 创建时间，
     * 修改时间，
     * 状态
     */

    public static void setWholeColumn(Object obj) {
        try {
            Class<?> c = obj.getClass();
            Field[] fields = c.getDeclaredFields();
            for (Field field :
                    fields) {
                if (field.getName().equals("creationDate")) {
                    field.setAccessible(true);
                    field.set(obj, LocalDateTime.now());
                }
                if (field.getName().equals("status")) {
                    field.setAccessible(true);
                    field.set(obj, 1);
                }
                if (field.getName().equals("lastUpdateDate")) {
                    field.setAccessible(true);
                    field.set(obj, LocalDateTime.now());
                }
            }
        } catch (Exception e) {

        }
    }
}
