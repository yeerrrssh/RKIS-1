package main.java.rkis.lab1.Rus;

import java.util.Objects;

/**
 * Подкласс молочных продуктов
 */
public class MilkProduct extends Food {
    /**
     * Процент жира
     */
    private int fats;
    /**
     * Чьё молоко использовано в продукте
     */
    private String milkOwner;

    /**
     * Конструктор без параметров по умолчанию
     */
    public MilkProduct() {
        super("none", 0, 0, "none");
        this.fats = 0;
        this.milkOwner = "none";
    }

    /**
     * Конструктор с параметрами
     *
     * @param name          Наименование
     * @param price         Стоимость
     * @param calories      Калорийность
     * @param formulation   Первое в составе
     * @param fats          Процент жиров
     * @param milkOwner     Чьё молоко
     */
    public MilkProduct(String name, int price, int calories, String formulation, int fats, String milkOwner) {
        super(name, price, calories, formulation);
        this.fats = fats;
        this.milkOwner = milkOwner;
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
                        
                        Процент жиров: %s;
                        Молоко: %s;""",
                fats, milkOwner);
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
        MilkProduct that = (MilkProduct) o;
        return Objects.equals(fats, that.fats) &&
                Objects.equals(milkOwner, that.milkOwner);
    }

    /**
     * Вычисляет хэш-код
     *
     * @return Хэш-код
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), fats, milkOwner);
    }

    /**
     * Извлекает процент жиров
     *
     * @return Процент жиров
     */
    public int getFats() {
        return fats;
    }

    /**
     * Задаёт процент жиров
     */
    public void setFats(int fats) {
        if (fats > 0)
            this.fats = fats;
    }

    /**
     * Извлекает источник молока
     *
     * @return Чьё молоко
     */
    public String getMilkOwner() {
        return milkOwner;
    }

    /**
     * Задаёт источник молока
     *
     * @param milkOwner Чьё молоко
     */
    public void setMilkOwner(String milkOwner) {
        if (!milkOwner.isBlank())
            this.milkOwner = milkOwner;
    }
}
