package simpleinput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.function.Function;
import java.util.function.Supplier;

public class Input {
    public static <R> R translateInput(Reader reader, Function<String[], R> processor, Supplier<R> onError) {
        try (BufferedReader bufferedReader = new BufferedReader(reader))
            {
                String line = bufferedReader.readLine();
                String[] tokens = line.trim().split(" ");
                
                return processor.apply(tokens);
            }
        catch (IOException _) { return onError.get(); }
    }
    
    public static void processInputs(Reader reader, Function<String[], Boolean> processor, Runnable onError) {
        try (BufferedReader bufferedReader = new BufferedReader(reader))
            {
                Boolean isRunning = true;
                do {
                    String line = bufferedReader.readLine();
                    
                    if (line == null) { return; }
                    String[] tokens = line.trim().split(" ");
                    
                    isRunning = processor.apply(tokens);
                } while (isRunning == null || isRunning);
            }
        catch (IOException _) { onError.run(); }
    }
}