package ITStep.learning.ioc;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.name.Named;


public class Starter {
    @Inject    private Service1 service1;          //в описании класса нет аннотаций == Transient
    @Inject    private Service1 service1v2;        //Transient - создание новый объктов в каждой точке инъекции
    @Inject    private Service2 service2;          //в описании класса  аннотаций == Singleton
    @Inject    private Service2 service2v2;        //инъекции того же объекта, что и service2
    @Inject    private IService3 service3;          //более слабая связь - через интерфейс! Рекомендвано
    @Inject @Named("v1")   private IService4 service4v1;
    @Inject @Named("v2")   private IService4 service4v2;
    @Inject @Named("MySqlConnectionString")   private String myCs;
    @Inject @Named("OracleConnectionString")   private String OraCs;
    @Inject CtrDemo ctrDemo;
    @Inject private Config config;


    public void run(){
        System.out.println("Di Demo");
        service1.show();
        service1v2.show();
        service2.show();
        service2v2.show();
        service3.show();
        service4v1 .show();
        service4v2.show();
        System.out.println(myCs);
        System.out.println(OraCs);
        ctrDemo.show();
        config.show();


    }
}
/*
Инверсия управления. Внедрения зависимостей. Инверсия зависимостей.
    Инверсия управления - ""не зная типа исходных данных, не можем рабоать дальше
    решение - создание асбтракции. Делаем интерфейс Data и работаем с ним когда станет известен конкретный тип,
    мы реализуем интерфейс Complex:Data

    Внедрение зависимотей - создание "центра управления" жизненным циклом зависимостей
    Задача центра - решать вопрос создание новых объектов / использования раннее созданных объектов

    Инверсия зависимостей - ослабление связей, принцип "0" - дополнять, но не изменять.
    плохо classA (private classB dependency) - сильная связь классов А и В, + отклонение
    от "0" - нельзя дополнить зависимость, не изменив ClassB (дополнение == изменение)
    решение: classA(private InterfaceB dependency) ClassB: InterfaceB
    дополнение, создание нового класса и замена реализации для dependency



 */
/*
контейнер зависимостей - Google Guice
    - Google Guice
    - Spring
    - встроенная система Javax/CDI

    указываем зависимость https://mvnrepository.com/artifact/com.google.inject/guice/5.1.0
    Создаем модуль настройки зависимостей AppModule

 */
