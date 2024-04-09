import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Calculator {
    int clients;
    ArrayList<Good> goods = new ArrayList<>();
    double totalBill;

    public void setClients(int clients) {
        this.clients = clients;
    }
    public void setGoods(String name, double price) {
        this.goods.add( new Good(name, price));
        this.totalBill += price;
    }

    public void printGoods() {
        for (Good good: goods) {
            System.out.println("Добавленные товары:" + good.name + " " + good.price);
        }
    }

    public double getSplitBill() {
        return totalBill / clients;
    }
}
