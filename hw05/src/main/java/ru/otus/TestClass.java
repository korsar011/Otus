package ru.otus;

public class TestClass {
    @Test
    public void method () throws Exception {
        throw new Exception ("ОШИБКА");
    }

    @After
    public void method1 () {

    }


    @Before
    public void method2 () {

    }
}
