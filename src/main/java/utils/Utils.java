package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Utils {


    public static List<Integer> parseInput(String filename){
        List<Integer> values = new ArrayList<>();

        File file = new File("inputs\\"+filename);
        Scanner sc = null;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while(true) {
            assert sc != null;
            if (!sc.hasNextLine()) break;
            String line = sc.nextLine();
            line = line.replace("\n", "");

            values.add(Integer.parseInt(line));
        }

        return values;
    }
}
