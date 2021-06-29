package com.neu.dao.impl;

import com.neu.dao.IUserDao;
import com.neu.pojo.User;

public class UserDao implements IUserDao {
    private User[] computer = {new User("刘备"), new User("孙权"),new User("曹操")};
    private User player;//玩家
    private User rival;//电脑对手
    private int times;//比赛次数

    /**
     * 比较出拳大小
     * @param a 玩家出拳编号
     * @param b 电脑出拳编号
     * @return 1 玩家得一分, -1 :电脑得一分 , 0: 平局
     */
    @Override
    public int cmpFist(int a, int b) {
        times++;//比赛次数增加一次
        if((a == 1 && b == 2) || (a == 2 && b == 3)||(a == 3 && b == 1)){//电脑胜利的所有情况
            rival.setScore(rival.getScore()+1);
            return -1;
        }else if (a == b){//平局
            return 0;
        }else{//玩家胜利
            player.setScore(player.getScore()+1);
            return 1;
        }
    }

    public void setPlayer(User player) {
        this.player = player;
    }

    public User setRival(User rival) {
        for(User el:computer){//匹配自己对手
            if(el.getName().equals(rival.getName())){
                this.rival = el;
                return el;//匹配成功返回true
            }
        }
        return null;//匹配失败返回false
    }

    /**
     * 传入出拳编号,传出出拳信息
     * @param fist 拳头代码
     * @return 所出拳头中文名称
     */
    @Override
    public String showFist(int fist){
        switch (fist){
            case 1:return "剪刀";//1 为剪刀
            case 2:return "石头";//2 为石头
            case 3:return "布";//3 为布
            default:return null;
        }
    }

    public User[] getComputer() {
        return computer;
    }

    public User getPlayer() {
        return player;
    }

    public User getRival() {
        return rival;
    }
    public int getTimes(){
        return times;
    }

}
