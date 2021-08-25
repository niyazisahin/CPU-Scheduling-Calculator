package com.company;

import java.util.Scanner;

public class Main {

    public static void FCFS(int[][] prosesler, int proses_sayisi){

        System.out.println("Proses    Varis zamanı     Patlama zamanı");
        for (int i = 0; i<proses_sayisi; i++){
            System.out.print((i+1) + "                ");
            for (int j = 0; j<2; j++){
                System.out.print(prosesler[i][j] + "                    ");
            }
            System.out.println();
        }

        double ort_bekleme, ort_donus;
    }

    public static void SJP_NP(int[][] prosesler, int proses_sayisi){
        //2
    }

    public static void SJP_P(int[][] prosesler, int proses_sayisi){
        //3
        //Kontrol mekanizması için prosesleri ve verilerini ekrana bastırma. Kod en son düzenlenirken silinecek.
  /*      for(int i = 0; i<proses_sayisi; i++){
            System.out.println((i+1) + ". Prosesin");
            for(int j = 0; j<2; j++){

                if(j == 0){
                    System.out.println("Varis zamani : " + prosesler[i][j]);
                }else{
                    System.out.println("patlama zamani : " + prosesler[i][j]);
                }
            }
        }*/
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
