package checkout;

import model.Item;

import java.util.List;

public interface ShoppingCart {

  double checkout(List<Item> items);
}
