package praktikum;

import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BurgerTest extends BurgerTestBase {

    @Test
    public void setBunTest() {
        burger.setBuns(bun);
               Assert.assertEquals("Не корректная булка " + bun.getName(), bun.getName(), burger.bun.getName());
    }

    @Test
    public void addIngredientTest() {
        burger.addIngredient(ingredient1);
        Assert.assertEquals("Не корректное добавление", 1, burger.ingredients.size());
    }

    @Test
    public void removeIngredientTest() {
        burger.ingredients.add(ingredient1);
        burger.ingredients.add(ingredient2);
        burger.ingredients.add(ingredient3);
        burger.removeIngredient(1);
        Assert.assertEquals("Не корректное удаление",2, burger.ingredients.size());
    }

    @Test
    public void moveIngredientTest() {
        burger.ingredients.add(ingredient1);
        burger.ingredients.add(ingredient2);
        burger.ingredients.add(ingredient3);
        burger.moveIngredient(2, 1);
        Assert.assertEquals("Не корректная позиция", burger.ingredients.get(1), ingredient3);
    }

    @Test
    public void getPriceTest() {
        burger.bun = bun;
        burger.ingredients.add(ingredient1);
        burger.ingredients.add(ingredient2);
        burger.ingredients.add(ingredient3);

        float expectedPrice = bun.getPrice()*2 + ingredient1.getPrice() + ingredient2.getPrice() + ingredient3.getPrice();

        Assert.assertEquals("Ожидаемая стоимость" + expectedPrice + " | Фактическая стоимость"
                + burger.getPrice(), expectedPrice, burger.getPrice(), 0);
    }

    @Test
    public void getReceiptTest() {
        burger.bun = bun;
        burger.ingredients.add(ingredient1);
        burger.ingredients.add(ingredient2);
        burger.ingredients.add(ingredient3);

        String actualReceipt = burger.getReceipt();
        String expectedReceipt = "(==== black bun ====)\r\n" +
                "= filling sausage =\r\n" +
                "= sauce hot sauce =\r\n" +
                "= filling cutlet =\r\n" +
                "(==== black bun ====)\r\n" +
                "\r\n" +
                "Price: 700,000000\r\n";

        assertEquals("Не верный чек", expectedReceipt, actualReceipt);
    }
}