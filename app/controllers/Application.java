package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import dto.StrikerDTO;

import models.*;

public class Application extends SecureController {

    public static void index() {
        Match pendingMatch = Match.nextMatch();
        Match lastMatch = Match.lastMatch();
        MatchParticipation lastStriker = Match.striker(lastMatch);
        
        StrikerDTO striker = Player.allTimeStriker();
        PlayerStat mvp = PlayerStat.mvp();
        PlayerStat lvp = PlayerStat.lvp();
        render(pendingMatch, lastMatch, lastStriker, mvp, striker, lvp);
    }

    
}