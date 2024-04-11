import java.util.ArrayList;

public class Calculator {
    ArrayList<Goods> goods = new ArrayList<>();
    double totalBill;

    public void setGoods(String name, double price) {
        this.goods.add( new Goods(name, price));
        this.totalBill += price;
    }

    public void printGoods() {
        for (Goods good: goods) {
            System.out.println("Добавленные товары:" + good.name + " " + good.price);
        }
    }

    public double getSplitBill(int clients) {
        return totalBill / clients;
    }
}
