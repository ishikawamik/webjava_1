package jp.co.systena.tigerscase.SpringHelloSystena.model;

public class ListForm {

  private int id;
  private String name;
  private int price;
  private int num;

  public int getNum() {
    return this.num;
  }

  public void setName(int num) {
    this.num = num;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }
}
