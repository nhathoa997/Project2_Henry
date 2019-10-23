package com.ex.yummy.services;

import com.ex.yummy.dao.FunSearchDao;
import com.ex.yummy.entities.Doop;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Random;

@Getter
@Setter
@NoArgsConstructor

@Service("funSearch")
public class FunSearchOne {
    private int sauces = 12;
    private int sides = 17;
    private FunSearchDao dao;
    private ArrayList<Integer> temp;

    @Autowired
    public FunSearchOne(FunSearchDao fun_dao) {
        this.dao = fun_dao;
    }

    public ArrayList<Doop> prepareRoundOne() {
        ArrayList<Doop> setup = new ArrayList<>();
        temp = getFourRando(sauces);
        System.out.println(temp.get(0));
        System.out.println(temp.get(1));
        System.out.println(temp.get(2));
        System.out.println(temp.get(3));
        setup.add(dao.getDoop(temp.get(0)));
        setup.add(dao.getDoop(temp.get(1)));
        setup.add(dao.getDoop(temp.get(2)));
        setup.add(dao.getDoop(temp.get(3))); // get four random sauces

        temp = getFourRando(sides);
        setup.add(dao.getDoop(temp.get(0) + sauces));
        setup.add(dao.getDoop(temp.get(1) + sauces));
        setup.add(dao.getDoop(temp.get(2) + sauces));
        setup.add(dao.getDoop(temp.get(3) + sauces)); //get four random sides

        return setup;
    }
    public ArrayList<Doop> prepareSecondRound(int[] guidance) { //guidance should have 8 integers that represent cuisine categories
        ArrayList<Doop> setup = new ArrayList<>();
        Random r = new Random();
        for (int i: guidance) {
            setup.add(dao.getDoop((i+1)*100 + r.nextInt(4) + 1 )) ; //gets one of the four associated foods for that cuisine, at random.
        }
        return setup;
    }

    public ArrayList<Integer> getFourRando(int max) {
        temp = new ArrayList<>();
        int a, b, c , d;
        int min = 1;
        Random r = new Random();
//        double randomDouble = Math.random();
//        randomDouble = randomDouble * 93 + 1;
//        int randomInt = (int) randomDouble;
        a = r.nextInt((max - min) + 1) + min;
        do {
            b = r.nextInt((max - min) + 1) + min;;
        } while (a == b);
        do {
            c = r.nextInt((max - min) + 1) + min;
        } while ((a == c) | (b == c));
        do {
            d = r.nextInt((max - min) + 1) + min;;
        } while ((a == d) | (b == d) | (c == d));
        temp.add(a);
        temp.add(b);
        temp.add(c);
        temp.add(d);
        return temp;
//        HERE I AM DEBUGGING THIS ALGORITHM I MADE, ONLY TO DISCOVER IT'S A SOLVED PROBLEM ><
//        AND IT WASN'T EVEN MY THIS THAT WAS BROKEN, IT WAS THE TEST'
//        return new Random().ints(1, max).distinct().limit(4).toArray();
    }

}
