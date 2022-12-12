package varB12;

import java.util.Arrays;

public class MainApplication {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws Exception {
        // Определение ссылок на продукты завтрака
        Food[] breakfast = new Food[20];
        // Анализ аргументов командной строки и создание для них
        // экземпляров соответствующих классов для завтрака
        int howManyCalories = 0;
        int howManyBigApples = 0;
        int howManyMiddleApples = 0;
        int howManyLittleApples = 0;
        int howManyCheeses = 0;
        int howManyBeefsWithBlood = 0;
        int howManyNormalBeefs = 0;
        int howManyGrillBeefs = 0;
        int itemsSoFar = 0;
        int howManyGrusha=0;
        for (String arg : args) {
            String[] parts = arg.split("/");
            if (parts[0].equals("Cheese"))
            {
                breakfast[itemsSoFar] = new Cheese();
                howManyCheeses++;
            }
            if (parts[0].equals("Grusha"))
            {
                breakfast[itemsSoFar] = new Grusha();
                howManyGrusha++;
            }
            else if (parts[0].equals("Apple"))
            {

                breakfast[itemsSoFar] = new Apple(parts[1]);
                if (parts[1].equals("большое"))
                {
                    howManyBigApples++;
                }
                else if (parts[1].equals("среднее"))
                {
                    howManyMiddleApples++;
                }
                else if (parts[1].equals("маленькое"))
                {
                    howManyLittleApples++;
                }
            }
            if (parts[0].equals("Beef"))
            {
                breakfast[itemsSoFar] = new Beef(parts[1]);
                if (parts[1].equals("с кровью"))
                {
                    howManyBeefsWithBlood++;
                }
                else if (parts[1].equals("норма"))
                {
                    howManyNormalBeefs++;
                }
                else if (parts[1].equals("прожаренное"))
                {
                    howManyGrillBeefs++;
                }
            }
            itemsSoFar++;
        }
        Arrays.sort(breakfast, new FoodComparator());
        for (Food item : breakfast) {
            if (item != null)
// Если элемент не null – употребить продукт
                item.consume();
            else
                break;
        }
        for (String arg : args)
        {
            if (arg.startsWith("-"))
            {

                if (arg.equals("-sort")) {
                    Arrays.sort(breakfast, new FoodComparator());
                    System.out.println();
                }
                if (arg.equals("-calories"))
                {
                    for (Food item : breakfast) {
                        if (item != null)
                            howManyCalories += item.calculateCalories();

                        else
                            break;
                    }
                    System.out.println("Calories in your breakfast: " + howManyCalories);
                }
            }
        }
        if (howManyLittleApples != 0) {
            System.out.println("Съедено маленьких яблок: " + howManyLittleApples);
        }
        if (howManyMiddleApples != 0) {
            System.out.println("Съедено средних яблок: " + howManyMiddleApples);
        }
        if (howManyBigApples != 0) {
            System.out.println("Съедено больших яблок: " + howManyBigApples);
        }
        if (howManyBeefsWithBlood != 0) {
            System.out.println("Съедено кусков мяса с кровью: " + howManyBeefsWithBlood);
        }
        if (howManyGrillBeefs != 0) {
            System.out.println("Съедено кусков мяса с прожаркой: " + howManyGrillBeefs);
        }
        if (howManyNormalBeefs != 0) {
            System.out.println("Съедено кусков мяса с нормой: " + howManyNormalBeefs);
        }
        if (howManyCheeses != 0) {
            System.out.println("Съедено ломтиков сыра: " + howManyCheeses);
        }
        System.out.println("Всего хорошего!");
    }
}

