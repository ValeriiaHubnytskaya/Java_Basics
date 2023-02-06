package ITStep.learning.db;

import java.sql.*;
import java.util.Random;
import java.util.Scanner;

public class DbDemo {
    /**
     * Демонстрация работы с базы данными
     */
    public void run() {
        /*
        регистрируем драйвер
         */
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException: " + ex.getMessage());
            return;
        }
        //new com.mysql.cj.jdbc.Driver;
        //Подключение
        Connection connection;
        try
        {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/java_011?useUnicode=true&characterEncoding=UTF-8",
                    "user_011","pass_011"
            );
        }
        catch(SQLException ex)
        {
            System.err.println("COnnection error: "+ ex.getMessage());
            return;
        }
        System.out.println("Connection OK");

        //запросы: раздельно запросы с результатом и без результата
        String sql = "CREATE TABLE IF NOT EXISTS rands (id CHAR(36) PRIMARY KEY, num INT, str VARCHAR(32)) " +
                "ENGINE=INNODB DEFAULT CHARSET=utf8";
        try(Statement statement = connection.createStatement())
        {
            statement.executeUpdate(sql);
        }
        catch(SQLException ex)
        {
            System.err.println("CREATE error: "+ ex.getMessage());
            return;
        }
        System.out.println("CREATE OK");
        Random random = new Random();

//        sql = "INSERT INTO rands VALUES (UUID(), ?,?)"; //подготовленный запрос - с параметрами
//        try(PreparedStatement preparedStatement = connection.prepareStatement(sql))
//        {
//            //на место первого вопроса ставим число
//            preparedStatement.setInt(1,random.nextInt(100)); //!!;
//            //на место второго строку
//            preparedStatement.setString(2, "str" + random.nextInt(100));
//            //после заполнения всех параметров выполняем запрос
//            preparedStatement.executeUpdate();
//        }
//        catch(SQLException ex)
//        {
//            System.err.println("INSERT error: "+ ex.getMessage());
//            return;
//        }
//        System.out.println("INSERT OK");

        //запросы с возвратом результат
        sql = "SELECT id,num,str FROM rands";
        try(Statement statement = connection.createStatement())
        {
            ResultSet res = statement.executeQuery(sql);
            while(res.next()){ // ~fetch ~read
                System.out.println(res.getString(1)+ " " + res.getInt(2) + " " + res.getString(3));
            }
            res.close();
        }
             catch(SQLException ex)
        {
            System.err.println("SELECT error: "+ ex.getMessage());
            return;
        }
        //region Домашние задание БД
        //задание: использовать параметрический запрос в который передается число, а в выборку
        //  попадают только те данные, у которых num меньше этого числа
        int number;
        Scanner input = new Scanner(System.in);
        System.out.print("Введите ваше число: ");
        number = input.nextInt();
        sql = "SELECT num FROM rands";
        try(Statement statement = connection.createStatement()) {
            ResultSet res = statement.executeQuery(sql);
            while(res.next()){
               if(res.getInt(1)<=number){

                    System.out.println("Number: " + res.getInt(1) + ";");
                }
            }
            res.close();

        } catch(SQLException ex)
        {
            System.err.println("Number error: "+ ex.getMessage());
            return;
        }
        //то же самое, но в запрос передается строка, а выборка должна содержать введенную строку
        //  как подстроку в поле str (поисковый режим). Саму строку запросить у пользователя в консоли
        String str = "str";
        String userStr;
        System.out.print("Введите строку!");
        userStr = input.next();
        sql="SELECT str FROM rands";
        try(Statement statement = connection.createStatement()) {
            ResultSet res = statement.executeQuery(sql);
            userStr = str + userStr;
            while(res.next()){

                if( userStr.equals(res.getString(1))){

                    System.out.println("String: " + res.getString(1) + ";");
                }
            }
            res.close();

        } catch(SQLException ex)
        {
            System.err.println("String error: "+ ex.getMessage());
            return;
        }


        //endregion


    }
}
/*
    Работа с бд JDBC
    Коннекторы - библиотеки для работами с БД
 */
