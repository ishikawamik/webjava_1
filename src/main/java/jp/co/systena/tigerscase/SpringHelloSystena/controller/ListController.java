package jp.co.systena.tigerscase.SpringHelloSystena.controller;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import jp.co.systena.tigerscase.SpringHelloSystena.model.Item;
import jp.co.systena.tigerscase.SpringHelloSystena.model.ListForm;
import jp.co.systena.tigerscase.SpringHelloSystena.model.ListService;
import jp.co.systena.tigerscase.SpringHelloSystena.model.Order;

@Controller
// Viewあり。Viewを返す。
public class ListController {

  @Autowired
  HttpSession session; // セッション管理

  @RequestMapping (value="/ListView", method = RequestMethod.GET) // URLとのマッピング
  public ModelAndView show(ModelAndView mav) {
    ListForm listForm = (ListForm) session.getAttribute("form");
    if (listForm != null) {

        mav.addObject("num", listForm.getNum());
    }
    mav.addObject("listForm", new ListForm()); // 新規クラスを設定

    ArrayList<Item> itemList = ListService.getItemList();
    mav.addObject("ItemList", itemList);
    mav.setViewName("ListView");

    return mav;
  }

  @RequestMapping (value="/ListView", method = RequestMethod.POST) // URLとのマッピング
  private ModelAndView order(ModelAndView mav,
      @Valid ListForm listForm, BindingResult bindingResult,
      HttpServletRequest request) {

    ArrayList<Order> orderList = (ArrayList<Order>) session.getAttribute("orderList");
    if (orderList == null) {
      orderList = new ArrayList<Order>();
      session.setAttribute("orderList", orderList);
    }
    if (bindingResult.getAllErrors().size() > 0) {
      // エラーがある場合はそのまま戻す
      mav.addObject("listForm", listForm);
      mav.addObject("orders", orderList);

      // Viewのテンプレート名を設定
      mav.setViewName("ListView");
      return mav;
    }

    Order order = new Order();
    order.setName(listForm.getName());
    order.setNum(listForm.getNum());
    orderList.add(order);
    // データをセッションへ保存
    session.setAttribute("form", listForm);

    return new ModelAndView("redirect:/ListView"); // リダイレクト;
  }
}
