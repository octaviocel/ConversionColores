/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imagergb;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author DELL
 */
public class Main {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        System.out.println("Bienvenido a la Conversión de Color");
        System.out.println("-----------------------------------");
        System.out.println("----------------Menu---------------");
        int d = 0;
        do {
            System.out.println("[1] Convertir RGN to CMYK");
            System.out.println("[2] Profundidad de imagen");
            System.out.println("[3] Quitar Color a una sección");
            System.out.println("[4] Salir");
            System.out.println("\nSelcciona una");
            d = sc.nextInt();
            if (d != 4) {
                System.out.println("\nEscribe el nombre con extensión");
                String ruta = sc.next();
                ConversionColor imagen = new ConversionColor("C:\\Users\\DELL\\Desktop\\" + ruta);
                if (d == 1) {
                    System.out.println("Cargando...");
                    imagen.RGBToCMYK();
                }
                if (d == 2) {
                    System.out.println("Selecciona el nivel en bits de profundidad \n[1]\n[2]\n[4]\n[8]\n");
                    int s;
                    do {
                        s = sc.nextInt();
                        if (s != 1 && s != 2 && s != 4 && s != 8) {
                            System.out.println("Error seleciona un numero dentro del parametro");
                        }
                    } while (s != 1 && s != 2 && s != 4 && s != 8);
                    System.out.println("Cargando...");
                    imagen.profundidad(s);
                }
                if (d == 3) {
                    System.out.println("Selecciona un color del RGB [1]Red [2]Green [3]Blue");
                    int s;
                    do {
                        s = sc.nextInt();
                        if (s != 1 && s != 2 && s != 3) {
                            System.out.println("Error digita un numero dentro del parametro");
                        }
                    } while (s != 1 && s != 2 && s != 3);
                    System.out.println("Selecciona el limite inferior");
                    int limiteInf;
                    do{
                        limiteInf= sc.nextInt();
                        if (limiteInf<0 || limiteInf>254) {
                            System.out.println("Error digita un numero dentro del parametro 0-254");
                        }
                    }while(limiteInf<0 || limiteInf>254);
                    System.out.println("Selecciona el limite Superior");
                    int limiteSup;
                    do{
                        limiteSup= sc.nextInt();
                        if (limiteSup<limiteInf || limiteInf>255) {
                            System.out.println("Error digita un numero dentro del parametro 0-254");
                        }
                    }while(limiteSup<limiteInf || limiteInf>255);
                    System.out.println("Cargando...");
                    imagen.eliminaColor(s, limiteInf, limiteSup);
                }
            }
        } while (d < 4);
    }
}
