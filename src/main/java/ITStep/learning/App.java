package ITStep.learning;

import ITStep.learning.db.DbDemo;
import ITStep.learning.files.DirDemo;
import ITStep.learning.files.IoDemo;
import ITStep.learning.oop.*;

import java.io.File;
import java.text.ParseException;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){
        new DbDemo().run();
//        new IoDemo().run() ;
//        new DirDemo().run() ;

    }

    public static void oop( String[] args ){

            Library library = new Library();
            library.add(new Book("Knuth", "Art of programming"));
            library.add(new Book("Shevchenko","Kobzar"));
            library.add(new Journal(10,"ArgC & ArgV"));
            library.add(new Journal(5,"Nature"));

            try{
                library.add(new Newspaper( "12.12.2022", "The Times"));
                library.add(new Newspaper("13.12.2022", "Positive News"));
                library.add(new Comics("Marvel", 1, "14.12.2022"));
            }
            catch (ParseException ignored) {
                System.err.println("Date parse error!!!!");
            }
            library.add(new AudioBook("Kobzar. Shevchenko", "SuperSound Studio"));
            library.printFunds();

            System.out.println( "-----------------------------------------" ) ;
            library.showPrinted() ;
            System.out.println( "-----------------------------------------" ) ;
            library.playAll() ;


    }

    public static void Game( String[] args )
    {
        //region Игра "Угадай число"
        int UserNumber, CompNumber,  count = 0;
        final int lifeCount = 7;
        System.out.println("Игра 'Угадайка'. Угадай число (от 0 до 100). У тебя 7 жизней. Удачи!");
        Scanner input = new Scanner(System.in);
        CompNumber  = (int)Math.floor(Math.random()*100);
        do{
            count++;
            if(count > lifeCount)
            {
                System.out.print("ТЫ потратил все свои жизни! До скорой встречи!! ");
                break;
            }
            System.out.print("Введите ваше число: ");
            UserNumber = input.nextInt();

            if(UserNumber> CompNumber )
                System.out.println("Мое число меньше.");

            else if(UserNumber < CompNumber )
                System.out.println("Мое число больше.");

            else
                System.out.println("!!!!Вы угадали!!!");
        }
        while (UserNumber != CompNumber);
        System.out.println("Количество попыток:" + count);
        //endregion
    }

    public static void Hello( String[] args )
    {
        // region Переменные и типы данных
        //Числовые - особенности, все числовые типы знаковые, беззнаковых не существует.
        byte byteVar = 10; // -128..127 = 256 комбинаций
        short shortVar = 30000;
        int intVar = 2000000000;
        long longVar = (long)1e15;

        float floatVar = 0.01f;
        double doubleVar = 1e-5;

        //Символьный
        char charVar = 'A';

        //Строковые
        String stringVar = "A string";
        String stringVar2 = String.format("....","A string");
        //оператор == для строк не перегружен, проверяется ссылочные равенство
        //для сравнения строк метод strungVar.equals(stringVar);


        //логический
        boolean boolVar = true;

        //константы
        final int constVar = 100;


        // endregion

        //region Правила
        // Все типы, кроме примитивов, - ссылочные. Примитивы - значимые, но свои типы не делаются
        // для примитивов есть ссылочные аналоги
        //Integer - int,  Double - double
        //перегрузки операторов нет
        //Object - общий родительский класс
        // endregion

        //region Input/output
//        System.out.println("println - Output with new line");
//        System.out.print("print - Output without new line");
//        System.out.printf("printf - formatted Output x=%d", byteVar);
//        System.err.println("err.println - Output error");
//        //System.in файловый (потоковый) формализм,  прямая работа  с ним крайне не удобна
//        Scanner scanner = new Scanner(System.in);
//        int x = scanner.nextInt();
//        String s = scanner.next();
//        System.out.printf( "x=%d, s= %s %n",x,s );
        //endregion



    }
}


/*
Введение и настройка
1. Intellij Idea (Ultimate, Student License)
2. JDK - Java Developer KIT (компилятор)
3. Новый проект - Maven - archetype - QuickStart

Java схожа с .NET , но менее скрывает подробности
Общая схема
App.java (текст, исходный код)---JDK---> App.class (промежуточный код)
App.class--JRE/JVM-->исполнение
Сборка JAR(JavaArchive) = Dll(библиотека классов)

Управление пакетами (и зависимости) -- Единой нет, Выбирается при создании проекта
Одна из наиболее популярных - Maven, а так же Gradle, Ant
Maven:
-содержит репозиторий пакетов,
которые подключаются через файл pom.xml
 3. Запуск и конфигурация запуска
Edit Configuration --> + --> Application [name: App, main class: App]


 */
/*
Java строго с именованием
- В одном файле может быть один только public класс
 !!!!один класс на несколько файлов не разбивается!!!!
- Название файла соответствует названию класса
-
 */
