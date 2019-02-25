package ru.ifmo.rain.bolotov.walk;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;

class Walker {
    private final Path pathIn;
    private final Path pathOut;


    private static final int FNV_START = 0x811c9dc5;
    private final static int FNV_PRIME = 0x01000193;
    private static final int BUF_SIZE = 4096;
    private byte[] buf = new byte[BUF_SIZE];


    Walker(String input, String output) throws WalkerException {
        try {
            pathIn = Paths.get(input);
        } catch (InvalidPathException e) {
            throw new WalkerException("Incorrect path to the input file: " + e.getMessage());
        }
        try {
            pathOut = Paths.get(output);
        } catch (InvalidPathException e) {
            throw new WalkerException("Incorrect path to the output file: " + e.getMessage());
        }
        if (pathOut.getParent() != null) {
            try {
                Files.createDirectories(pathOut.getParent());
            } catch (IOException e) {
                throw new WalkerException("Can't create directory for output file:" + e.getMessage());
            }
        }
    }


    private int calculateFNVHash(String pathTofile) {
        int hash = FNV_START;


        try (FileInputStream inputStream = new FileInputStream(pathTofile)) {

            int cnt;
            while ((cnt = inputStream.read(buf)) != -1) {
                for (int i = 0; i < cnt; i++) {
                    hash = (hash * FNV_PRIME) ^ (buf[i] & 0xff);
                }
            }
            return hash;
        } catch (IOException e) {
            return 0;
        }

    }


    void walk() throws WalkerException {
        try (BufferedReader reader = Files.newBufferedReader(pathIn)) {
            try (BufferedWriter writer = Files.newBufferedWriter(pathOut)) {
                String pathFiles;

                try {
                    while ((pathFiles = reader.readLine()) != null) {
                        int hashResult = calculateFNVHash(pathFiles);
                        if (hashResult == 0) {
                            writer.write(String.format("%08x %s", 0, pathFiles));
                            writer.newLine();
                        } else {
                            writer.write(String.format("%08x", hashResult) + " " + pathFiles);
                            writer.newLine();


                        }
                    }
                } catch (IOException e) {
                    throw new WalkerException("Error during writing in output file " + e.getMessage());
                }
            } catch (FileNotFoundException e) {
                throw new WalkerException("Can't write to output file: " + e.getMessage());
            } catch (IllegalArgumentException e) {
                throw new WalkerException("Incorrect data format " + e.getMessage());
            } catch (UnsupportedOperationException e) {
                throw new WalkerException("Unsupported operation " + e.getMessage());
            } catch (UnsupportedEncodingException e) {
                throw new WalkerException("Unsupported encoding " + e.getMessage());
            } catch (SecurityException e) {
                throw new WalkerException("Security error " + e.getMessage());
            } catch (IOException e) {
                throw new WalkerException("Something went wrong " + e.getMessage());
            }
        } catch (FileNotFoundException e) {
            throw new WalkerException("Can't find input file: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            throw new WalkerException("Buffer size<=0 wtf " + e.getMessage());
        } catch (SecurityException e) {
            throw new WalkerException("Security error " + e.getMessage());
        } catch (NullPointerException e) {
            throw new WalkerException("NPE Error " + e.getMessage());
        } catch (IOException e) {
            throw new WalkerException("Something went wrong during work with input file " + e.getMessage());
        }
    }


}


