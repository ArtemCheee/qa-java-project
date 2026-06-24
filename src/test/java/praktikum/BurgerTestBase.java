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
    protected Ingredient ingredient1;
    @Mock
    protected Ingredient ingredient2;
    @Mock
    protected Ingredient ingredient3;

    @Before
    public void createBurgerWithMocks() {
        burger = new Burger();

        when(bun.getName()).thenReturn("black bun");
        when(bun.getPrice()).thenReturn(100F);

        when(ingredient1.getType()).thenReturn(IngredientType.FILLING);
        when(ingredient1.getName()).thenReturn("sausage");
        when(ingredient1.getPrice()).thenReturn(300F);

        when(ingredient2.getType()).thenReturn(IngredientType.SAUCE);
        when(ingredient2.getName()).thenReturn("hot sauce");
        when(ingredient2.getPrice()).thenReturn(100F);

        when(ingredient3.getType()).thenReturn(IngredientType.FILLING);
        when(ingredient3.getName()).thenReturn("cutlet");
        when(ingredient3.getPrice()).thenReturn(100F);


    }
}