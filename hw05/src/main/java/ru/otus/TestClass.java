package ru.otus;

public class TestClass {
    @Test
    public void method () throws Exception {
        throw new Exception ("Ошибка");
    }

    @After
    public void method1 () {

    }


    @Before
    public void method2 () {

    }
}
