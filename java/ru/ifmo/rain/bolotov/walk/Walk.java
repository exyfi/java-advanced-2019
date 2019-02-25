package ru.ifmo.rain.bolotov.walk;


public class Walk {
    public static void main(String[] args) {

        try {
            if (args == null || args.length != 2 || args[0] == null || args[1] == null) {
                throw new WalkerException("Incorrect input. Try again, write data in this format: <input file> <output file>");
            }
            Walker walker = new Walker(args[0], args[1]);
            walker.walk();


        } catch (WalkerException e) {
            System.err.println(e + ". Please write correct input file and output file and try again.");
        }

    }


}

