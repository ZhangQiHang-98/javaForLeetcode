package test;

/**
 * @Description 测试多态和向上转型
 * @Author Zhang Qihang
 * @Date 2021/10/6 13:10
 */
class Person {
    private void print() {
        System.out.println("我是人");
    }

    public static void main(String[] args) {
        Person per = new Student();
        per.print();
    }
}

class Student extends Person {
    private void print() {
        System.out.println("我是学生");
    }
}

public class testInher {

}
