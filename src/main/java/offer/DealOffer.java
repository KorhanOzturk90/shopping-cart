package offer;

import model.Item;

import java.util.List;

public interface DealOffer {
  double calculateDiscount(List<Item> items);
}
