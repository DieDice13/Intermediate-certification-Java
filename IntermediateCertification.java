/*
Подумать над структурой класса Ноутбук для магазина техники - выделить поля и 
методы. Реализовать в java.
Создать множество ноутбуков.
Написать метод, который будет запрашивать у пользователя критерий (или критерии) 
фильтрации и выведет ноутбуки, отвечающие фильтру. Критерии фильтрации можно 
хранить в Map. Например:
“Введите цифру, соответствующую необходимому критерию:
1 - ОЗУ
2 - Объем ЖД
3 - Операционная система
4 - Цвет …
Далее нужно запросить минимальные значения для указанных критериев - сохранить 
параметры фильтрации можно также в Map.
Отфильтровать ноутбуки их первоначального множества и вывести проходящие по 
условиям
*/

import java.util.*;

class Laptop {
    String os;
    int ram;
    int hdd;

    public Laptop(String os, int ram, int hdd) {
        this.os = os;
        this.ram = ram;
        this.hdd = hdd;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                ", os='" + os + '\'' +
                ", ram=" + ram +
                ", hdd=" + hdd +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Laptop laptop = (Laptop) o;
        return ram == laptop.ram &&
                hdd == laptop.hdd &&
                Objects.equals(os, laptop.os);
    }

    @Override
    public int hashCode() {
        return Objects.hash(os, ram, hdd);
    }
}

public class IntermediateCertification {

    public static void main(String[] args) {
        Set<Laptop> laptops = new HashSet<>();
        laptops.add(new Laptop("Windows", 8, 500));
        laptops.add(new Laptop("Mac", 16, 256));
        laptops.add(new Laptop("Linux", 4, 1000));

        Scanner scanner = new Scanner(System.in);
        while (true) {
            Map<String, String> filters = new HashMap<>();
            System.out.println(
                    "Введите цифру, соответствующую необходимому критерию:\n1 - ОЗУ\n2 - Объем ЖД\n3 - Операционная система\n Или выберите 4 для выхода из программы");
            int choice = scanner.nextInt();
            System.out.println();
            if (choice == 1) {
                System.out.println("Введите минимальное значение ОЗУ:");
                filters.put("ram", String.valueOf(scanner.nextInt()));
            }
            if (choice == 2) {
                System.out.println("Введите минимальный объем ЖД:");
                filters.put("hdd", String.valueOf(scanner.nextInt()));
            }
            if (choice == 3) {
                System.out.println("Введите интересующую os:");
                filters.put("os", scanner.next());
            }
            if (choice == 4) {
                break;
            }

            for (Laptop laptop : laptops) {
                if (filters.containsKey("ram") && laptop.ram < Integer.parseInt(filters.get("ram"))) {
                    continue;
                }
                if (filters.containsKey("hdd") && laptop.hdd < Integer.parseInt(filters.get("hdd"))) {
                    continue;
                }
                if (filters.containsKey("os") && !laptop.os.equals(filters.get("os"))) {
                    continue;
                }
                System.out.println(laptop);
            }
        }

    }

}


