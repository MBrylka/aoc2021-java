package day02;

import utils.Utils;

import java.util.ArrayList;
import java.util.List;

class Command {
    public String command;
    public int value;

    public Command(String cmd, int val) {
        command = cmd;
        value = val;
    }
}

public class Day2 {


    public static void main(String ...args) {
        List<String> inputString = Utils.parseInput("day2_input1.txt");
        List<Command> commandList = createCommands(inputString);

        System.out.println(result(commandList, true));
        System.out.println(result(commandList, false));
    }

    private static int result(List<Command> commandList, boolean part1) {
        int position = 0;
        int aim = 0;
        int depth = 0;

        for(Command cmd: commandList) {
            switch (cmd.command) {
                case "forward":
                    position += cmd.value;
                    depth += cmd.value * aim;
                    break;
                case "up":
                    aim -= cmd.value;
                    break;
                case "down":
                    aim += cmd.value;
                    break;
            }
        }

        return part1 ? position * aim : position * depth;
    }

    private static List<Command> createCommands(List<String> inputString) {
        List<Command> commands = new ArrayList<>();

        for(String line: inputString) {
            String[] split = line.split(" ");
            Command cmd = new Command(split[0], Integer.parseInt(split[1]));

            commands.add(cmd);
        }

        return commands;
    }
}
