package checkout;

import model.Item;
import offer.DealOffer;

import java.util.List;

public class DealShoppingCart implements ShoppingCart {

  private List<DealOffer> offersList;

  public DealShoppingCart(List<DealOffer> offersList) {
    this.offersList = offersList;
  }

  @Override
  public double checkout(List<Item> items) {
    double sum = items.stream().map(i -> i.getPrice()).reduce(0d, (x,y) -> x+ y);
    double discount = offersList.stream().map(o -> o.calculateDiscount(items)).reduce(0d, (x,y) -> x+ y);;
    return sum - discount;
  }
}
