package com.neu.view;

import com.neu.pojo.User;
import com.neu.service.impl.UserService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class LoginUI extends JFrame implements ActionListener {
    UserService serve = new UserService();
    User player,rival;
    JPanel panel, gamePanel;
    JLabel label,label2,rivalName,gameLabel;
    JButton loginButton,exitButton,confirmButton,logoutButton;
    JTextField jTextField;
    //创建三个单选按钮
    JRadioButton radioBtn01 = new JRadioButton("1.刘备");
    JRadioButton radioBtn02 = new JRadioButton("2.孙权");
    JRadioButton radioBtn03 = new JRadioButton("3.曹操");
    //创建三个游戏按钮
    JRadioButton radioBtn04 = new JRadioButton("1.剪刀");
    JRadioButton radioBtn05 = new JRadioButton("2.石头");
    JRadioButton radioBtn06 = new JRadioButton("3.布");
    ButtonGroup gameBtnGroup = new ButtonGroup();

    public static void main(String[] args) {
        LoginUI systemUI = new LoginUI();
    }

    private String input(String tip){
        System.out.print(tip+":");
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

    public LoginUI() {
        this.setTitle("不服来战");
        this.setSize(300,220);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(new FlowLayout());//设置为流式布局
        label = new JLabel("你的名字");
        label2 = new JLabel("对手编号");
        rivalName = new JLabel("你的对手是: 1.无双刘备 2.盖世孙权 3.枭雄曹操");

        loginButton = new JButton("开始");
        loginButton.addActionListener(this);//监听事件
        exitButton = new JButton("退出");
        exitButton.addActionListener(this);//监听事件
        jTextField = new JTextField(20);//设置文本框的长度
        logoutButton = new JButton("退出");//退出按钮
        logoutButton.addActionListener(this);

        //创建按钮组,把三个单选按钮添加到改组
        ButtonGroup btnGroup = new ButtonGroup();
        btnGroup.add(radioBtn01);
        btnGroup.add(radioBtn02);
        btnGroup.add(radioBtn03);

        //设置第一个按钮被选中
        radioBtn01.setSelected(true);


        panel.add(rivalName);
        panel.add(label);//把组件添加到面板panel
        panel.add(jTextField);
        panel.add(label2);
        //panel.add(passwordField);
        panel.add(radioBtn01);
        panel.add(radioBtn02);
        panel.add(radioBtn03);
        panel.add(loginButton);
        panel.add(exitButton);

        //设计游戏机界面
        gamePanel = new JPanel();
        //设计游戏按钮
        gameBtnGroup.add(radioBtn04);
        gameBtnGroup.add(radioBtn05);
        gameBtnGroup.add(radioBtn06);
        radioBtn04.setSelected(true);

        //设计游戏按键
        confirmButton = new JButton("确认");
        confirmButton.addActionListener(this);//安装监视器

        gamePanel.add(radioBtn04);
        gamePanel.add(radioBtn05);
        gamePanel.add(radioBtn06);
        gamePanel.add(confirmButton);

        this.add(panel);//实现面板panel

        this.setVisible(true);//设置可见
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==loginButton) {
            if (jTextField.getText().length() != 0) {
                player = serve.setName(jTextField.getText());
                rival = chooseRival();
                JOptionPane.showMessageDialog(null,"游戏开始！" );
                gameLabel = new JLabel(rival.getName()+",放马过来吧,"+player.getName()+"不怕你!");
                this.remove(panel);
                gamePanel.add(gameLabel);
                gamePanel.add(logoutButton);
                this.add(gamePanel);
                this.setSize(300, 180);
                this.setVisible(true);
            }else {
                JOptionPane.showMessageDialog(null, "请填写用户名！");
            }
        }
        if (e.getSource()==exitButton) {
            System.exit(0);
        }
        if(e.getSource() == confirmButton){
            play();
        }
        if(e.getSource() == logoutButton){
            end();
        }
    }

    public User chooseRival(){
        if(radioBtn01.isSelected()){
            return serve.chooseRival("刘备");
        }else if(radioBtn02.isSelected()){
            return serve.chooseRival("孙权");
        }else{
            return serve.chooseRival("曹操");
        }
    }

    public void play(){
        int[] res;
        if(radioBtn04.isSelected()){
            res = serve.play(1);
        }else if(radioBtn05.isSelected()){
            res = serve.play(2);
        }else{
            res = serve.play(3);
        }
        String[] map = {"", "剪刀", "石头", "布"};
        if(res[0] == 0){
            JOptionPane.showMessageDialog(null,rival.getName()+"出了"+map[res[1]]+"平局" );
        }else if(res[0] == 1){
            JOptionPane.showMessageDialog(null,rival.getName()+"出了"+map[res[1]]+"你赢了" );
        }else{
            JOptionPane.showMessageDialog(null,rival.getName()+"出了"+map[res[1]]+"你输了" );
        }
    }

    public void end(){
        int times = serve.getTimes();
        JPanel finalPanel = new JPanel();

        JLabel label1 = new JLabel(rival.getName()+":"+rival.getScore());
        JLabel label2 = new JLabel(player.getName()+":"+player.getScore());
        JLabel label3;

        if(rival.getScore()>player.getScore()){
            JOptionPane.showMessageDialog(null,"游戏结束, 你输了");
            label3 = new JLabel("笨笨还需努力");
        }else if(rival.getScore() == player.getScore()){
            JOptionPane.showMessageDialog(null,"游戏结束,平局");
            label3 = new JLabel("彼此彼此");
        }else{
            JOptionPane.showMessageDialog(null,"游戏结束,你赢了");
            label3 = new JLabel("笨笨太棒了, 你是最棒的");
        }
        finalPanel.add(label1);
        finalPanel.add(label2);
        finalPanel.add(label3);
        finalPanel.add(exitButton);
        this.remove(gamePanel);
        this.remove(panel);
        this.add(finalPanel);
        this.setVisible(true);

    }
}














