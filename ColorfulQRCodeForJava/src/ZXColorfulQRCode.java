import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class ZXColorfulQRCode {
    /**
     * 生成一个上下左右四个方块颜色不同的二维码
     * @param image 待处理的二维码图片
     * @param leftTopColor 左上角颜色
     * @param leftBottomColor 左下角颜色
     * @param rightTopColor 右上角颜色
     * @param rightBottomColor 右下角颜色
     * @return 处理后的二维码
     */
    public static BufferedImage handleGradientQRCodeBlock(BufferedImage image, Color leftTopColor, Color leftBottomColor, Color rightTopColor, Color rightBottomColor){
        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                int  clr   = image.getRGB(x, y);
                int  red   = (clr & 0x00ff0000) >> 16;
                int  green = (clr & 0x0000ff00) >> 8;
                int  blue  =  clr & 0x000000ff;
                if(red < 50 && green < 50 && blue < 50){
                    Color fillColor;
                    if(x < image.getWidth() / 2){
                        if(y < image.getHeight() / 2){
                            //左上
                            fillColor = leftTopColor;
                        }else{
                            //左下
                            fillColor = leftBottomColor;
                        }

                    }else{
                        if(y < image.getHeight() / 2){
                            //右上
                            fillColor = rightTopColor;
                        }else{
                            //右下
                            fillColor = rightBottomColor;
                        }
                    }
                    image.setRGB(x,y,fillColor.getRGB());
                }

            }
        }
        return image;
    }

    /**
     * 生成一个每一行颜色不同的二维码
     * @param image 待处理的二维码
     * @param colors 每一行的颜色
     * @return 处理后的二维码
     */
    public static BufferedImage handleGradientQRCodeRow(BufferedImage image, Color[] colors){
        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                int clr = image.getRGB(x, y);
                int red = (clr & 0x00ff0000) >> 16;
                int green = (clr & 0x0000ff00) >> 8;
                int blue = clr & 0x000000ff;
                if (red < 50 && green < 50 && blue < 50) {
                    int step = image.getWidth() / colors.length;
                    int currentStep = y / step;
                    if(currentStep >= colors.length){
                        currentStep =  colors.length - 1;
                    }
                    Color currentColor = colors[currentStep];
                    image.setRGB(x,y,currentColor.getRGB());
                }
            }

        }
        return image;
    }

    /**
     * 生成一个每一列颜色不同的二维码
     * @param image 待处理的二维码
     * @param colors 每一列的颜色
     * @return 处理后的二维码
     */
    public static BufferedImage handleGradientQRCodeColoum(BufferedImage image, Color[] colors){
        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                int clr = image.getRGB(x, y);
                int red = (clr & 0x00ff0000) >> 16;
                int green = (clr & 0x0000ff00) >> 8;
                int blue = clr & 0x000000ff;
                if (red < 50 && green < 50 && blue < 50) {
                    int step = image.getWidth() / colors.length;
                    int currentStep = x / step;
                    if(currentStep >= colors.length){
                        currentStep =  colors.length - 1;
                    }
                    Color currentColor = colors[currentStep];
                    image.setRGB(x,y,currentColor.getRGB());
                }
            }

        }
        return image;
    }

    /**
     * 生成一个每一对角线颜色不同的二维码
     * @param image 待处理的二维码
     * @param colors 每一对角线的颜色
     * @return 处理后的二维码
     */
    public static BufferedImage handleGradientQRCodeOblique(BufferedImage image, Color[] colors){
        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                int clr = image.getRGB(x, y);
                int red = (clr & 0x00ff0000) >> 16;
                int green = (clr & 0x0000ff00) >> 8;
                int blue = clr & 0x000000ff;
                if (red < 50 && green < 50 && blue < 50) {
                    int currentStep = 0;
                    for(int i = 0; i < colors.length; i++){
                        if((x + y) - ((i + 1) * 2.0 * image.getWidth()) / (colors.length)  < 0){
                            currentStep  = i;
                            break;
                        }
                    }
                    Color currentColor;
                    currentColor = colors[currentStep];

                    image.setRGB(x,y,currentColor.getRGB());
                }
            }

        }
        return image;
    }


    public static Color[] getGradientColor(Color fromColor, Color toColor, int step){
        ArrayList<Color> colorList = new ArrayList<Color>();
        int fromR = fromColor.getRed();
        int fromG = fromColor.getGreen();
        int fromB = fromColor.getBlue();
        int toR = toColor.getRed();
        int toG = toColor.getGreen();
        int toB = toColor.getBlue();
        for(int i = 0; i < step; i++){
            int r = fromR + (toR - fromR) / step * i;
            int g = fromG + (toG - fromG) / step * i;
            int b = fromB + (toB - fromB) / step * i;
            Color color = new Color(r,g,b);
            colorList.add(color);
        }
        return colorList.toArray(new Color[step]);
    }
}
