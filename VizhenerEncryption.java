/**
 * Класс, шифрующий текст шифром Виженера с произвольным ключем.
 */


public class VizhenerEncryption extends EncryptionMethods {

    private String key;

    private VizhenerEncryption(String message, String key) {

        this.key = key;
        StringBuilder output = new StringBuilder();
        message = message.toLowerCase();

        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);

            if (minString(message) < key.length())
                throw new IllegalArgumentException("Ключ не может быть длиннее сообщения!");

            if (onlyLatinAlphabet(message) && onlyLatinAlphabet(key)) {
                if (findInEnglish(c) != -1) {
                    int num = ((c + key.charAt(i % key.length()) - 2 * smeshEng) % 26); //В num лежит номер буквы в алфавите
                    char t = (char) (num + smeshEng); //Получаем нужный символ
                    output.append(t);
                } else output.append(c);


            } else if (onlyRussianAlphabet(message) && onlyRussianAlphabet(key)) {
                if (findInRussian(c) != -1) {
                    int num = ((c + key.charAt(i % key.length()) - 2 * smeshRus) % 32); //в num лежит номер буквы в алфавите
                    char t = (char) (num + smeshRus);//получаем нужный символ
                    output.append(t);
                } else output.append(c);


            } else
                throw new IllegalArgumentException("Недопустимо использование нескольких языков в одном сообщении или ключе!");
        }
        this.output = output.toString();
    }

    public static String vizhenerEncode(String message, String key) {
        VizhenerEncryption viz = new VizhenerEncryption(message, key);
        return viz.getText();
    }
}