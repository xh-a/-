package com.neu.dao;

import com.neu.pojo.User;

public interface IUserDao {
    int cmpFist(int a, int b);//比较出拳胜负
    void setPlayer(User player);//设置玩家
    User setRival(User player);//设置对手
    String showFist(int fist);//展现编号对应的出拳
}
