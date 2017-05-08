package offer;

import model.Item;

import java.util.List;
import java.util.stream.Stream;

public class MelonDealOffer implements DealOffer {
  public double calculateDiscount(List<Item> items) {
     long melonCount = getFilteredItems(items, "Melon").count();
     if(melonCount > 1) {
       return melonCount / 2 * (getFilteredItems(items, "Melon").findAny().get().getPrice());
     }else {
       return 0;
     }
  }

  private Stream<Item> getFilteredItems(List<Item> items, String itemName){
    return items.stream().filter(i -> i.getName().equals(itemName));
  }
}
