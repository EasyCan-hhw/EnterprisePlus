package com.jianneng.moduleapp.util;

import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.JavaType;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * json转换工具类
 * 
 * @author wangxg
 * 
 */
public class JsonUtils {
    private static ObjectMapper objectMapper;

    private static JsonUtils mJsonUtils;
    static {
    	
        objectMapper = new ObjectMapper();
        // 设置输入时忽略JSON字符串中存在而Java对象实际没有的属性
        // objectMapper
        // .getDeserializationConfig()
        // .set(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES,
        // false);
        objectMapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    }

    public static JsonUtils getIntance() {
        if (null == mJsonUtils) {
            mJsonUtils = new JsonUtils();
        }
        return mJsonUtils;
    }

    /**
     * 对象转成json
     * 
     * @param <T>
     */
    public static <T> String getJsonByObj(T t) {
        String json = null;
        try {
            json = objectMapper.writeValueAsString(t);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json;
    }

    /**
     * json转成对象
     * 
     * @param <T>
     */
    public static <T> T getObjByJson(String json, Class<T> clazz) {
        T t = null;
        try {
            t = objectMapper.readValue(json, clazz);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return t;
    }

    /**
     * JSONARRAY 转 arraylist
     * 
     * @param jsonArray
     * @return
     */
    public static List<?> getListByJSONArray(String jsonArray, Class<?> collectionClass, Class<?> elementClass) {
        List<?> list = null;
        JavaType javaType = getCollectionType(collectionClass, elementClass);
        try {
            list = objectMapper.readValue(jsonArray, javaType);
        } catch (JsonParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (JsonMappingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;
    }

    /***
     * list转rray String
     * 
     * @param list
     * @return
     */
    public static String getJsonArrayByList(List<?> list) {
        String json = null;
        try {
            json = objectMapper.writeValueAsString(list);
        } catch (JsonGenerationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (JsonMappingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return json;

    }

    private static JavaType getCollectionType(Class<?> collectionClass, Class<?> elementClass) {
        return objectMapper.getTypeFactory().constructParametricType(collectionClass, elementClass);
    }

    /**
     * 初始化jsonobject
     * 
     * @param keyName
     *            keyname数据
     * @param value
     *            值的数组
     * @return
     */
    public JSONObject initJsonObj(String[] keyName, Object[] value) {
        JSONObject jsonObject = new JSONObject();
        for (int i = 0; i < value.length; i++) {
            try {
                jsonObject.put(keyName[i], value[i]);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return jsonObject;
    }
    
    public static String getResultByJson(JSONObject obj){
    	if(obj == null)return "";
        if(obj.has("data")){
        	try {
				JSONArray array = (JSONArray) obj.get("data");
				if(array.length()!=0){
					JSONObject obj1 = array.getJSONObject(0);
					if(obj1.has("result")){
						return (String) obj1.getString("result");
					}
				}
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        return "";
    }
}
