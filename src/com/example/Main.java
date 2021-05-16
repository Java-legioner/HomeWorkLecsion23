package com.example;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IllegalAccessException {

        VerhovnaRada verhovnaRada = VerhovnaRada.getInstance();

        boolean exit = false;
        while (!exit) {
            System.out.println(
                    "Выберете пункт меню:" + "\n"
                            + "1. Додати фракцію" + "\n"
                            + "2. Вдалити фракцію" + "\n"
                            + "3. Вивести список фракцій" + "\n"
                            + "4. Очистити фракцію" + "\n"
                            + "5. Вивести фракцію на екран" + "\n"
                            + "6. Додати депутата до фракції" + "\n"
                            + "7. Видалити депутата з фракції" + "\n"
                            + "8. Список хабарників" + "\n"
                            + "9. Вивести найбільшого хабарника" + "\n"
                            + "10. Вихід" + "\n"
            );

            Scanner sc = new Scanner(System.in);
            int menuInput = sc.nextInt();
            if (menuInput == 1) {
                verhovnaRada.addFaction();
            } else if (menuInput == 2) {
                verhovnaRada.removeFaction();
            } else if (menuInput == 3) {
                verhovnaRada.allFaction();
            } else if (menuInput == 4) {
                verhovnaRada.removeAllDeputiesFromFaction();
            } else if (menuInput == 5) {
                verhovnaRada.displayFaction();
            } else if (menuInput == 6) {
                verhovnaRada.addDeputyInFaction();
            } else if (menuInput == 7) {
                verhovnaRada.removeDeputyFromFaction();
            } else if (menuInput == 8) {
                verhovnaRada.allGrafterInFaction();
            } else if (menuInput == 9) {
                verhovnaRada.bigGrafterInFaction();
            } else if (menuInput == 10) {
                exit = true;
            }
        }
    }
}

