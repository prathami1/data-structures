import java.io.*;

public class GuitarHero {

    public static void main(String[] args) {
        GuitarHero app = new GuitarHero();
    }

    public GuitarHero() {
        File filename = new File("GuitarInput.txt");

        try {
            BufferedReader input = new BufferedReader(new FileReader(filename));
            String text;

            String[][] Arrangement = { { "E", "A", "D", "G", "B", "E" }, { "F", "A#", "D#", "G#", "C", "F" },
                    { "F#", "B", "E", "A", "C#", "F#" }, { "G", "C", "F", "A#", "D", "G" },
                    { "G#", "C#", "F#", "B", "D#", "G#" } };

            int row = 0;
            String[][] grid = null;
            while ((text = input.readLine()) != null) {

                String[] measures = text.split(",");

                if (grid == null) {
                    grid = new String[Arrangement.length * Arrangement[0].length + 1][measures.length + 1];

                    grid[0][0] = "Measure";
                    int count = 1;
                    String previousArrangement = "";

                    for (int j = 5; j >= 0; j--) {
                        for (int i = 4; i >= 0; i--) {
                            if (Arrangement[i][j] != previousArrangement) {
                                grid[count][0] = Arrangement[i][j];
                                previousArrangement = Arrangement[i][j];
                                count++;
                            }
                        }
                    }
                }

                for (int i = 0; i < measures.length; i++) {
                    for (int j = 0; j < measures[i].length(); j++) {
                        String test = Character.toString(measures[i].charAt(j));
                        int index = ((Arrangement[0].length - j - 1) * Arrangement.length) + (Arrangement.length - row);
                        if ((test.equals("o") || test.equals("*")) && index <= 10) {
                            grid[index][i + 1] = "O";
                        } else if ((test.equals("o") || test.equals("*")) && index > 10) {
                            grid[index - 1][i + 1] = "O";
                        }
                    }
                }
                row++;
            }
            for (int i = 1; i < grid[0].length; i++) {
                grid[0][i] = Integer.toString(i);
            }
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] != null)
                        System.out.print(grid[i][j] + "\t");
                    else
                        System.out.print("\t");
                }
                System.out.println();
            }

        } catch (IOException e) {

        }
    }
}