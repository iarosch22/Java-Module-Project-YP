import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int clients = 0;
        Calculator calculator = new Calculator();
        Formatter formatter = new Formatter();


        System.out.println("На сколько человек необходимо разделить счет?");

        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\n");

        while (true) {
            if (scanner.hasNextInt()) {
                clients = scanner.nextInt();

                if (clients == 1) {
                    System.out.println("Считать нечего. Спасибо!");
                    break;
                } else if (clients > 1) {
                    scanner.nextLine();
                    break;
                } else {
                    System.out.println("Введено неверное значение. Просьба повторить еще.");
                    scanner.nextLine();
                }
            } else {
                System.out.println("Введено неверное значение. Просьба повторить еще.");
                scanner.nextLine();
            }
        }

        if (clients > 1) {
            String name;
            double price;

            System.out.println("Необходимо сообщить название товара и его стоимость.");

            while (true) {
                System.out.println("Введите название товара");
                name = scanner.nextLine();

                System.out.println("Введите стоимость товара");

                while (true) {
                    if (scanner.hasNextDouble()) {
                        price = scanner.nextDouble();

                        if (price > 0) {
                            scanner.nextLine();
                            break;
                        } else {
                            System.out.println("Введено неверное значение. Просьба повторить еще.");
                            scanner.nextLine();
                        }
                    } else {
                        System.out.println("Введено неверное значение. Просьба повторить еще.");
                        scanner.nextLine();
                    }
                }

                calculator.setGoods(name, price);

                System.out.println("Товар " + name + " по цене " + price + " успешно добавлен");

                System.out.println("Если товары закончились введите команду 'Завершить', если нет, то введите любой другой символ");

                String answer = scanner.nextLine();

                if (answer.equalsIgnoreCase("завершить")) {
                    System.out.println("Добавление товаров завершено.");
                    break;
                }
            }

            calculator.printGoods();
            System.out.println("Каждый должен заплатить по " + formatter.formatPaid(calculator.getSplitBill(clients)));
        }

        scanner.close();
    }
}