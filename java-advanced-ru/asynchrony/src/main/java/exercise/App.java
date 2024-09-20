package exercise;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.CompletableFuture;


class App {

    // BEGIN
    public static CompletableFuture<String> unionFiles(String path1, String path2, String pathDest) {

        if (Files.notExists(Path.of(pathDest))) {
            try {
                Files.createFile(Path.of(pathDest));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        CompletableFuture<String> readFile1 = CompletableFuture.supplyAsync(() -> {
            String result = "";
            try {
                result = Files.readString(stringToPath(path1));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return result.trim();
        });

        CompletableFuture<String> readFile2 = CompletableFuture.supplyAsync(() -> {
            String result = "";
            try {
                result = Files.readString(stringToPath(path2));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return result.trim();
        });

        CompletableFuture<String> write = readFile1.thenCombine(readFile2, (file1ToString, file2ToString) -> {
                String result = file1ToString + " " + file2ToString;
            try {
                Files.writeString(Path.of(pathDest), result, StandardOpenOption.APPEND);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return result;
        }).exceptionally(ex -> {
            System.out.println("Oops! We have an exception - " + ex.getMessage());
            return null;
        });
        return write;
    }

    private static Path stringToPath(String pathToFile) {
        Path path = Path.of(pathToFile);
        return path.isAbsolute() ? path : path.toAbsolutePath();
    }

    public static CompletableFuture<Long> getDirectorySize(String pathToDir) throws IOException {
        CompletableFuture<Long> sizeAllFiles = CompletableFuture.supplyAsync(() -> {
            Long result = 0L;
            try (DirectoryStream<Path> files = Files.newDirectoryStream(Path.of(pathToDir))) {
                for (Path path : files) {
                    if (Files.isRegularFile(path)) {
                        try {
                            result = result + Files.size(path);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            } catch (IOException e) {
                e.getMessage();
            }
            return result;
        }).exceptionally(ex -> {
            System.out.println("Oops! We have an exception - " + ex.getMessage());
            return null;
        });
        return sizeAllFiles;
    }
    // END

    public static void main(String[] args) throws Exception {
        // BEGIN
        unionFiles("src/main/resources/file1.txt",
                "src/main/resources/file2.txt",
                "src/main/resources/result.txt").get();

        System.out.println(getDirectorySize("src/main/resources/").get());
        // END
    }
}

