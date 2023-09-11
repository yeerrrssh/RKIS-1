package main.java.rkis.lab1.Rus;

import java.util.Objects;

/**
 * Подкласс продуктов
 */
public class Food extends Product {
    /**
     * Преобладающее в составе
     */
    private String formulation;
    /**
     * Калорийность
     */
    private int calories;

    /**
     * Конструктор без параметров по умолчанию
     */
    public Food() {
        super("none", 0);
        this.calories = 0;
        this.formulation = "none";
    }

    /**
     * Конструктор с параметрами
     *
     * @param name          Наименование
     * @param price         Стоимость
     * @param calories      Количество калорий
     * @param formulation   Основной компонент
     */
    public Food(String name, int price, int calories, String formulation) {
        super(name, price);
        this.calories = calories;
        this.formulation = formulation;
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
                        
                        Калорий: %s;
                        Первое в составе: %s;""",
                calories, formulation);
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
        Food that = (Food) o;
        return Objects.equals(formulation, that.formulation) &&
                Objects.equals(calories, that.calories);
    }

    /**
     * Вычисляет хэш-код
     *
     * @return Хэш-код
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), formulation, calories);
    }

    /**
     * Извлекает количество калорий
     *
     * @return Количество калорий
     */
    public int getCalories() {
        return calories;
    }

    /**
     * Задаёт количество калорий
     *
     * @param calories Количество калорий
     */
    public void setCalories(int calories) {
        if (calories > 0)
            this.calories = calories;
    }

    /**
     * Извлекает основной компонент
     *
     * @return Основной компонент
     */
    public String getFormulation() {
        return formulation;
    }

    /**
     * Задаёт наличие участка
     *
     * @param formulation Наличие участка
     */
    public void setFormulation(String formulation) {
        if (!formulation.isBlank())
            this.formulation = formulation;
    }
}
