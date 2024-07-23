package utils;
//2. zad
public class Item {
  private String name;
  private String description;
  private double price;
  private String imageUrl;

  public Item(String name, String description, Double price, String imageUrl){
    this.name=name;
    this.description=description;
    this.price=price;
    this.imageUrl=imageUrl;
  }

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  public double getPrice() {
    return price;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  @Override
  public String toString(){
    return "Item{" +
      "name='" + name + '\'' +
      ", description='" + description + '\'' +
      ", price=" + price +
      ", imageUrl='" + imageUrl + '\'' +
      '}';
  }
}
