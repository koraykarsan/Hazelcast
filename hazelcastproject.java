package com.hazelcastproject;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;
public class HazelcastDemo{
    public static void main(String[] args){
        HazelcastInstance hz=Hazelcast.newHazelcastInstance();
        IMap<Integer,Person> map=hz.getMap("people");
        for(int i=0;i<10000;i++){
            map.put(i, new Person("Person " + i));
        }
        Person person=map.get(5000);
        System.out.println("Retrieved: " + person.getName());
        hz.shutdown();
    }
}
public class Person{
    private String name;
    public Person(){
    }
    public Person(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
}