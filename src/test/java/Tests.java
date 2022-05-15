import org.testng.annotations.Test;

import java.io.*;
import java.lang.reflect.Method;
import java.util.*;

import static org.testng.AssertJUnit.*;
import static org.testng.internal.junit.ArrayAsserts.assertArrayEquals;

import java.io.File;
import java.util.LinkedList;

public class Tests {
    @Test
    public void TestReflectionList() {
        Human human = new Human();
        Human human1 = new Human();
        Human human2 = new Human();
        Object object = new Object();
        File file = new File("C:\\Users\\Win10Pro\\VvodAndVivod\\src\\test\\TestChar.txt");
        LinkedList<Object> list = new LinkedList<>();
        list.add(human);
        list.add(human1);
        list.add(human2);
        list.add(object);
        list.add(file);
        int i = 0;
        Class<Human> analyzeHuman = null;
        for (Object l : list) {
            if (l instanceof Human) {
                i++;
            }
        }
        assertEquals(3, i);
    }

    @Test
    public void TestReflectionMethods() throws NoSuchMethodException {
        Human human = new Human();
        Class<Human> analyzeHuman = (Class<Human>) human.getClass();
        HashSet<Method> set = new HashSet<>(Arrays.asList(analyzeHuman.getDeclaredMethods()));
        HashSet<Method> expected = new HashSet<>();

        expected.add(analyzeHuman.getMethod("getAge"));
        expected.add(analyzeHuman.getMethod("getFirstName"));
        expected.add(analyzeHuman.getMethod("getMiddleName"));
        expected.add(analyzeHuman.getMethod("getLastName"));
        expected.add(analyzeHuman.getMethod("equals", Object.class));
        expected.add(analyzeHuman.getMethod("hashCode"));
        assertEquals(expected, set);
    }

    @Test
    public void TestGetSuperClasses() {
        Class<?> clazz = Child.class;
        Class<?>[] testArray = new Class<?>[3];
        int i = 0;
        while (clazz != null) {
            testArray[i] = clazz;
            clazz = clazz.getSuperclass();
            i++;
        }
        Class<?>[] test = new Class<?>[]{Child.class, Human.class, Object.class};
        assertArrayEquals(test, testArray);
    }
}
