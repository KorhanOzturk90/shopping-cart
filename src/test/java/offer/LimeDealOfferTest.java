package offer;

import static org.junit.Assert.assertEquals;

import model.Item;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LimeDealOfferTest {

  private DealOffer offer;
  private final Item lime = new Item("Lime", 15);
  private final Item banana = new Item("Banana", 20);

  @Before
  public void setUp() {
    offer = new LimeDealOffer();
  }

  @Test
  public void returnsZeroForEmptyShoppingCart() {
    assertEquals(0d, offer.calculateDiscount(Collections.emptyList()), 0);
  }

  @Test
  public void returnsNoDiscountForSingleLime() {
    assertEquals(0d, offer.calculateDiscount(Collections.singletonList(lime)), 0);
  }

  @Test
  public void returnsOneLimeFreeForThreeLimes() {
    assertEquals(15d, offer.calculateDiscount(Collections.nCopies(3, lime)), 0);
  }

  @Test
  public void returnsOneLimeFreeForFourLimesAndBananas() {
    List<Item> items = new ArrayList<>();
    items.addAll(Collections.nCopies(4, lime));
    items.addAll(Collections.nCopies(4, banana));
    assertEquals(15d, offer.calculateDiscount(items), 0);
  }
}
