/**
 * Общие методы для работы шифратора.
 */


public class EncryptionMethods {

    protected static final int nRus = 33; //Мощность русского алфавита
    protected static final int nEng = 26; //Мощность английского алфавита
    protected static final int smeshEng = (char) 'a'; //Смещение алфавита для шифра Виженера относительно таблицы юникодов для английского языка
    protected static final int smeshRus = (char) 'а'; //Смещение алфавита для шифра Виженера относительно таблицы юникодов для русского языка
    protected String output;

    protected static char[] englishAlphabet = {'A', 'B', 'C', 'D', 'E', 'F', 'G',
            'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
            'U', 'V', 'W', 'X', 'Y', 'Z'};

    protected static char[] russianAlphabet = {'А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ё',
            'Ж', 'З', 'И', 'Й', 'К', 'Л', 'М', 'Н', 'О', 'П', 'Р', 'С', 'Т', 'У',
            'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ', 'Ъ', 'Ы', 'Ь', 'Э', 'Ю', 'Я',};

    //Поиск и возврат позиции буквы в английском алфавите
    protected static int findInEnglish(char c) {
        int rez = -1;

        for (int i = 0; i < englishAlphabet.length; ++i) {
            if (Character.toUpperCase(c) == englishAlphabet[i])
                rez = i;
        }
        return rez;
    }

    //Поиск и возврат позиции буквы в русском алфавите
    protected static int findInRussian(char c) {
        int rez = -1;

        for (int i = 0; i < russianAlphabet.length; ++i) {
            if (Character.toUpperCase(c) == russianAlphabet[i])
                rez = i;
        }
        return rez;
    }

    //Проверка, принадлежит ли буква русскому алфавиту путем проверки диапазона кодов кириллицы
    protected static boolean isRussian(char c) {
        int i = (int) c;

        return i >= 1040 && i <= 1103 || i == 1105 || i == 1025;
    }

    //Проверка, принадлежит ли буква английскому алфавиту путем проверки диапазона кодов латиницы
    protected static boolean isEnglish(char c) {
        int i = (int) c;

        return i >= 65 && i <= 122;
    }


    //Возвращаем зашифрованный/расшифрованый текст
    protected String getText() {
        return this.output;
    }

    //Провека, состоит ли алфавит только из латинских букв или символов
    protected static boolean onlyLatinAlphabet(String text) {
        for (int i = 0; i < text.length(); i++) {
            if (!isRussian(text.charAt(i))) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    //Провека, состоит ли алфавит только из русских букв или символов
    protected static boolean onlyRussianAlphabet(String text) {
        for (int i = 0; i < text.length(); i++) {
            if (!isEnglish(text.charAt(i))) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    //минимальная длина слова в строке
    protected static int minString(String str) {
        String[] mesArray = str.split(" ");
        int[] lenArray = new int[mesArray.length];
        for (int i = 0; i < mesArray.length; i++) {
            lenArray[i] = mesArray[i].length();
        }
        int min = lenArray[0];
        for (int i = 0; i != lenArray.length; i++) {
            if (lenArray[i] < min) {
                min = lenArray[i];
            }
        }
        return min;
    }

}