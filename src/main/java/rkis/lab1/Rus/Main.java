package main.java.rkis.lab1.Rus;

/**
 * Практическая работа №1, Вариант 6;
 * В программе реализован базовый класс товаров и производные классы: продукты, молочные продукты, игрушка.
 * Программа позволяет добавлять, удалять, выводить и сравнивать элементы классов.
 */

public class Main {
    /**
     * Основная функция программы
     *
     * @param args массив строк
     */
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.start();
    }
}