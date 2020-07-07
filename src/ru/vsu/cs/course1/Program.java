package ru.vsu.cs.course1;

import ru.vsu.cs.util.SwingUtils;

import javax.swing.*;
import java.util.Iterator;
import java.util.Locale;


public class Program {

    public static void main(String[] args) throws Exception {
        //SwingUtils.setLookAndFeelByName("Windows");
        Locale.setDefault(Locale.ROOT);
        //UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        SwingUtils.setDefaultFont("Microsoft Sans Serif", 18);

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameMain().setVisible(true);
            }
        });

        MyLinkedList<Integer> list = new MyLinkedList<>();

        findMin(list);

        for (Integer x : list) {
            System.out.println(x);
        }

        Iterator<Integer> itr = list.iterator();
        while (itr.hasNext()) {
            Integer x = itr.next();
            System.out.println(x);
        }

    }

    public static int findMin(int[] arr) throws Exception {
        if (arr.length < 1)
            throw new Exception("");
        int m = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < m)
                m = arr[i];
        }
        return m;
    }

    public static int findMin(Iterable<Integer> collection) throws Exception {
        Iterator<Integer> itr = collection.iterator();
    //public static int findMin(Iterator<Integer> itr) {
        if (!itr.hasNext())
            throw new Exception("");
        int m = itr.next();
        while (itr.hasNext()){
            int q = itr.next();
            if (q < m)
                m = q;
        }
        return m;
    }
}
