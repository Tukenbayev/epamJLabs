package kaz.epam.services;

import kaz.epam.entities.Paragraph;
import kaz.epam.entities.Sentence;
import kaz.epam.entities.Text;
import kaz.epam.entities.Word;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SplitterService {

    public static void split(Text text){
        int pCounter = 0;
        String fullText = text.getFullText().toString();
        Pattern p = Pattern.compile("[А-Я].+[\\.\\!\\?\\...]");
        Matcher m = p.matcher(fullText);

        while(m.find()) {
            Paragraph paragraph = new Paragraph();
            paragraph.setParagraph(fullText.substring(m.start(),m.end()));
            // Разделяем параграф на предложения
            splitToSentences(paragraph);
            pCounter++;
        }

        System.out.println("Количество параграфов в тексте - "+pCounter);
        System.out.println("________________________________________________________________");
    }

    private static void splitToSentences(Paragraph paragraph){
        int counter = 0;

        Pattern p = Pattern.compile("[А-Я].+?[\\.\\!\\?\\.]");

        Matcher m = p.matcher(paragraph.getParagraph());


        while (m.find()) {
            Sentence sentence = new Sentence();
            sentence.setSentence(paragraph.getParagraph().substring(m.start(), m.end()));
            // Разделяем предложения на слова
            splitToWords(sentence);
            counter++;
        }

        System.out.println("Количество предложении в параграфе - "+counter);
        System.out.println("________________________________________________________________");
        counter = 0;
    }

    private static void splitToWords(Sentence sentence){
        int counter = 0;
        Pattern p = Pattern.compile("[А-Я-а-я]+");
        Matcher m = p.matcher(sentence.getSentence());

        while(m.find()) {
            Word word = new Word();
            word.setWord(sentence.getSentence().substring(m.start(),m.end()));
            //Разделяем слова на буквы
            splitToChars(word);
            counter++;
        }

        System.out.println("[ Количество слов в предложении - "+counter+" ]");
        counter = 0;
    }

    private static void splitToChars(Word word){
        int counter = 0;
        Pattern p = Pattern.compile("[А-Яа-я]");
        Matcher m = p.matcher(word.getWord());

        while(m.find()) {
            counter++;
        }
        System.out.print(word.getWord()+"("+counter+") ");
        counter = 0;
    }

}
