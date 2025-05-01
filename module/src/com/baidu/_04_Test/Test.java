package com.baidu._04_Test;

/*
    在一个图书管理系统中，有一个 `Book` 类，包含 `id`、`title` 和 `author` 三个属性。系统中有一个 `BookLibrary` 类，用于管理图书列表。要求实现以下功能：

1. 使用 `ReentrantReadWriteLock` 对图书列表的读写操作进行加锁，确保线程安全。
2. 使用反射机制修改 `Book` 对象的 `title` 属性。
3. 实现 `Book` 类的浅克隆方法。
 */

public class Test {
    public static void main(String[] args) {
        try {
            BookSystem library = new BookSystem();
            Book book1 = new Book(1, "Java Programming", "Author A");
            library.addBook(book1);
            System.out.println("Before Reflection: " + book1);

            BookSystem.modifyBookTitleUsingReflection(book1, "Advanced Java");
            System.out.println("After Reflection: " + book1);

            Book clonedBook = (Book) book1.clone();
            System.out.println("Cloned Book: " + clonedBook);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
