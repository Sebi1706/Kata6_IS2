package kata.pkg6;

import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="word")
public class Word {
    public String word;
    public List<Phonetic> phonetics;
    public List<Meaning> meanings;
    public License license;
    public List<String> sourceUrls;
    
    
    public static class Phonetic {
        public String text;
        public String audio;
        public String sourceUrl;
        public License license;

        @Override
        public String toString() {
            return "Phonetic{" + "text=" + text + ", audio=" + audio + ", sourceUrl=" + sourceUrl + ", license=" + license + '}';
        } 
        
    }
    
    public static class License {
        public String name;
        public String url;

        @Override
        public String toString() {
            return "License{" + "name=" + name + ", url=" + url + '}';
        }
        
    }
    
    public static class Meaning {
        public String partOfSpeech;
        public List<Definition> definitions;
        public List<String> synonyms;
        public List<String> antonyms;

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (Definition definition : definitions) {
                sb.append(definition.definition).append("\n");
            }
            return sb.toString();
        }
        
        
    }
    
    public static class Definition {
        public String definition;
        public List<String> synonyms;
        public List<String> antonyms;        
        public String example;
        
        @Override
        public String toString() {
            return "Definition{" + "definition=" + definition + ", synonyms=" + synonyms + ", antonyms=" + antonyms + ", example=" + example + '}';
        }
    }
    
    
    

}
