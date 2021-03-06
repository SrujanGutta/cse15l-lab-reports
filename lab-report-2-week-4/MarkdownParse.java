//https://howtodoinjava.com/java/io/java-read-file-to-string-examples/

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParse {

    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        // find the next [, then find the ], then find the (, then read link upto next )
        int currentIndex = 0;
        while(currentIndex < markdown.length()) {
            int exclamation = markdown.indexOf("!",currentIndex);
            int openBracket = markdown.indexOf("[", currentIndex);
            if(openBracket == -1){
                break;
            }
            int closeBracket = markdown.indexOf("]", openBracket);
            int openParen = markdown.indexOf("(", closeBracket);
            int closeParen = markdown.indexOf(")", openParen);
            String sub = markdown.substring(openParen + 1, closeParen);
            int currentIndex2 = openParen + 1;
            if(sub.contains("(")){
                sub = markdown.substring(sub.lastIndexOf("(", currentIndex2)+openParen+2, closeParen);
            }
            if(exclamation == -1){
                toReturn.add(sub);
            }
            else{
                if(exclamation != (openBracket-1)){
                    toReturn.add(sub);
                }
            }
            currentIndex = closeParen + 1;
        }

        return toReturn;
    }


    public static void main(String[] args) throws IOException {
        Path fileName = Path.of(args[0]);
        String content = Files.readString(fileName);
        ArrayList<String> links = getLinks(content);
	    System.out.println(links);
    }
}
