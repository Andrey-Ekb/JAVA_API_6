/*
 * 1 Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. 
 *   Реализовать в java.
 * 2 Создать множество ноутбуков.
 * 3 Написать метод, который будет запрашивать у пользователя критерий фильтрации и выведет 
 * ноутбуки, отвечающие фильтру.
 * NoteBook notebook1 = new NoteBook
 * NoteBook notebook2 = new NoteBook
 * NoteBook notebook3 = new NoteBook
 * NoteBook notebook4 = new NoteBook
 * NoteBook notebook5 = new NoteBook
 * 
 * Например: “Введите цифру, соответствующую необходимому критерию:
 * 1 - ОЗУ
 * 2 - Объем ЖД
 * 3 - Операционная система
 * 4 - Цвет
 * 
 * Далее нужно запросить минимальные значения для указанных критериев - сохранить параметры 
 * фильтрации можно также в Map.
 * Отфильтровать ноутбуки их первоначального множества и вывести проходящие по условиям.
 * 
 * Класс сделать в отдельном файле
 * 
 * приветствие
 * Выбор параметра
 * выбор конкретнее
 * вывод подходящих
 */

 import java.util.Arrays;
 import java.util.HashMap;
 import java.util.HashSet;
 import java.util.Iterator;
 import java.util.Scanner;
 import java.util.Map.Entry;
 
 public class task_6 {
     public static void main(String[] args) {
 
         System.out.println();
         System.out.println("Здравствуйте");
         System.out.println("список имеющихся компьюторов: ");
         System.out.println();
 
         notebook nout1=new notebook("A5","Xiaomi");
         nout1.setColor("black");
         nout1.setHDD(200);
         nout1.setOS("Windows");
         nout1.setRAM(8);
         
         notebook nout2=new notebook("ABC30","Acer");
         nout2.setColor("white");
         nout2.setHDD(200);
         nout2.setOS("Windows");
         nout2.setRAM(8);
 
         notebook nout3=new notebook("AB97","Acer");
         nout3.setColor("While");
         nout3.setHDD(250);
         nout3.setOS("Windows 10");
         nout3.setRAM(16);
 
         notebook nout4=new notebook("OMAN11","hp");
         nout4.setColor("black");
         nout4.setHDD(500);
         nout4.setOS("Linux");
         nout4.setRAM(8);
 
         notebook nout5=new notebook("MAC101","Apple");
         nout5.setColor("silver");
         nout5.setHDD(1000);
         nout5.setOS("macOS");
         nout5.setRAM(32);
         
         HashSet <notebook> notebooks = new HashSet<>(Arrays.asList(nout1,nout2,nout3,nout4,nout5));
         HashSet <notebook> res = new HashSet<>();
 
         System.out.println();
         System.out.print("Выберите параметр отбора:\n 1 - ОЗУ \n 2 - Объем HDD \n 3 - Операционная система \n 4 - цвет \n");
         System.out.print(" Выберете параметр - ");
         System.out.println();
         Scanner sc = new Scanner(System.in);
         String n="";
         n = sc.nextLine();
 
         HashMap<String, Object> filters = new HashMap<>();
         switch (n) {
             case "1": {
                 System.out.println("Введите минимальную оперативную память (8,16,32): ");
                 System.out.println("параметры ОЗУ: - 8 ГБ, - 16 ГБ, 32 ГБ.\n");
                 System.out.println("Введите минимальные требования по ОЗУ ");
                 Integer temp = sc.nextInt();
                 sc.nextLine();
                 filters.put("RAM", temp); 
                 break;
             }   
             case "2":{
                 System.out.println("Введите минимальный объем HDD (200, 250, 500, 1000) : " );
                 System.out.println("параметры жестких дисков:\n - обьем 200 гБ\n - обьем 250 гБ\n - обьем 500 гБ \n - обьем 1 тБ\n");
                 System.out.println("введите минимальный обькм диска - ");
                 Integer temp = sc.nextInt();
                 sc.nextLine();
                 filters.put("HDD", temp);
                 break;
             }
             case "3":{
                 System.out.println("Выберите ОС");
                 System.out.println("операционные системы: \n Windows\n Windows 10 \n Lenux\n Mas OC\n");
                 System.out.println("Выберите операционную систему : ");
                 String temp = sc.nextLine();
                 filters.put("OS", temp);
                 break;
             }
             case "4":{ 
                 System.out.println("Выберите цвет (while, black, silver) : ");
                 String temp = sc.nextLine();
                 filters.put("color", temp);                
                 break;
             }
             default:
                 System.out.println("данный параметр не используется");
                 System.out.println("Выход");
                 break;
         }
         System.out.println("");
         
         for (Entry<String, Object> entry : filters.entrySet()) {
             if(entry.getKey().equals("RAM")){
                 Iterator it = notebooks.iterator();
                 while(it.hasNext()){
                     notebook nout = (notebook) it.next();
                     if(nout.getRAM()>=(Integer)entry.getValue()){
                         res.add(nout);
                     }
                 }
             }
              if(entry.getKey().equals("HDD")){
                 Iterator it = notebooks.iterator();
                 while(it.hasNext()){
                     notebook nout = (notebook)it.next();
                     if(nout.getHDD()>=(Integer)entry.getValue()){
                         res.add(nout);
                     }
                 }
             }
 
             if(entry.getKey().equals("OS")){
                 Iterator it = notebooks.iterator();
                 while(it.hasNext()){
                     notebook nout = (notebook)it.next();
                     if(nout.getOS().equals(entry.getValue())){
                         res.add(nout);
                     }
                 }
             }
 
             if(entry.getKey().equals("color")){
                 Iterator it = notebooks.iterator();
                 while(it.hasNext()){
                     notebook nout = (notebook)it.next();
                     if(nout.getColor().equals(entry.getValue())){
                         res.add(nout);
                     }
                 }
             }
         }
         
         Iterator it = res.iterator();
         while(it.hasNext()){
         notebook nout = (notebook)it.next();
         System.out.println(nout.toString());
         System.out.println();
         }
     }
 }
 