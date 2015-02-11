import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;

/**
 * Created by nolanof on 1/28/2015.
 */
public class DelegateWithReflection {

    public static void main(String[] args) throws Exception {
        String stringToPrint = "Hello, World!";
        Method m1 = DelegateWithReflection.class.getMethod("toConsole",
                new Class[]{String.class});
        Display(m1, stringToPrint);
        Method m2 = DelegateWithReflection.class.getMethod("toFile",
                new Class[]{String.class});
        Display(m2, stringToPrint);
    }

    public static void toConsole(String str) {
        System.out.print(str + " ");
    }

    public static void toFile(String s) {
        File f = new File("delegate.txt");
        try {
            PrintWriter fileOut =
                    new PrintWriter(new FileOutputStream(f));
            fileOut.write(s);
            fileOut.flush();
            fileOut.close();
        } catch (IOException ioe) {
        }
    }

    public static void Display(Method m, String stringToPrint) {
        try {
            m.invoke(null, stringToPrint);
        } catch (Exception e) {
        }

    }
}
