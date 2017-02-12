package kaz.epam;

import kaz.epam.entities.Text;
import kaz.epam.services.ReaderWriterService;
import kaz.epam.services.SplitterService;

import java.io.*;

/**
 * CLOSE ALL RESOURCES!!!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {

        Text text = new Text();
        //Заполняем text данными
        ReaderWriterService.getDataFromFile(text);

        // Расщепляем текст на составляющие
        SplitterService.split(text);

        //Записываем текст в новый файл
        ReaderWriterService.writeDataToNewFile(text);

    }
}
