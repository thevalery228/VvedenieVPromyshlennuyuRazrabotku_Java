package com.company;
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        ArrayList<IKadr> mas = new ArrayList<IKadr>();

        FileReader fr = new FileReader("Сотрудники.txt");
        Scanner s = new Scanner(fr);
        s.nextLine();

        Factory factory = new Factory();

        while (s.hasNextLine())
        {
            String[] str = s.nextLine().split("\t");

            mas.add(factory.getCurrentKadr(str[0]));

            if (str[0].equals("Диспетчер")){
                mas.set(mas.size()-1, new Dispatcher(str[1], Integer.parseInt(str[2]), Integer.parseInt(str[3]),
                        Boolean.parseBoolean(str[4]), str[5], Integer.parseInt(str[6]),Integer.parseInt(str[7])));
            }

            if (str[0].equals("ПассажирскийВодитель")){
                mas.set(mas.size()-1, new PassangerDriver(str[1], Integer.parseInt(str[2]), Boolean.parseBoolean(str[3]),
                        Integer.parseInt(str[4]), Boolean.parseBoolean(str[5]), Boolean.parseBoolean(str[6]),
                        Boolean.parseBoolean(str[7]), Boolean.parseBoolean(str[8]), Boolean.parseBoolean(str[9])));
            }

            if (str[0].equals("ГрузовойВодитель")){
                mas.set(mas.size()-1, new LuggageDriver(str[1], Integer.parseInt(str[2]), Boolean.parseBoolean(str[3]),
                        Integer.parseInt(str[4]), Boolean.parseBoolean(str[5]), Boolean.parseBoolean(str[6]),
                        Boolean.parseBoolean(str[7]), Boolean.parseBoolean(str[8]), Boolean.parseBoolean(str[9])));
            }
        }
        fr.close();

        int count = 0;
        System.out.println("");
        System.out.println("Сотрудники с зарплатой более 15000:");
        for (int i=0; i<mas.size(); i++) {
            ZPInterface zpi = (zp) -> (zp > 15000);
            if (zpi.test(mas.get(i).getZP())){
                System.out.println(mas.get(i).toString() + " Зарплата: " + mas.get(i).getZP());
                count++;
            }
        }
        System.out.println("Количество: " + count);

        count = 0;
        System.out.println("");
        System.out.println("Сотрудники с зарплатой более 20000:");
        for (int i=0; i<mas.size(); i++) {
            ZPInterface zpi = (zp) -> (zp > 20000);
            if (zpi.test(mas.get(i).getZP())){
                System.out.println(mas.get(i).toString() + " Зарплата: " + mas.get(i).getZP());
                count++;
            }
        }
        System.out.println("Количество: " + count);
    }
}
