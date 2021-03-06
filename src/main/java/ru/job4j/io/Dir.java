package ru.job4j.io;

import java.io.File;

/**
 * Главным элементом файловой системы является объект java.io.File.
 * <p>
 * File может быть и текстовым документом и директорией.
 * <p>
 * Рассмотрим задачу с получением всех элементов директории.
 * Наш проект лежит в папке c:\projects\.
 * <p>
 * Напишем программу, которая проверяет,
 * что директория projects - это директория и выведем ее
 * содержимое.
 *
 * @author AlexSapsay (sapsayalexey@gmail.com)
 * @version 1.0
 * @since 03.09.2021
 */

public class Dir {
    public static void main(String[] args) {
        /**
         *  валидация аргументов запуска
         */
        if (args.length == 0) {
            throw new IllegalArgumentException("Root folder is null. Usage java -jar dir.jar ROOT_FOLDER.");
        }
        /**
         *изменим программу, чтобы начальная папка передавалась через аргументы запуска.
         */
        File file = new File(args[0]);
        /**
         *ручками указываем начальную папку для поиска
         *File file = new File(".");
         *Проверяем, что файл существует.
         */

        if (!file.exists()) {
            throw new IllegalArgumentException(String.format("Not exist %s", file.getAbsoluteFile()));
        }
        /**
         * Проверяет, что файл - это директория.
         */
        if (!file.isDirectory()) {
            throw new IllegalArgumentException(String.format("Not directory %s", file.getAbsoluteFile()));
        }
        System.out.println(String.format("size : %s", file.getTotalSpace()));
        /**
         *Получаем список файлов в этой директории.
         */
        for (File subfile : file.listFiles()) {
            System.out.println(subfile.getName() + " " + subfile.length() + " Bytes");
        }
    }
}