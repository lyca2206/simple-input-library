package libraries.input;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.function.Function;
import java.util.function.Supplier;

public class Input {
    public static <T> T translateInput(Function<String[], T> processor, Supplier<T> onError) {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in)))
            {
                String line = bufferedReader.readLine();
                String[] tokens = line.trim().split(" ");
                
                return processor.apply(tokens);
            }
        catch (Exception e) { return onError.get(); }
    }
    
    public static void processInputs(Function<String[], Boolean> processor, Supplier<Boolean> onError) {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in)))
            {
                Boolean isRunning = true;
                do {
                    String line = bufferedReader.readLine();
                    
                    if (line == null) { return; }
                    String[] tokens = line.trim().split(" ");
                    
                    isRunning = processor.apply(tokens);
                } while (isRunning == null || isRunning);
            }
        catch (Exception e) {
            System.err.println(e.toString());
            onError.get();
        }
    }
}