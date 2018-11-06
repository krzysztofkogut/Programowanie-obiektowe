package microdvd;

import java.io.*;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.regex.*;

public class MicroDVD {
    public static void microDVD(String sourceName, String whereSave,
        int delay, int fps) throws IOException, UnproperDataException {

        FileSystem fs = FileSystems.getDefault();
        Path source = fs.getPath(sourceName);
        Path where = fs.getPath(whereSave);
        try (BufferedReader in = new BufferedReader(new FileReader(source.toFile()));
            BufferedWriter out = new BufferedWriter(new FileWriter(where.toFile()));){
            
            String temp;
            while ((temp = in.readLine()) != null) {
                out.write(delay(temp, delay, fps));
            }
        }
    }


    public static String delay(String in, int delay, int fps) throws UnproperDataException {
        String[] temp = in.split("\\}");
        String connect = temp[0] + temp[1];
        String tekst = temp[2];
        temp = connect.split("\\{");
        int begin, end;
        if ((Pattern.matches("[0-9]*", temp[1]))
            && (Pattern.matches("[0-9]*", temp[2]))) {
            begin = Integer.parseInt(temp[1]);
            end = Integer.parseInt(temp[2]);
            if (begin >= end) {
                    throw new UnproperDataException();
            }
            begin += fps * delay / 1000;
            end += fps * delay / 1000;
            return "{" + Integer.toString(begin) + "}{" + Integer.toString(end)
                + "}" + tekst + "\n";
        } else
            throw new UnproperDataException();
    }
}