package com.ex.yummy.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Random;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table
public class Doop {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
//    private String item, link;
//    private String link ;
    private String name;
    private int mexican=0, chinese=0, japanese=0, thai=0, greek=0, indian=0, caribbean=0, italian=0, german=0, korean=0, american=0, deli=0, vietnamese=0, breakfast=0, soulFood=0, bakery=0;


    public int doopSpit() {
        int arr[] = {
                this.mexican,
                this.chinese,
                this.japanese,
                this.thai,
                this.greek,
                this.indian,
                this.caribbean,
                this.italian,
                this.german,
                this.korean,
                this.american,
                this.deli,
                this.vietnamese,
                this.breakfast,
                this.soulFood,
                this.bakery} ;
        Random r = new Random();
        int sum = 0;
        for (int i:arr) {
            sum += i;

        }
        int target = (r.nextInt(sum) + 1);
        for (int i = 0; i < 15 ; i++) {
            target -= arr[i];
            if (target <= 0) {
                return i;
            }
        }
        return -1;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public String getItem() {
//        return item;
//    }

//    public void setItem(String item) {
//        this.item = item;
//    }

//    public String getLink() {
//        return link;
//    }
//
//    public void setLink(String link) {
//        this.link = link;
//    }

    public int getMexican() {
        return mexican;
    }

    public void setMexican(int mexican) {
        this.mexican = mexican;
    }

    public int getChinese() {
        return chinese;
    }

    public void setChinese(int chinese) {
        this.chinese = chinese;
    }

    public int getJapanese() {
        return japanese;
    }

    public void setJapanese(int japanese) {
        this.japanese = japanese;
    }

    public int getThai() {
        return thai;
    }

    public void setThai(int thai) {
        this.thai = thai;
    }

    public int getGreek() {
        return greek;
    }

    public void setGreek(int greek) {
        this.greek = greek;
    }

    public int getIndian() {
        return indian;
    }

    public void setIndian(int indian) {
        this.indian = indian;
    }

    public int getCaribbean() {
        return caribbean;
    }

    public void setCaribbean(int caribbean) {
        this.caribbean = caribbean;
    }

    public int getItalian() {
        return italian;
    }

    public void setItalian(int italian) {
        this.italian = italian;
    }

    public int getGerman() {
        return german;
    }

    public void setGerman(int german) {
        this.german = german;
    }

    public int getKorean() {
        return korean;
    }

    public void setKorean(int korean) {
        this.korean = korean;
    }

    public int getAmerican() {
        return american;
    }

    public void setAmerican(int american) {
        this.american = american;
    }

    public int getDeli() {
        return deli;
    }

    public void setDeli(int deli) {
        this.deli = deli;
    }

    public int getVietnamese() {
        return vietnamese;
    }

    public void setVietnamese(int vietnamese) {
        this.vietnamese = vietnamese;
    }

    public int getBreakfast() {
        return breakfast;
    }

    public void setBreakfast(int breakfast) {
        this.breakfast = breakfast;
    }

    public int getSoulFood() {
        return soulFood;
    }

    public void setSoulFood(int soulFood) {
        this.soulFood = soulFood;
    }

    public int getBakery() {
        return bakery;
    }

    public void setBakery(int bakery) {
        this.bakery = bakery;
    }
}
