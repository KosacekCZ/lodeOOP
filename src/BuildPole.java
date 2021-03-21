public class BuildPole {
    public static void buildPole() {
        int size = 10; //vyska i sirka, pole ma byt ctvercove
        // construct pole 1

        String[][] battlefield = new String[size][size];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                battlefield[j][i] = "0";
            }
        }

        // construct pole 2

        String[][] battlefield2 = new String[size][size];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                battlefield2[j][i] = "0";
            }
        }

        // viditelné pole AI

        String[][] battlefield3 = new String[size][size];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                battlefield3[j][i] = "0";
            }
        }
    }
}
