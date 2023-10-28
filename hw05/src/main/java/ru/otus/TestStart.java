package ru.otus;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class TestStart <T>{
    static int totalTest = 0;
    static int passTest = 0;
    static int failedTest = 0;

    public void run (T testClass){
        runBeforeAnnotation(testClass);
        runTestAnnotation(testClass);
        runAfterAnnotation(testClass);
    }

    private void runBeforeAnnotation (T testClass) {
        Class <?> classOfTest = testClass.getClass();
        ArrayList<Method> array = new ArrayList<>(List.of(classOfTest.getMethods()));
        for (Method method : array) {
            if (method.isAnnotationPresent(Before.class)) {
                try {
                    method.invoke(testClass);
                    passTest++;
                } catch (Exception e) {
                    System.err.println("Ошибка в методе Before");
                    failedTest++;
                }
                totalTest++;
            }
        }
    }

    private void runTestAnnotation (T testClass) {
        Class <?> classOfTest = testClass.getClass();
        ArrayList<Method> array = new ArrayList<>(List.of(classOfTest.getMethods()));
        for (Method method : array) {
            if (method.isAnnotationPresent(Test.class)) {
                try {
                    method.invoke(testClass);
                    passTest++;
                } catch (Exception e) {
                    System.err.println("Ошибка в методе Test");
                    failedTest++;
                }
                totalTest++;
            }
        }
    }
        private void runAfterAnnotation (T testClass) {
        Class <?> classOfTest = testClass.getClass();
            ArrayList<Method> array = new ArrayList<>(List.of(classOfTest.getMethods()));
            for (Method method : array) {
                if (method.isAnnotationPresent(After.class)) {
                    try {
                        method.invoke(testClass);
                        passTest++;
                    } catch (Exception e) {
                        System.err.println("Ошибка в методе After");
                        failedTest++;
                    }
                    totalTest++;
                }
            }
        }

    public static void main (String[] args) {
        TestStart<TestClass> testStart = new TestStart<>();
        TestClass testClass = new TestClass();
        testStart.run(testClass);
        System.out.println("Всего тестов: " + totalTest + ", " + "Всего пройдено тестов: " + passTest + ", " + "Всего завалено тестов: " + failedTest);
    }
}
