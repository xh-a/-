package com.neu.service.impl;

import com.neu.dao.impl.UserDao;
import com.neu.pojo.User;
import com.neu.service.IUserService;

import java.util.Random;

public class UserService implements IUserService {
    UserDao game = new UserDao();

    @Override
    public int[] play(int fist) {
        Random random = new Random();
        int rivalFist = random.nextInt(3)+1;
        System.out.println(fist + " " + rivalFist);
        int res = game.cmpFist(fist,rivalFist);
        return new int[]{res,rivalFist};
    }

    @Override
    public User chooseRival(String name) {
        User rival = new User(name);//根据名字选择自己的对手
        User res = game.setRival(rival);//设置自己对手
        return res;
    }

    @Override
    public User setName(String name) {
        User player = new User(name);
        game.setPlayer(player);//设置玩家
        return player;
    }

    @Override
    public int getTimes() {
        return game.getTimes();//获取比赛次数
    }
}
