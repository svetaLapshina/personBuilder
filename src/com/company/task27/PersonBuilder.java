package com.company.task27;

public class PersonBuilder {
    private String name;
    private String surname;
    private Integer age;
    private String address;

    public PersonBuilder setName(String name) {
        if (null == name || name.trim().isEmpty())
            throw new IllegalArgumentException("Incorrect name");
        this.name = name.trim();
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        if (null == surname || surname.trim().isEmpty())
            throw new IllegalArgumentException("Incorrect surname");
        this.surname = surname.trim();
        return this;
    }

    public PersonBuilder setAge(int age) throws IllegalArgumentException {
        if (age < 0)
            throw new IllegalArgumentException("Incorrect age");
        this.age = age;
        return this;
    }

    public PersonBuilder setAddress(String address) {
        if (null == address || address.trim().isEmpty())
            throw new IllegalArgumentException("Incorrect address");
        this.address = address.trim();
        return this;
    }

    public Person build() {
        if (null == name)
            throw new IllegalStateException("Name missing");
        if (null == surname)
            throw new IllegalStateException("Surname missing");

        Person person = (null == age) ? new Person(name, surname) : new Person(name, surname, age);
        if (null != address)
            person.setAddress(address);

        return person;
    }
}