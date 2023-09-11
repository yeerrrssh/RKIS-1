package main.java.rkis.lab1.Rus;

import java.util.Objects;

/**
 * Подкласс игрушек
 */
public class Toy extends Product {
    /**
     * Минимальный возраст
     */
    private int minAge;
    /**
     * Материал
     */
    private String material;

    /**
     * Конструктор без параметров по умолчанию
     */
    public Toy() {
        super("none", 0);
        this.minAge = 0;
        this.material = "none";
    }

    /**
     * Конструктор с параметрами
     *
     * @param name      Наименование
     * @param price     Стоимость
     * @param minAge    Минимальный возраст
     * @param material  Материал
     */
    public Toy(String name, int price, int minAge, String material) {
        super(name, price);
        this.minAge = minAge;
        this.material = material;
    }

    /**
     * Преобразование информации об объекте в строку
     *
     * @return Строка с параметрами
     */
    @Override
    public String toString() {
        return String.format(super.toString() +
                """
                        
                        Минимальный возраст ребёнка: %s;
                        Материал: %s;""",
                minAge, material);
    }

    /**
     * Проверка объектов на равенство
     *
     * @param o     Объект для сравнения
     * @return      Результат сравнения
     */
    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) return false;
        Toy that = (Toy) o;
        return Objects.equals(minAge, that.minAge) &&
                Objects.equals(material, that.material);
    }

    /**
     * Вычисляет хэш-код
     *
     * @return Хэш-код
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), minAge, material);
    }

    /**
     * Извлекает минимальный возраст
     *
     * @return Минимальный возраст
     */
    public int getMinAge() {
        return minAge;
    }

    /**
     * Задаёт минимальный возраст
     */
    public void setMinAge(int rooms) {
        if (rooms > 0)
            this.minAge = rooms;
    }

    /**
     * Извлекает материал
     *
     * @return Материал
     */
    public String getMaterial() {
        return material;
    }

    /**
     * Задаёт материал
     *
     * @param material Материал
     */
    public void setMaterial(String material) {
        if (!material.isBlank())
            this.material = material;
    }
}
