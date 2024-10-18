package main.java.com.mycompany.java_lab_3.Classes;
import java.util.regex.Pattern;
import java.util.Scanner;

public class UI {
    /**
     *  Сообщение для пользователя
     */
    private String _message; 
    /*
     *  Объект сканера
     */
    public static Scanner _sc; 
    static public final String _nameMess = "Enter Name";
    static public final String _gamesCountMess = "Enter Games count";
    static public final String _playersCountMess = "Enter Players count";
    static public final String _winCountMess = "Enter Wins count";
    static public final String _limTempMess = "Enter Limit Temperature";
    static public final String _goalkeepMess = "Enter Goalkeeper's form";
    static public final String _socksMess = "Enter 'true' if socks allowed"
            + "and 'false' if not";
    static public final String _teamTypeMess = "Enter Team Type";
    static public final String _positionsMess = "Enter Positions";
    static public final String _extraArmorMess = "Is Extra Armor needed? "
            + "(true/false)";
    static public final String _gameSchemeMess = "Enter Game Scheme";
    static public final String _shieldsMess = "Are Shields needed?"
            + " (true/false)";
    static public final String _mascotMess = "Enter Mascot";
    static public final String _welcomeMess = "Enter team type(1/2/3)";
    static public final String _errorMess = "ERROR";
    static public final String _typeMess = ""
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
        String select = getEditSelection(userSelection, team);
    }
    
    public static void getDefMess(String mess, FootballTeam team, String type){
        System.out.println(mess);
        boolean verification = selDefVer(mess, scanInput(), team, type);
        while (!verification){
            System.out.println(_errorMess);
            System.out.println(mess);
            verification = selDefVer(mess, scanInput(), team);
        }
    }
    
    public static void getDefMess(String mess, FootballTeam team){
        System.out.println(mess);
        boolean verification = selDefVer(mess, scanInput(), team);
        while (!verification){
            System.out.println(_errorMess);
            System.out.println(mess);
            verification = selDefVer(mess, scanInput(), team);
        }
    }
    
    public static boolean selDefVer(String mess, String userInput, FootballTeam team, 
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
    
    public static boolean selDefVer(String mess, String userInput, FootballTeam team){
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
    
    public String getEditSelection(String type, FootballTeam team){
        System.out.println("Выберете поле для изменения:");
        String select = new String();
        while(true){
            switch(type){
                case "1":
                    ((BeachFootball)team).getInfo();
                    break;
                case "2":
                    ((AmericanFootball)team).getInfo();
                    break;
                case "3":
                    ((EuropeanFootball)team).getInfo();
                    break;
                default:
                    break;
            }
            select = scanInput();
            if(Pattern.matches("^([1-7])$", select)){
                break;
            }
            System.out.println("Select from 1 to 7");
        }
        return select;
    }
    
    /**
     * Получение ввода пользователя
     * @return введённую строчку
     */
    public static String scanInput(){
        String inputUser = _sc.nextLine();
        return inputUser;
    }
    
}
