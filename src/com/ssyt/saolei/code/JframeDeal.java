package com.ssyt.saolei.code;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class JframeDeal {
    boolean life;
    public JframeDeal(boolean life) {
    this.life=life;
    }

    public JframeDeal() {
    }

    public void initializationMaps(int sa, int sb, int[][] map) {

        // sa x sb y
        int gx = 0;
        if (map[sa][sb] == 0) {
            // L
            if ((sa - 1) >= 0) {
                if (map[sa - 1][sb] == -1) {
                    gx++;
                }
            }
            // R
            if (sa + 1 < 10) {
                if (map[sa + 1][sb] == -1) {
                    gx++;
                }
            }
            // s
            if (sb - 1 >= 0) {
                if (map[sa][sb - 1] == -1) {
                    gx++;
                }
            }
            // x
            if (sb + 1 < 10) {
                if (map[sa][sb + 1] == -1) {
                    gx++;
                }
            }
            // q
            if (sa - 1 >= 0 && sb - 1 >= 0) {
                if (map[sa - 1][sb - 1] == -1) {
                    gx++;
                }
            }
            // m
            if (sa + 1 < 10 && sb + 1 < 10) {
                if (map[sa + 1][sb + 1] == -1) {
                    gx++;
                }
            }
            // zz
            if (sa - 1 >= 0 && sb + 1 < 10) {
                if (map[sa - 1][sb + 1] == -1) {
                    gx++;
                }
            }
            // rr
            if (sa + 1 < 10 && sb - 1 >= 0) {
                if (map[sa + 1][sb - 1] == -1) {
                    gx++;
                }
            }

        } else {
            gx = -1;
        }
        map[sa][sb] = gx;
    }

    public void initializationMapl(int[][] map, int leinubmer) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                map[i][j] = 0;
            }
        }
        Random leix = new Random();
        Random leiy = new Random();
        int[][] leixy=new int[2][leinubmer];
        int x=0,y=0,cc=0;
        for (int i = 0; i <2; i++) {
            for (int j = 0; j < leixy[0].length; j++) {
                leixy[i][j]=0;
            }

        }
        for (int i = 0; i < leinubmer; i++) {
            x=leix.nextInt(10);
            y=leiy.nextInt(10);
            cc=0;
            for(int f=0;f<leinubmer;f++){
                if(x==leixy[0][f]&&y==leixy[1][f]){
                    i--;
                    break;
                }else{
                    cc++;
                }
            }
            if(cc==leinubmer){
                leixy[0][i]=x;
                leixy[1][i]=y;
                map[x][y]=-1;
            }
        }
    }

    public void createleiimg(JFrame jframe, final int[][] map,final boolean[][] mapx) {
        final JButton[][] jButton = new JButton[10][10];
        for (int i = 0; i < jButton.length; i++) {
            for (int j = 0; j < jButton[0].length; j++) {
                jButton[i][j] = new JButton();

                final int  x=i,y=j;
                jButton[i][j].addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (map[x][y] == -1) {
                            jButton[x][y].setText("地雷");
                            life=false;
                        }
                        if (map[x][y] == 0) {
                            tanCeDiLei(jButton,map,x,y,mapx);
                        }
                        if (map[x][y] == 1) {
                            jButton[x][y].setText("1");
                        }
                        if (map[x][y] == 2) {
                            jButton[x][y].setText("2");
                        }
                        if (map[x][y] == 3) {
                            jButton[x][y].setText("3");
                        }
                        if (map[x][y] == 4) {
                            jButton[x][y].setText("4");
                        }
                            if (map[x][y] == 5) {
                            jButton[x][y].setText("5");
                        }
                        if (map[x][y] == 6) {
                            jButton[x][y].setText("6");
                        }
                        if (map[x][y] == 7) {
                            jButton[x][y].setText("7");
                        }
                        if (map[x][y] == 8) {
                            jButton[x][y].setText("8");
                        }
                    }
                });

                jframe.add(jButton[i][j]);
            }
        }
    }

    public void tanCeDiLei(JButton[][] jButton,int[][] map,int x,int y,boolean[][] mapx){
        mapx[x][y]=true;
        //左
        if ((x- 1) >= 0) {
            if (map[x - 1][y] == 0) {
                if(!mapx[x-1][y]) {
                    tanCeDiLei(jButton, map, x-1, y, mapx);
                }
            }else{
                jButton[x-1][y].setText(""+map[x-1][y]);
            }
        }
        // 右
        if (x + 1 < 10) {
            if (map[x+ 1][y] == 0) {
                if(!mapx[x+ 1][y]) {
                    tanCeDiLei(jButton, map, x+1, y, mapx);
                }
            }else
            {
               jButton[x+ 1][y].setText(""+map[x+ 1][y]);
            }
        }
        // 上
        if (y - 1 >= 0) {
            if (map[x][y-1] == 0) {
                if(!mapx[x][y-1]) {
                    tanCeDiLei(jButton, map, x, y-1, mapx);
                }
            }else {
                jButton[x][y - 1].setText(""+map[x][y - 1]);

            }
        }
        // 下
        if (y + 1 < 10) {
            if (map[x][y+1] == 0) {
                if(!mapx[x][y+1]) {
                    tanCeDiLei(jButton, map, x, y+1, mapx);
                }
            }else {
                jButton[x][y + 1].setText(""+map[x][y + 1]);

            }
        }
        // 左上
        if (x - 1 >= 0 && y - 1 >= 0) {
            if (map[x - 1][y - 1] == 0) {
                if(!mapx[x - 1][y - 1]) {
                    tanCeDiLei(jButton, map, x-1, y-1, mapx);
                }
            }else {
                jButton[x - 1][y - 1].setText(""+map[x - 1][y - 1]);
            }
        }
        // 右下
        if (x + 1 < 10 && y + 1 < 10) {
            if (map[x + 1][y + 1] == 0) {
                if(!mapx[x + 1][y + 1]) {
                    tanCeDiLei(jButton, map, x+1, y+1, mapx);
                }
            }else {
                jButton[x + 1][y + 1].setText(""+map[x + 1][y + 1]);
            }
        }
        // 左下
        if (x - 1 >= 0 && y + 1 < 10) {
            if (map[x - 1][y + 1] == 0) {
                if(!mapx[x - 1][y + 1]) {
                    tanCeDiLei(jButton, map, x-1, y+1, mapx);
                }
            }else {
                jButton[x - 1][y + 1].setText(""+map[x - 1][y + 1]);
            }
        }
        // 右上
        if (x + 1 < 10 && y - 1 >= 0) {
            if (map[x+ 1][y- 1] == 0) {
                if(!mapx[x+ 1][y- 1]) {
                    tanCeDiLei(jButton, map, x+1, y-1, mapx);
                }
            }else {
                jButton[x+ 1][y- 1].setText(""+map[x+ 1][y- 1]);
            }

        }

    }
}