package kaz.epam.services;

import kaz.epam.entities.Paragraph;
import kaz.epam.entities.Sentence;
import kaz.epam.entities.Text;
import kaz.epam.entities.Word;
import kaz.epam.interfaces.Entity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RecursiveSplitterService {

    private static int pCounter = 0;
    private static int sCounter = 0;
    private static int wCounter = 0;
    private static int chCounter = 0;
    
    private static final String PARAGRAPH_REGEX = "[А-Я].+[\\.\\!\\?\\...]";
    private static final String SENTENCE_REGEX = "[А-Я].+?[\\.\\!\\?\\.]";
    private static final String WORD_REGEX = "[А-Я-а-я]+";
    private static final String LETTER_REGEX = "[А-Яа-я]";
   

    public static void split(Entity entity){
        // Split text to paragraphs
        recursiveSplit(entity,PARAGRAPH_REGEX);
    }

    private static void recursiveSplit(Entity entity, String regex){
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(entity.getString());

        while(m.find()) {
            if(entity instanceof Text){
                Paragraph paragraph = new Paragraph();
                paragraph.setString(entity.getString().substring(m.start(),m.end()));
                // Split paragraph to sentences
                recursiveSplit(paragraph,SENTENCE_REGEX);
                pCounter++;
            }else if(entity instanceof Paragraph){
                Sentence sentence = new Sentence();
                sentence.setString(entity.getString().substring(m.start(), m.end()));
                // Split sentence to words
                recursiveSplit(sentence,WORD_REGEX);
                sCounter++;
            }else if(entity instanceof Sentence){
                Word word = new Word();
                word.setString(entity.getString().substring(m.start(),m.end()));
                //Split words to chars
                recursiveSplit(word,LETTER_REGEX);
                wCounter++;
            }else if(entity instanceof Word){
                chCounter++;
            }
        }

        if(entity instanceof Text) {
            System.out.println("Количество параграфов в тексте - " + pCounter);
            System.out.println("________________________________________________________________");
        }else if(entity instanceof Paragraph){
            System.out.println("Количество предложении в параграфе - "+sCounter);
            System.out.println("________________________________________________________________");
            sCounter = 0;
        }else if(entity instanceof Sentence){
            System.out.println("[ Количество слов в предложении - "+wCounter+" ]");
            wCounter = 0;
        }else if(entity instanceof Word){
            System.out.print(entity.getString()+"("+chCounter+") ");
            chCounter = 0;
        }
    }
}
