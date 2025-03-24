package redo_hackathon.myHackathon.entity;

import redo_hackathon.myHackathon.services.CustomerValidator;

import java.util.Scanner;

public class Customer implements IApp{
    private String customerId;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private boolean gender;
    private String address;
    private String phoneNumber;
    private String email;
    private String customerType;

    public Customer() {
    }

    public Customer(String customerId, String firstName, String lastName, String dateOfBirth, boolean gender, String address, String phoneNumber, String email, String customerType) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.customerType = customerType;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String id) {
        this.customerId = id;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phone) {
        this.phoneNumber = phone;
    }

    public String getCustomerType() {
        return customerType;
    }



    public void setCustomerType(String type) {
        this.customerType = type;
    }


    // method---------------------------------------------------------------------------------
    @Override
    public void displayData() {
        System.out.println("ID: " + this.customerId);
        System.out.println("fullname: " + this.lastName + " " + this.firstName);
        System.out.println("date of birth: " + this.dateOfBirth);
        System.out.println("gender: " + (this.gender ? "Nam" : "Nữ"));
        System.out.println("address: " + this.address);
        System.out.println("phone: " + this.phoneNumber);
        System.out.println("email: " + this.email);
        System.out.println("type: " + this.customerType);
    }

}
