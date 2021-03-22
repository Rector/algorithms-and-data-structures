package taskLesson03;

public class WorkWithStackAndQueue {

/**
 * 1. Создать программу, которая переворачивает вводимые строки (читает справа налево).
 */

    public static String reversString (String str){
        if(str.equals("") || str.equals(" ")){
            throw new RuntimeException("В введённой строке отсутствуют символы");
        }

        MyStack<Character> myStack = new MyStack<>(str.length());
        for(int i = 0; i < str.length(); i++){
            myStack.push(str.charAt(i));
        }

        StringBuilder sb = new StringBuilder();
        while(myStack.size() != 0){
            sb.append(myStack.pop());
        }
        return sb.toString();
    }

    public static void main(String[] args){
        String str = "Я знаю, что ничего не знаю.";
        System.out.println(str);
        System.out.println(reversString(str));

/**
 * 2. Создать класс для реализации дека.
 * */

        MyDeque<Integer> md = new MyDeque<>(4);

//        md.insertLeft(100);
//        md.insertLeft(200);
//        md.insertLeft(10);
//        md.insertLeft(20);

//        md.insertRight(100);
//        md.insertRight(200);
//        md.insertRight(10);
//        md.insertRight(20);

        md.insertFirst(100);
        md.insertFirst(200);
        md.insertLast(10);
        md.insertLast(20);


        StringBuilder sb = new StringBuilder();
        while(md.size() != 0){
            sb.append(md.removeFirst()).append(" ");
//            sb.append(md.removeRight()).append(" ");
        }

        System.out.println(sb.toString());


        MyQueue<Integer> mq = new MyQueue<>(2);
        mq.insert(10);
        mq.insert(20);
        mq.insert(40);
        System.out.println(mq.toString());
        mq.remove();
        mq.remove();
        mq.insert(50);
        mq.insert(60);

        System.out.println(mq.toString());

    }

}
