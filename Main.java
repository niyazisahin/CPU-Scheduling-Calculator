package com.company;

import java.util.Scanner;
import static java.util.Arrays.sort;
import java.util.*;

public class Main {


    public static void FCFS(int[][] prosesler, int proses_sayisi) {

        int[] patlama_zamanlari = new int[proses_sayisi]; //2 boyutlu prosesler arrayinin patlama zamanlarını tutacak array.
        int[] bekleme_zamanlari = new int[proses_sayisi]; //2 boyutlu prosesler arrayinin bekleme zamanlarını tutacak array.
        int[] donus_zamanlari = new int[proses_sayisi]; //2 boyutlu prosesler arrayinin bekleme zamanlarını tutacak array.
        int[] tamamlanma_zamani = new int[proses_sayisi]; //2 boyutlu prosesler arrayinin bekleme zamanlarını tutacak array.

        double ort_bekleme = 0, ort_donus = 0;
        int[] varis_zamanlari = new int[proses_sayisi]; //2 boyutlu prosesler arrayinin varış zamanlarını tutacak array.


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

        // Tamamlanma zamanı hesaplama
        for (int i = 0; i< proses_sayisi; i++){
            tamamlanma_zamani[i] = donus_zamanlari[i] + varis_zamanlari[i];
        }

        //Tablo halinde ekrana bastırma.
        System.out.println("***** FCFS ALGORİTMASI ÇALIŞTIRILIYOR *****");
        System.out.println("Proses ID    Varis zamanı     Patlama zamanı      Bekleme zamanı      Donus zamanı       Tamamlanma zamanı");
        for (int i = 0; i < proses_sayisi; i++) {
            System.out.print(prosesler[i][0] + "                ");
            for (int j = 1; j < 3; j++) {
                System.out.print(prosesler[i][j] + "                ");
            }
            System.out.print(bekleme_zamanlari[i] + "                 ");
            System.out.print(donus_zamanlari[i] + "                  ");
            System.out.print(tamamlanma_zamani[i] + "                  ");
            ort_donus += donus_zamanlari[i]; // donus sürelerinin toplanması işlemi.
            ort_bekleme += bekleme_zamanlari[i]; // bekleme sürelerinin toplanması işlemi.
            System.out.println();
        }
        ort_bekleme = ort_bekleme / proses_sayisi; // Ortalama bekleme sürelerinin hesaplanması.
        System.out.println("Ortalama Bekleme Süresi : " + ort_bekleme);

        ort_donus = ort_donus / proses_sayisi; // Ortalama donus sürelerinin hesaplanması.
        System.out.println("Ortalama Donus Süresi : " + ort_donus);
        System.out.println("----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- -----");
    }

    public static void SJF_NP(int[][] prosesler, int proses_sayisi) {

        int[] patlama_zamanlari = new int[proses_sayisi]; //2 boyutlu prosesler arrayinin patlama zamanlarını tutacak array.
        int[] bekleme_zamanlari = new int[proses_sayisi]; //2 boyutlu prosesler arrayinin bekleme zamanlarını tutacak array.
        int[] donus_zamanlari = new int[proses_sayisi]; //2 boyutlu prosesler arrayinin bekleme zamanlarını tutacak array.
        int[] tamamlanma_zamani = new int[proses_sayisi]; //2 boyutlu prosesler arrayinin bekleme zamanlarını tutacak array.
        int[] varis_zamanlari = new int[proses_sayisi]; //2 boyutlu prosesler arrayinin bekleme zamanlarını tutacak array.

        double bekleme_suresi = 0;
        double ort_donus = 0;

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

        //Varış zamanlarını yeni arraye aktarma.
        for (int i = 0; i < proses_sayisi; i++) {
            varis_zamanlari[i] = prosesler[i][1];
        }

        //Bekleme zamanlarının hesaplanması.
        for (int i = 1; i < proses_sayisi; i++) {
            bekleme_zamanlari[i] = patlama_zamanlari[i - 1] + bekleme_zamanlari[i - 1];
        }

        //Donus zamanlarının hesaplanması.
        for (int i = 0; i < proses_sayisi; i++) {
            donus_zamanlari[i] = patlama_zamanlari[i] + bekleme_zamanlari[i];
        }

        // Tamamlanma zamanı hesaplama
        for (int i = 0; i< proses_sayisi; i++){
            tamamlanma_zamani[i] = donus_zamanlari[i] + varis_zamanlari[i];
        }

        //Tablo halinde ekrana bastırma.
        System.out.println("***** SJF-NP ALGORİTMASI ÇALIŞTIRILIYOR *****");
        System.out.println("Proses ID        Patlama zamanı      Bekleme zamanı      Donus zamanı      Tamamlanma zamanı");
        for (int i = 0; i < proses_sayisi; i++) {
            System.out.print(prosesler[i][0] + "                ");
            for (int j = 2; j < 3; j++) {
                System.out.print(prosesler[i][j] + "                       ");
            }
            System.out.print(bekleme_zamanlari[i] + "                     ");
            System.out.print(donus_zamanlari[i] + "                  ");
            System.out.print(tamamlanma_zamani[i] + "                  ");
            ort_donus += donus_zamanlari[i]; // donus sürelerinin toplanması işlemi.
            bekleme_suresi += bekleme_zamanlari[i]; // bekleme sürelerinin toplanması işlemi.
            System.out.println();
        }
        bekleme_suresi = bekleme_suresi / proses_sayisi; // Ortalama bekleme sürelerinin hesaplanması.
        System.out.println("Ortalama Bekleme Süresi : " + bekleme_suresi);

        ort_donus = ort_donus / proses_sayisi; // Ortalama donus sürelerinin hesaplanması.
        System.out.println("Ortalama Donus Süresi : " + ort_donus);
        System.out.println("----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- -----");
    }

    public static void SJF_P(int[][] prosesler, int proses_sayisi) {


        int[] tamamlanma_zamani = new int[proses_sayisi]; //2 boyutlu prosesler arrayinin bekleme zamanlarını tutacak array.

        int[] bekleme_zamani = new int[proses_sayisi];
        int[] donus_zamani = new int[proses_sayisi];

        int bitis_kontrol = 0;
        int sayac = 0;
        int min = Integer.MAX_VALUE;
        int en_kucuk = 0; //Algoritma için patlama zamanlarinda kullanilacak degisken.
        int bitis;
        boolean flag = false;
        int patlama_zamanlari[] = new int[proses_sayisi]; // Patlama zamanlarinin yeni diziye alınması icin olusturulan yeni dizi.

        // Ortalamayı tutacak degiskenler
        double ort_donus = 0;
        double ort_bekleme = 0;

        // Patlama zamanlarının yeni diziye alınması
        for (int i = 0; i < proses_sayisi; i++)
            patlama_zamanlari[i] = prosesler[i][2];

        while (bitis_kontrol != proses_sayisi) { //Prosesler bitene kadar dön.

            for (int j = 0; j < proses_sayisi; j++) {
                if ((prosesler[j][1] <= sayac) &&
                        (patlama_zamanlari[j] < min) && patlama_zamanlari[j] > 0) {
                    min = patlama_zamanlari[j];
                    en_kucuk = j;
                    flag = true;
                }
            }
            if (flag == false) {
                sayac++;
                continue;
            }
            patlama_zamanlari[en_kucuk]--;

            min = patlama_zamanlari[en_kucuk];
            if (min == 0)
                min = Integer.MAX_VALUE;

            if (patlama_zamanlari[en_kucuk] == 0) {

                bitis_kontrol++;
                flag = false;

                bitis = sayac + 1;

                // Bekleme zamanının hesaplanması.
                bekleme_zamani[en_kucuk] = bitis -
                        prosesler[en_kucuk][2] -
                        prosesler[en_kucuk][1];

                if (bekleme_zamani[en_kucuk] < 0)
                    bekleme_zamani[en_kucuk] = 0;
            }
            sayac++;
        }

        // Donus zamanlarının hesaplanması
        for (int i = 0; i < proses_sayisi; i++) {
            donus_zamani[i] = prosesler[i][2] + bekleme_zamani[i];
        }

        // Tamamlanma zamanı hesaplama
        for (int i = 0; i< proses_sayisi; i++){
            tamamlanma_zamani[i] = donus_zamani[i] + prosesler[i][1];
        }

        //Tablo halinde ekrana bastırma.
        System.out.println("***** SJF-P ALGORİTMASI ÇALIŞTIRILIYOR *****");
        System.out.println("Proses ID    Varis zamanı     Patlama zamanı      Bekleme zamanı      Donus zamanı      Tamamlanma zamanı");
        for (int i = 0; i < proses_sayisi; i++) {
            System.out.print(prosesler[i][0] + "                ");
            for (int j = 1; j < 3; j++) {
                System.out.print(prosesler[i][j] + "                ");
            }
            System.out.print(bekleme_zamani[i] + "                 ");
            System.out.print(donus_zamani[i] + "                  ");
            System.out.print(tamamlanma_zamani[i] + "                  ");
            ort_donus += donus_zamani[i]; // donus sürelerinin toplanması işlemi.
            ort_bekleme += bekleme_zamani[i]; // bekleme sürelerinin toplanması işlemi.
            System.out.println();
        }
        ort_bekleme = ort_bekleme / proses_sayisi; // Ortalama bekleme sürelerinin hesaplanması.
        System.out.println("Ortalama Bekleme Süresi : " + ort_bekleme);

        ort_donus = ort_donus / proses_sayisi; // Ortalama donus sürelerinin hesaplanması.
        System.out.println("Ortalama Donus Süresi : " + ort_donus);
        System.out.println("----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- -----");

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
        FCFS(prosesler, proses_sayisi);
        SJF_NP(prosesler, proses_sayisi);
        SJF_P(prosesler, proses_sayisi);

    }
}
