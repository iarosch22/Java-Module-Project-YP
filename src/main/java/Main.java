import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int clients;
        Calculator calculator = new Calculator();
        Formatter formatter = new Formatter();


        System.out.println("На сколько человек необходимо разделить счет?");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            if (scanner.hasNextInt()) {
                clients = scanner.nextInt();

                if (clients == 1) {
                    System.out.println("Считать нечего. Спасибо!");
                    break;
                } else if (clients > 1) {
                    calculator.setClients(clients);
                    break;
                } else {
                    System.out.println("Введено неверное значение. Просьба повторить еще.");
                }
            } else {
                System.out.println("Введено неверное значение. Просьба повторить еще.");
                scanner.next();
            }
        }

        if (clients > 1) {
            String name;
            double price;

            System.out.println("Необходимо сообщить название товара и его стоимость.");

            while (true) {
                System.out.println("Введите название товара либо 'Завершить'");
                name = scanner.next();

                if (name.equalsIgnoreCase("завершить")) {
                    System.out.println("Добавление товаров завершено.");
                    break;
                }

                System.out.println("Введите стоимость товара.");

                while (true) {
                    if (scanner.hasNextDouble()) {
                        price = scanner.nextDouble();
                        break;
                    } else {
                        System.out.println("Введено неверное значение. Просьба повторить еще.");
                        scanner.next();
                    }
                }



                calculator.setGoods(name, price);

                System.out.println("Товар " + name + " по цене " + price + " успешно добавлен");

                System.out.println("При наличии товаров продолжайте вводить название и стоимость, если нет, то введите команду 'Завершить'");
            }

            calculator.printGoods();
            System.out.println("Каждый должен заплатить по " + formatter.formatPaid(calculator.getSplitBill()));
        }

        scanner.close();
    }
}