package com.ex.yummy.Controller;

import com.ex.yummy.entities.Doop;
import com.ex.yummy.services.FunSearchOne;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@Controller
@ResponseBody
public class FunSearchController {
    ObjectMapper obMap;
    FunSearchOne servy;

    @Autowired
    public FunSearchController(ObjectMapper obMap, FunSearchOne servy) {
        this.obMap = obMap;
        this.servy = servy;
    }

    @PostMapping(path="/funs/one")
    public ArrayList<Doop> searchOne(HttpServletRequest req, HttpServletResponse res) {
        return servy.prepareRoundOne();
    }

@PostMapping(path="/funs/two")
    public ArrayList<Doop> searchTwo(HttpServletRequest req, HttpServletResponse res) {
        Doop[] winners;
        try {
            winners = obMap.readValue(req.getInputStream(), Doop[].class);
            int[] guidance = {winners[0].doopSpit(),
                    winners[1].doopSpit(),
                    winners[2].doopSpit(),
                    winners[3].doopSpit(),
                    winners[0].doopSpit(),
                    winners[1].doopSpit(),
                    winners[2].doopSpit(),
                    winners[3].doopSpit()};  // gets two cuisineId's from each winners-seed

            return servy.prepareSecondRound(guidance);
        } catch (IOException e) {
            e.printStackTrace();
            // maybe add default return to cover some bases?
        }

 ;      return servy.prepareSecondRound(new int[] {1,2,3,4,5,6,7,8}); //random default array in case something went wrong with the read.
    }
}
