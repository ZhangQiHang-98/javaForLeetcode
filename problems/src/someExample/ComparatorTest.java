package someExample;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @Description 测试Comparable与Comparator
 * @Author Zhang Qihang
 * @Date 2022/3/9 14:37
 */
public class ComparatorTest {
    public static class User implements Serializable, Comparable<User> {
        private static final long serialVersionUID = 1L;
        private int age;
        private String name;

        public User() {
        }

        public User(int age, String name) {
            this.age = age;
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public int compareTo(User o) {
            return this.age - o.age;
        }

        @Override
        public String toString() {
            return "[user={age=" + age + ",name=" + name + "}]";
        }
    }

    public static class MyComparator implements Comparator<User> {
        @Override
        public int compare(User o1, User o2) {
            return o1.getAge() - o2.getAge();
        }
    }

    public static void main(String[] args) {
        User user1 = new User(12, "test1");
        User user2 = new User(13, "test2");
        ArrayList<User> users = new ArrayList<>();
        users.add(user2);
        users.add(user1);
        //Collections.sort(users, new MyComparator());
        Collections.sort(users,(o1, o2) -> (o1.getAge() - o2.getAge()));
        System.out.println(users.get(0).getAge());
    }
}
