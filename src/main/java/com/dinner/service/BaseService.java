package com.dinner.service;



/**
 * created by dailf on 2018/7/13
 *
 * @author dailf
 */
public interface BaseService<T> {
    /**
     * 根据条件删除
     * @param key 条件
     * @return 删除数
     * @
     */
    int deleteByPrimaryKey(T key) ;

    /**
     * 添加
     * @param record 记录
     * @return 添加结果
     * @
     */
    int insert(T record) ;

    /**
     * 根据条件查询
     * @param key 条件
     * @return 对象
     * @
     */
    T selectByPrimaryKey(T key) throws Exception;

    /**
     * 更新成员
     * @param record 更改记录
     * @return 更新结果
     * @
     */
    int updateByPrimaryKey(T record) ;

    /**
     * 分页查找
     * @param key 条件
     * @param pager 分页
     * @return 结果
     */

}

