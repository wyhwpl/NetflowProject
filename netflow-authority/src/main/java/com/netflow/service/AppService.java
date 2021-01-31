package com.netflow.service;

import com.netflow.bean.AppTree;
import com.netflow.bean.Application;
import com.netflow.bean.Role;

import java.util.List;

/**
 * 应用服务接口
 */
public interface AppService {

    /**
     * 获取所有应用信息
     * @return
     */
    List<Application> getAllApp();

    /**
     * 获取应用信息树
     * @return
     */
    List<AppTree> getAppTree();

    /**
     * 获取指定id的应用信息
     * @param id
     * @return
     */
    Application getAppById(String id);


    /**
     * 添加新角色
     * @param application
     * @return
     */
    int insertApp(Application application);

    /**
     * 修改应用信息
     * @param application
     * @return
     */
    int updateApp(Application application);

    /**
     * 根据主键删除应用
     * @param id
     * @return
     */
    int deleteAppById(String id);

}
