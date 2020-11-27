/**
 * Класс, шифрующий текст штфром Цезаря с произвольным смещением.
 */


public class CaesarEncryption extends EncryptionMethods {

    private int key;

    private CaesarEncryption(String message, int key) {

        this.key = key;
        StringBuilder output = new StringBuilder();

        //Посимвольно проверяем и шифруем каждый символ
        for (int i = 0; i < message.length(); ++i) {
            char c = message.charAt(i);

            if (isEnglish(c)) {
                int y = (findInEnglish(c) + key) % nEng; //Формула шифровки Цезаря: y = (x + k) mod N

                if (Character.isUpperCase(c)) { //Проверка и приведение регистров к исходным, т.к. алфавит состоит только из букв верхнего регистра
                    output.append(englishAlphabet[y]);
                } else {
                    output.append(Character.toLowerCase(englishAlphabet[y]));
                }

                continue;
            }

            if (isRussian(c)) {
                int y = (findInRussian(c) + key) % nRus; //Формула шифра Цезаря: y = (x + k) mod N

                if (Character.isUpperCase(c)) { //Проверка и приведение регистров к исходным, т.к. алфавит состоит только из букв верхнего регистра
                    output.append(russianAlphabet[y]);
                } else {
                    output.append(Character.toLowerCase(russianAlphabet[y]));
                }

                continue;
            }

            if (!isEnglish(c) && !isRussian(c)) { //Случай цифры, символа или неучтенных символов
                output.append(c);
            }
        }
        this.output = output.toString();
    }


    //Метод, вызываемый пользователем
    public static String caesarEncode(String message, int key) {

        CaesarEncryption enc = new CaesarEncryption(message, key);
        return enc.getText();
    }

}
