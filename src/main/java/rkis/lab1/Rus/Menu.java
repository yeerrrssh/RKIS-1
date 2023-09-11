package main.java.rkis.lab1.Rus;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Класс меню
 */
class Menu {
    /**
     * Список объектов
     */
    private final ArrayList<Product> productList = new ArrayList<>(0);

    /**
     * Запуск пользовательского интерфейса
     */
    public void start() {
        int choice;

        do {
            printMenu();
            choice = intInput();

            switch (choice) {
                case 1:
                    addParamsProduct();
                    break;
                case 2:
                    if (productList.isEmpty()) {
                        System.out.println("Список товаров пуст!");
                        break;
                    }
                    deleteProduct();
                    break;
                case 3:
                    if (productList.isEmpty()) {
                        System.out.println("Список товаров пуст!");
                        break;
                    }
                    printArray();
                    break;
                case 4:
                    if (productList.isEmpty()) {
                        System.out.println("Список товаров пуст!");
                        break;
                    }
                    System.out.println(compareProducts(productList));
                    break;
                default:
                    if (choice != 5) {
                        System.err.println("Некорректный ввод!");
                    }
            }
        } while (choice != 5);
    }

    /**
     * Функция вывода меню
     */
    private void printMenu() {
        System.out.println("""
                ----------------------------------------
                1. Добавить товар;
                2. Удалить товар;
                3. Вывести информацию обо всех имеющихся товарах;
                4. Сравнить имеющиеся товары на равенство;
                5. Завершение работы.
                ----------------------------------------
                """);
    }

    /**
     * Функция вывода типов товаров
     */
    private void printTypes() {
        System.out.println("""
                1. Продукты;
                2. Молочные продукты;
                3. Игрушки;
                4. Другое;
                """);
    }

    /**
     * Функция вывода списка объектов (товаров)
     */
    private void printArray() {
        for (int i = 0; i < productList.size(); i++) {
            System.out.println("Индекс: " + i);
            if (productList.get(i) instanceof MilkProduct)
                System.out.println("Молочный продукт");
            else if (productList.get(i) instanceof Food)
                System.out.println("Продукт");
            else if (productList.get(i) instanceof Toy)
                System.out.println("Игрушка");
            else System.out.println("Другое");
            System.out.println("***************************");
            System.out.println(productList.get(i));
            System.out.println("***************************\n");
        }
    }

    /**
     * Функция сравнения строений на равенство
     *
     * @param productList  Список остроений
     * @return res         Результат сравнения или сообщение о неверном вводе
     */
    private String compareProducts(ArrayList<Product> productList) {
        String res = "Товар с таким индексом отсутствует";
        printEnter("индекс первого объекта для сравнения");
        int choice1 = intInput();
        printEnter("индекс второго объекта для сравнения");
        int choice2 = intInput();
        int max = productList.size() - 1;
        int min = 0;
        if (max >= choice1 && max >= choice2 && choice1 >= min && choice2 >= min) {
            if (productList.get(choice1).equals(productList.get(choice2)))
                res = "Товары равны";
            else
                res = "Товары не равны";
        }
        return res;
    }

    /**
     * Функция добавления товара в список
     */
    private void addParamsProduct() {
        System.out.println("Что Вы хотите добавить?");
        printTypes();
        int choice = intInput();
        if (choice > 4 || choice < 0) {
            System.out.println("Некорректное значение");
            return;
        }
        printEnter("наименование");
        String name = stringInput();
        if (name.length() < 1) {
            System.out.println("Ошибка ввода!");
            return;
        }
        printEnter("стоимость");
        int price = intInput();
        if (price <= 0) {
            System.out.println("Ошибка ввода! Значение должно быть больше 0");
            return;
        }
        switch (choice) {
            case 1 -> {
                printEnter("калорийность");
                int calories = intInput();
                if (calories <= 0) {
                    System.out.println("Ошибка ввода! Значение должно быть больше 0");
                    return;
                }
                printEnter("первое слово в составе");
                String formulation = stringInput();
                productList.add(new Food(name, price, calories, formulation));
            }
            case 2 -> {
                printEnter("калорийность");
                int calories = intInput();
                if (calories <= 0) {
                    System.out.println("Ошибка ввода! Значение должно быть больше 0");
                    return;
                }
                printEnter("первое в составе");
                String formulation = stringInput();

                printEnter("процент жиров");
                int fats = intInput();
                if (fats <= 0) {
                    System.out.println("Ошибка ввода! Значение должно быть больше 0");
                    return;
                }
                printEnter("вид молока в составе");
                String milkOwner = stringInput();
                productList.add(new MilkProduct(name, price, calories, formulation, fats, milkOwner));
            }
            case 3 -> {
                printEnter("с какого возраста разрешено играть");
                int minAge = intInput();
                if (minAge <= 0) {
                    System.out.println("Ошибка ввода! Значение должно быть больше 0");
                    return;
                }
                printEnter("материал");
                String material = stringInput();
                productList.add(new Toy(name, price, minAge, material));
            }
            case 4 -> {
                productList.add(new Product(name, price));
            }
        }
    }

    /**
     * Удаляет товар из списка
     */
    private void deleteProduct() {
        printEnter("индекс удаляемой ячейки");
        int choice = intInput();
        int max = productList.size();
        int min = 0;
        if (max >= choice && choice >= min) {
            productList.remove(choice);
        } else System.out.println("Некорректный ввод");
    }

    /**
     * Функция запроса ввода
     *
     * @param value Значение которое нужно ввести
     */
    private void printEnter(String value) {
        System.out.println("Введите " + value + ":");
    }

    /**
     * Функция ввода с проверкой на целочисленность
     *
     * @return int
     */
    private int intInput() {
        Scanner scan = new Scanner(System.in);
        while (!scan.hasNextInt()) {
            System.err.println("Некорректное значение!");
            scan.next();
        }
        return scan.nextInt();
    }

    /**
     * Функция ввода строки
     *
     * @return string
     */
    private String stringInput() {
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }
}
