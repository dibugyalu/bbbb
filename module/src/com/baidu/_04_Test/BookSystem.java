package com.baidu._04_Test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class BookSystem {
    private final List<Book> books = new ArrayList<>();
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public void addBook(Book book) {
        lock.writeLock().lock();
        try {
            books.add(book);
        } finally {
            lock.writeLock().unlock();
        }
    }

    public List<Book> getBooks() {
        lock.readLock().lock();
        try {
            return new ArrayList<>(books);
        } finally {
            lock.readLock().unlock();
        }
    }

    public void updateBookTitle(int bookId, String newTitle) {
        lock.writeLock().lock();
        try {
            for (Book book : books) {
                if (book.getId() == bookId) {
                    book.setTitle(newTitle);
                    break;
                }
            }
        } finally {
            lock.writeLock().unlock();
        }
    }

    public static void modifyBookTitleUsingReflection(Book book, String newTitle) throws Exception {
        Field titleField = Book.class.getDeclaredField("title");
        titleField.setAccessible(true);
        titleField.set(book, newTitle);
    }
}
