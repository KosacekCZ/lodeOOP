import java.util.Scanner;

import static java.lang.Thread.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Pole p = new Pole();
        ColorsANSI c = new ColorsANSI();

        // construct pole 1

        String[][] battlefield = new String[p.size][p.size];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                battlefield[j][i] = "0";
            }
        }

        // construct pole 2

        String[][] battlefield2 = new String[p.size][p.size];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                battlefield2[j][i] = "0";
            }
        }

        // viditelné pole AI

        String[][] battlefield3 = new String[p.size][p.size];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                battlefield3[j][i] = "0";
            }
        }

        //umisteni lodi

        int cruiserCount = 0;
        int destroyerCount = 0;
        int boatCount = 0;
        int rMin = 0;
        int rMax = p.size - 1;
        int randomX;
        int randomY;
        int rozsah = rMax - rMin + 1;
        int randomR;
        boolean orientace; //false = up, true = horizontal
        int shipSize;
        int px;
        int py;
        String rot = "";
        int sc;
        boolean alive = true;


        while (cruiserCount < 2) {
            shipSize = 5;
            // orientace

            randomR = (int) (Math.random() * rozsah) + rMin;
            if (randomR % 2 == 0) {
                orientace = true;
            } else {
                orientace = false;
            }

            randomX = (int) (Math.random() * rozsah) + rMin;
            randomY = (int) (Math.random() * rozsah) + rMin;
            //System.out.println("x & y: " + randomX + " " + randomY);
            //System.out.println("orientace: " + orientace);

            // clarity


            // spawn a fieldcheck

            if (orientace == true) {

                if (battlefield[randomX][randomY] == "0" && randomX + 4 < 10) {
                    for (int i = 0; i < shipSize; i++) {
                        battlefield[randomX + i][randomY] = c.ANSI_RED + "3" + c.ANSI_RESET;
                    }
                    cruiserCount++;
                    System.out.println("Spawn Cruiser");
                }
            }

            if (orientace == false) {
                if (orientace == false) {
                    if (battlefield[randomX][randomY] == "0" && randomY + 4 < 10) {
                        for (int i = 0; i < shipSize; i++) {
                            battlefield[randomX][randomY + i] = c.ANSI_RED + "3" + c.ANSI_RESET;
                        }
                        cruiserCount++;
                        System.out.println("Spawn Cruiser");
                    } else {
                        //System.out.println("error.reachedMaxInt");
                    }
                }
            }
        }


        while (destroyerCount < 2) {
            shipSize = 4;
            // orientace

            randomR = (int) (Math.random() * rozsah) + rMin;
            if (randomR % 2 == 0) {
                orientace = true;
            } else {
                orientace = false;
            }

            randomX = (int) (Math.random() * rozsah) + rMin;
            randomY = (int) (Math.random() * rozsah) + rMin;
            //System.out.println("x & y: " + randomX + " " + randomY);
            //System.out.println("orientace: " + orientace);

            // spawn a fieldcheck

            if (orientace == true) {
                if (battlefield[randomX][randomY] == "3" && randomX + 3 < 10) {
                    for (int i = 0; i < shipSize; i++) {
                        battlefield[randomX + i][randomY] = c.ANSI_YELLOW + "2" + c.ANSI_RESET;
                    }
                    destroyerCount++;
                    System.out.println("Spawn Destroyer");
                }
            }

            if (orientace == false) {
                if (orientace == false) {
                    if (battlefield[randomX][randomY] == "0" && randomY + 3 < 10) {
                        for (int i = 0; i < shipSize; i++) {
                            battlefield[randomX][randomY + i] = c.ANSI_YELLOW + "2" + c.ANSI_RESET;
                        }
                        destroyerCount++;
                        System.out.println("Spawn Destroyer");
                    } else {
                        //System.out.println("error.reachedMaxInt");
                    }
                }
            }
        }


        while (boatCount < 2) {
            shipSize = 2;
            // orientace

            randomR = (int) (Math.random() * rozsah) + rMin;
            if (randomR % 2 == 0) {
                orientace = true;
            } else {
                orientace = false;
            }

            randomX = (int) (Math.random() * rozsah) + rMin;
            randomY = (int) (Math.random() * rozsah) + rMin;
            //System.out.println("x & y: " + randomX + " " + randomY);
            //System.out.println("orientace: " + orientace);

            // spawn a fieldcheck

            if (orientace == true) {
                if (battlefield[randomX][randomY] == "0" && randomX + 1 < 10) {
                    for (int i = 0; i < shipSize; i++) {
                        battlefield[randomX + i][randomY] = c.ANSI_GREEN + "1" + c.ANSI_RESET;
                    }
                    boatCount++;
                    System.out.println("Spawn Boat");
                }
            }

            if (orientace == false) {
                if (orientace == false) {
                    if (battlefield[randomX][randomY] == "0" && randomY + 1 < 10) {
                        for (int i = 0; i < shipSize; i++) {
                            battlefield[randomX][randomY + i] = c.ANSI_GREEN + "1" + c.ANSI_RESET;
                        }
                        boatCount++;
                        System.out.println("Spawn Boat");
                    } else {
                        //System.out.println("error.reachedMaxInt");
                    }

                }
            }
        }


// print pole
        String pole = "";
        cruiserCount = 0;
        destroyerCount = 0;
        boatCount = 0;

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                pole = pole + battlefield[j][i] + "  ";
            }
            System.out.println(pole);
            pole = "";
        }

        Scanner ui = new Scanner(System.in);

        System.out.println(c.ANSI_PURPLE + "Umístěte svoje lodě." + c.ANSI_RESET);


        while (cruiserCount < 2) {
            sc = cruiserCount + 1;
            System.out.println(c.ANSI_PURPLE + "Cruiser " + c.ANSI_GREEN + "(" + sc + "/2)" + c.ANSI_PURPLE + ", size " + c.ANSI_GREEN + "[5]" + c.ANSI_RESET);
            System.out.println(c.ANSI_PURPLE + "Zadejte rotaci " + c.ANSI_GREEN + "(VERTICAL [V] / HORIZONTAL [H])" + c.ANSI_PURPLE + ":" + c.ANSI_RESET);

            // rotace lodi

            rot = ui.next();
            System.out.println(c.ANSI_PURPLE + "Zadejte " + c.ANSI_GREEN + "[x] " + c.ANSI_PURPLE + "pro spawn:" + c.ANSI_RESET);

            px = ui.nextInt() - 1;

            System.out.println(c.ANSI_PURPLE + "Zadejte " + c.ANSI_GREEN + "[y] " + c.ANSI_PURPLE + "pro spawn:" + c.ANSI_RESET);

            py = ui.nextInt() - 1;

            // spawn lodi

            if (rot.equals("h") || rot.equals("H")) {
                battlefield2[px][py] = c.ANSI_RED + "3" + c.ANSI_RESET;
                for (int i = 0; i < 5; i++) {
                    battlefield2[px + i][py] = c.ANSI_RED + "3" + c.ANSI_RESET;
                }
                cruiserCount++;
            } else if (rot.equals("v") || rot.equals("V")) {
                battlefield2[px][py] = c.ANSI_RED + "3" + c.ANSI_RESET;
                for (int i = 0; i < 5; i++) {
                    battlefield2[px][py + i] = c.ANSI_RED + "3" + c.ANSI_RESET;
                }
                cruiserCount++;
            } else {
                continue;
            }

            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    pole = pole + battlefield2[j][i] + "  ";
                }
                System.out.println(pole);
                pole = "";
            }
        }


        while (destroyerCount < 2) {
            sc = destroyerCount + 1;

            System.out.println(c.ANSI_PURPLE + "Destroyer " + c.ANSI_GREEN + "(" + sc + "/2)" + c.ANSI_PURPLE + ", size " + c.ANSI_GREEN + "[4]" + c.ANSI_RESET);
            System.out.println(c.ANSI_PURPLE + "Zadejte rotaci " + c.ANSI_GREEN + "(VERTICAL [V] / HORIZONTAL [H])" + c.ANSI_PURPLE + ":" + c.ANSI_RESET);

            // rotace lodi

            rot = ui.next();
            System.out.println(c.ANSI_PURPLE + "Zadejte " + c.ANSI_GREEN + "[x] " + c.ANSI_PURPLE + "pro spawn:" + c.ANSI_RESET);

            px = ui.nextInt() - 1;

            System.out.println(c.ANSI_PURPLE + "Zadejte " + c.ANSI_GREEN + "[y] " + c.ANSI_PURPLE + "pro spawn:" + c.ANSI_RESET);

            py = ui.nextInt() - 1;

            // spawn lodi

            if (rot.equals("h") || rot.equals("H")) {
                battlefield2[px][py] = c.ANSI_YELLOW + "2" + c.ANSI_RESET;
                for (int i = 0; i < 4; i++) {
                    battlefield2[px + i][py] = c.ANSI_YELLOW + "2" + c.ANSI_RESET;
                }
                destroyerCount++;
            } else if (rot.equals("v") || rot.equals("V")) {
                battlefield2[px][py] = c.ANSI_YELLOW + "2" + c.ANSI_RESET;
                for (int i = 0; i < 4; i++) {
                    battlefield2[px][py + i] = c.ANSI_YELLOW + "2" + c.ANSI_RESET;
                }
                destroyerCount++;
            } else {
                continue;
            }

            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    pole = pole + battlefield2[j][i] + "  ";
                }
                System.out.println(pole);
                pole = "";
            }
        }


        while (boatCount < 2) {
            sc = boatCount + 1;

            System.out.println(c.ANSI_PURPLE + "Boat " + c.ANSI_GREEN + "(" + sc + "/2)" + c.ANSI_PURPLE + ", size " + c.ANSI_GREEN + "[2]" + c.ANSI_RESET);
            System.out.println(c.ANSI_PURPLE + "Zadejte rotaci " + c.ANSI_GREEN + "(VERTICAL [V] / HORIZONTAL [H])" + c.ANSI_PURPLE + ":" + c.ANSI_RESET);

            // rotace lodi

            rot = ui.next();
            System.out.println(c.ANSI_PURPLE + "Zadejte " + c.ANSI_GREEN + "[x] " + c.ANSI_PURPLE + "pro spawn:" + c.ANSI_RESET);

            px = ui.nextInt() - 1;

            System.out.println(c.ANSI_PURPLE + "Zadejte " + c.ANSI_GREEN + "[y] " + c.ANSI_PURPLE + "pro spawn:" + c.ANSI_RESET);

            py = ui.nextInt() - 1;

            // spawn lodi

            if (rot.equals("h") || rot.equals("H")) {
                battlefield2[px][py] = c.ANSI_GREEN + "1" + c.ANSI_RESET;
                for (int i = 0; i < 2; i++) {
                    battlefield2[px + i][py] = c.ANSI_GREEN + "1" + c.ANSI_RESET;
                }
                boatCount++;
            } else if (rot.equals("v") || rot.equals("V")) {
                battlefield2[px][py] = c.ANSI_GREEN + "1" + c.ANSI_RESET;
                for (int i = 0; i < 2; i++) {
                    battlefield2[px][py + i] = c.ANSI_GREEN + "1" + c.ANSI_RESET;
                }
                boatCount++;
            } else {
                continue;
            }

            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    pole = pole + battlefield2[j][i] + "  ";
                }
                System.out.println(pole);
                pole = "";
            }
        }
        System.out.println("done.");

        // battle

        while (alive == true) {

            // cpu attack

            System.out.println(c.ANSI_PURPLE + "Protihráč útočí..." + c.ANSI_RESET);
            Thread.sleep(2000);

            randomX = (int) (Math.random() * rozsah) + rMin;
            randomY = (int) (Math.random() * rozsah) + rMin;

            if (battlefield2[randomX][randomY].equals("0")) {
                battlefield2[randomX][randomY] = c.ANSI_BLUE + "*" + c.ANSI_RESET;
            } else if (battlefield2[randomX][randomY].equals(c.ANSI_GREEN + "1" + c.ANSI_RESET)) {
                battlefield2[randomX][randomY] = c.ANSI_GREEN + "#" + c.ANSI_RESET;
            } else if (battlefield2[randomX][randomY].equals(c.ANSI_YELLOW + "2" + c.ANSI_RESET)) {
                battlefield2[randomX][randomY] = c.ANSI_YELLOW + "#" + c.ANSI_RESET;
            } else if (battlefield2[randomX][randomY].equals(c.ANSI_RED + "3" + c.ANSI_RESET)) {
                battlefield2[randomX][randomY] = c.ANSI_RED + "#" + c.ANSI_RESET;
            } else if (battlefield2[randomX][randomY].equals("#")) {
                battlefield2[randomX][randomY] = "#" + c.ANSI_RESET;
            } else {
                battlefield2[randomX][randomY] = c.ANSI_BLUE + "*" + c.ANSI_RESET;
            }
            System.out.println(c.ANSI_PURPLE + "Protihráč zasáhl na x =  " + c.ANSI_GREEN + randomX + c.ANSI_PURPLE + " y = " + c.ANSI_GREEN + randomY);

            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    pole = pole + battlefield2[j][i] + "  ";
                }
                System.out.println(pole);
                pole = "";
            }

            // player attack

            System.out.println(c.ANSI_PURPLE + "Zadejte " + c.ANSI_GREEN + "[x] " + c.ANSI_PURPLE + "útoku:" + c.ANSI_RESET);
            px = ui.nextInt() - 1;
            System.out.println(c.ANSI_PURPLE + "Zadejte " + c.ANSI_GREEN + "[y] " + c.ANSI_PURPLE + "útoku:" + c.ANSI_RESET);
            py = ui.nextInt() - 1;

            // chceck na polích cpu

            if (battlefield[px][py].equals("0")) {
                battlefield3[px][py] = c.ANSI_BLUE + "*" + c.ANSI_RESET;
            } else if (battlefield[px][py].equals(c.ANSI_GREEN + "1" + c.ANSI_RESET)) {
                battlefield3[px][py] = c.ANSI_GREEN + "#" + c.ANSI_RESET;
            } else if (battlefield[px][py].equals(c.ANSI_YELLOW + "2" + c.ANSI_RESET)) {
                battlefield3[px][py] = c.ANSI_YELLOW + "#" + c.ANSI_RESET;
            } else if (battlefield[px][py].equals(c.ANSI_RED + "3" + c.ANSI_RESET)) {
                battlefield3[px][py] = c.ANSI_RED + "#" + c.ANSI_RESET;
            } else {
                battlefield3[px][py] = c.ANSI_BLUE + "*" + c.ANSI_RESET;
            }

            for (int k = 0; k < 10; k++) {
                for (int j = 0; j < 10; j++) {
                    pole = pole + battlefield3[j][k] + "  ";
                }
                System.out.println(pole);
                pole = "";
                continue;


            }
        }
    }
}
