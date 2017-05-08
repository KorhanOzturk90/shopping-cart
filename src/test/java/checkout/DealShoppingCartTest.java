package checkout;

import static org.junit.Assert.assertEquals;

import model.Item;
import org.junit.Before;
import org.junit.Test;
import offer.DealOffer;
import offer.LimeDealOffer;
import offer.MelonDealOffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DealShoppingCartTest {
  private ShoppingCart shoppingCart;
  private final Item lime = new Item("Lime", 15);
  private final Item melon = new Item("Melon", 50);
  private final Item banana = new Item("Banana", 20);
  private final Item apple = new Item("Apple", 35);

  @Before
  public void setUp() {
    List<DealOffer> deals = new ArrayList<>();
    deals.add(new MelonDealOffer());
    deals.add(new LimeDealOffer());
    shoppingCart = new DealShoppingCart(deals);
  }

  @Test
  public void shouldWorkWithEmptyList() {
    double cost = shoppingCart.checkout(Collections.emptyList());
    assertEquals(0d, cost, 0);
  }

  @Test
  public void shouldReturnExpectedForSingleMelon() {
    List<Item> shoppingList = Collections.singletonList(melon);
    double cost = shoppingCart.checkout(shoppingList);
    assertEquals(50d, cost, 0);
  }

  @Test
  public void shouldReturnTotalSumForBananas() {
    List<Item> shoppingList = Arrays.asList(banana, banana, banana);
    double cost = shoppingCart.checkout(shoppingList);
    assertEquals(60, cost, 0);
  }

  @Test
  public void shouldReturnTotalSumForBananasAndApplesWithoutDiscount() {
    List<Item> shoppingList = new ArrayList<>();
    shoppingList.addAll(Collections.nCopies(10, apple));
    shoppingList.addAll(Collections.nCopies(5, banana));
    double cost = shoppingCart.checkout(shoppingList);
    assertEquals(450, cost, 0);
  }

  @Test
  public void shouldReturnTotalSumForApples() {
    List<Item> shoppingList = Collections.nCopies(10, apple);
    double cost = shoppingCart.checkout(shoppingList);
    assertEquals(350, cost, 0);
  }

  @Test
  public void shouldReturnTwoForOneDiscountForMelon() {
    List<Item> shoppingList = Collections.nCopies(4, melon);
    double cost = shoppingCart.checkout(shoppingList);
    assertEquals(100d, cost, 0);
  }

  @Test
  public void shouldReturnExpectedForSingleLime() {
    List<Item> shoppingList = Collections.singletonList(lime);
    double cost = shoppingCart.checkout(shoppingList);
    assertEquals(15, cost, 0);
  }

  @Test
  public void shouldReturnDiscountedResultFor2Limes() {
    List<Item> shoppingList = Arrays.asList(lime, lime);
    double cost = shoppingCart.checkout(shoppingList);
    assertEquals(30, cost, 0);
  }

  @Test
  public void shouldReturnDiscountedResultForMultipleLimes() {
    List<Item> shoppingList = Collections.nCopies(7, lime);
    double cost = shoppingCart.checkout(shoppingList);
    assertEquals(75d, cost, 0);
  }

  @Test
  public void shouldReturnDiscountedResultForMultipleDealItems() {
    List<Item> shoppingList = new ArrayList<>();
    shoppingList.addAll(Collections.nCopies(10, melon));
    shoppingList.addAll(Collections.nCopies(8, lime));
    double cost = shoppingCart.checkout(shoppingList);
    assertEquals(340d, cost, 0);
  }

  @Test
  public void shouldReturnDiscountedResultForMixedItems() {
    List<Item> shoppingList = new ArrayList<>();
    shoppingList.addAll(Collections.nCopies(10, melon));
    shoppingList.addAll(Collections.nCopies(8, lime));
    shoppingList.addAll(Collections.nCopies(3, apple));
    shoppingList.addAll(Collections.nCopies(2, banana));
    double cost = shoppingCart.checkout(shoppingList);
    assertEquals(485d, cost, 0);
  }

}
