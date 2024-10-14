package main.java.com.mycompany.java_lab_3.Classes;
import java.util.ArrayList;

public class TeamList {
    static public final String[][] BeachInfo = {
        {"Sun", "30", "5", "1", "shorts", "25", "true"},
        {"Water", "50", "5", "20", "pants", "40", "false"},
        {"Sand", "100", "5", "99", "shorts", "49", "false"}
    };
    static public final String[][] AmericInfo = {
        {"Liberty", "70", "11", "35", "attack", "Center, offensive guard", 
            "true"},
        {"Eagle", "55", "11", "30", "protection", "Middle, tackle", "false"},
        {"Maggots", "30", "11", "0", "attack", "Center, RB", "true"}    
    };
    static public final String[][] EuropeInfo = {
        {"Lion", "90", "11", "70", "4-4-2", "true", "Lyova"},
        {"Wolf", "40", "11", "10", "4-6-0", "false", "Volchara"},
        {"Capybara", "2", "11", "0", "4-5-1", "true", "Chill Capy"}
    };
    
    private ArrayList<FootballTeam> teamMass;
    
    public TeamList(String name, int players, int gamesCount, int winCount,
            int limitTemperature, String goalkeeperForm, boolean socksAllowed){
        
        BeachFootball bfTeam = new BeachFootball(name, players ,gamesCount,
                winCount, limitTemperature, goalkeeperForm, socksAllowed);
        
        for(int i = 0; i < BeachInfo.length; i++){
            
            String locName = FootballTeam._defaultValueString;
            int locPlayers = FootballTeam._defaultValueInt;
            int locGamesC = FootballTeam._defaultValueInt;
            int locWinC = FootballTeam._defaultValueInt;
            int locLimTemp = FootballTeam._defaultValueInt;
            String locGKF = FootballTeam._defaultValueString;
            boolean locSocksA = FootballTeam._defaultValueBoolean;
            
            for(int j = 0; j < BeachInfo[i].length; j++){
                switch(j){
                    case 0:
                        locName = BeachInfo[i][j];
                        break;
                    case 1:
                        locPlayers = Integer.parseInt(BeachInfo[i][j]);
                        break;
                    case 2:
                        locGamesC = Integer.parseInt(BeachInfo[i][j]);
                        break;
                    case 3:
                        locWinC = Integer.parseInt(BeachInfo[i][j]);
                        break;
                    case 4:
                        locLimTemp = Integer.parseInt(BeachInfo[i][j]);
                        break;
                    case 5:
                        locGKF = BeachInfo[i][j];
                        break;
                    case 6:
                        if(BeachInfo[i][j] == "true"){
                            locSocksA = true;
                            break;
                        }
                        locSocksA = false;
                        break;
                    default:
                        break;
                }
            }
            BeachFootball localTeam = new BeachFootball(locName, locPlayers,
            locGamesC, locWinC, locLimTemp, locGKF, locSocksA);
            teamMass.add(localTeam);
        }
        teamMass.add(bfTeam);
    }
}
