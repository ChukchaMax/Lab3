import java.io.PrintStream;
import java.util.Scanner;

class Book { // Создает класс "Книга"
    private String name; // Поле с названием книги
    private String author; // Поле с именем автора
    private int page; // Поле с количеством страниц
    private boolean status; // Поле со статусом прочтения

    @Override // Изменяем метод
    public String toString() {
        if (status)
            return name + " - " + author + " - " + page + " стр. (Прочитано)"; // Возвращает строку, если книга прочитана
        else
            return name + " - " + author + " - " + page + " стр. (Не прочитано)"; // Возвращает строку, если книга не прочитана
    }

    public Book(String name, String author, int page, boolean status) { // Создает конструктор
        this.name = name;
        this.author = author;
        this.page = page;
        this.status = status;
    }

    public void setStatus() { // Метод изменяет статус книги
        status = !status;
    }

    public String getAuthor() { // Возвращает имя автора
        return author;
    }

    public String getName() { // Возвращает название книги
        return name;
    }

    public int getPage() { // Возвращает количество страниц
        return page;
    }

    public boolean getStatus() { // Возвращает статус прочтения
        return status;
    }
}

class Library {  // Создает класс "Библиотека"
    public static Scanner in = new Scanner(System.in);
    public static PrintStream out = System.out;

    private Book[] shelf; // Поле с массивом из книг, то есть полка

    public Library() { // Конструктор с массивом размером 0
        shelf = new Book[0];
    }

    public void addBook(String name, String author, int page, String readOrNo) { // Метод добавляет книгу в массив
        boolean status = readOrNo.equals("прочитано") || readOrNo.equals("Прочитано"); // Если пользователь ответил "прочитано"/"Прочитано", то статус ставится, как "Прочитано", иначе "Не прочитано"
        Book book = new Book(name, author, page, status); // Создается книга благодаря данным, введенным пользователем
        boolean test = true; // Проверка на то, есть ли в массиве такая книга
        for (int i = 0; i < shelf.length; i++) // Перебираем книги в массиве
            if (book.getAuthor().equals(shelf[i].getAuthor()) && book.getName().equals(shelf[i].getName())) // Если такая книга есть,
                test = !test; // то меняем статус теста
        if (test) { // Если тест принимает значение true, то книга добавляется в массив
            Book[] add = new Book[shelf.length + 1]; // Создается массив на 1 больше "полки"
            for (int i = 0; i < shelf.length; i++) // Перебираются элементы массива "полка"
                add[i] = shelf[i]; // Эти элементы добавляются в новый массив
            add[shelf.length] = book; // Новая книга добавляется в массив
            shelf = add; // "Полка" ссылается на новый массив, где есть новая добавленная книга
        }
    }

    public void getShelf() { // Метод показывает все книги
        for (int i = 0; i < shelf.length; i++) // Перебираются элементы массива
            out.println(shelf[i]); // Книги выводятся на экран
    }

    public void setStatus(String name, String author) { // Изменяет статус прочтения выбранной книги
        for (int i = 0; i < shelf.length; i++) // Перебор книг в массиве
            if (name.equals(shelf[i].getName())&&author.equals(shelf[i].getAuthor())) // Если название и автор совпадают,
                shelf[i].setStatus(); // то у книги меняется статус
    }

    public void sortAuthor() { // Метод сортирует книги по имени автора или по названию
        for (int i = 0; i < shelf.length - 1; i++) {
            for (int j = 0; j < shelf.length - i - 1; j++) { // Сортировка пузырьком
                if (shelf[j].getAuthor().equals(shelf[j + 1].getAuthor())) { // Если книги одного автора, то сортировка выполняется по названию
                    int k = 0; // Счетчик
                    while (shelf[j].getName().charAt(k) == shelf[j + 1].getName().charAt(k)) { // Перебирает буквы в слове, пока буквы не будет отличаться
                        k++;
                    }
                    if (shelf[j].getName().charAt(k) > shelf[j + 1].getName().charAt(k)) { // Если у следующего слова, отличающаяся буква стоит раньше в алфавите,
                        Book temp = shelf[j]; // то меняет слова местами
                        shelf[j] = shelf[j + 1];
                        shelf[j + 1] = temp;
                    }
                } else { //То же самое, если авторы разный
                    int k = 0;
                    while (shelf[j].getAuthor().charAt(k) == shelf[j + 1].getAuthor().charAt(k)) {
                        k++;
                    }
                    if (shelf[j].getAuthor().charAt(k) > shelf[j + 1].getAuthor().charAt(k)) {
                        Book temp = shelf[j];
                        shelf[j] = shelf[j + 1];
                        shelf[j + 1] = temp;
                    }
                }
            }
        }
    }

    public void sortPage() { // Метод сортирует книги по количеству страниц
        for (int i = 0; i < shelf.length - 1; i++) {
            for (int j = 0; j < shelf.length - i - 1; j++) { // Сортировка пузырьком
                if (shelf[j].getPage() < shelf[j + 1].getPage()) { // Если страниц в следующей книге больше,
                    Book temp = shelf[j]; // то книги меняются местами
                    shelf[j] = shelf[j + 1];
                    shelf[j + 1] = temp;
                }
            }
        }
    }

    public void thisAuthor(String author) { // Метод показывает все книги заданного автора
        for (int i = 0; i < shelf.length; i++) { // Перебираются книги в массиве
            if (shelf[i].getAuthor().equals(author)) // Если автор совпадает,
                out.println(shelf[i]); // то книга выводится на экран
        }
    }

    public void unreadBook() { // Метод возвращает непрочитанные книги
        for (int i = 0; i < shelf.length; i++) { // Перебираются книги в массиве
            if (!shelf[i].getStatus()) // Если статус !true,
                out.println(shelf[i]); // то выводить книгу на экран
        }
    }

    public int sumUnreadPage() { // Метод возвращает сумму страниц у непрочитанных книг
        int s = 0; // Сумма
        for (int i = 0; i < shelf.length; i++) { // Перебирает книги в массиве
            if (!shelf[i].getStatus()) // Если статус !true,
                s += shelf[i].getPage(); // то суммирует страницы
        }
        return s; // Возвращает сумму
    }

    public void deleteBook(String name, String author) { // Метод удаляет книгу из массива
        boolean test = false; // Проверка, есть ли книга в массиве
        for (int i = 0; i < shelf.length; i++) // Перебирает книги в массиве
            if (author.equals(shelf[i].getAuthor()) && name.equals(shelf[i].getName())) // Если книга есть,
                test = !test; // то изменяет тест на true
        if (test) {
            Book[] delete = new Book[shelf.length - 1]; // Создается новый массив длины на 1 меньше "полки"
            for (int i = 0, j = 0; i < shelf.length; i++) // Перебираются книги в массиве
                if (!(shelf[i].getName().equals(name) && shelf[i].getAuthor().equals(author))) { // Если книга не совпала с введенными данными пользователем,
                    delete[j] = shelf[i]; // то книга добавляется в новый массив
                    j++; // Счетчик перебирающий элементы в новом массиве
                }
            shelf = delete; // "Полка" ссылается на новый массив
        }
    }

    public Book maxPageBook() { // Метод возвращает книгу с наибольшим количеством страниц
        int im = 0; // Пусть у первой книги больше всего страниц
        for (int i = 0; i < shelf.length; i++) // Перебираются книги в массиве
            if (shelf[i].getPage() > shelf[im].getPage()) // Если в какой-то книге страниц больше,
                im = i; // то запоминаем ее
        return shelf[im]; // Возвращается книга с наибольшим количеством страниц
    }

    public double percentUnreadBook() { // Метод возвращает долю непрочитанных книг
        if (shelf.length == 0) // Если книг вообще нет,
            return 0; // то возвращаем 0
        else {
            int k = 0; // Счетчик
            for (int i = 0; i < shelf.length; i++) // Перебираются книги в массиве
                if (!shelf[i].getStatus()) // Считаем сколько непрочитанных книг
                    k++;
            return (double) k / shelf.length; // Делим это количество на длину массива, то есть на количество всех книг и возвращаем результат
        }
    }
}

public class Main {
    public static Scanner in = new Scanner(System.in);
    public static PrintStream out = System.out;

    public static void main(String[] args) {
    }
}