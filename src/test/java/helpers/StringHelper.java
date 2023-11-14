package helpers;

public class StringHelper {
    public static String textToCamelCase(String text){
        String[] words = text.split("[\\W_]+");
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (i == 0) {
                word = word.isEmpty() ? word : word.toLowerCase();
            } else {
                word = word.isEmpty() ? word : Character.toUpperCase(word.charAt(0)) + word.substring(1).toLowerCase();
            }
            builder.append(word);
        }
        return builder.toString();
    }

    public static String singularize(String text){
        if (text.endsWith("ies"))
            return text.substring(0, text.length()-3).concat("y");
        else if (text.endsWith("s"))
            return text.substring(0, text.length()-1);
        return text;
    }
}
