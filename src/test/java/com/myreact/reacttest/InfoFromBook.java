package com.myreact.reacttest;

import com.myreact.reacttest.entity.Customer;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class InfoFromBook {
    //JAVA Решение практических задач Анджел Леонард

//    @Test(expected = ArithmeticException.class) //- Для этой строки включить и внизу
    @Test
    public void newJava_8_Buffer() {
        // 67.Переплнение буфера (int, long)
        int x = Integer.MAX_VALUE;
        int y = Integer.MAX_VALUE;
        //Так не правильно
        int z = x + y;
        System.out.println("int = " + z);//-2
        //А так правильно
//        int z2 = Math.addExact(x, y); //- Для этой строки включить и наверху
        int z2 = Math.addExact(100, 55);
        System.out.println("Math.addExact = " + z2);// - Вызывает Exception "ArithmeticException"
    }

    @Test
    public void newJava_8_() {
        // 33.Подсчёт количества символов в строке
        // .
        List<Customer> customerList = new ArrayList<>();

        Customer customer = new Customer();
        customer.setFirstName("testName_");
        customer.setLastName("test2LastName_");
        customer.setEmail("testEmail_@test.com");
        customerList.add(customer);

        System.out.println("1 = " + customerList.get(0).getFirstName());

        for (Customer c : customerList) {
            c.setFirstName(null);
        }

        System.out.println("2 = " + customerList.get(0).getFirstName());

    }

    @Test
    public void newJava_8_2() {
        //

    }

    @Test
    public void newJava_8_3() {
        //

    }

    @Test
    public void newJava_8_4() {
        //

    }
}
