package com.company;

import java.util.Scanner;

import static java.util.Arrays.sort;

import java.util.*;

public class Main {

    public static void FCFS(int[][] prosesler, int proses_sayisi) {

        double ort_bekleme = 0, ort_donus = 0;
        int[] varis_zamanlari = new int[proses_sayisi]; //2 boyutlu prosesler arrayinin varış zamanlarını tutacak array.
        int[] bekleme_zamanlari = new int[proses_sayisi]; //2 boyutlu prosesler arrayinin bekleme zamanlarını tutacak array.
        int[] patlama_zamanlari = new int[proses_sayisi]; //2 boyutlu prosesler arrayinin patlama zamanlarını tutacak array.

        int[] donus_zamanlari = new int[proses_sayisi]; //2 boyutlu prosesler arrayinin donus zamanlarını tutacak array.

        //Matrisi varis degerlerine göre sıralamak icin.
        Arrays.sort(prosesler, new Comparator<int[]>() {
            @Override
            public int compare(final int[] giris1,
                               final int[] giris2) {

                if (giris1[1] > giris2[1])
                    return 1;
                else
                    return -1;
            }
        });

        //Varış zamanlarını yeni arraye aktarma.
        for (int i = 0; i < proses_sayisi; i++) {
            varis_zamanlari[i] = prosesler[i][1];
        }

        //Patlama zamanlarını yeni arraye aktarma.
        for (int i = 0; i < proses_sayisi; i++) {
            patlama_zamanlari[i] = prosesler[i][2];
        }

        //Bekleme zamanlarının hesaplanması.
        for (int i = 1; i < proses_sayisi; i++) {
            bekleme_zamanlari[i] = patlama_zamanlari[i - 1] + bekleme_zamanlari[i - 1];
        }

        //Donus zamanlarının hesaplanması.
        for (int i = 0; i < proses_sayisi; i++) {
            donus_zamanlari[i] = patlama_zamanlari[i] + bekleme_zamanlari[i];
        }

        //Tablo halinde ekrana bastırma.
        System.out.println("Proses ID    Varis zamanı     Patlama zamanı      Bekleme zamanı      Donus zamanı");
        for (int i = 0; i < proses_sayisi; i++) {
            System.out.print(prosesler[i][0] + "                ");
            for (int j = 1; j < 3; j++) {
                System.out.print(prosesler[i][j] + "                ");
            }
            System.out.print(bekleme_zamanlari[i] + "                 ");
            System.out.print(donus_zamanlari[i] + "                  ");
            ort_donus += donus_zamanlari[i]; // donus sürelerinin toplanması işlemi.
            ort_bekleme += bekleme_zamanlari[i]; // bekleme sürelerinin toplanması işlemi.
            System.out.println();
        }
        ort_bekleme = ort_bekleme / proses_sayisi; // Ortalama bekleme sürelerinin hesaplanması.
        System.out.println("Ortalama Bekleme Süresi : " + ort_bekleme);

        ort_donus = ort_donus / proses_sayisi; // Ortalama donus sürelerinin hesaplanması.
        System.out.println("Ortalama Donus Süresi : " + ort_donus);
    }

    public static void SJF_NP(int[][] prosesler, int proses_sayisi) {

        double bekleme_suresi = 0;
        double ort_donus = 0;

        int[] patlama_zamanlari = new int[proses_sayisi]; //2 boyutlu prosesler arrayinin patlama zamanlarını tutacak array.
        int[] bekleme_zamanlari = new int[proses_sayisi]; //2 boyutlu prosesler arrayinin bekleme zamanlarını tutacak array.
        int[] donus_zamanlari = new int[proses_sayisi]; //2 boyutlu prosesler arrayinin bekleme zamanlarını tutacak array.

        //Matrisi patlama zamani degerlerine göre sıralamak icin.
        Arrays.sort(prosesler, new Comparator<int[]>() {
            @Override
            public int compare(final int[] giris1,
                               final int[] giris2) {

                if (giris1[2] > giris2[2])
                    return 1;
                else
                    return -1;
            }
        });

        //Patlama zamanlarını yeni arraye aktarma.
        for (int i = 0; i < proses_sayisi; i++) {
            patlama_zamanlari[i] = prosesler[i][2];
        }

        //Bekleme zamanlarının hesaplanması.
        for (int i = 1; i < proses_sayisi; i++) {
            bekleme_zamanlari[i] = patlama_zamanlari[i - 1] + bekleme_zamanlari[i - 1];
        }

        //Donus zamanlarının hesaplanması.
        for (int i = 0; i < proses_sayisi; i++) {
            donus_zamanlari[i] = patlama_zamanlari[i] + bekleme_zamanlari[i];
        }

        //Tablo halinde ekrana bastırma.
        System.out.println("Proses ID        Patlama zamanı      Bekleme zamanı      Donus zamanı");
        for (int i = 0; i < proses_sayisi; i++) {
            System.out.print(prosesler[i][0] + "                ");
            for (int j = 2; j < 3; j++) {
                System.out.print(prosesler[i][j] + "                       ");
            }
            System.out.print(bekleme_zamanlari[i] + "                     ");
            System.out.print(donus_zamanlari[i] + "                  ");
            ort_donus += donus_zamanlari[i]; // donus sürelerinin toplanması işlemi.
            bekleme_suresi += bekleme_zamanlari[i]; // bekleme sürelerinin toplanması işlemi.
            System.out.println();
        }
        bekleme_suresi = bekleme_suresi / proses_sayisi; // Ortalama bekleme sürelerinin hesaplanması.
        System.out.println("Ortalama Bekleme Süresi : " + bekleme_suresi);

        ort_donus = ort_donus / proses_sayisi; // Ortalama donus sürelerinin hesaplanması.
        System.out.println("Ortalama Donus Süresi : " + ort_donus);
        }

    public static void SJF_P(int[][] prosesler, int proses_sayisi) {
        //3
    }


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println(" Lütfen Proses Sayısını Giriniz : ");

        int proses_sayisi = scanner.nextInt();
        int varis_zamani;
        int patlama_zamani;

        int[][] prosesler = new int[proses_sayisi][3];//Prosesleri tutacak olan dizi.

        System.out.println(proses_sayisi + " Adet prosesin istenilen değerlerini sırası ile giriniz : ");

        //Proseslerin sırasıyla verileri alınıyor.
        for (int i = 0; i < proses_sayisi; i++) {
            System.out.println((i + 1) + ". Proses için : ");
            for (int j = 0; j < 3; j++) {

                if (j == 0) {
                    prosesler[i][j] = i; // Proseslerin ID sinin 0. indiste tutulması.
                }
                if (j == 1) { // 1. indis varis zamani.
                    System.out.println("Varış zamanını giriniz : ");
                    prosesler[i][j] = scanner.nextInt();
                }
                if (j == 2) { // 2. indis patlama zamani.
                    System.out.println("Patlama zamanını giriniz : ");
                    prosesler[i][j] = scanner.nextInt();
                }
            }
        }

        //FCFS(prosesler, proses_sayisi);
        SJF_NP(prosesler, proses_sayisi);
        SJF_P(prosesler, proses_sayisi);

    }
}
