package main.java.rkis.lab1.Rus;

import java.util.Objects;

/**
 * Класс товаров
 */
public class Product {
    /**
     * Наименование товара
     */
    private String name;
    /**
     * Стоимость товара
     */
    private int price;

    /**
     * Конструктор без параметров по умолчанию
     */
    public Product() {
        this("none", 0);
    }

    /**
     * Конструктор с параметрами
     *
     * @param name      Наименование
     * @param price     Стоимость
     */
    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    /**
     * Преобразование информации об объекте в строку
     *
     * @return Строка с параметрами
     */
    @Override
    public String toString() {
        return String.format(
                """
                        Наименование: %s;
                        Стоимость: %s;""",
                name, price);
    }

    /**
     * Проверка объектов на равенство
     *
     * @param o     Объект для сравнения
     * @return      Результат сравнения объектов
     */
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name) && Objects.equals(price, product.price);
    }

    /**
     * Вычисляет хэш-код
     *
     * @return Хэш-код
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }

    /**
     * Извлекает наименование товара
     *
     * @return Наименование товара
     */
    public String getName() {
        return name;
    }

    /**
     * Задаёт наименование товара
     *
     * @param address Наименование товара
     */
    public void setName(String address) {
        if (!address.isBlank())
            this.name = address;
    }

    /**
     * Извлекает стоимость
     *
     * @return Стоимость товара
     */
    public int getPrice() {
        return price;
    }

    /**
     * Задаёт площадь
     *
     * @param price Площадь строения
     */
    public void setPrice(int price) {
        if (price > 0)
            this.price = price;
    }
}
