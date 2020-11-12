package cn.lightzz.idcodeutils.connector;

import java.awt.*;

/**
 * @author JCLightZZ
 * @date 2020/11/4 20:19
 */
public interface IdCodeToolsPort {
    /**
     * 设置窗体程序的验证码
     *
     * @param width         验证码宽度
     * @param height        验证码高度
     * @param graphics      画笔参数
     * @param bgColor       背景颜色
     * @param obstructColor 干扰颜色
     */
    void setWindowIdCode(int width, int height, Graphics graphics, Color bgColor, Color obstructColor);

}
