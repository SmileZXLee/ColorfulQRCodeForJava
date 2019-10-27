/**
 * @Author ZXLee
 * @Date  2019.10.27
 * @Github https://github.com/SmileZXLee/ColorfulQRCodeForJava
 **/

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class Main {
    public static void main(String[] args) {
        //读取图片的路径(测试的时候必须改成电脑中本地二维码图片的路径)
        String imgPath = "/Users/lzx/Desktop/zxleecode.png";
        //存储图片的路径(测试的时候必须改成电脑中需要存储的路径)
        String savePath = "/Users/lzx/Desktop/zxleecodeResult/";
        try {
            Color leftTopColor = new Color(255, 0, 0);
            Color leftBottomColor = new Color(0, 0, 255);
            Color rightTopColor = new Color(0, 255, 0);
            Color rightBottomColor = new Color(255, 144, 0);

            Color[] colors = new Color[]{leftTopColor, leftBottomColor, rightTopColor, rightBottomColor};

            //生成一个上下左右四个方块颜色不同的二维码
            BufferedImage image1 = ImageIO.read(new File(imgPath));
            BufferedImage resImg1 = ZXColorfulQRCode.handleGradientQRCodeBlock(image1, leftTopColor, leftBottomColor, rightTopColor, rightBottomColor);
            ImageIO.write(resImg1, "png", new File(savePath + "/img1.png"));

            //生成一个每一行颜色不同的二维码
            BufferedImage image2 = ImageIO.read(new File(imgPath));
            BufferedImage resImg2 = ZXColorfulQRCode.handleGradientQRCodeRow(image2, colors);
            ImageIO.write(resImg2, "png", new File(savePath + "/img2.png"));

            //生成一个每一列颜色不同的二维码
            BufferedImage image3 = ImageIO.read(new File(imgPath));
            BufferedImage resImg3 = ZXColorfulQRCode.handleGradientQRCodeColoum(image3, colors);
            ImageIO.write(resImg3, "png", new File(savePath + "/img3.png"));

            //生成一个每一对角线颜色不同的二维码
            BufferedImage image4 = ImageIO.read(new File(imgPath));
            BufferedImage resImg4 = ZXColorfulQRCode.handleGradientQRCodeOblique(image4, colors);
            ImageIO.write(resImg4, "png", new File(savePath + "/img4.png"));

            //生成一个每一对角线颜色不同的渐变二维码
            Color[] gradientcolors = ZXColorfulQRCode.getGradientColor(Color.PINK,Color.BLUE,30);
            BufferedImage image5 = ImageIO.read(new File(imgPath));
            BufferedImage resImg5 = ZXColorfulQRCode.handleGradientQRCodeOblique(image5, gradientcolors);
            ImageIO.write(resImg5, "png", new File(savePath + "/img5.png"));

        } catch (Exception e) {
            System.out.println("无法获取图片：" + imgPath + "或程序出现异常！" + e);
        }

    }
}
