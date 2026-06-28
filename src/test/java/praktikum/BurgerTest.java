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
        burger.addIngredient(firstIngredient);
        Assert.assertEquals("Не корректное добавление", 1, burger.ingredients.size());
    }

    @Test
    public void removeIngredientTest() {
        burger.ingredients.add(firstIngredient);
        burger.ingredients.add(secondIngredient);
        burger.ingredients.add(thirdIngredient);
        burger.removeIngredient(1);
        Assert.assertEquals("Не корректное удаление",2, burger.ingredients.size());
    }

    @Test
    public void moveIngredientTest() {
        burger.ingredients.add(firstIngredient);
        burger.ingredients.add(secondIngredient);
        burger.ingredients.add(thirdIngredient);
        int sourceIndex = 2;
        int targetIndex = 1;
        Ingredient expectedIngredient = thirdIngredient;
        burger.moveIngredient(sourceIndex, targetIndex);
        Assert.assertEquals("Не корректная позиция", expectedIngredient, burger.ingredients.get(targetIndex));
    }



    @Test
    public void getReceiptTest() {
        burger.bun = bun;
        burger.ingredients.add(firstIngredient);
        burger.ingredients.add(secondIngredient);
        burger.ingredients.add(thirdIngredient);

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