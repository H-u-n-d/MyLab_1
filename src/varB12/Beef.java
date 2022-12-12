package varB12;

public class Beef extends Food
{
    private String preparedness;
    public Beef(String preparedness)
    {
        super("Мясо");
        this.preparedness = preparedness;
    }
    public void consume () {
        System.out.println(this + " Калорийности: " + calculateCalories() + " съедено");
    }
    public boolean equals(Object arg0)
    {
        if (super.equals(arg0)) { // Шаг 1
            if (!(arg0 instanceof Apple)) return false; // Шаг 2
            return preparedness.equals(((Apple)arg0).name); // Шаг 3
        } else
            return false;
    }
    public double calculateCalories()
    {
        if(preparedness.equals("With Blood"))
        {
            return 20;
        }
        else
        if(preparedness.equals("Normal"))
        {
            return 28;
        }
        else
        {
            return 78;
        }
    }
    public String toString() {
        return super.toString() + " готовности '" + preparedness.toUpperCase() + "'";
    }
// Переопределять метод equals() в данном классе не нужно, т.к. он
// не добавляет новых полей данных, а сравнение по внутреннему полю name
// уже реализовано в базовом классе
// Переопределять метод toString() в данном классе не нужно, т.к. он
// не добавляет внутренних полей данных, а возврат поля name уже
// реализован в версии toString() базового класса
}
