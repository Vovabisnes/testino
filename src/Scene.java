import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public interface Scene {
    int run(JFrame frame) throws IOException;
}