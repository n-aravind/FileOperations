import java.io.IOException;
import java.nio.file.*;

import static java.nio.file.Files.deleteIfExists;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class Main {
    public static void main(String[] args) {
        Path path = Paths.get(System.getProperty("user.dir"),"logs");
        System.out.println(Files.exists(path));

        Path reportsPath = Paths.get(System.getProperty("user.dir"),"reports","report.txt");
        System.out.println(Files.exists(reportsPath));

        System.out.println(Files.isRegularFile(reportsPath));
        System.out.println(Files.isReadable(reportsPath));
        System.out.println(Files.isExecutable(reportsPath));

        try {
            Files.delete(path);
        } catch (NoSuchFileException x) {
            System.err.format("%s: no such" + " file or directory%n", path);
        } catch (DirectoryNotEmptyException x) {
            System.err.format("%s not empty%n", path);
        } catch (IOException x) {
            // File permission problems are caught here.
            System.err.println(x);
        }

        try {
            System.out.println(deleteIfExists(path));
        } catch (IOException e) {
            System.out.println("Inside this exception");
            e.printStackTrace();
        }

        Path p1 = Paths.get(System.getProperty("user.dir"),"reports","report.txt");
        Path p2 = Paths.get(System.getProperty("user.dir"),"reports_copy","report.txt");
        try {
           Files.copy(p1,p2,REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
