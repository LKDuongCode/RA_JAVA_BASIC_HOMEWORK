package entity;

import java.util.Scanner;

public class Student {
    private String id;
    private String name;
    private int age;
    private float averageScore;

    public Student() {
    }

    public Student(String id, String name, int age, float averageScore) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.averageScore = averageScore;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(float averageScore) {
        this.averageScore = averageScore;
    }

    public void inputData (Scanner sc){
        System.out.println("nhập thông tin sinh viên:");
        System.out.print("id = ");
        String id = sc.nextLine();
        setId(id);

        System.out.print("name = ");
        String name = sc.nextLine();
        setName(name);

        System.out.print("age = ");
        int age = Integer.parseInt(sc.nextLine());;
        setAge(age);


        System.out.print("avgScore = ");
        float score = Float.parseFloat(sc.nextLine());
        setAverageScore(score);
    }

    @Override
    public String toString (){
        return "ID : " + this.id + " | " + "name: " + this.name + " | " + "age: " + this.age + "| avgScore: " + this.averageScore;
    }
}
