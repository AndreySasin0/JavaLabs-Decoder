/**
 * Класс, дешифрующий текст шифром Виженера с произвольным ключем.
 */


public class VizhenerDecryption extends EncryptionMethods {

    private String key;

    private VizhenerDecryption(String message, String key) {

        this.key = key;
        StringBuilder output = new StringBuilder();
        message = message.toLowerCase();

        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);

            if (minString(message) < key.length())
                throw new IllegalArgumentException("Ключ не может быть длиннее сообщения!");

            if (onlyLatinAlphabet(message) && onlyLatinAlphabet(key)) {
                if (findInEnglish(c) != -1) {
                    int num = ((c - key.charAt(i % key.length()) + 26) % 26); //Обратные преобразования с номером буквы в алфавит
                    char t = (char) (num + smeshEng);
                    output.append(t);
                } else {
                    output.append(c);
                }


            } else if (onlyRussianAlphabet(message) && onlyRussianAlphabet(key)) {
                if (findInRussian(c) != -1) {
                    int num = ((c - key.charAt(i % key.length()) + 32) % 32); //Обратные преобразования с номером буквы в алфавит
                    char t = (char) (num + smeshRus);
                    output.append(t);
                } else {
                    output.append(c);
                }


            } else
                throw new IllegalArgumentException("Недопустимо использование нескольких языков в одном сообщении или ключе!");
        }
        this.output = output.toString();
    }

    public static String vizhenerDecode(String message, String key) {
        VizhenerDecryption dec = new VizhenerDecryption(message, key);
        return dec.getText();
    }
}