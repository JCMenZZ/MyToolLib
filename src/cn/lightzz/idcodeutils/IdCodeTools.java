package cn.lightzz.idcodeutils;

import cn.lightzz.idcodeutils.connector.IdCodeToolsPort;

import java.awt.*;
import java.util.Random;

/**
 * 验证码工具
 *
 * @author JCLightZZ
 * @date 2020/11/4 20:18
 */
public class IdCodeTools implements IdCodeToolsPort {
    /**
     * 常量含义介绍：
     * POINT_X              远点的X坐标
     * POINT_Y              原点的Y坐标
     * OBSTRUCT_POINT_NUM   干扰点的数量
     * ID_CODE_CHAR         验证码的来源
     * CODE_NUM             验证码位数
     */
    private static final int POINT_X = 0;
    private static final int POINT_Y = 0;
    private static final int OBSTRUCT_POINT_NUM = 200;
    private static final String ID_CODE_CHAR = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKL" +
            "MNOPQRSTUVWXYZ";
    private static final int CODE_NUM = 4;

    @Override
    public void setWindowIdCode(int width, int height, Graphics graphics, Color bgColor,
                                Color obstructColor) {
        /*方法使用说明：当某个类继承Panel类时，这时只需要重写paint方法，在paint中引入该方法即可实现验证码的创建*/
        /*设置窗体程序验证码的步骤，首先设置背景颜色并填充背景，然后设置干扰颜色并绘制边框，再后绘制干扰点并设置验证码的字体
        和颜色，最后产生验证码的四个字符*/
        graphics.setColor(bgColor);
        graphics.fillRect(POINT_X, POINT_Y, width, height);
        graphics.setColor(obstructColor);
        graphics.drawRect(POINT_X, POINT_Y, width - 1, height - 1);
        Random random = new Random();
        for (int i = 0; i < OBSTRUCT_POINT_NUM; i++) {
            int x = random.nextInt(width) - 2;
            int y = random.nextInt(height) - 2;
            graphics.drawOval(x, y, 3, 3);
        }
        graphics.setFont(new Font("黑体", Font.BOLD, 30));
        graphics.setColor(Color.BLUE);
        char[] idCode = ID_CODE_CHAR.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < CODE_NUM; i++) {
            int pos = random.nextInt(idCode.length);
            char c = idCode[pos];
            stringBuilder.append(c).append(" ");
        }
        graphics.drawString(stringBuilder.toString(), 20, 30);
    }
}
