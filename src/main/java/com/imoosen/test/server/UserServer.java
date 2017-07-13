package com.imoosen.test.server;

import com.imoosen.test.model.User;

import java.util.List;

/**
 * Created by Administrator on 2017/6/23.
 */
public interface UserServer {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    List<User> selectAll();

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}
