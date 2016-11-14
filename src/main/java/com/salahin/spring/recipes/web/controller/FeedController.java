//FINAL 
package com.salahin.spring.recipes.web.controller;


import com.salahin.spring.recipes.domain.TournamentContent;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Controller
public class FeedController {
    @RequestMapping("/atomfeed")
    public String getAtomFeed(Model model) {
        List<TournamentContent> atomTournamentList = new ArrayList<TournamentContent>();
        atomTournamentList.add(TournamentContent.generateContent("ATP", new Date(), "Australian Open", "www.australianopen.com"));
        atomTournamentList.add(TournamentContent.generateContent("ATP", new Date(), "Roland Garros", "www.rolandgarros.com"));
        atomTournamentList.add(TournamentContent.generateContent("ATP", new Date(), "Wimbledon", "www.wimbledon.org"));
        atomTournamentList.add(TournamentContent.generateContent("ATP", new Date(), "US Open", "www.usopen.org"));
        model.addAttribute("feedContent", atomTournamentList);

        return "atomFeedViewTemplate";
    }

    @RequestMapping("/rssfeed")
    public String getRSSFeed(Model model) {
        List<TournamentContent> tournamentList = new ArrayList<TournamentContent>();
        tournamentList.add(TournamentContent.generateContent("FIFA", new Date(), "World Cup", "www.fifa.com/worldcup/"));
        tournamentList.add(TournamentContent.generateContent("FIFA", new Date(), "U-20 World Cup", "www.fifa.com/u20worldcup/"));
        tournamentList.add(TournamentContent.generateContent("FIFA", new Date(), "U-17 World Cup", "www.fifa.com/u17worldcup/"));
        tournamentList.add(TournamentContent.generateContent("FIFA", new Date(), "Confederations Cup", "www.fifa.com/confederationscup/"));
        model.addAttribute("feedContent", tournamentList);

        return "rssFeedViewTemplate";
    }

    @RequestMapping("/jsontournament")
    public String getJSON(Model model) {
        List<TournamentContent> tournamentList = new ArrayList<TournamentContent>();
        tournamentList.add(TournamentContent.generateContent("FIFA", new Date(), "World Cup", "www.fifa.com/worldcup/"));
        tournamentList.add(TournamentContent.generateContent("FIFA", new Date(), "U-20 World Cup", "www.fifa.com/u20worldcup/"));
        tournamentList.add(TournamentContent.generateContent("FIFA", new Date(), "U-17 World Cup", "www.fifa.com/u17worldcup/"));
        tournamentList.add(TournamentContent.generateContent("FIFA", new Date(), "Confederations Cup", "www.fifa.com/confederationscup/"));
        model.addAttribute("feedContent", tournamentList);

        return "jsontournamenttemplate";
    }
}
