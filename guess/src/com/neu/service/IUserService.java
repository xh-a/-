package com.neu.service;

import com.neu.pojo.User;

public interface IUserService {
    int[] play(int fist);
    User chooseRival(String name);
    User setName(String name);
    int getTimes();
}
