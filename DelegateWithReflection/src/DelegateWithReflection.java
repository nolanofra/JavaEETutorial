import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;

/**
 * Created by nolanof on 1/28/2015.
 */
public class DelegateWithReflection {

    public static void main(String[] args) throws Exception
    {
        String[] list= {"to","be","or","not","to","be"};
        Method m1 = DelegateWithReflection.class.getMethod("toConsole",
                new Class[] {String.class});
        Display(m1, list);
        Method m2 = DelegateWithReflection.class.getMethod("toFile",
                new Class[] {String.class});
        Display (m2, list);
    }
    public static void toConsole (String str)
    {
        System.out.print(str+" ");
    }
    public static void toFile (String s)
    {
        File f = new File("delegate.txt");
        try{
            PrintWriter fileOut =
                    new PrintWriter(new FileOutputStream(f));
            fileOut.write(s);
            fileOut.flush();
            fileOut.close();
        }catch(IOException ioe) {}
    }
    public static void Display(Method m, String[] list)
    {
        for(int k = 0; k < list.length; k++) {
            try {
                Object[] args = {new String(list[k])};
                m.invoke(null, args);
            }catch(Exception e) {}
        }
    }
}
