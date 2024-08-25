package ru.shiftcft.app.console;

public class ConsoleCommandParser {

    public ConsoleCommand commandConstruct(String... args) {
        for (int i = 0; i < args.length; i++) {
            Command command = command(args[i]);
            if(command != null) {
                if (command.parameterExist() && ((i + 1) < args.length)) {
                    if(command.paramIsCorrect(args[i+1])) {
                        command.addCommand(args[++i]);
                    }
                } else {
                    command.addCommand("");
                }
            } else {
                Command.DEFAULT.addCommand(args[i]);
            }
        }
        return Command.getCommands();
    }

    private Command command(String name) {
        for (Command command : Command.values()) {
            if(command.getName().equals(name)) return command;
        }
        return null;
    }
}
