package com.itheima;

import com.itheima.dao.AccountDao;
import com.itheima.pojo.Account;
import com.itheima.utils.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * 包名:com.itheima
 * 目标: 使用者只调用第一次查询，由mybatis选择调用第二次查询
 *
 * 懒加载是需要配置的:
 *  1. 局部懒加载: 只在你配置了的地方才会进行懒加载
 *  2. 全局懒加载:
 */
public class TestMybatis {
    @Test
    public void test01(){
        //如果只需要查询账号信息
        SqlSession sqlSession = SqlSessionFactoryUtil.openSqlSession();
        AccountDao accountDao = sqlSession.getMapper(AccountDao.class);

        //查询aid为1的账号信息
        Account account = accountDao.findAccountByAid(1);

        //如果需要先查询到账号信息，然后再查询该账号所属的用户信息
        //UserDao userDao = sqlSession.getMapper(UserDao.class);

        //将第一步查询到的uid传入到第二步
        //User user = userDao.findUserByUid(account.getUid());

        //将第二步查询到的user，设置到第一步查询到的account里面
        //account.setUser(user);

        System.out.println(account.getMoney());

        SqlSessionFactoryUtil.commitAndClose(sqlSession);
    }
}
