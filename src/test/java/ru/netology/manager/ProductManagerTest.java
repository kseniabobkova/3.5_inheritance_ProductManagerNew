package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Product;
import ru.netology.domain.Book;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;


public class ProductManagerTest {

    ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);

    private Book first = new Book(1, "first", 100, "author1");
    private Book second = new Book(2, "second", 100, "author1");
    private Book third = new Book(3, "first", 200, "author2");
    private Book fourth = new Book(4, "third", 300, "author3");
    private Book fifth = new Book(5, "fourth", 200, "author3");
    private Smartphone sixth = new Smartphone(1, "first", 100, "producer1");
    private Smartphone seventh = new Smartphone(2, "second", 100, "producer1");
    private Smartphone eighth = new Smartphone(1, "first", 200, "producer2");
    private Smartphone ninth = new Smartphone(1, "third", 300, "producer3");
    private Smartphone tenth = new Smartphone(1, "fourth", 200, "producer3");

    @BeforeEach
    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);
    }


    @Test
    public void shouldSearchSame() {

        manager.searchBy("first");

        Product[] expected = new Product[]{first, third, sixth, eighth};
        Product[] actual = manager.searchBy("first");
        assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSearchByAuthor() {

        manager.searchBy("author1");

        Product[] expected = new Product[]{first, second};
        Product[] actual = manager.searchBy("author1");
        assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSearchByProducer() {

        manager.searchBy("Producer1");

        Product[] expected = new Product[]{sixth, seventh};
        Product[] actual = manager.searchBy("Producer1");
        assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSearchNotExistBook() {

        manager.searchBy("author4");

        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("author4");
        assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSearchNotExistSmartphone() {

        manager.searchBy("producer4");

        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("producer4");
        assertArrayEquals(expected, actual);

    }

}
