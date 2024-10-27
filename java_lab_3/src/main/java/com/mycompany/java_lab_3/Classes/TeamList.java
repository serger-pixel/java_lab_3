package main.java.com.mycompany.java_lab_3.Classes;
import java.util.ArrayList;
import java.util.Collections;

public class TeamList {
    /**
     * Данные для создания команд по пляжному футболу
     */
    static public final String[][] _BeachInfo = {
        {"Sun", "30", "5", "1", "shorts", "25", "true"},
        {"Water", "50", "5", "20", "pants", "40", "false"},
        {"Sand", "100", "5", "99", "shorts", "49", "false"}
    };
    /**
     * Данные для создания команд по амерекансому футболу
     */
    static public final String[][] _AmericInfo = {
        {"Liberty", "70", "11", "35", "attack", "Center, offensive guard", 
            "true"},
        {"Eagle", "55", "11", "30", "protection", "Middle, tackle", "false"},
        {"Maggots", "30", "11", "0", "attack", "Center, RB", "true"}    
    };
    /**
     * Данные для создания команд по европейскому футболу
     */
    static public final String[][] _EuropeInfo = {
        {"Lion", "90", "11", "70", "4-4-2", "true", "Lyova"},
        {"Wolf", "40", "11", "10", "4-6-0", "false", "Volchara"},
        {"Capybara", "2", "11", "0", "4-5-1", "true", "Capy"}
    };
    /**
     * Массив для хранения команд
     */
    private ArrayList<FootballTeam> _teamMass;
    
    /**
     * Конструтор с параметром
     * @param type - тип команд
     */
    public TeamList(String type){
        _teamMass = new ArrayList<>();
        String locName = FootballTeam._defaultValueString;
        int locPlayers = FootballTeam._defaultValueInt;
        int locGamesC = FootballTeam._defaultValueInt;
        int locWinC = FootballTeam._defaultValueInt;
        switch (type){
            case ("1"):
                int locLimTemp = FootballTeam._defaultValueInt;
                String locGKF = FootballTeam._defaultValueString;
                boolean locSocksA = FootballTeam._defaultValueBoolean;
                for(int i = 0; i < _BeachInfo.length; i++){
                    for(int j = 0; j < _BeachInfo[i].length; j++){
                        switch(j){
                            case 0:
                                locName = _BeachInfo[i][j];
                                break;
                            case 1:
                                locPlayers = Integer.parseInt(_BeachInfo[i][j]);
                                break;
                            case 2:
                                locGamesC = Integer.parseInt(_BeachInfo[i][j]);
                                break;
                            case 3:
                                locWinC = Integer.parseInt(_BeachInfo[i][j]);
                                break;
                            case 4:
                                locGKF = _BeachInfo[i][j];
                                
                                break;
                            case 5:
                                locLimTemp = Integer.parseInt(_BeachInfo[i][j]);
                                break;
                            case 6:
                                if(_BeachInfo[i][j] == "true"){
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
                    _teamMass.add(localTeam);
                }
                break;
            case "2":
                String locTeamType = FootballTeam._defaultValueString;
                String locPositions = FootballTeam._defaultValueString;
                boolean locExtraArmor = FootballTeam._defaultValueBoolean;
                for(int i = 0; i < _AmericInfo.length; i++){
                    for(int j = 0; j < _AmericInfo[i].length; j++){
                        switch(j){
                            case 0:
                                locName = _AmericInfo[i][j];
                                break;
                            case 1:
                                locPlayers = Integer.parseInt(_AmericInfo[i][j]);
                                break;
                            case 2:
                                locGamesC = Integer.parseInt(_AmericInfo[i][j]);
                                break;
                            case 3:
                                locWinC = Integer.parseInt(_AmericInfo[i][j]);
                                break;
                            case 4:
                                locTeamType= _AmericInfo[i][j];
                                break;
                            case 5:
                                locPositions = _AmericInfo[i][j];
                                break;
                            case 6:
                                if(_AmericInfo[i][j] == "true"){
                                    locExtraArmor = true;
                                    break;
                                }
                                locExtraArmor = false;
                                break;
                            default:
                                break;
                        }
                    }
                    AmericanFootball localTeam = new AmericanFootball(locName, locPlayers,
                    locGamesC, locWinC, locTeamType, locPositions, locExtraArmor);
                    _teamMass.add(localTeam);
                }
                break;
            case "3":
                String locGameScheme = FootballTeam._defaultValueString;
                String locMascot = FootballTeam._defaultValueString;
                boolean locShields = FootballTeam._defaultValueBoolean;
                for(int i = 0; i < _EuropeInfo.length; i++){
                    for(int j = 0; j < _EuropeInfo[i].length; j++){
                        switch(j){
                            case 0:
                                locName = _EuropeInfo[i][j];
                                break;
                            case 1:
                                locPlayers = Integer.parseInt(_EuropeInfo[i][j]);
                                break;
                            case 2:
                                locGamesC = Integer.parseInt(_EuropeInfo[i][j]);
                                break;
                            case 3:
                                locWinC = Integer.parseInt(_EuropeInfo[i][j]);
                                break;
                            case 4:
                                locGameScheme= _EuropeInfo[i][j];
                                break;
                            case 6:
                                locMascot= _AmericInfo[i][j];
                                break;
                            case 5:
                                if(_EuropeInfo[i][j] == "true"){
                                    locShields = true;
                                    break;
                                }
                                locShields = false;
                                break;
                            default:
                                break;
                        }
                    }
                    EuropeanFootball localTeam = new EuropeanFootball(locName, locPlayers,
                    locGamesC, locWinC, locGameScheme, locShields, locMascot);
                    _teamMass.add(localTeam);
                }
                break;
            default:
                break;
        }
    }

    /**
     * Конструктор по умолчанию
     */
    public TeamList() {
        _teamMass = new ArrayList<>();
    }
    
    /**
     * Конструктор с параметрами
     * @param teams - массив команд 
     */
    public TeamList(ArrayList<FootballTeam> teams) {
        _teamMass = teams;
    }
    
    /**
     * Добавление команды в массив команд
     * @param team - команда
     */
    public void add(FootballTeam team){
        _teamMass.add(team);
    }
    
    /**
     * Получение элемента массива команд
     * @param i - индекс элемена
     * @return команда
     */
    public FootballTeam get(int i){
        return _teamMass.get(i);
    }
    
    /**
     * Возращение длины массива команд
     * @return длина массива 
     */
    public int length(){
        return _teamMass.size();
    }
    
    /**
     * Поиск команды по названию
     * @return команда
     */
    public FootballTeam findTheBest() {
            FootballTeam team = _teamMass.get(0);
            int theBestCount = team.getWinCount();
            for (int i = 1; i< _teamMass.size(); i++){
                if (_teamMass.get(i).getWinCount() > theBestCount){
                    team = _teamMass.get(i);
                }
            }
            return team;
    }
    
    /**
     * Поиск команд с кол-вом побед выше среднего
     * @return список команд
     */
    public TeamList findAboveAverege() {
        int averageWins = FootballTeam._defaultValueInt;
        int cntTeam = _teamMass.size();
        for (int i = 0; i< _teamMass.size(); i++){
            averageWins += _teamMass.get(i).getGamesCount();
        }
        int aboveAverage = averageWins/cntTeam;
        ArrayList<FootballTeam> aboveAverageTeam = new ArrayList<>();
        for (int i = 0; i< _teamMass.size(); i++){
            if (_teamMass.get(i).getWinCount() > aboveAverage){
                aboveAverageTeam.add(_teamMass.get(i));
            }
        }
        return new TeamList(aboveAverageTeam);
	}
    
    /**
     * Сортировка команд
     */
    public void sortTeams() {
        Collections.sort(_teamMass, 
                (team1, team2)-> Integer.compare(team1.getWinCount(), 
                        team2.getWinCount()));
    }

    /**
     * Поиск команды
     * @param name - имя команды
     * @return найденная команда
     */
    public FootballTeam findTeam(String name) {
        for (int i = 0; i < _teamMass.size(); i++){
            if ((_teamMass.get(i)).getName().equals(name)){
                return _teamMass.get(i);
            }
        }
        return null;
    }
        
}