package someExample;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @Description
 * @Author Zhang Qihang
 * @Date 2022/3/9 14:46
 */
public class ComparableTest {
    public static class Person implements Comparable<Person> {
        private int age;

        // 构造方法
        public Person(int age) {
            this.age = age;
        }

        public Person() {

        }

        @Override
        public int compareTo(Person o) {
            return this.age - o.age;
        }
    }

    public static void main(String[] args) {
        Person p1 = new Person(20);
        Person p2 = new Person(10);
        ArrayList<Person> persons = new ArrayList<>();
        persons.add(p1);
        persons.add(p2);
        Collections.sort(persons);
        System.out.println(persons);
    }
}
