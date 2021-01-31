package com.netflow.mapper;

import com.alibaba.fastjson.JSONObject;
import com.netflow.bean.User;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 汪培林
 * @data 2020-12-24  17:21:03
 */
@Repository
public class AddressMapper {

    /**
     * 通过jdbcTemplate形式操作数据库
     */
    @Autowired
    @Qualifier("templateTwo")
    private JdbcTemplate jdbcTemplate;

    public List<JSONObject> getStreetByArea(String area){
        List<JSONObject> res = new ArrayList<>();

        String sql = " select street_code,street_name from bs_street where area_code = '"+area+"'";

        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);

        if(maps!=null && maps.size()>0){

            for (Map<String, Object> map : maps) {

                JSONObject object = new JSONObject();
                object.put("code",map.get("street_code").toString());
                object.put("label",map.get("street_name").toString());
                object.put("value",map.get("street_code").toString());
                res.add(object);
            }

        }

        return res;
    }
    public List<JSONObject> getAreaByCity(String city){
        List<JSONObject> res = new ArrayList<>();

        String sql = "select area_code,area_name from bs_area where city_code = '"+city+"'";

        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);

        if(maps!=null && maps.size()>0){

            for (Map<String, Object> map : maps) {

                JSONObject object = new JSONObject();
                String code = map.get("area_code").toString();
                List<JSONObject> objects = getStreetByArea(code);
                object.put("code",code);
                object.put("label",map.get("area_name").toString());
                object.put("value",map.get("area_code").toString());
                if(objects!=null&&objects.size()>0){
                    object.put("children",objects);
                }
                res.add(object);
            }

        }

        return res;
    }
    public List<JSONObject> getCityByProvince(String province){
        List<JSONObject> res = new ArrayList<>();

        String sql = "select city_code,city_name from bs_city where province_code = '"+province+"'";

        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);

        if(maps!=null && maps.size()>0){

            for (Map<String, Object> map : maps) {

                JSONObject object = new JSONObject();
                String code = map.get("city_code").toString();
                List<JSONObject> objects = getAreaByCity(code);
                object.put("code",code);
                object.put("label",map.get("city_name").toString());
                object.put("value",code);
                if(objects!=null&&objects.size()>0){
                    object.put("children",objects);
                }
                res.add(object);
            }

        }

        return res;
    }
    public List<JSONObject> getProvinceByCode(){
        List<JSONObject> res = new ArrayList<>();

        String sql = "select province_code,province_name from bs_province";

        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);

        if(maps!=null && maps.size()>0){

            for (Map<String, Object> map : maps) {

                JSONObject object = new JSONObject();
                String code = map.get("province_code").toString();
                List<JSONObject> objects = getCityByProvince(code);
                object.put("code",code);
                object.put("label",map.get("province_name").toString());
                object.put("value",code);
                if(objects!=null&&objects.size()>0){
                    object.put("children",objects);
                }
                res.add(object);
            }

        }

        return res;
    }
}
