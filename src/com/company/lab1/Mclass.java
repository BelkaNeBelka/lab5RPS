package com.company.lab1;

import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.PlainDocument;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Math.sqrt;


/**
 * A class that implements the functionality for
 * performing interval operations by means of sqrt decomposition.
 * @author Toropova Diana
 * @version 0.1
 */

public class Mclass {

    /**
     * A method that processes the input of a single value of the int type
     * @return returns an int number
     */


    class DigitFilter extends DocumentFilter {
        private static final String DIGITS = "\\d+";

        @Override
        public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {

            if (string.matches(DIGITS)) {
                super.insertString(fb, offset, string, attr);
            }
        }

        @Override
        public void replace(FilterBypass fb, int offset, int length, String string, AttributeSet attrs) throws BadLocationException, BadLocationException {
            if (string.matches(DIGITS)) {
                super.replace(fb, offset, length, string, attrs);
            }
        }
    }

    private int sqrtInput(String input) {
        boolean flag;
        int n = 0;
        flag = false;
        while (flag ==false) {
            try {
                Scanner in = new Scanner(System.in);
                n = in.nextInt();
                flag = true;
            } catch (InputMismatchException e) {
                System.out.println("Mistake!You need to enter a number!");
            }
        }
        return n;
    }

    /**
     * A method that handles the input of an array of type int
     * @param n the number of array elements
     * @return returns an array of integers
     */
    private int[] sqrtArrayInput(int n) {
        int i = 0;
        int[] A = new int[n];
        while (i<n) {
            try {
                Scanner in = new Scanner(System.in);
                System.out.print("Enter " + (i+1)+ " element :");
                A[i] = in.nextInt();
                i++;
            } catch (InputMismatchException e) {
                System.out.println("Mistake!You need to enter a number (no more than 2,147,483,647)!");
            }
        }
        return A;
    }

    /**
     * The method outputs an array of int type elements to the console
     * @param n the number of array elements
     * @param A array of integers
     */
    private void sqrtOutput(int n, int[] A) {
        int i = 0;
        while (i < n) {
            System.out.print(" " + A[i]);
            i++;
        }
    }

    /**
     * A method that determines the sum of array values on an interval
     * @param n the number of array elements
     * @param A array of integers
     */
    public int sqrtSum(int n, int[] A,int l, int r) {
        int len = (int)sqrt(n) + 1; //длина каждого "sqrt-отрезка" n-число элементов массива

        int[] B=new int[((int)Math.ceil(n/len)+1)];// объявление массива

        for(int i = 0; i < n; i++)
            B[i / len] += A[i];//вычисляем сумму блоков//A-заданный массив len -длинна блока

        //l и r — границы вводятся пользователем
//        System.out.println("");
//        System.out.print("Enter the left border of the interval: ");
//        int l=2;//sqrtInput()-1;
//        System.out.print("Enter the right border of the interval: ");
//        int r=7;//sqrtInput()-1;

//        if (l+1>n || r+1>n || l>r) {
//            while (n < l+1 || n < r+1 || r < l) {
//                System.out.println("You entered the wrong interval. The left border should be smaller than the right one. The right border should not exceed the number of array elements.");
//                System.out.println("Enter the left border of the interval: ");
//                l = 2;//sqrtInput()-1;
//                System.out.println("Enter the right border of the interval: ");
//                r = 7;//sqrtInput()-1;
//            }
//        }

        int i = l, sum = 0;
        while(i <= r) {
            if(i % len == 0 && i + len -1 <= r) {
                sum += B[i / len];
                i += len;
            }
            else {
                sum += A[i];//result v
                i++;
            }
        }
        System.out.println("The sum of the array elements in the interval ["+(l+1)+";"+(r+1)+"] : "+sum);
        return sum;
    }

    /**
     * A method that replaces values on an interval
     * @param n the number of array elements
     * @param A array of integers
     * @return returns an array of integers
     */
    private int[]sqrtEditInterval(int[]A,int n,int l,int r,int[] C) {
        int len = (int)sqrt(n) + 1; //длина каждого "sqrt-отрезка" n-число элементов массива

     //   int[] B=new int[((int)Math.ceil(n/len)+1)];// объявление массива

  //      for(int i = 0; i < n; i++)
       //     B[i / len] += A[i];//вычисляем сумму блоков//A-заданный массив len -длинна блока

//        //l и r — границы вводятся пользователем
//        System.out.println("");
//        System.out.print("Enter the left border of the interval: ");
//       // int l=2;//sqrtInput()-1;
//        System.out.print("Enter the right border of the interval: ");
//       // int r=7;//sqrtInput()-1;
//
//        if (l+1>n || r+1>n || l>r) {
//            while (n < l+1 || n < r+1 || r < l) {
//                System.out.println("You entered the wrong interval. The left border should be smaller than the right one. The right border should not exceed the number of array elements.");
//                System.out.println("Enter the left border of the interval: ");
//                l = 2;//sqrtInput()-1;
//                System.out.println("Enter the right border of the interval: ");
//                r = 7;//sqrtInput()-1;
//            }
//        }

//        int[] C=new int[r-l+1];// объявление массива
//      //  System.out.println("Enter the elements to replace");
//       // C=sqrtArrayInput(r-l+1);
//        Random rnd = new Random(System.currentTimeMillis());
//        int items;
//        for(int i = 0; i < r-l+1; i++){
//
//            // Получаем случайное число в диапазоне от min до max (включительно)
//            items = 1 + rnd.nextInt(70 - 1 + 1);
//            C[i]=items;
//        }


        int i = l; int j=0;
        while(i <= r)
        {
            A[i]=C[j];
//            if(i % len == 0 && i + len -1 <= r) {
//                A[i]= C[j];
//                j++;
//                i += len;
//            }
//            else {
//                A[i]= C[j];
                j++;
                i++;
//            }
        }

        return A;
    }

    /**
     * A method that replaces values at a given point
     * @param n the number of array elements
     * @param A array of integers
     * @return returns an array of integers
     */
    private int[] sqrtEditPoint(int[]A,int n,int position,int item) {
       // int position=0;
      //  int items=0;
    //    System.out.println("Enter the point where you want to change the element");
     //   position=sqrtInput()-1;
//       while (position>n){
//            position=sqrtInput()-1;
//       }
          //  System.out.println("Enter the element to replace");
        // Инициализируем генератор
     //   Random rnd = new Random(System.currentTimeMillis());
        // Получаем случайное число в диапазоне от min до max (включительно)
      //  int items = 100 + rnd.nextInt(70 - 0 + 1);
          //  items=sqrtInput();
            A[position]=item;

        return A;
    }


//    private int [] button1(String str){
//        int A[] = new int[str.length()];
//        for(int i = 0; i < str.length(); i++){
//            char c = str.charAt(i);
//            A[i]= A[i]=Integer.parseInt(String.valueOf(c));
//        }
//        return A;
//    }

    private void mistakeViever(String Ot, String Do,String tmp) {
          int sOt=Integer.parseInt(Ot);
          int sDo=Integer.parseInt(Do);


    }

    public void Menu() {
        JFrame a = new JFrame("lab3");

        JLabel b1 = new JLabel("Введите числовой интервал через пробел");
        b1.setBounds(40,40,300,20);
        a.add(b1);

        JTextField textField = new JTextField(50);
        textField.setBounds(40, 70, 390, 30);
        a.add(textField);

        PlainDocument doc ;
        //proc1
        JCheckBox sumCheck = new JCheckBox("Определения суммы значений на интервале.");
        sumCheck.setBounds(40, 120, 300, 30);
        sumCheck.setVisible(false);
        a.add(sumCheck);

        JLabel otSum = new JLabel("Левая граница интервала");
        otSum.setBounds(40,250,200,30);
        otSum.setVisible(false);
        a.add(otSum);

        JLabel doSum = new JLabel("Правая граница интервала");
        doSum.setBounds(40,300,200,30);
        doSum.setVisible(false);
        a.add(doSum);

        JTextField otSumField = new JTextField();
        otSumField.setBounds(250, 250, 180, 30);
        otSumField.setVisible(false);
        a.add(otSumField);
        doc = (PlainDocument) otSumField.getDocument();
        doc.setDocumentFilter(new DigitFilter());
        otSumField.setDocument(new PlainDocument() {
            String chars = "0123456789";
            @Override
            public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
                if (chars.indexOf(str) != -1) {
                    if (getLength()< 5) {
                        super.insertString(offs, str, a);
                    }
                }
            }
        });

        JTextField doSumField = new JTextField();
        doSumField.setBounds(250, 300, 180, 30);
        doSumField.setVisible(false);
        a.add(doSumField);
        doc = (PlainDocument) doSumField.getDocument();
        doc.setDocumentFilter(new DigitFilter());
        doSumField.setDocument(new PlainDocument() {
            String chars = "0123456789";
            @Override
            public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
                if (chars.indexOf(str) != -1) {
                    if (getLength()< 5) {
                        super.insertString(offs, str, a);
                    }
                }
            }
        });

     //   p.setBounds(320,320,60,30);
        JButton buttonSum = new JButton("Принять");
        buttonSum .setBounds(180,350,90,30);
        buttonSum.setVisible(false);
       // p.add(buttonSum);
        a.add(buttonSum);


        JButton spravka = new JButton("Справка");
        spravka .setBounds(180,350,90,30);
        spravka.setVisible(false);
        // p.add(buttonSum);
        a.add(spravka);


        //proc2
        JCheckBox pointCheck = new JCheckBox("Изменения значения в заданной точке.");
        pointCheck.setBounds(40, 150, 300, 30);
        pointCheck.setVisible(false);
        a.add(pointCheck);
//
//        JLabel otSum = new JLabel("Левая граница интервала");
//        otSum.setBounds(40,250,200,30);
//        otSum.setVisible(false);
//        a.add(otSum);

        JLabel otPoint = new JLabel("Позиция элемента");
        otPoint.setBounds(40,250,200,30);
        otPoint.setVisible(false);
        a.add(otPoint);

        JTextField otPointField = new JTextField();
        otPointField.setBounds(250, 250, 50, 30);
        otPointField.setVisible(false);
        a.add(otPointField);
        doc = (PlainDocument) otPointField.getDocument();
        doc.setDocumentFilter(new DigitFilter());
        otPointField.setDocument(new PlainDocument() {
            String chars = "0123456789";
            @Override
            public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
                if (chars.indexOf(str) != -1) {
                    if (getLength()< 5) {
                        super.insertString(offs, str, a);
                    }
                }
            }
        });

        JLabel itemPoint = new JLabel("Элемент для встаки");
        itemPoint.setBounds(40,300,200,30);
        itemPoint.setVisible(false);
        a.add(itemPoint);

        JTextField itemPointField = new JTextField();
        itemPointField.setBounds(250, 300, 50, 30);
        itemPointField.setVisible(false);
        a.add(itemPointField);
        doc = (PlainDocument) itemPointField.getDocument();
        doc.setDocumentFilter(new DigitFilter());
        itemPointField.setDocument(new PlainDocument() {
            String chars = "0123456789";
            @Override
            public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
                if (chars.indexOf(str) != -1) {
                    if (getLength()< 5) {
                        super.insertString(offs, str, a);
                    }
                }
            }
        });

        JButton buttonPoint = new JButton("Принять");
        buttonPoint .setBounds(180,350,90,30);
        // p.add(buttonSum);
        buttonPoint.setVisible(false);
        a.add(buttonPoint);

        //proc3
        JCheckBox intervalCheck = new JCheckBox("Изменения значений на интервале.");
        intervalCheck.setBounds(40, 180, 300, 30);
        intervalCheck.setVisible(false);
        a.add(intervalCheck);


        JLabel otInterval = new JLabel("Левая граница интервала");
        otInterval.setBounds(40,220,200,30);
        otInterval.setVisible(false);
        a.add(otInterval);
        JLabel doInterval = new JLabel("Правая граница интервала");
        doInterval.setBounds(40,270,200,30);
        doInterval.setVisible(false);
        a.add(doInterval);
        JLabel intervalInterval = new JLabel("Интервал для вставки");
        intervalInterval.setBounds(40,320,200,30);
        intervalInterval.setVisible(false);
        a.add(intervalInterval);

        JTextField otIntervalField = new JTextField();
        otIntervalField.setBounds(250, 220, 180, 30);
        otIntervalField.setVisible(false);
        a.add(otIntervalField);
        doc = (PlainDocument) otIntervalField.getDocument();
        doc.setDocumentFilter(new DigitFilter());
        otIntervalField .setDocument(new PlainDocument() {
            String chars = "0123456789";
            @Override
            public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
                if (chars.indexOf(str) != -1) {
                    if (getLength()< 5) {
                        super.insertString(offs, str, a);
                    }
                }
            }
        });

        JTextField doIntervalField = new JTextField();
        doIntervalField.setBounds(250, 270, 180, 30);
        doIntervalField.setVisible(false);
        a.add(doIntervalField);
        doc = (PlainDocument) doIntervalField.getDocument();
        doc.setDocumentFilter(new DigitFilter());
        doIntervalField .setDocument(new PlainDocument() {
            String chars = "0123456789";
            @Override
            public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
                if (chars.indexOf(str) != -1) {
                    if (getLength()< 5) {
                        super.insertString(offs, str, a);
                    }
                }
            }
        });

        JTextField IntervalField = new JTextField();
        IntervalField.setBounds(250, 320, 180, 30);
        IntervalField.setVisible(false);
        a.add(IntervalField);
//        doc = (PlainDocument) IntervalField.getDocument();
//        doc.setDocumentFilter(new DigitFilter());

        JButton buttonInterval = new JButton("Принять");
        buttonInterval .setBounds(180,380,90,30);
        buttonInterval.setVisible(false);
        // p.add(buttonSum);
        buttonInterval.setVisible(false);
        a.add(buttonInterval);



        //proc1result
        JLabel SumL = new JLabel("Сумма на интервале");
        SumL.setBounds(40,450,200,30);
        SumL.setVisible(false);
        a.add(SumL);
        JTextField SumLField = new JTextField();
        SumLField.setBounds(250, 450, 180, 30);
        SumLField.setVisible(false);
        a.add(SumLField);

        //proc2result
        JTextField  intervalFieldResult = new JTextField();
        intervalFieldResult.setBounds(40, 450, 400, 30);
        intervalFieldResult.setVisible(false);
        a.add( intervalFieldResult);


        //proc3result
        JTextField pointField = new JTextField();
        pointField.setBounds(40, 450, 390, 30);
        pointField.setVisible(false);
        a.add(pointField);


        //mistake
        JLabel mistake = new JLabel();
        mistake.setBounds(40,500,500,30);
    //    mistake.setVisible(false);
        a.add(mistake);



        sumCheck.setVisible(true);
        pointCheck.setVisible(true);
        intervalCheck.setVisible(true);


                sumCheck.addActionListener(
                        ae -> {
                            sumCheck.removeAll();
                            if (sumCheck.isSelected()) {

                                //point
                                pointCheck.setSelected(false);

                                otPoint.setVisible(false);
                                otPointField.setVisible(false);
                                itemPoint.setVisible(false);
                                itemPointField.setVisible(false);

                                buttonPoint.setVisible(false);

                                pointField.setVisible(false);

                                //interval

                                intervalCheck.setSelected(false);

                                otIntervalField.setVisible(false);
                                doIntervalField.setVisible(false);
                                otInterval.setVisible(false);
                                doInterval.setVisible(false);
                                intervalInterval.setVisible(false);
                                IntervalField.setVisible(false);

                                buttonInterval.setVisible(false);

                                intervalFieldResult.setVisible(false);

                                //sum
                                otSum.setVisible(true);
                                doSum.setVisible(true);
                                otSumField.setVisible(true);
                                doSumField.setVisible(true);

                                buttonSum.setVisible(true);

                                buttonSum.addActionListener(new ActionListener() {
                                    // Используем переопределение
                                    @Override
                                    // Добавляем событие нажатия на кнопку e — название события
                                    public void actionPerformed(ActionEvent e) {
                                        String tmp =textField.getText();

                                        SumL.setVisible(true);
                                        SumLField.setVisible(true);

                                        int l=0;
                                        if (tmp.length() % 2 != 0){   l=tmp.length()/2+1;}else{  l=tmp.length()/2;}

                                        int A[]= new int[l];
                                        Arrays.fill(A, 0);
                                        Pattern p = Pattern.compile("[0-9]+");
                                        Matcher m = p.matcher(tmp);int i=0;
                                        while (m.find()) {
                                            int n = Integer.parseInt(m.group());
                                            A[i]=n;
                                            i++;

                                        }

                                        String sumOt = otSumField.getText();
                                        String sumDo = doSumField.getText();
                                      //  mistakeViever(sumOt ,sumDo, tmp);

                                        //если ничего не введено
                                      if (otSumField.getText().length()==0){
                                          //otSumField.setText("1");
                                          mistake.setText("<html><font color='red'>Введите левую границу интервала (меньше правой)</font></html>");
                                      }else{


                                          if (Integer.parseInt(sumOt)<1){
                                              sumOt="1";
                                              mistake.setText("<html><font color='red'>Левая граница интервала должна быть больше 0</font></html>");
                                          }

                                      }
//                                      if (doSumField.getText().length()==0){
//                                         // doSumField.setText(String.valueOf(A.length));
//                                          mistake.setText("<html><font color='red'>Введите правую границу интервала</font></html>");
//                                      }else{
//
//                                          if (Integer.parseInt(intervalDo)>A.length){intervalDo= String.valueOf(A.length);}else{
//                                              if(Integer.parseInt(intervalOt)>Integer.parseInt(intervalDo)){
//                                                  mistake.setText("<html><font color='red'>Левая граница интервала должна быть меньше правой</font></html>");
//                                              }}
//
//                                          if(Integer.parseInt(sumOt)>Integer.parseInt(sumDo)){
//                                              mistake.setText("<html><font color='red'>Левая граница интервала должна быть меньше правой</font></html>");
//                                          }
//                                          if (Integer.parseInt(sumDo)>A.length){sumDo= String.valueOf(A.length);}
//                                      }




                                        if (doSumField.getText().length()==0){
                                            // doSumField.setText(String.valueOf(A.length));
                                            mistake.setText("<html><font color='red'>Введите правую границу интервала</font></html>");
                                        }else{


                                            if (Integer.parseInt(sumDo)>A.length){sumDo= String.valueOf(A.length);}else{
                                                if(Integer.parseInt(sumOt)>Integer.parseInt(sumDo)){
                                                    mistake.setText("<html><font color='red'>Левая граница интервала должна быть меньше правой</font></html>");
                                                }}

                                        }

                                        if (tmp.length()==0){mistake.setText("<html><font color='red'>Введите интервал </font></html>");}



                                        if (sumOt.length() > 0 && sumDo.length() > 0 && A.length>0) {
                                            mistake.setText("");
                                            int sum = sqrtSum(A.length, A, Integer.parseInt(sumOt) - 1, Integer.parseInt(sumDo) - 1);
                                              SumLField.setText(String.valueOf(sum));
                                        }

                                    }});


                            } else {

                                //point
                                otPoint.setVisible(false);
                                otPointField.setVisible(false);
                                itemPoint.setVisible(false);
                                itemPointField.setVisible(false);
                                buttonPoint.setVisible(false);
                                pointField.setVisible(false);

                                //interval
                                otIntervalField.setVisible(false);
                                doIntervalField.setVisible(false);
                                otInterval.setVisible(false);
                                doInterval.setVisible(false);
                                intervalInterval.setVisible(false);
                                IntervalField.setVisible(false);
                                buttonInterval.setVisible(false);
                                intervalFieldResult.setVisible(false);

                                //sum
                                otSum.setVisible(false);
                                doSum.setVisible(false);
                                otSumField.setVisible(false);
                                doSumField.setVisible(false);
                                buttonSum.setVisible(false);

                                SumL.setVisible(false);
                                SumLField.setText("");
                                SumLField.setVisible(false);

                            }
                        });

                pointCheck.addActionListener(
                        ae -> {
                            pointCheck.removeAll();
                            if (pointCheck.isSelected()) {

                                //interval

                                intervalCheck.setSelected(false);

                                otIntervalField.setVisible(false);
                                doIntervalField.setVisible(false);
                                otInterval.setVisible(false);
                                doInterval.setVisible(false);
                                intervalInterval.setVisible(false);
                                IntervalField.setVisible(false);

                                buttonInterval.setVisible(false);

                                intervalFieldResult.setVisible(false);

                                //sum
                                sumCheck.setSelected(false);

                                otSum.setVisible(false);
                                doSum.setVisible(false);
                                otSumField.setVisible(false);
                                doSumField.setVisible(false);

                                SumL.setVisible(false);
                                SumLField.setVisible(false);
                                buttonSum.setVisible(false);

                                //point
                                itemPoint.setVisible(true);
                                itemPointField.setVisible(true);

                                otPoint.setVisible(true);
                                otPointField.setVisible(true);

                                buttonPoint.setVisible(true);

                                buttonPoint.addActionListener(new ActionListener() {
                                    // Используем переопределение
                                    @Override
                                    // Добавляем событие нажатия на кнопку e — название события
                                    public void actionPerformed(ActionEvent e) {
                                        String tmp =textField.getText();
                                        pointField.setVisible(true);

                                        int l=0;
                                        if (tmp.length() % 2 != 0){   l=tmp.length()/2+1;}else{  l=tmp.length()/2;}

                                        int A[]= new int[l];
                                        Arrays.fill(A, 0);
                                        Pattern p = Pattern.compile("[0-9]+");
                                        Matcher m = p.matcher(tmp);int i=0;
                                        while (m.find()) {
                                            int n = Integer.parseInt(m.group());
                                            A[i]=n;
                                            i++;
                                        }


                                        String pointOt =otPointField.getText();


                                        if (otPointField.getText().length()==0){
                                            //otSumField.setText("1");
                                            mistake.setText("<html><font color='red'>Введите позицию для вставки элемента</font></html>");
                                        }else{

                                            if ( Integer.parseInt(String.valueOf(otPointField.getText()))>A.length){
                                                pointOt= String.valueOf(A.length);
                                            }
                                        }
                                        if (itemPointField.getText().length()==0){
                                            // doSumField.setText(String.valueOf(A.length));
                                            mistake.setText("<html><font color='red'>Введите элемент для вставки</font></html>");
                                        }else{

//                                            if (Integer.parseInt(String.valueOf(itemPointField.getText()))>2147483647){
//                                                mistake.setText("<html><font color='red'>Введенное значение должно быть меньше 2 147 483 647</font></html>");
//                                            }
                                        }

                                        if (tmp.length()==0){mistake.setText("<html><font color='red'>Введите интервал </font></html>");}

                                        //2,147,483,647

                                        if (pointOt.length()>0 && A.length>0 && itemPointField.getText().length()>0){
                                            int point[] =sqrtEditPoint(A,A.length,Integer.parseInt(String.valueOf(pointOt))-1,Integer.parseInt(String.valueOf(itemPointField.getText())) );

                                            String arr="";
                                            for(int k = 0; k < point.length; k++){
                                                arr=arr.concat(String.valueOf(point[k])+" ");
                                            }
                                            pointField.setText(arr);
                                        }
                                    }
                                });

                            } else {

                                //point
                                pointField.setText("");
                                pointField.setVisible(false);
                                otPoint.setVisible(false);
                                otPointField.setVisible(false);
                                buttonPoint.setVisible(false);
                                itemPoint.setVisible(false);
                                itemPointField.setVisible(false);

                                //sum
                                otSum.setVisible(false);
                                doSum.setVisible(false);
                                otSumField.setVisible(false);
                                doSumField.setVisible(false);

                                SumL.setVisible(false);
                                SumLField.setVisible(false);
                                buttonSum.setVisible(false);


                                //interval
                                otIntervalField.setVisible(false);
                                doIntervalField.setVisible(false);
                                otInterval.setVisible(false);
                                doInterval.setVisible(false);
                                intervalInterval.setVisible(false);
                                IntervalField.setVisible(false);
                                buttonInterval.setVisible(false);
                                intervalFieldResult.setVisible(false);

                            }
                        });
//
                intervalCheck.addActionListener(
                        ae -> {
                            intervalCheck.removeAll();
                            if (intervalCheck.isSelected()) {


                                //point
                                pointCheck.setSelected(false);

                                otPoint.setVisible(false);
                                otPointField.setVisible(false);
                                itemPoint.setVisible(false);
                                itemPointField.setVisible(false);

                                buttonPoint.setVisible(false);

                                pointField.setVisible(false);


                                //sum
                                sumCheck.setSelected(false);
                                otSum.setVisible(false);
                                doSum.setVisible(false);
                                otSumField.setVisible(false);
                                doSumField.setVisible(false);

                                SumL.setVisible(false);
                                SumLField.setVisible(false);
                                buttonSum.setVisible(false);

                                //interval

                                otInterval.setVisible(true);
                                doInterval.setVisible(true);
                                otIntervalField.setVisible(true);
                                doIntervalField.setVisible(true);

                                intervalInterval.setVisible(true);
                                IntervalField.setVisible(true);

                                buttonInterval.setVisible(true);

                                buttonInterval.addActionListener(new ActionListener() {
                                    // Используем переопределение
                                    @Override
                                    // Добавляем событие нажатия на кнопку e — название события
                                    public void actionPerformed(ActionEvent e) {
                                        intervalFieldResult.setVisible(true);
                                        String tmp =textField.getText();
                                        int l=0;
                                        if (tmp.length() % 2 != 0){   l=tmp.length()/2+1;}else{  l=tmp.length()/2;}

                                        int A[]= new int[l];
                                        Arrays.fill(A, 0);
                                        Pattern p = Pattern.compile("[0-9]+");
                                        Matcher m = p.matcher(tmp);int i=0;
                                        while (m.find()) {
                                            int n = Integer.parseInt(m.group());
                                            A[i]=n;
                                            i++;
                                            // append n to list
                                        }


                                        String intervalOt =otIntervalField.getText();
                                        String intervalDo =doIntervalField.getText();

                                        int interval[]= new int[l];
                                     //   Arrays.fill(interval, 0);
                                        Pattern pp = Pattern.compile("[0-9]+");
                                        Matcher mm = pp.matcher( IntervalField.getText());int j=0;
                                        while (mm.find()) {
                                            int n = Integer.parseInt(mm.group());
                                            if (j<l){
                                                interval[j]=n;
                                                System.out.println(interval[j]);
                                                j++;
                                            }else{break;}

                                        }


                                      //если ничего не введено
                                      if (otIntervalField.getText().length()==0){
                                          //otSumField.setText("1");
                                          mistake.setText("<html><font color='red'>Введите левую границу интервала (меньше правой)</font></html>");
                                      }else{

                                          if (Integer.parseInt(intervalOt)<1){
                                              intervalOt="1";
                                              mistake.setText("<html><font color='red'>Левая граница интервала должна быть больше 0</font></html>");
                                          }

                                      }
                                      if (doIntervalField.getText().length()==0){
                                         // doSumField.setText(String.valueOf(A.length));
                                          mistake.setText("<html><font color='red'>Введите правую границу интервала</font></html>");
                                      }else{


                                          if (Integer.parseInt(intervalDo)>A.length){intervalDo= String.valueOf(A.length);}else{
                                              if(Integer.parseInt(intervalOt)>Integer.parseInt(intervalDo)){
                                              mistake.setText("<html><font color='red'>Левая граница интервала должна быть меньше правой</font></html>");
                                          }}

                                      }

                                        if (tmp.length()==0){mistake.setText("<html><font color='red'>Введите интервал </font></html>");}


                                        if (intervalOt.length()>0 && intervalDo.length()>0 && A.length>0){
                                            int point[] =sqrtEditInterval(A,A.length,Integer.parseInt(String.valueOf(intervalOt))-1,Integer.parseInt(String.valueOf(intervalDo))-1,interval);
                                            mistake.setText("");
                                            String arr="";
                                            for(int k = 0; k < A.length; k++){
                                                arr=arr.concat(String.valueOf(A[k])+" ");
                                            }
                                            intervalFieldResult.setText(arr);
                                        }
                                    }
                                });





                            } else {

                                //point
                                pointField.setText("");
                                pointField.setVisible(false);
                                otPoint.setVisible(false);
                                otPointField.setVisible(false);
                                buttonPoint.setVisible(false);
                                itemPoint.setVisible(false);
                                itemPointField.setVisible(false);

                                //sum
                                otSum.setVisible(false);
                                doSum.setVisible(false);
                                otSumField.setVisible(false);
                                doSumField.setVisible(false);

                                SumL.setVisible(false);
                                SumLField.setVisible(false);
                                buttonSum.setVisible(false);


                                //interval
                                otIntervalField.setVisible(false);
                                doIntervalField.setVisible(false);
                                otInterval.setVisible(false);
                                doInterval.setVisible(false);
                                intervalInterval.setVisible(false);
                                IntervalField.setVisible(false);
                                buttonInterval.setVisible(false);
                                intervalFieldResult.setVisible(false);
                            }
                        });



        a.setSize(490, 600);//size application
        a.setLayout(null);
        a.setVisible(true);


    }
//    /**
//     * Method-menu for selecting an operation
//     */
//    public void Menu() {
//        /**Array Size*/
//        int n;
//        /**Array*/
//        int[] A;
//
//        System.out.print("Enter the number of array elements: ");
//        n=sqrtInput();
//        System.out.println("Enter the array elements: ");
//        A=sqrtArrayInput(n);
//        System.out.println("You have entered an array");
//        sqrtOutput(n,A);
//
//        boolean flag = false;int j = 0;
//        while (flag ==false) {
//            System.out.println("");
//            System.out.println("Select a menu item: ");
//            System.out.println("1)Changes in the value at a given point: ");
//            System.out.println("2)Changes in values on the interval: ");
//            System.out.println("3)Determining the sum of values in the interval: ");
//            System.out.println("4)Exit ");
//            j=sqrtInput();
//            switch (j) {
//                case 1:
//                    sqrtEditPoint(A,n);
//                    sqrtOutput(n,A);
//                    break;
//                case 2:
//                    sqrtEditInterval(A,n);
//                    sqrtOutput(n,A);
//                    break;
//                case 3:
//                    sqrtSum(n,A);
//                    sqrtOutput(n,A);
//                    break;
//                case 4:
//                    flag=true;
//                    break;
//                default:
//                    System.out.print("There is no such menu item.");
//            }
//        }
//    }
}
