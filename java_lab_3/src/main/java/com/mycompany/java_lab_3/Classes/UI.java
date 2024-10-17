package main.java.com.mycompany.java_lab_3.Classes;
import java.util.regex.Pattern;
import java.util.Scanner;

public class UI {
    /**
     *  Сообщение для пользователя
     */
    private String _message; 
    /**
     *  Объект сканера
     */
    private Scanner _sc; 
    static private final String _nameMess = "Enter Name";
    static private final String _gamesCountMess = "Enter Games count";
    static private final String _playersCountMess = "Enter Players count";
    static private final String _winCountMess = "Enter Wins count";
    static private final String _limTempMess = "Enter Limit Temperature";
    static private final String _goalkeepMess = "Enter Goalkeeper's form";
    static private final String _socksMess = "Enter 'true' if socks allowed"
            + "and 'false' if not";
    static private final String _teamTypeMess = "Enter Team Type";
    static private final String _positionsMess = "Enter Positions";
    static private final String _extraArmorMess = "Is Extra Armor needed? "
            + "(true/false)";
    static private final String _gameSchemeMess = "Enter Game Scheme";
    static private final String _shieldsMess = "Are Shields needed?"
            + " (true/false)";
    static private final String _mascotMess = "Enter Mascot";
    static private final String _welcomeMess = "Enter team type(1/2/3)";
    static private final String _errorMess = "ERROR";
    static private final String _typeMess = ""
            + "1. Beach football" + "\n"
            + "2. American football" + "\n"
            + "3. European football";
    /**
     * Конструктор с параметром
     * @param message - сообщение для пользователя 
     */
    public UI(String message) {
        _sc = new Scanner(System.in);
        _message = message;
    }
    
    /**
     * Конструктор по умолчанию
     */
    public UI(){
        //this(_defaultMess);
    }
    
    /**
     * Запуск приложения
     */
    public void startApplication(){
        System.out.println(_welcomeMess);
        FootballTeam team = null;
        String userSelection = getSelMess(_welcomeMess).substring(0, 1);
        League league = new League();
        switch (userSelection){
            case "1":
                team = new BeachFootball();
                break;
            case "2":
                team = new AmericanFootball();
                break;
            case "3":
                team = new EuropeanFootball();
                break;
            default:
                break;
        }
        int lgInd = Integer.parseInt(userSelection) - 1;
        for(int i = 0; i < League._defaultLeagues[0].length; i++){
            switch(i){
                case 0:
                    league.setName(League._defaultLeagues[lgInd][i]);
                    break;
                case 1:
                    league.setDivision(League._defaultLeagues[lgInd][i]);
                    break;
                case 2:
                    league.setCountry(League._defaultLeagues[lgInd][i]);
                    break;
                case 3:
                    league.setYear(League._defaultLeagues[lgInd][i]);
                    break;
                default:
                    break;      
            }
        }
        
        getDefMess(_nameMess, team);
        getDefMess(_gamesCountMess, team);
        getDefMess(_playersCountMess, team);
        getDefMess(_winCountMess, team);
        TeamList teams = new TeamList(userSelection);
        switch (userSelection){
            case "1":
                BeachFootball beachTeam = new BeachFootball(); 
                getDefMess(_limTempMess, beachTeam, userSelection);
                getDefMess(_goalkeepMess, beachTeam, userSelection);
                getDefMess(_socksMess, beachTeam, userSelection);
                team = beachTeam;
                break;
            case "2":
                AmericanFootball amerTeam = new AmericanFootball(); 
                getDefMess(_limTempMess, amerTeam, userSelection);
                getDefMess(_teamTypeMess, amerTeam, userSelection);
                getDefMess(_extraArmorMess, amerTeam, userSelection);
                team = amerTeam;
                break;
            case "3":
                EuropeanFootball europTeam = new EuropeanFootball(); 
                getDefMess(_mascotMess, europTeam, userSelection);
                getDefMess(_gameSchemeMess, europTeam, userSelection);
                getDefMess(_shieldsMess, europTeam, userSelection);
                team = europTeam;
                break;
            default: 
                break;
        }
        teams.add(team);
        league.setTeams(teams);
    }
    
    public void getDefMess(String mess, FootballTeam team, String type){
        System.out.println(mess);
        boolean verification = selDefVer(mess, scanInput(), team, type);
        while (!verification){
            System.out.println(_errorMess);
            System.out.println(mess);
            verification = selDefVer(mess, scanInput(), team);
        }
    }
    
    public void getDefMess(String mess, FootballTeam team){
        System.out.println(mess);
        boolean verification = selDefVer(mess, scanInput(), team);
        while (!verification){
            System.out.println(_errorMess);
            System.out.println(mess);
            verification = selDefVer(mess, scanInput(), team);
        }
    }
    
    private boolean selDefVer(String mess, String userInput, FootballTeam team, 
            String type){
        boolean verification = FootballTeam._defaultValueBoolean;
        AmericanFootball amerTeam = null;
        BeachFootball beachTeam = null;
        EuropeanFootball europTeam = null;
        switch (type){
            case "2":
                amerTeam = (AmericanFootball)team;
                break;
            case "1":
                beachTeam = (BeachFootball)team;
                break;
            case "3":
                europTeam = (EuropeanFootball)team;
                break;
            default:
                break;
        }
        switch (mess){
            case _limTempMess:
                verification = beachTeam.setLimitTemperature(userInput);
                break;
            case _goalkeepMess:
                verification = beachTeam.setGoalkeeperForm(userInput);
                break;
            case _socksMess:
                verification = beachTeam.setSocksAllowed(userInput);
                break;
            case _teamTypeMess:
                verification = amerTeam.setTeamType(userInput);
                break;
            case _positionsMess:
                verification = amerTeam.setPositions(userInput);
                break;
            case _extraArmorMess:
                verification = amerTeam.setExtraArmor(userInput);
                break;
            case _gameSchemeMess:
                verification = europTeam.setGameScheme(userInput);
                break;
            case _mascotMess:
                verification = europTeam.setMascot(userInput);
                break;
            case _shieldsMess:
                verification = europTeam.setShields(userInput);
                break;
            default:
                break;
        }
        return verification;
    }
    
    private boolean selDefVer(String mess, String userInput, FootballTeam team){
        boolean verification = FootballTeam._defaultValueBoolean;
        switch (mess){
            case _nameMess:
                verification = team.setName(userInput);
                break;
            case _gamesCountMess:
                verification = team.setGamesCount(userInput);
                break;
            case _playersCountMess:
                verification = team.setPlayers(userInput);
                break;
            case _winCountMess:
                verification = team.setWinCount(userInput);
                break;
            default:
                break;
        }
        return verification;
    }
        
    public String getSelMess(String mess){
        String userInput = scanInput();
        System.out.println(mess);
        while(!League.selVer(mess)){
            System.out.println(_errorMess);
            System.out.println(mess);
            userInput = scanInput();
        }
         return userInput;           
    }
    /**
     * Получение ввода пользователя
     * @return введённую строчку
     */
    private String scanInput(){
        String inputUser = _sc.nextLine();
        return inputUser;
    }
    
}
