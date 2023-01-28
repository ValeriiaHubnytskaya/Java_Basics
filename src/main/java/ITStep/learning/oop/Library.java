package ITStep.learning.oop;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Literature> funds; //это интерфейс для коллекции

    public Library() {
        funds = new ArrayList<>(); // - конкретный тип
    }

    public void add(Literature literature){
        funds.add(literature);
    }
    public void printFunds(){
        if(funds.size()==0){
            System.out.println("Funds are empty");
        }
        else{
            for(Literature literature: funds){
                System.out.println(literature);
            }

        }
    }

}
/*
ООП - объекты + взаимодействие
- Инкапсулия
_ наследование
- Полиморфизм
= Абстрагирование (генерализация (книги, журналы, газеты - литература))

Book        Journal             Newspaper
 Author      Number              Date     --> Personal
 Title       Title               Title    --> General       -->Literature

 Literature(title), Book(author)
 ?можно ли вызывать book.setTitle()?                                +
 ?можно ли вызывать literature.setAuthor()?                         -
 ?можно ли просвоить this.title=".." (внутри класса LIterature)     +
 ?можно ли просвоить this.title=".." (внутри класса Book)           -
 ? Так есть ли поле title у объекта "книга" Да, но доступа к этому полю нет, тольео через аксессоры
 ? можно ли в классе Book описать свое поле title?                  +
 ? Что при этом происходит? Поле перекрывает или заменяет Родительское?  Перекрывают,
    создается два поля title, одно this.title  а второе super.title (скрыто по доступу)
? Если не переопределить геттер, какое значение вернет book.getTitle () ?  super
book = new Book()
book.title =      "1" (this.Title)
book.getTitle --> " " (super.Title)

--Literature--
[title,get,set] -a->[[title,get,set]+ author, get,set] +
                -b->[[title],get,set + author, get,set]
[[title,get,set]+ author, get,set,title]


 */