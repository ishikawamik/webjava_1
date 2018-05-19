package jp.co.systena.tigerscase.SpringHelloSystena.model;

import java.util.ArrayList;
import org.springframework.web.bind.annotation.RestController;

@RestController
// Viewを返さないコントローラー
// 商品一覧（ItemList）を返却する
public class ListService {
  public static ArrayList<Item> getItemList(){

    ArrayList<Item> itemList = new ArrayList<Item>();
    itemList.add(new Item(100, "にんじん", 100));
    itemList.add(new Item(101, "じゃがいも", 80));
    itemList.add(new Item(102, "たまねぎ", 120));
    itemList.add(new Item(103, "牛肉", 200));
    itemList.add(new Item(104, "ルウ", 500));

    return itemList;
  }
}



