package Writer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import University.*;
public class MyWriter {
    static public void toFile(Course course, File file, boolean append) throws IOException
    {
        try(FileWriter out = new FileWriter(file,append)) {
            out.write(course.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
