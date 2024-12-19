//import PenguinSupermarket.LinkedStack;
//
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.util.*;
//import java.util.concurrent.CountDownLatch;
//import java.util.concurrent.Semaphore;
//import java.util.concurrent.locks.Condition;
//import java.util.concurrent.locks.Lock;
//import java.util.concurrent.locks.ReentrantLock;
//
////TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
//// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
//public class Main {
//    public static void main(String[] args) throws IOException {
////        var numLock = new NumLock();
////        new Thread(() -> numLock.add(1)).start();
////        new Thread(() -> numLock.add(2)).start();
////        new Thread(() -> numLock.prod()).start();
////
//
//        FileInputStream in  = new FileInputStream("C:\\Users\\WERO\\IdeaProjects\\OOP\\src\\info.txt");
//
//        byte[] b = new byte[0];
//
//        int n = in.read(b);
//
//        System.out.println(b.length + " " + n);
//
//        List.of("aa","bb","aaaa","cc","bb","aaa").stream().filter(x->x.compareTo("b")>0).map(x->x.length()).forEach(x-> System.out.println(x));
//
//
//        Queue<String> queue;
//        List<String> list = new LinkedList<>();
//        ArrayList<String> l  = new ArrayList<>();
//        HashSet<String> set = new HashSet<>();
//        TreeSet<String> treeSet = new TreeSet<>();
//        List<String> list1 = new LinkedList<>();
//        ArrayList<String> arrayList = new ArrayList<>();
////        treeSet.poll()
//    }
//
//    @FunctionalInterface
//    interface A{
//        void act();
//
//        void ad();
//    }
//
//
//
//
//
//
//
//}
//
//
//
//class NumLock {
//
//    static Lock lock = new ReentrantLock(true);
//    static Condition condition = lock.newCondition();
//    private int res;
//    public void add(int value) {
//        try {
//            lock.lock();
//            res +=value;
//            condition.await();
//
//        } catch (InterruptedException e) {
//
//        } finally {
//            System.out.println(res);
//            lock.unlock();
//        }
//
//
//    }
//
//    public void prod() {
//        lock.lock();
//        condition.signalAll();
//        lock.unlock();
//    }
//}
//
