package offer;

import model.Item;

import java.util.List;

public class LimeDealOffer implements DealOffer {
  public double calculateDiscount(List<Item> items) {
     long limesCount = items.stream().filter(i -> i.getName().equals("Lime")).count();
     if(limesCount > 2) {
       return (limesCount / 3) * (items.stream().filter(i -> i.getName().equals("Lime")).findAny().get().getPrice());
     }else {
       return 0;
     }
  }
}
