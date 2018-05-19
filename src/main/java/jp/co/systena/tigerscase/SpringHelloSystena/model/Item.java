package jp.co.systena.tigerscase.SpringHelloSystena.model;

public class Item {
  private int id;
  private String name;
  private int price;

  public Item(int id, String name, int price) {
    // TODO 自動生成されたコンストラクター・スタブ
    this.id = id;
    this.name = name;
    this.price = price;
  }

  public int getId() {
    return this.id;
  }
  // setter
  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
   return this.name;
 }
 // setter
 public void setName(String name) {
   this.name = name;
 }

 public int getPrice() {
   return this.price;
 }

 // setter
 public void setPrice(int price) {
   this.price = price;
 }
}
