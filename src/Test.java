public class Test {
    public static void main(String[] args) {
        // Создаем объект библиотеки
        Library library = new Library();
        // Добавляем книги
        library.addBook("Евгений Онегин", "Пушкин А. С.", 224, "Прочитано");
        library.addBook("Война и мир", "Толстой Л. Н.", 5202, "Не прочитано");
        library.addBook("Преступление и наказание", "Достоевский Ф. М.", 672, "Прочитано");
        library.addBook("Герой нашего времени", "Лермонтов М. Ю.", 224, "Прочитано");
        library.addBook("Руслан и Людмила", "Пушкин А. С.", 288, "Прочитано");
        // Выводим содержимое библиотеки
        library.getShelf();
        System.out.println();
        // Изменяю статус книги
        library.setStatus("Руслан и Людмила", "Пушкин А. С.");
        library.getShelf();
        System.out.println();
        // Сортирует книги по автору
        library.sortAuthor();
        library.getShelf();
        System.out.println();
        // Сортирует книги по количеству страниц
        library.sortPage();
        library.getShelf();
        System.out.println();
        // Показывает все книги указанного автора
        library.thisAuthor("Пушкин А. С.");
        System.out.println();
        // Выводит непрочитанные книги
        library.unreadBook();
        System.out.println();
        // Возвращает сумму непрочитанных страниц
        System.out.println(library.sumUnreadPage());
        System.out.println();
        // Удаляет указанную книгу
        library.deleteBook("Евгений Онегин", "Пушкин А. С.");
        library.getShelf();
        System.out.println();
        // Возвращает книгу, у которой больше всего страниц
        System.out.println(library.maxPageBook());
        System.out.println();
        // Возвращает долю непрочитанных страниц
        System.out.println(library.percentUnreadBook());
    }
}
