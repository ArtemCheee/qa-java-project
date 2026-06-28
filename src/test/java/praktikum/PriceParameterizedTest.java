package praktikum;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class PriceParameterizedTest {

    private static final Random random = new Random();


    private final Bun bun;
    private final List<Ingredient> ingredients;
    private final float expectedPrice;

    public PriceParameterizedTest(Bun bun, List<Ingredient> ingredients, float expectedPrice) {

        this.bun = bun;
        this.ingredients = ingredients;
        this.expectedPrice = expectedPrice;
    }

    @Parameterized.Parameters
    public static Object[][] data() {
        Database database = new Database();
        List<Bun> buns = database.availableBuns();
        List<Ingredient> allIngredients = database.availableIngredients();

        List<Object[]> testData = new ArrayList<>();
        int testCount = 5;

        for (int i = 0; i < testCount; i++) {

            Bun randomBun = buns.get(random.nextInt(buns.size()));


            List<Ingredient> randomIngredients = new ArrayList<>();
            List<Ingredient> tempList = new ArrayList<>(allIngredients);

            for (int j = 0; j < 4; j++) {
                int index = random.nextInt(tempList.size());
                randomIngredients.add(tempList.remove(index));
            }

            testData.add(new Object[]{
                    randomBun,
                    randomIngredients,
                    calculatePrice(randomBun, randomIngredients)
            });
        }

        return testData.toArray(new Object[0][]);
    }

    private static float calculatePrice(Bun bun, List<Ingredient> ingredients) {
        float price = bun.getPrice() * 2;
        for (Ingredient ingredient : ingredients) {
            price += ingredient.getPrice();
        }
        return price;
    }

    @Test
    public void getPriceTest() {

        Burger burger = new Burger();
        burger.setBuns(bun);
        for (Ingredient ingredient : ingredients) {
            burger.addIngredient(ingredient);
        }


        float actualPrice = burger.getPrice();


        assertEquals("Неверная цена бургера",
                expectedPrice, actualPrice, 0.001f);
    }
}
