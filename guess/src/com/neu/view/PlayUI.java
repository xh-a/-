package com.neu.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayUI extends JFrame implements ActionListener {
    JPanel gamePanel;
    JButton confirmButton;
    //创建三个游戏按钮
    JRadioButton radioBtn04 = new JRadioButton("1.石头");
    JRadioButton radioBtn05 = new JRadioButton("2.剪刀");
    JRadioButton radioBtn06 = new JRadioButton("3.布");
    ButtonGroup gameBtnGroup = new ButtonGroup();

    public PlayUI() throws HeadlessException {
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

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
