package day01;

import utils.Utils;

import java.io.FileNotFoundException;
import java.util.List;

public class Day01 {

    private static int part1(List<Integer> input) {
        int count = 0;
        for(int i = 1; i < input.size(); i++)
            if(input.get(i) > input.get(i - 1)) count++;
        return count;
    }

    private static int part2(List<Integer> input) {
        int count = 0;
        int previousSum = -1;
        for(int i = 0; i < input.size(); i++) {
            if(i+2 < input.size()) {
                int nextSum = input.get(i)+ input.get(i+1)+input.get(i+2);
                if(previousSum != -1 && previousSum < nextSum) {
                    count++;
                }
                previousSum = nextSum;
            }
        }
        return count;
    }


    public static void main(String ...args) {
        List<Integer> input01 = Utils.parseInput("day1_input1.txt");

        System.out.println(part1(input01));
        System.out.println(part2(input01));
    }
}
