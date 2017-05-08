package offer;

import static org.junit.Assert.assertEquals;

import model.Item;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MelonDealOfferTest {

  private DealOffer offer;
  private final Item melon = new Item("Melon", 50);
  private final Item banana = new Item("Banana", 20);

  @Before
  public void setUp() {
    offer = new MelonDealOffer();
  }

  @Test
  public void returnsZeroForEmptyShoppingCart() {
    assertEquals(0d, offer.calculateDiscount(Collections.emptyList()), 0);
  }

  @Test
  public void returnsNoDiscountForSingleMelon() {
    assertEquals(0d, offer.calculateDiscount(Collections.singletonList(melon)), 0);
  }

  @Test
  public void returnsTwoForOneLimeDiscount() {
    assertEquals(50d, offer.calculateDiscount(Collections.nCopies(2, melon)), 0);
  }

  @Test
  public void returnsOneLimeFreeForFourLimesAndBananas() {
    List<Item> items = new ArrayList<>();
    items.addAll(Collections.nCopies(5, melon));
    items.addAll(Collections.nCopies(4, banana));
    assertEquals(100d, offer.calculateDiscount(items), 0);
  }
}
