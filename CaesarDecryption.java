/**
 * Класс, дешифрующий текст шифром Цезаря с произвольным смещением.
 */


public class CaesarDecryption extends EncryptionMethods {

    private int key;

    private CaesarDecryption(String message, int key) {

        this.key = key;
        StringBuilder output = new StringBuilder();

        //Посимвольно проверяем и дешифруем каждый символ
        for (int i = 0; i < message.length(); ++i) {
            char c = message.charAt(i);

            if (isEnglish(c)) {
                int x = (findInEnglish(c) - key + nEng) % nEng; //Каноничная формула дешифровки Цезаря: x = (y - k + N) mod N

                if (Character.isUpperCase(c)) { //Проверка и приведение регистров к исходным, т.к. алфавит состоит только из букв верхнего регистра
                    output.append(englishAlphabet[x]);
                } else {
                    output.append(Character.toLowerCase(englishAlphabet[x]));
                }

                continue;
            }

            if (isRussian(c)) {
                int x = (findInRussian(c) - key + nRus) % nRus; //Формула дешифровки Цезаря: x = (y - k + N) mod N

                if (Character.isUpperCase(c)) { //Проверка и приведение регистров к исходным, т.к. алфавит состоит только из букв верхнего регистра
                    output.append(russianAlphabet[x]);
                } else {
                    output.append(Character.toLowerCase(russianAlphabet[x]));
                }

                continue;
            }

            //Случай цифры, символа или неучтенных символов
            if (!isEnglish(c) && !isRussian(c)) {
                output.append(c);
            }
        }
        this.output = output.toString();
    }


    //Метод, вызываемый пользователем
    public static String caesarDecode(String message, int key) {

        CaesarDecryption dec = new CaesarDecryption(message, key);
        return dec.getText();
    }
}