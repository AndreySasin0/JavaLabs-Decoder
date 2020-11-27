/**
 * Основной класс шифратора.
 */

import java.util.*;

public class Encryptor {
    public static void main(String[] args) throws IllegalArgumentException {

        try {
            Scanner scan = new Scanner(System.in);

            System.out.println("Выберите метод шифрования/дешифровки: 1-Шифр Цезаря, 2-Шифр Виженера");
            String destiny = scan.nextLine();

            if (destiny.equals("1")) {
                System.out.println("Введите сообщение, которое хотите зашифровать/расшифровать: ");
                String message = scan.nextLine();
                System.out.println("Введите ключ шифрования: ");
                int key = Integer.parseInt(scan.nextLine());
                System.out.println("Исходное сообщение: " + message + "\nЗашифрованное сообщение: " + CaesarEncryption.caesarEncode(message, key) + "\nДешифрованное сообщение: " + CaesarDecryption.caesarDecode(message, key));

            } else if (destiny.equals("2")) {
                System.out.println("Введите сообщение, которое хотите зашифровать/расшифровать: ");
                String message = scan.nextLine();
                System.out.println("Введите ключ шифрования: ");
                String key = scan.nextLine();
                System.out.println("Исходное сообщение: " + message + "\nЗашифрованное сообщение: " + VizhenerEncryption.vizhenerEncode(message, key) + "\nДешифрованное сообщение: " + VizhenerDecryption.vizhenerDecode(message, key));

            } else System.out.println("Выбор некорректен, попробуйте снова!");

        } catch (IllegalArgumentException e) {
            System.out.println("Что-то пошло не так, смотрите описание ошибки!");
        }
    }
}