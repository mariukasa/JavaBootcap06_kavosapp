package com.company;

import com.company.maker.CoffeMaker;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Main obj = new Main();
        obj.dirbam();
    }

    private void showMenu() {
        System.out.println("0 - baigti darba");
        System.out.println("1 - gaminti kava");
        System.out.println("2 - rodyti aparato busena");
        System.out.println("3 - plauti aparata");
        System.out.println("4 - pildyti produktus");
    }

    private void dirbam() {
        CoffeMaker aparatas = new CoffeMaker();
        Scanner sc = new Scanner(System.in);
        boolean arTesti = true;
        do {
            showMenu();
            int pasirinkimas = sc.nextInt();
            switch (pasirinkimas) {
                case 0:
                    arTesti = false;
                    break;
                case 1:
                    System.out.println("Parasykite kokios kavos norite\nblack\nlatte\nespresso");
                    String kava;
                    do {
                    kava= sc.nextLine();}
                  //  if("black".equals(kava)) aparatas.makeCoffe("black");
                  //  if("latte".equals(kava)) aparatas.makeCoffe("latte");
                  //  if("black".equals(kava)) aparatas.makeCoffe("espresso");}
                while(!"black".equals(kava) &&!"latte".equals(kava) &&!"espresso".equals(kava));
                    aparatas.makeCoffe(kava);
                    break;
                case 2:
                    aparatas.showStatus();
                    break;
                case 3:
                    aparatas.washMaker();
                    break;
                case 4:
                    Float [] papildymas = new Float[3];
                    for (int i = 0; i <papildymas.length ; i++) {
                        if(i==0) System.out.println("Iveskite vandens kieki");
                        if(i==1) System.out.println("Iveskite cukraus kieki");
                        if(i==2) System.out.println("Iveskite pupeliu kieki");
                        papildymas[i]=sc.nextFloat();
                    }
                    aparatas.fillProducts(papildymas);
                    break;

            }

        } while (arTesti);
    }
}
