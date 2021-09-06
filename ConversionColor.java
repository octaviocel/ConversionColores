/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imagergb;

import java.awt.Color;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author DELL
 */
public class ConversionColor {

    private BufferedImage image;

    public ConversionColor(String ruta) {
        try {
            this.image = ImageIO.read(new File(ruta));

        } catch (IOException e) {
            System.out.println("No se pudo cargar la imagen" + e.getMessage());
        }
    }

    public void RGBToCMYK() throws IOException {
        for (int i = 0; i < image.getWidth(); i++) {
            for (int j = 0; j < image.getHeight(); j++) {
                Integer rgb = image.getRGB(i, j);
                Color imagen = new Color(rgb);

                Color nuevo = new Color(255 - imagen.getRed(), 255 - imagen.getGreen(), 255 - imagen.getBlue());

                image.setRGB(i, j, nuevo.getRGB());
            }
        }
        ImageIO.write(image, "jpeg", new File("C:\\Users\\DELL\\Desktop\\ConversionColor.jpeg"));
        System.out.println("Listo imagen transformada, se guardo como ConversionColor.jpeg");
    }

    public void eliminaColor(Integer color, Integer limInf, Integer limSup) throws IOException {
        for (int i = 0; i < image.getWidth(); i++) {
            for (int j = 0; j < image.getHeight(); j++) {
                Integer rgb = image.getRGB(i, j);
                Color imagen = new Color(rgb);
                if (color == 1) {
                    if ((imagen.getRed() >= limInf) && (imagen.getRed() <= limSup)) {
                        Color colorcito = new Color(255, 255, 255);
                        image.setRGB(i, j, colorcito.getRGB());
                    }
                }
                if (color == 2) {
                    if ((imagen.getGreen() >= limInf) && (imagen.getGreen() <= limSup)) {
                        Color colorcito = new Color(255, 255, 255);
                        image.setRGB(i, j, colorcito.getRGB());
                    }
                }
                if (color == 3) {
                    if ((imagen.getBlue() >= limInf) && (imagen.getBlue() <= limSup)) {
                        Color colorcito = new Color(255, 255, 255);
                        image.setRGB(i, j, colorcito.getRGB());
                    }
                }
            }
        }
        ImageIO.write(image, "jpg", new File("C:\\Users\\DELL\\Desktop\\CambioSoloColor.jpg"));
        System.out.println("Listo imagen transformada, se guardo como CambioSoloColor.jpg");

    }

    public void profundidad(Integer bits) throws IOException {
        switch (bits) {
            case 1:
                for (int i = 0; i < image.getWidth(); i++) {
                    for (int j = 0; j < image.getHeight(); j++) {
                        Color color = new Color(image.getRGB(i, j));
                        if (color.getBlue() <= 128) {
                            Color colorcito = new Color(0, 0, 0);
                            image.setRGB(i, j, colorcito.getRGB());
                        } else {
                            Color colorcito = new Color(255, 255, 255);
                            image.setRGB(i, j, colorcito.getRGB());
                        }
                    }
                }
                ImageIO.write(image, "jpg", new File("C:\\Users\\DELL\\Desktop\\Profundidas1bit.jpg"));
                System.out.println("Listo imagen transformada a profundidad de 1 bit, se guardo como Profundidas1bit.jpg");
                break;
            case 2:
                for (int i = 0; i < image.getWidth(); i++) {
                    for (int j = 0; j < image.getHeight(); j++) {
                        Color color = new Color(image.getRGB(i, j));
                        if (color.getBlue() <= 63) {
                            Color colorcito = new Color(0, 0, 0);
                            image.setRGB(i, j, colorcito.getRGB());
                        } else if ((color.getBlue() >= 64) && (color.getBlue() <= 127)) {
                            Color colorcito = new Color(64, 64, 64);
                            image.setRGB(i, j, colorcito.getRGB());
                        } else if ((color.getBlue() >= 128) && (color.getBlue() <= 191)) {
                            Color colorcito = new Color(128, 128, 128);
                            image.setRGB(i, j, colorcito.getRGB());
                        } else {
                            Color colorcito = new Color(192, 192, 192);
                            image.setRGB(i, j, colorcito.getRGB());
                        }

                    }
                }
                ImageIO.write(image, "jpg", new File("C:\\Users\\DELL\\Desktop\\Profundidas2bit.jpg"));
                System.out.println("Listo imagen transformada a profundidad de 2 bit, se guardo como Profundidas2bit.jpg");
                break;
            case 4:
                for (int i = 0; i < image.getWidth(); i++) {
                    for (int j = 0; j < image.getHeight(); j++) {
                        Color color = new Color(image.getRGB(i, j));
                        if (color.getBlue() <= 31) {
                            Color colorcito = new Color(0, 0, 0);
                            image.setRGB(i, j, colorcito.getRGB());
                        } else if ((color.getBlue() >= 32) && (color.getBlue() <= 63)) {
                            Color colorcito = new Color(64, 64, 64);
                            image.setRGB(i, j, colorcito.getRGB());
                        } else if ((color.getBlue() >= 64) && (color.getBlue() <= 95)) {
                            Color colorcito = new Color(64, 64, 64);
                            image.setRGB(i, j, colorcito.getRGB());
                        } else if ((color.getBlue() >= 96) && (color.getBlue() <= 127)) {
                            Color colorcito = new Color(96, 96, 96);
                            image.setRGB(i, j, colorcito.getRGB());
                        } else if ((color.getBlue() >= 128) && (color.getBlue() <= 159)) {
                            Color colorcito = new Color(128, 128, 128);
                            image.setRGB(i, j, colorcito.getRGB());
                        } else if ((color.getBlue() >= 160) && (color.getBlue() <= 191)) {
                            Color colorcito = new Color(160, 160, 160);
                            image.setRGB(i, j, colorcito.getRGB());
                        } else if ((color.getBlue() >= 192) && (color.getBlue() <= 223)) {
                            Color colorcito = new Color(192, 192, 192);
                            image.setRGB(i, j, colorcito.getRGB());
                        } else {
                            Color colorcito = new Color(224, 224, 224);
                            image.setRGB(i, j, colorcito.getRGB());
                        }
                    }
                }
                ImageIO.write(image, "jpg", new File("C:\\Users\\DELL\\Desktop\\Profundidas4bit.jpg"));
                System.out.println("Listo imagen transformada a profundidad de 4 bit, se guardo como Profundidas4bit.jpg");
                break;
            case 8:
                for (int i = 0; i < image.getWidth(); i++) {
                    for (int j = 0; j < image.getHeight(); j++) {
                        Color color = new Color(image.getRGB(i, j));
                        if (color.getBlue() <= 15) {
                            Color colorcito = new Color(0, 0, 0);
                            image.setRGB(i, j, colorcito.getRGB());
                        } else if ((color.getBlue() >= 16) && (color.getBlue() <= 31)) {
                            Color colorcito = new Color(16, 16, 16);
                            image.setRGB(i, j, colorcito.getRGB());
                        } else if ((color.getBlue() >= 32) && (color.getBlue() <= 47)) {
                            Color colorcito = new Color(32, 32, 32);
                            image.setRGB(i, j, colorcito.getRGB());
                        } else if ((color.getBlue() >= 48) && (color.getBlue() <= 63)) {
                            Color colorcito = new Color(48, 48, 48);
                            image.setRGB(i, j, colorcito.getRGB());
                        } else if ((color.getBlue() >= 64) && (color.getBlue() <= 79)) {
                            Color colorcito = new Color(64, 64, 64);
                            image.setRGB(i, j, colorcito.getRGB());
                        } else if ((color.getBlue() >= 80) && (color.getBlue() <= 95)) {
                            Color colorcito = new Color(80, 80, 80);
                            image.setRGB(i, j, colorcito.getRGB());
                        } else if ((color.getBlue() >= 96) && (color.getBlue() <= 111)) {
                            Color colorcito = new Color(96, 96, 96);
                            image.setRGB(i, j, colorcito.getRGB());
                        } else if ((color.getBlue() >= 112) && (color.getBlue() <= 127)) {
                            Color colorcito = new Color(112, 112, 112);
                            image.setRGB(i, j, colorcito.getRGB());
                        } else if ((color.getBlue() >= 128) && (color.getBlue() <= 143)) {
                            Color colorcito = new Color(128, 128, 128);
                            image.setRGB(i, j, colorcito.getRGB());
                        } else if ((color.getBlue() >= 144) && (color.getBlue() <= 159)) {
                            Color colorcito = new Color(144, 144, 144);
                            image.setRGB(i, j, colorcito.getRGB());
                        } else if ((color.getBlue() >= 160) && (color.getBlue() <= 175)) {
                            Color colorcito = new Color(160, 160, 160);
                            image.setRGB(i, j, colorcito.getRGB());
                        } else if ((color.getBlue() >= 176) && (color.getBlue() <= 191)) {
                            Color colorcito = new Color(176, 176, 176);
                            image.setRGB(i, j, colorcito.getRGB());
                        } else if ((color.getBlue() >= 192) && (color.getBlue() <= 207)) {
                            Color colorcito = new Color(192, 192, 192);
                            image.setRGB(i, j, colorcito.getRGB());
                        } else if ((color.getBlue() >= 208) && (color.getBlue() <= 223)) {
                            Color colorcito = new Color(208, 208, 208);
                            image.setRGB(i, j, colorcito.getRGB());
                        } else if ((color.getBlue() >= 224) && (color.getBlue() <= 239)) {
                            Color colorcito = new Color(224, 224, 224);
                            image.setRGB(i, j, colorcito.getRGB());
                        } else {
                            Color colorcito = new Color(240, 240, 240);
                            image.setRGB(i, j, colorcito.getRGB());
                        }
                    }
                }
                ImageIO.write(image, "jpg", new File("C:\\Users\\DELL\\Desktop\\Profundidas8bit.jpg"));
                System.out.println("Listo imagen transformada a profundidad de 8 bit, se guardo como Profundidas8bit.jpg");
                break;
            default:
                System.out.println("Fuera de rango");
                break;
        }
    }

}
