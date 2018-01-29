package com.ssyt.saolei.code;

        import java.awt.GridLayout;

        import javax.swing.JFrame;
        import javax.swing.JMenu;
        import javax.swing.JMenuBar;
        import javax.swing.JMenuItem;

public class Mainjfram {
    boolean life=true;
    JframeDeal jframeDeal;

    public Mainjfram() {
        // TODO Auto-generated method stub
        jframeDeal=new JframeDeal(life);

        JFrame jframe = new JFrame();
        JMenu jMenu = new JMenu("菜单");
        JMenuBar jMenuBar = new JMenuBar();
        jframe.setJMenuBar(jMenuBar);
        jMenuBar.add(jMenu);
        JMenuItem restgame = new JMenuItem("重新开始");
        jMenu.add(restgame);

        jframe.setSize(800, 900);
        jframe.setLocationRelativeTo(null);
        jframe.setResizable(false);
        jframe.setDefaultCloseOperation(3);
        jframe.setTitle("扫雷");
        jframe.setLayout(new GridLayout(10, 10));

        int[][] map = new int[10][10];
        boolean[][] mapx= new boolean[10][10];
        for (int i = 0; i < mapx.length; i++) {
            for (int j=0;j<mapx.length;j++){
                mapx[i][j]=false;
            }
        }
        int leinubmer = 15;
        jframeDeal.initializationMapl(map, leinubmer);
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                jframeDeal.initializationMaps(i, j, map);
            }

        }

        jframeDeal.createleiimg(jframe, map,mapx);
        jframe.setVisible(true);
    }

}
