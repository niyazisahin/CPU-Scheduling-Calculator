package com.company;

import java.util.Scanner;
import static java.util.Arrays.sort;
import java.util.*;

public class Main {




    public static void FCFS(int[][] prosesler, int proses_sayisi){

        double ort_bekleme = 0, ort_donus = 0;
        int[] varis_zamanlari = new int[proses_sayisi]; //2 boyutlu prosesler arrayinin varış zamanlarını tutacak array.
        int[] bekleme_zamanlari = new int[proses_sayisi]; //2 boyutlu prosesler arrayinin bekleme zamanlarını tutacak array.
        int[] patlama_zamanlari = new int[proses_sayisi]; //2 boyutlu prosesler arrayinin patlama zamanlarını tutacak array.

        int[] donus_zamanlari = new int[proses_sayisi]; //2 boyutlu prosesler arrayinin donus zamanlarını tutacak array.


        Arrays.sort(prosesler, (b, a) -> Integer.compare(b[0], a[0])); // Varış zamanlarına göre diziyi sıralar.

     /*   for (int i = 0; i< proses_sayisi; i++){
            for (int j = 0; j<2; j++){
                System.out.println(prosesler[i][j] + "   ");
            }
            System.out.println();
        }*/


        //Varış zamanlarını yeni arraye aktarma.
        for (int i = 0; i<proses_sayisi; i++){
            varis_zamanlari[i] = prosesler[i][0];
        }

        //Patlama zamanlarını yeni arraye aktarma.
        for (int i = 0; i<proses_sayisi; i++){
            patlama_zamanlari[i] = prosesler[i][1];
        }

        //Bekleme zamanlarının hesaplanması.
        for (int i = 1; i< proses_sayisi; i++){
            bekleme_zamanlari[i] = patlama_zamanlari[i-1] + bekleme_zamanlari[i-1];
        }

        //Donus zamanlarının hesaplanması.
        for (int i = 0; i< proses_sayisi; i++){
            donus_zamanlari[i] = patlama_zamanlari[i] + bekleme_zamanlari[i];
        }

        //Tablo halinde ekrana bastırma.
        System.out.println("Proses    Varis zamanı     Patlama zamanı      Bekleme zamanı      Donus zamanı");
        for (int i = 0; i<proses_sayisi; i++){
            System.out.print((i+1) + "                ");
            for (int j = 0; j<2; j++){
                System.out.print(prosesler[i][j] + "                ");
            }
            System.out.print(bekleme_zamanlari[i] + "                 ");
            System.out.print(donus_zamanlari[i] + "                  ");
            ort_donus += donus_zamanlari[i]; // donus sürelerinin toplanması işlemi.
            ort_bekleme += bekleme_zamanlari[i]; // bekleme sürelerinin toplanması işlemi.
            System.out.println();
        }
        ort_bekleme = ort_bekleme/3; // Ortalama bekleme sürelerinin hesaplanması.
        System.out.println("Ortalama Bekleme Süresi : " + ort_bekleme);

        ort_donus = ort_donus/3; // Ortalama donus sürelerinin hesaplanması.
        System.out.println("Ortalama Donus Süresi : " + ort_donus);
    }

    public static void SJP_NP(int[][] prosesler, int proses_sayisi){
        //2
    }

    public static void SJP_P(int[][] prosesler, int proses_sayisi){
        //3
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println(" Lütfen Proses Sayısını Giriniz : ");

        int proses_sayisi = scanner.nextInt();
        int varis_zamani;
        int patlama_zamani;

        int[][] prosesler = new int[proses_sayisi][2];//Prosesleri tutacak olan dizi.

        System.out.println(proses_sayisi + " Adet prosesin istenilen değerlerini sırası ile giriniz : ");

        //Proseslerin sırasıyla verileri alınıyor.
        for (int i = 0; i<proses_sayisi ; i++){
            System.out.println((i+1) + ". Proses için : ");
            for (int j = 0; j<2; j++){

                if(j == 0 ){ // 0. indis varis zamani.
                    System.out.println("Varış zamanını giriniz : ");
                    prosesler[i][j] = scanner.nextInt();
                }
                else{ // indis 0 değilse patlama zamani.
                    System.out.println("Patlama zamanını giriniz : ");
                    prosesler[i][j] = scanner.nextInt();
                }
            }
        }

        FCFS(prosesler, proses_sayisi);
        SJP_NP(prosesler, proses_sayisi);
        SJP_P(prosesler, proses_sayisi);

    }
}
