package wc2014;

class Team implements Comparable {
    String teamName;
    String sortCriterion;
    String iconPath;
    String largeIconPath;
    int matchesPlayed;
    int wins;
    int loses;
    int draws;
    int goalsFor;
    int goalsAgainst;
    int goalsDifference;
    
    Team(String name) {
        teamName = name;
        sortCriterion = " ";
        iconPath = "/wc2014/resources/" + name + ".png";
        largeIconPath = "/wc2014/resources/" + name + "-финал" + ".jpg";
        matchesPlayed = 0;
        wins = 0;
	loses = 0;
	draws = 0;
        goalsFor = 0;
	goalsAgainst = 0;
	goalsDifference = 0;
    }
    
    Team(String name, int played, int wins, int loses, int draws, int scored, int conceded) {
        teamName = name;
        sortCriterion = " ";
        iconPath = "/wc2014/resources/" + name + ".png";
        largeIconPath = "/wc2014/resources/" + name + "-финал" + ".jpg";
        matchesPlayed = played;
        this.wins = wins;
	this.loses = loses;
	this.draws = draws;
        goalsFor = scored;
	goalsAgainst = conceded;
	goalsDifference = goalsFor - goalsAgainst;
    }
    
    void setSortCriterion (String set) { sortCriterion = set; }
    
    String getTeamName() { return teamName; }
    String getIconPath() { return iconPath; }
    String getlargeIconPath() { return largeIconPath; }
    int getMatchesPlayed() { return matchesPlayed; }
    int getWins() { return wins; }
    int getLoses() { return loses; }
    int getDraws() { return draws; }
    int getGoalsFor() { return goalsFor; }
    int getGoalsAgainst() { return goalsAgainst; }
    int getGoalDifference() { return goalsDifference; }
    
    void processMatch(int goalsScored, int goalsConceded, String contenderName) {
        matchesPlayed++;
        goalsFor += goalsScored;
        goalsAgainst += goalsConceded;
        goalsDifference = goalsFor - goalsAgainst;
        
        if (goalsScored > goalsConceded) 
            wins++;
        else if (goalsScored == goalsConceded) 
            draws++;
        else
            loses++;
    }
    
    void removeLastMatch(int goalsScored, int goalsConceded) {
        matchesPlayed--;
        goalsFor -= goalsScored;
        goalsAgainst -= goalsConceded;
        goalsDifference = goalsFor - goalsAgainst;
        
        if (goalsScored > goalsConceded) 
            wins--;
        else if (goalsScored == goalsConceded) 
            draws--;
        else
            loses--;
    }
    
    public int compareTo(Object obj) {
        Team otherTeam = (Team)obj;
        int goalsForDifference = this.getGoalsFor() - otherTeam.getGoalsFor();
        int goalsAgainstDifference = this.getGoalsAgainst() - otherTeam.getGoalsAgainst();
        int winsDifference = this.getWins() - otherTeam.getWins();
        int losesDifference = this.getLoses() - otherTeam.getLoses();
        int drawsDifference = this.getDraws() - otherTeam.getDraws();
        
        switch (sortCriterion) {
            case "Scored":
                if (goalsForDifference > 0)
                    return 1;
                else if (goalsForDifference < 0)
                    return -1;
                else
                    return 0;
            case "Conceded":
                if (goalsAgainstDifference > 0)
                    return 1;
                else if (goalsAgainstDifference < 0)
                    return -1;
                else
                    return 0;
            case "Wins":
                if (winsDifference > 0)
                    return 1;
                else if (winsDifference < 0)
                    return -1;
                else
                    return 0;
            case "Loses":
                if (losesDifference > 0)
                    return 1;
                else if (losesDifference < 0)
                    return -1;
                else
                    return 0;
            default:
                if (drawsDifference > 0)
                    return 1;
                else if (drawsDifference < 0)
                    return -1;
                else
                    return 0;
        }
    } 
    
}

class GroupTeam extends Team {  
    String contenderName1;
    String contenderName2;
    String contenderName3;
    int points;
    boolean isPlayedWithContender1;
    boolean isPlayedWithContender2;
    boolean isPlayedWithContender3;
    int [] lastScoreWithContender1 = {0, 0};
    int [] lastScoreWithContender2 = {0, 0};
    int [] lastScoreWithContender3 = {0, 0};
    String lastResultWithContender1;
    String lastResultWithContender2;
    String lastResultWithContender3;

    GroupTeam(String name) {
        super(name);
        contenderName1 = " ";
        contenderName2 = " ";
        contenderName3 = " ";
	points = 0;
        isPlayedWithContender1 = false;
        isPlayedWithContender2 = false;
        isPlayedWithContender3 = false;
        lastResultWithContender1 = " ";
        lastResultWithContender2 = " ";
        lastResultWithContender3 = " ";
    }
    
    GroupTeam(String name, String contenderName1, String contenderName2, String contenderName3, int played, 
        int wins, int loses, int draws, int scored, int conceded, int points, boolean isPlayedWithContender1,
        boolean isPlayedWithContender2, boolean isPlayedWithContender3, int [] lastScoreWithContender1,
        int [] lastScoreWithContender2, int [] lastScoreWithContender3, String lastResultWithContender1,
        String lastResultWithContender2, String lastResultWithContender3) 
    {
        super(name, played, wins, loses, draws, scored, conceded);
        this.contenderName1 = contenderName1;
        this.contenderName2 = contenderName2;
        this.contenderName3 = contenderName3;
	this.points = points;
        this.isPlayedWithContender1 = isPlayedWithContender1;
        this.isPlayedWithContender2 = isPlayedWithContender2;
        this.isPlayedWithContender3 = isPlayedWithContender3;
        this.lastResultWithContender1 = lastResultWithContender1;
        this.lastResultWithContender2 = lastResultWithContender2;
        this.lastResultWithContender3 = lastResultWithContender3;
        this.lastScoreWithContender1 [0] = lastScoreWithContender1 [0];
        this.lastScoreWithContender1 [1] = lastScoreWithContender1 [1];
        this.lastScoreWithContender2 [0] = lastScoreWithContender2 [0];
        this.lastScoreWithContender2 [1] = lastScoreWithContender2 [1];
        this.lastScoreWithContender3 [0] = lastScoreWithContender3 [0];
        this.lastScoreWithContender3 [1] = lastScoreWithContender3 [1];
    }
    
    String getContenderName1() { return contenderName1; }
    String getContenderName2() { return contenderName2; }
    String getContenderName3() { return contenderName3; }
    int getPoints() { return points; }
    String getIsPlayedWithContender1() { return Boolean.toString(isPlayedWithContender1); }
    String getIsPlayedWithContender2() { return Boolean.toString(isPlayedWithContender2); }
    String getIsPlayedWithContender3() { return Boolean.toString(isPlayedWithContender3); }
    String getLastScoreWithContender1() {
        return (Integer.toString(lastScoreWithContender1[0]) + ";" + Integer.toString(lastScoreWithContender1[1]));
    }
    String getLastScoreWithContender2() {
        return (Integer.toString(lastScoreWithContender2[0]) + ";" + Integer.toString(lastScoreWithContender2[1]));
    }
    String getLastScoreWithContender3() {
        return (Integer.toString(lastScoreWithContender3[0]) + ";" + Integer.toString(lastScoreWithContender3[1]));
    }
    String getLastResultWithContender1() { return lastResultWithContender1; }
    String getLastResultWithContender2() { return lastResultWithContender2; }
    String getLastResultWithContender3() { return lastResultWithContender3; }
    
    void processMatch (int goalsScored, int goalsConceded, String contenderName) {
        if(contenderName.equals(contenderName1) && isPlayedWithContender1) {
            goalsFor -= lastScoreWithContender1[0];
            goalsAgainst -= lastScoreWithContender1[1];
            goalsDifference = goalsFor - goalsAgainst;
            if(lastResultWithContender1.equals("win")) {
                wins--;
                points -= 3;
            }
            else if (lastResultWithContender1.equals("draw")) {
                draws--;
                points -= 1;
            }
            else
                loses--;
            
            goalsFor += goalsScored;
            goalsAgainst += goalsConceded;
            goalsDifference = goalsFor - goalsAgainst;
            if (goalsScored > goalsConceded) {
                points += 3;
                wins++;
                lastResultWithContender1 = "win";
            }
            else if (goalsScored == goalsConceded) {
                points += 1;
                draws++;
                lastResultWithContender1 = "draw";
            }
            else {
                loses++;
                lastResultWithContender1 = "lose";
            }
            
            lastScoreWithContender1[0] = goalsScored;
            lastScoreWithContender1[1] = goalsConceded;
        }
        
        else if(contenderName.equals(contenderName2) && isPlayedWithContender2) {
            goalsFor -= lastScoreWithContender2[0];
            goalsAgainst -= lastScoreWithContender2[1];
            goalsDifference = goalsFor - goalsAgainst;
            if(lastResultWithContender2.equals("win")) {
                wins--;
                points -= 3;
            }
            else if (lastResultWithContender2.equals("draw")) {
                draws--;
                points -= 1;
            }
            else
                loses--;
            
            goalsFor += goalsScored;
            goalsAgainst += goalsConceded;
            goalsDifference = goalsFor - goalsAgainst;
            if (goalsScored > goalsConceded){
                points += 3;
                wins++;
                lastResultWithContender2 = "win";
            }
            else if (goalsScored == goalsConceded){
                points += 1;
                draws++;
                lastResultWithContender2 = "draw";
            }
            else {
                loses++;
                lastResultWithContender2 = "lose";
            }
            
            lastScoreWithContender2[0] = goalsScored;
            lastScoreWithContender2[1] = goalsConceded;
        }
        
        else if(contenderName.equals(contenderName3) && isPlayedWithContender3) {
            goalsFor -= lastScoreWithContender3[0];
            goalsAgainst -= lastScoreWithContender3[1];
            goalsDifference = goalsFor - goalsAgainst;
            if(lastResultWithContender3.equals("win")) {
                wins--;
                points -= 3;
            }
            else if (lastResultWithContender3.equals("draw")) {
                draws--;
                points -= 1;
            }
            else
                loses--;
            
            goalsFor += goalsScored;
            goalsAgainst += goalsConceded;
            goalsDifference = goalsFor - goalsAgainst;
            if (goalsScored > goalsConceded){
                points += 3;
                wins++;
                lastResultWithContender3 = "win";
            }
            else if (goalsScored == goalsConceded){
                points += 1;
                draws++;
                lastResultWithContender3 = "draw";
            }
            else {
                loses++;
                lastResultWithContender3 = "lose";
            }
            
            lastScoreWithContender3[0] = goalsScored;
            lastScoreWithContender3[1] = goalsConceded;
        }
        
        else {
            if(contenderName1.equals(" ")) {
                contenderName1 = contenderName;
                isPlayedWithContender1 = true;
                lastScoreWithContender1[0] = goalsScored;
                lastScoreWithContender1[1] = goalsConceded;
                
                if (goalsScored > goalsConceded)
                    lastResultWithContender1 = "win";
                else if (goalsScored == goalsConceded)
                    lastResultWithContender1 = "draw";
                else
                    lastResultWithContender1 = "lose";
            }
            else if(contenderName2.equals(" ")){
                contenderName2 = contenderName;
                isPlayedWithContender2 = true;
                lastScoreWithContender2[0] = goalsScored;
                lastScoreWithContender2[1] = goalsConceded;
                
                if (goalsScored > goalsConceded)
                    lastResultWithContender2 = "win";
                else if (goalsScored == goalsConceded)
                    lastResultWithContender2 = "draw";
                else
                    lastResultWithContender2 = "lose";
            }
            else {
                contenderName3 = contenderName;
                isPlayedWithContender3 = true;
                lastScoreWithContender3[0] = goalsScored;
                lastScoreWithContender3[1] = goalsConceded;
                
                if (goalsScored > goalsConceded)
                    lastResultWithContender3 = "win";
                else if (goalsScored == goalsConceded)
                    lastResultWithContender3 = "draw";
                else
                    lastResultWithContender3 = "lose";
            }
            
            matchesPlayed++;
            goalsFor += goalsScored;
            goalsAgainst += goalsConceded;
            goalsDifference = goalsFor - goalsAgainst;
            if (goalsScored > goalsConceded) {
                wins++;
                points += 3;
            }
            else if (goalsScored == goalsConceded) {
                points += 1;
                draws++;
            }
            else
                loses++;
        }
    }
    
    public int compareTo(Object obj) {
        GroupTeam otherTeam = (GroupTeam)obj;
        int pointsDifference = this.getPoints() - otherTeam.getPoints();
        int goalsDifference = this.getGoalDifference() - otherTeam.getGoalDifference();
        int goalsForDifference = this.getGoalsFor() - otherTeam.getGoalsFor();
        if (pointsDifference > 0) {
            return 1;
        } else if (pointsDifference < 0) {
            return -1;
        } else {
            if (goalsDifference > 0) {
                return 1;
            } else if (goalsDifference < 0) {
                return -1;
            } else {
                if (goalsForDifference > 0) {
                    return 1;
                } else if (goalsForDifference < 0) {
                    return -1;
                }
                else
                    return 0;
            }
        }
    }
    
}

class PlayOffTeam extends Team {
    boolean isWinner;
    boolean isPenalty;
    int [] lastScoreWithContender = {0, 0};
    int [] lastPenaltyWithContender = {0, 0};
    
    PlayOffTeam(String teamName, boolean isWinner, boolean isPenalty, int [] lastScoreWithContender, 
            int [] lastPenaltyWithContender) 
    {
        super(teamName);
        this.isWinner = isWinner;
        this.isPenalty = isPenalty;
        this.lastScoreWithContender[0] = lastScoreWithContender[0];
        this.lastScoreWithContender[1] = lastScoreWithContender[1];
        this.lastPenaltyWithContender[0] = lastPenaltyWithContender[0];
        this.lastPenaltyWithContender[1] = lastPenaltyWithContender[1];
    }
    
    PlayOffTeam(String teamName) {
        super(teamName);
        isWinner = false;
        isPenalty = false;
        lastScoreWithContender[0] = -1;
        lastScoreWithContender[1] = -1;
        lastPenaltyWithContender[0] = -1;
        lastPenaltyWithContender[1] = -1;
    }
    
    String getLastScoreWithContender() {
        return (Integer.toString(lastScoreWithContender[0]) + ";" + Integer.toString(lastScoreWithContender[1]));
    }
    String getLastPenaltyWithContender() {
        return (Integer.toString(lastPenaltyWithContender[0]) + ";" + Integer.toString(lastPenaltyWithContender[1]));
    }
    String getIsWinner() { return Boolean.toString(isWinner); }
    String getIsPenalty() { return Boolean.toString(isPenalty); }
    void setIsWinner(boolean value) { isWinner = value; }
    
    void processMatch (int goalsScored, int goalsConceded, String contender) {
        if (goalsScored > goalsConceded) 
            isWinner = true;
        else
            isWinner = false;
        lastScoreWithContender[0] = goalsScored;
        lastScoreWithContender[1] = goalsConceded;
        isPenalty = false;
        lastPenaltyWithContender[0] = -1;
        lastPenaltyWithContender[1] = -1;
    }
    
    void processPenalty(int goalsScored, int goalsConceded, int goalsScoredPenalty, int goalsConcededPenalty) {
        lastScoreWithContender[0] = goalsScored;
        lastScoreWithContender[1] = goalsConceded;
        isPenalty = true;
        if (goalsScoredPenalty > goalsConcededPenalty) 
            isWinner = true;
        else
            isWinner = false;
        lastPenaltyWithContender[0] = goalsScoredPenalty;
        lastPenaltyWithContender[1] = goalsConcededPenalty;
    }
    
}
        
