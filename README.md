## Отчет по лабораторной работе № 3

#### № группы: `ПМ-2401`
  
#### Выполнил: `Ядыкин Максим Михайлович`

#### Вариант: `31`

### Cодержание:

- [Постановка задачи](#1-постановка-задачи)
- [Входные и выходные данные](#2-входные-и-выходные-данные)
- [Математическая модель](#25-математическая-модель)
- [Выбор структуры данных](#3-выбор-структуры-данных)
- [Алгоритм](#4-алгоритм)
- [Программа](#5-программа)
- [Анализ правильности решения](#6-анализ-правильности-решения)

### 1. Постановка задачи

> #### Краткое описание
> Разработать программу для управления личной библиотекой, включающей книги с информацией о названии, авторе, количестве страниц и статусе прочтения. Реализовать функции добавления, удаления, сортировки книг и анализа прогресса чтения.
> #### Описание функционала
> #### 1. Добавление книги
> Добавляет книгу с указанными названием, автором и количеством страниц. Если книга с таким названием и автором уже существует, добавление не выполняется.
> #### 2. Вывод всех книг
> Отображает список всех книг в библиотеке с указанием названия, автора, количества страниц и статуса (прочитана или нет).
> #### 3. Отметить книгу прочитанной
> Устанавливает статус книги «прочитана» по её названию и автору. Если книги с такими данными нет, действие не выполняется.
> #### 4. Сортировка книг по авторам
> Сортирует книги по фамилиям авторов в алфавитном порядке. Если фамилии совпадают, сортировка выполняется по названиям книг.
> #### 5. Сортировка книг по количеству страниц
> Сортирует книги по количеству страниц в порядке убывания.
> #### 6. Вывод книг заданного автора
> Отображает список всех книг указанного автора.
> #### 7. Вывод непрочитанных книг
> Выводит список всех книг, которые ещё не были прочитаны.
> #### 8. Подсчёт страниц непрочитанных книг
> Возвращает общее количество страниц у всех непрочитанных книг.
> #### 9. Удаление книги
> Удаляет книгу по её названию и автору. Если книга не найдена, действие не выполняется.
> #### 10. Книга с наибольшим количеством страниц
> Находит книгу с максимальным количеством страниц. Если таких книг несколько, возвращается первая по порядку добавления.
> #### 11. Процент прочитанных книг
> Вычисляет процент прочитанных книг в библиотеке. Если в библиотеке нет книг, возвращает 0%.

Для данной задачи нужно написать два класса: "Библиотека" и "Книга".
Для класса "Книга" нужно описать поля с названием книги, именем автора, количеством страниц и статусом прочтения и создать методы возвращающие значения этих полей и метод изменяющий статус.
Для класса "Библиотека" нужно описать только поле с массивом книг. После этого можно выполнить 11 подзадани:
1. Проверяем, есть ли уже данная книга в массиве. Если такой книги нет, то создаем массив на 1 больше, прежнего массива. Добавляем в него старые книги, добавляем новую книг. Потом ссылаемся на этот массив.
2. Выводим при помощи цикла с счетчиком все книги на экран.
3. Находим книгу в массиве и меняем ее статус при помощи метода.
4. Сортируем пузырьком. Если автор у книг один, то сортируем по названию. Перебираем буквы, пока не попадутся две разные буквы.
5. Сортируем пузырьком книги по количеству страниц.
6. Перебираем книги, если имя автора совпадает с указанным, то выводим книгу на экран.
7. Перебираем книги, если статус "не прочитанно", то выводим книгу на экран
8. Перебираем книги, если статус "не прочитанно", прибавляем количество страниц к сумме. Возвращаем сумму.
9. Проверяем, есть ли такая книга в массиве. Если есть, то создаем массив на 1 меньше и добавляем туда все книги, кроме указанной.
10. Находим максимальный элемент массива по странницам.
11. Считаем сколько непрочитанных книг и делим это количество на длину массива.

### 3. Выбор структуры данных

Класс `Book` состоит из названия книги, имени автора, количества страниц и статусе прочтения. Значит нужно выделить 4 переменные: две переменные `name` и `author` типа данных `String`, одну переменную типа `int` для количества страниц `page`, и переменую `status` типа данных `boolean`.
Класс `Library` состоит из набора книг, то есть нужно создать массив `shelf` типа `Book[]`.

|                    | название переменной | Тип (в Java) | 
|--------------------|---------------------|--------------|
| Название книги     | `name`              | `String`     |
| Имя автора         | `author`            | `String`     |
| Количество страниц | `page`              | `int`        |
| Статус прочтения   | `status`            | `boolean`    | 
| Набор книг         | `shelf`             | `Book[]`     |

### 4. Классы

#### Класс `Book`:

1. **setStatus**  
   Метод изменяет статус прочтения.

2. **getAuthor**  
   Метод возвращает имя автора `author`.

3. **getName**
   Метод возвращает название книги `name`.

5. **getPage**
   Метод возвращает количество страниц в книге `page`.

6. **getStatus**  
   Метод возвращает статус прочтения `status`.

#### Класс `Library`:

1. **addBook**
   Метод проверяет есть ли указанная книга. Если нет, то создает массив `add`, длина которого на 1 больше массива `shelf`. Добавляет все книги из массива `shelf` в массив `add`. В конец добавляет указанную книгу. `shelf` ссылается на новый массив.

2. **getShelf**
   Метод перебирает книги и выводит их поочереди на экраг.

3. **setStatus**
   Метод перебирает книги и у указанной меняет статус.

4. **sortAuthor**
   Метод сортирует пузырьком. Проверяет текущая и следующая имеет однго автора или разных. Если разных, то перебираются буквы до первой не совпадающей. Если у текущего слова буква стоит позже в алфавите, то книги меняются местами. Если автор один, аналогично для названий.

5. **sortPage**
   Метод сортирует пузырьком. Если у текущей книги страниц меньше, чем у следующей, то книги меняются местами.

6. **thisAuthor**
   Метод перебирает книги, если автор книги совпадает с указанным, то книга выводится на экран.

7. **unreadBook**
   Метод перебирает книги, если у них статус `!true`, то они выводятся на экран.

8. **sumUnreadPage**
   Метод перебирает книги. Если у книги статус `!true`, то количество страниц `page` добавляется к общей сумме. Возвращается эта сумма.

9. **deleteBook**
    Метод проверяет есть ли указанная книга в массиве `shelf`. Если есть, то создается новый массив `delete`, длина которого на 1 меньше длины массива `shelf`. Перебираются книги и добавляются в массив `delete` все, кроме указанной. `shelf` ссылается на новый массив.

10. **maxPageBook**
    Предполаагается, что максимально страниц у первой книги. Перебираются книги, и если у книги больше страниц, то запоминается ее индекс. Возвращается данная книга.

11. **percentUnreadBook**
    Метод перебирает книги и считает количество непрочитанных. Возвращает частое количества на длину массива.

   
### 5. Программа

```java
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
```

### 6. Анализ правильности решения

Программа работает корректно на всем множестве решений с учетом ограничений.

1. Тест на `N=1`:

    - **Input**:
        ```
        1
        ```

    - **Output**:
        ```
        Сумма всех нечетных чисел: 1
        Двоичное представление чисел: 1
        Сумма цифр каждого числа: 1
        ```

2. Тест на `N=10`:

    - **Input**:
        ```
        10
        ```

    - **Output**:
        ```
        Сумма всех нечетных чисел: 99
        Двоичное представление чисел: 1000 101 11 10 1 1 110111 100010 10101 1101
        Сумма цифр каждого числа: 8 5 3 2 1 1 10 7 3 4 
        ```