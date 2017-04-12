/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Spring.util;

/**
 *
 * @author irfan
 */
public class Price {
    private String item;
    private int price;
     
    public Price(String itm, int pr){
                System.out.println("In Side Constructor");

        this.item = itm;
        this.price = pr;
                        System.out.println("In Side lastConstructor");

    }
     
    @Override
    public int hashCode(){
        System.out.println("In hashcode");
        int hashcode = 0;
        hashcode = price*20;
        hashcode += item.hashCode();
        System.out.println(hashcode);
        return hashcode;
    }
    @Override
    public boolean equals(Object obj){
        System.out.println("In equals");
        if (obj instanceof Price) {
            Price pp = (Price) obj;
            return (pp.item.equals(this.item) && pp.price == this.price);
        } else {
            return false;
        }
    }

    public String getItem() {
        return item;
    }
    public void setItem(String item) {
        this.item = item;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    @Override
    public String toString(){
        System.out.println("inside toString");
        return "item: "+item+"  price: "+price;
    }


}
