package com.itliuliuliu;

import java.util.ArrayList;
import java.util.Scanner;

/*
* 学生管理系统
* */
public class StudentManager {
    /*
    * 1.用输出语句完成主界面的编写
    * 2.用Scanner实现键盘录入数据
    * 3.用switch语句完成操作的选择
    * 4.用循环完成再次回到主界面的操作
    * */

    public static void main(String[] args) {
        //创建集合对象，用于存储学生数据
        ArrayList<Student> array = new ArrayList<Student>();

        //用循环再次回到主页面
        while (true) {

            //用输出语句完成主界面的编写
            System.out.println("--------欢迎来到学生管理系统--------");
            System.out.println("1 添加学生");
            System.out.println("2 删除学生");
            System.out.println("3 修改学生");
            System.out.println("4 查看所有学生");
            System.out.println("5 退出");
            System.out.println("请输入你的选择");

            //用Scanner实现键盘录入数据
            Scanner sc = new Scanner(System.in);
            String line = sc.nextLine();
            //用switch语句完成操作的选择
            switch (line) {
                case "1":
                    System.out.println("添加学生");
                    addStudent(array);
                    break;
                case "2":
                    System.out.println("删除学生");
                    deleteStudent(array);
                    break;
                case "3":
                    System.out.println("修改学生");
                    updateStudent(array);
                    break;
                case "4":
                    System.out.println("查看所有学生");
                    findeAllStudent(array);
                    break;
                case "5":
                    System.out.println("谢谢使用");
                    System.exit(0);//JVM退出
            }
        }
    }

    //定义一个方法：用于添加学生信息
    public static void addStudent(ArrayList<Student> array){
        Scanner sc = new Scanner(System.in);
        String sid;
        //为了让程序能够回到这里，我们使用循环实现
        while(true){
            System.out.println("请输入学生学号:");
            sid = sc.nextLine();
            boolean flag =  isUsed(array,sid);
            if(flag){
                System.out.println("您输入的学号已经被使用，请重新输入");
            }else {
                break;
            }
        }

        System.out.println("请输入学生姓名:");
        String name = sc.nextLine();
        System.out.println("请输入学生年龄:");
        String age = sc.nextLine();
        System.out.println("请输入学生居住地:");
        String address = sc.nextLine();
        Student s = new Student();
        s.setSid(sid);
        s.setName(name);
        s.setAge(age);
        s.setAddress(address);
        array.add(s);
        System.out.println("添加学生成功！");
    }

    //定义一个方法：判断学号是否被使用
    public static boolean isUsed(ArrayList<Student> array,String sid){
        boolean flag = false;
        for(int i = 0;i<array.size();i++){
            Student s = array.get(i);
            if(s.getSid().equals(sid)){
              flag = true;
              break;
            }
        }
        return flag;
    }

    //定义一个方法：用于查看所有学生信息
    public static void findeAllStudent(ArrayList<Student> array){
        if(array.size() == 0){
            System.out.println("无信息，请先添加信息!");
            return;
        }

        System.out.println("学号\t姓名\t\t\t年龄\t居住地");

        for (int i = 0;i<array.size();i++){
            Student s = array.get(i);
            System.out.println(s.getSid()+"\t"+s.getName()+"\t\t\t"+s.getAge()+"岁\t"+s.getAddress());
        }
    }

    //定义一个方法：用于删除学生信息
    public static void deleteStudent(ArrayList<Student> array){
        int index = -1;
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要删除学生的学号:");
        String  sid = sc.nextLine();
        for(int i = 0;i<array.size();i++){
            Student s = array.get(i);
            if (s.getSid().equals(sid)){
                index = i;
                break;
            }
        }
        if(index == -1){
            System.out.println("该信息不存在，请重新输入!");
        }else{
            array.remove(index);
            System.out.println("删除学生成功!");
        }
    }

    //定义一个方法：用于修改学生信息
    public static void updateStudent(ArrayList<Student> array){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要修改的学生的学号:");
        String sid = sc.nextLine();
        System.out.println("请输入学生的新姓名:");
        String name = sc.nextLine();
        System.out.println("请输入学生的新年龄:");
        String age = sc.nextLine();
        System.out.println("请输入学生的新居住地:");
        String address = sc.nextLine();
        Student s = new Student();
        s.setSid(sid);
        s.setName(name);
        s.setAge(age);
        s.setAddress(address);
        for(int i = 0;i<array.size();i++){
            Student student = array.get(i);
            if (student.getSid().equals(sid)){
                array.set(i,s);
                break;
            }
        }
        System.out.println("修改学生信息成功！");
    }




}
