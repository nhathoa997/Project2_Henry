package com.ex.yummy.services;

import com.ex.yummy.dao.FunSearchDao;
import com.ex.yummy.entities.Doop;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
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

    public ArrayList<Doop> prepareRoundOne() {
        ArrayList<Doop> setup = new ArrayList<>();
        int[] temp = getFourRando(sauces);
        setup.add(dao.getDoop(temp[0]));
        setup.add(dao.getDoop(temp[1]));
        setup.add(dao.getDoop(temp[2]));
        setup.add(dao.getDoop(temp[3])); // get four random sauces
        temp = getFourRando(sides);
        setup.add(dao.getDoop(temp[0] + sauces));
        setup.add(dao.getDoop(temp[1] + sauces));
        setup.add(dao.getDoop(temp[2] + sauces));
        setup.add(dao.getDoop(temp[3] + sauces)); //get four random sides

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

    public int[] getFourRando(int max) {
//        int a, b, c , d;
//        Random r = new Random();
//        a = r.nextInt(max);
//        do {
//            b = r.nextInt(max);
//        } while (a == b);
//        do {
//            c = r.nextInt(max);
//        } while ((a == c) | (b == c));
//        do {
//            d = r.nextInt(max);
//        } while ((a == d) | (b == d) | (c == d));
//        HERE I AM DEBUGGING THIS ALGORITHM I MADE, ONLY TO DISCOVER IT'S A SOLVED PROBLEM ><
//        AND IT WASN'T EVEN MY THIS THAT WAS BROKEN, IT WAS THE TEST'
        return new Random().ints(1, max).distinct().limit(4).toArray();
    }

}
