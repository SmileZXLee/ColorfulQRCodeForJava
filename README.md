# ColorfulQRCodeForJava
![](https://img.shields.io/badge/language-java-orange.svg)
## 使用方法
### 注意:请先生成黑白的二维码，再通过ZXColorfulQRCode类生成彩色二维码
### 生成一个上下左右四个方块颜色不同的二维码
```java
BufferedImage resImg1 = ZXColorfulQRCode.handleGradientQRCodeBlock(image1, leftTopColor, leftBottomColor, rightTopColor, rightBottomColor); 
```
* 查看效果
<img src="https://github.com/SmileZXLee/ColorfulQRCodeForJava/blob/master/DemoImgs/img1.png?raw=true"/>

### 生成一个每一行颜色不同的二维码
```java
BufferedImage resImg2 = ZXColorfulQRCode.handleGradientQRCodeRow(image2, colors);
```
* 查看效果
<img src="https://github.com/SmileZXLee/ColorfulQRCodeForJava/blob/master/DemoImgs/img2.png?raw=true"/>

### 生成一个每一列颜色不同的二维码
```java
BufferedImage resImg3 = ZXColorfulQRCode.handleGradientQRCodeColoum(image3, colors);
```
* 查看效果
<img src="https://github.com/SmileZXLee/ColorfulQRCodeForJava/blob/master/DemoImgs/img3.png?raw=true"/>

### 生成一个每一对角线颜色不同的二维码
```java
BufferedImage resImg4 = ZXColorfulQRCode.handleGradientQRCodeOblique(image4, colors);
```
* 查看效果
<img src="https://github.com/SmileZXLee/ColorfulQRCodeForJava/blob/master/DemoImgs/img4.png?raw=true"/>
