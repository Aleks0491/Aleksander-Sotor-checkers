package com.kodilla.exception.io;



import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.stream.Stream;

public class FileReader {
    public void readFile() throws FileReaderException {

        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(String.valueOf(classLoader.getResourceAsStream("file/names.txt")));

            try (Stream<String> fileLines = Files.lines(Paths.get(file.getPath()))) {

                fileLines.forEach(System.out::println);
            } catch (IOException e) {
                new FileReaderException();
            } finally {
                System.out.println("I'm gonna be here... always!");
            }

    }
}