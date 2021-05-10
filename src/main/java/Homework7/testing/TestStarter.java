package Homework7.testing;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TestStarter {
    private TestStarter(){}

    public static void start(Class aClass){
        Object obj = initObject(aClass);
        List<Method> testMethods = findMethods(aClass, Test.class);

        Collections.sort(testMethods, new Comparator<Method>() {
            @Override
            public int compare(Method o1, Method o2) {
                Test an1 = o1.getAnnotation(Test.class);
                Test an2 = o2.getAnnotation(Test.class);
                return an1.order() - an2.order();
            }
        });

        if(testMethods.isEmpty()) {
            System.out.printf("% has no any test methods", aClass.getName());
            return;
        }

        List<Method> beforeSuitMethods = findMethods(aClass, BeforeSuite.class);
        if(!beforeSuitMethods.isEmpty() && beforeSuitMethods.size() > 1){
            throw new RuntimeException("BeforeSuit annotation must be one");

                }

        List<Method> afterSuitMethods = findMethods(aClass, AfterSuite.class);
        if(!afterSuitMethods.isEmpty() && afterSuitMethods.size() > 1){
            throw new RuntimeException("AfterSuit annotation must be one");
        }

        if(beforeSuitMethods.size() == 1){
            executeMethod(beforeSuitMethods.get(0), obj);
        }

        for(Method testMethod : testMethods){
           // System.out.println(testMethod);
            executeMethod(testMethod, obj);
        }

//        Method afterSuitMethod = findMethod(aClass, AfterSuite.class);
        if(afterSuitMethods.size() == 1){
            executeMethod(afterSuitMethods.get(0), obj);
        }

    }

    private static void executeMethod(Method testMethod, Object obj, Object... args) {
        try {
            testMethod.setAccessible(true);
            testMethod.invoke(obj, args);
            testMethod.setAccessible(false);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

//    private static Method findMethod(Class aClass, Class<? extends Annotation> annotationClass) {
//        //return null;
//        //List<Method> testMethods = new ArrayList<>();
//        for (Method method : aClass.getDeclaredMethods()) {
//            if(method.isAnnotationPresent(annotationClass)) {
//                //testMethods.add(method);
//                return method;
//            }
//        } return null;
//    }

    private static List<Method> findMethods(Class aClass, Class<? extends Annotation> annotationClass) {
        //return null;
        List<Method> testMethods = new ArrayList<>();
        for (Method method : aClass.getDeclaredMethods()) {
            if(method.isAnnotationPresent(annotationClass)) {
                testMethods.add(method);
            }
        }
        return testMethods;

    }

    public static void start(String className){
        try {
            start(Class.forName(className));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static Object initObject(Class aClass){
        try {
            return aClass.getDeclaredConstructor().newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
   //         e.printStackTrace();
            throw new RuntimeException("RuntimeException", e);
        } return null;
    }
}
