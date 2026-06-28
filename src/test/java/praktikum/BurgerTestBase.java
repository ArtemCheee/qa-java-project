package praktikum;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)

public class BurgerTestBase {

    protected Burger burger;

    @Mock
    protected Bun bun;
    @Mock
    protected Ingredient firstIngredient;
    @Mock
    protected Ingredient secondIngredient;
    @Mock
    protected Ingredient thirdIngredient;

    @Before
    public void createBurgerWithMocks() {
        burger = new Burger();

        when(bun.getName()).thenReturn("black bun");
        when(bun.getPrice()).thenReturn(100F);

        when(firstIngredient.getType()).thenReturn(IngredientType.FILLING);
        when(firstIngredient.getName()).thenReturn("sausage");
        when(firstIngredient.getPrice()).thenReturn(300F);

        when(secondIngredient.getType()).thenReturn(IngredientType.SAUCE);
        when(secondIngredient.getName()).thenReturn("hot sauce");
        when(secondIngredient.getPrice()).thenReturn(100F);

        when(thirdIngredient.getType()).thenReturn(IngredientType.FILLING);
        when(thirdIngredient.getName()).thenReturn("cutlet");
        when(thirdIngredient.getPrice()).thenReturn(100F);


    }
}