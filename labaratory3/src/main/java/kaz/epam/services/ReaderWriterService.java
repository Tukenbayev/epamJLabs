package kaz.epam.services;

import kaz.epam.entities.Text;

import java.io.*;

public class ReaderWriterService {

    public static void getDataFromFile(Text text) throws IOException {
        Reader reader = createReader();
        while (reader.ready()){
            text.getFullText().append(Character.toString((char) reader.read()));
        }
        reader.close();
    }

    public static void writeDataToNewFile(Text text) throws IOException {
        char[] chars = text.getFullText().toString().toCharArray();
        OutputStreamWriter writer = createWriter();
        writer.write(chars);
        writer.close();
    }

    private static Reader createReader() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        File file = new File(reader.readLine());
        FileInputStream inputStream = new FileInputStream(file);

        InputStreamReader isr = new InputStreamReader(inputStream,"Cp1251");

        return new BufferedReader(isr);
    }

    private static OutputStreamWriter createWriter() throws FileNotFoundException, UnsupportedEncodingException {
        FileOutputStream fileOutputStream = new FileOutputStream("D:/test.txt");
        return new OutputStreamWriter(fileOutputStream,"Cp1251");
    }


}
