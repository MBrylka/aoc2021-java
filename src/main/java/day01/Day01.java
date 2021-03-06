package day01;

import utils.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

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
                int nextSum = IntStream.range(i, i+3).map(input::get).sum();
                if(previousSum != -1 && previousSum < nextSum) {
                    count++;
                }
                previousSum = nextSum;
            }
        }
        return count;
    }


    public static void main(String ...args) {
        List<String> inputString = Utils.parseInput("day1_input1.txt");
        List<Integer> input = new ArrayList<>();

        for(String line: inputString) {
            input.add(Integer.parseInt(line));
        }

        System.out.println(part1(input));
        System.out.println(part2(input));
    }
}
