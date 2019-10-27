# ColorfulQRCodeForJava
![](https://img.shields.io/badge/language-java-orange.svg)
## 使用方法
### 注意:请先生成黑白的二维码，再通过ZXColorfulQRCode类生成彩色二维码
### 生成一个上下左右四个方块颜色不同的二维码
* 参数为待处理的二维码图片与上下左右四个方块的颜色
```java
BufferedImage resImg1 = ZXColorfulQRCode.handleGradientQRCodeBlock(image1, leftTopColor, leftBottomColor, rightTopColor, rightBottomColor); 
```
* 查看效果
<img src="https://github.com/SmileZXLee/ColorfulQRCodeForJava/blob/master/DemoImgs/img1.png?raw=true"/>

### 生成一个每一行颜色不同的二维码
* 参数为待处理的二维码图片与图片数组
```java
BufferedImage resImg2 = ZXColorfulQRCode.handleGradientQRCodeRow(image2, colors);
```
* 查看效果
<img src="https://github.com/SmileZXLee/ColorfulQRCodeForJava/blob/master/DemoImgs/img2.png?raw=true"/>

### 生成一个每一列颜色不同的二维码
* 参数为待处理的二维码图片与图片数组
```java
BufferedImage resImg3 = ZXColorfulQRCode.handleGradientQRCodeColoum(image3, colors);
```
* 查看效果
<img src="https://github.com/SmileZXLee/ColorfulQRCodeForJava/blob/master/DemoImgs/img3.png?raw=true"/>

### 生成一个对角线颜色不同的二维码
* 参数为待处理的二维码图片与图片数组
```java
BufferedImage resImg4 = ZXColorfulQRCode.handleGradientQRCodeOblique(image4, colors);
```
* 查看效果
<img src="https://github.com/SmileZXLee/ColorfulQRCodeForJava/blob/master/DemoImgs/img4.png?raw=true"/>

### 生成一个对角线颜色为渐变色的二维码
* 参数为待处理的二维码图片与图片数组
```java
Color[] gradientcolors = ZXColorfulQRCode.getGradientColor(Color.PINK,Color.BLUE,30);
BufferedImage resImg5 = ZXColorfulQRCode.handleGradientQRCodeOblique(image5, gradientcolors);
```
* 查看效果
<img src="https://github.com/SmileZXLee/ColorfulQRCodeForJava/blob/master/DemoImgs/img5.png?raw=true"/>
