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
    public Scanner _sc; 
    static public final String _nameMess = "Enter Name";
    static public final String _sortMess = "Teams are sorted";
    static public final String _findTheBestMess = "The best team";
    static public final String _nameTeamMess = "Enter team name";
    static public final String _findAverageMess = "Teams: ";
    static public final String _nameTeamError ="This name is not found";
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
    static public final String _typeMess = "1. Beach football" + "\n"
            + "2. American football" + "\n"
            + "3. European football";
    static public final String _mainFunMess = "1. Find the best team \n" +
            "2. Sort teams \n" +
            "3. Find teams that have win cnt > average win cnt \n" +
            "4. Edit team \n" +
            "5. Sort teams \n" +
            "0. Exit"; 
    /**
     * Конструктор с параметром
     * @param message - сообщение для пользователя 
     */
    public UI() {
        _sc = new Scanner(System.in);
    }
    
    /**
     * Конструктор по умолчанию
     */
    
    /**
     * Запуск приложения
     */
    public void startApplication(){
        FootballTeam team = null;
        String userSelection = (getSelMess(_welcomeMess));
        userSelection.substring(0, 1);
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
        
        getPropMess(_nameMess, team);
        getPropMess(_gamesCountMess, team);
        getPropMess(_playersCountMess, team);
        getPropMess(_winCountMess, team);
        TeamList teams = new TeamList(userSelection);
        switch (userSelection){
            case "1":
                getPropMess(_limTempMess, (BeachFootball)team, userSelection);
                getPropMess(_goalkeepMess, (BeachFootball)team, userSelection);
                getPropMess(_socksMess, (BeachFootball)team, userSelection);
                break;
            case "2": 
                getPropMess(_positionsMess, (AmericanFootball)team, userSelection);
                getPropMess(_teamTypeMess, (AmericanFootball)team, userSelection);
                getPropMess(_extraArmorMess, (AmericanFootball)team, userSelection);
                break;
            case "3": 
                getPropMess(_mascotMess, (EuropeanFootball)team, userSelection);
                getPropMess(_gameSchemeMess, (EuropeanFootball)team, userSelection);
                getPropMess(_shieldsMess, (EuropeanFootball)team, userSelection);
                break;
            default: 
                break;
        }
        teams.add(team);
        league.setTeams(teams);
        mainFunMess(league, userSelection);
        
    }
    
    public void getPropMess(String mess, FootballTeam team, String type){
        System.out.println(mess);
        boolean verification = League.selPropVer(mess, scanInput(), team, type);
        while (!verification){
            System.out.println(_errorMess);
            System.out.println(mess);
            verification = League.selPropVer(mess, scanInput(), team);
        }
    }
    
    public void getPropMess(String mess, FootballTeam team){
        System.out.println(mess);
        boolean verification = League.selPropVer(mess, scanInput(), team);
        while (!verification){
            System.out.println(_errorMess);
            System.out.println(mess);
            verification = League.selPropVer(mess, scanInput(), team);
        }
    }
    
    public String getSelMess(String mess){
        System.out.println(mess);
        String userInput = scanInput();
        while(!League.selVer(userInput)){
            System.out.println(_errorMess);
            System.out.println(mess);
            userInput = scanInput();
        }
        return userInput;           
    }
    
    private void editTeamMess(FootballTeam team, String type, String select) {
            switch(select){
                case "1":
                    getPropMess(_nameMess, team);
                    break;
                case "2":
                    getPropMess(_gamesCountMess, team);
                    break;
                case "3":
                    getPropMess(_playersCountMess, team);
                    break;
                case "4":
                    getPropMess(_winCountMess, team);
                    break;
                default:
                    break;
            }
            switch(type){
                case "1":
                    switch(select){
                        case "5":
                            getPropMess(_goalkeepMess, team);
                        case "6":
                            getPropMess(_limTempMess, team);
                        case "7":
                            getPropMess(_socksMess, team);
                        default:
                            break;
                    }
                    break;
                case "2":
                    switch(select){
                        case "5":
                            getPropMess(_extraArmorMess, team);
                        case "6":
                            getPropMess(_teamTypeMess, team);
                        case "7":
                            getPropMess(_positionsMess, team);
                        default:
                            break;
                    }
                    break;
                case "3":
                   switch(select){
                       case "5":
                            getPropMess(_gameSchemeMess, team);
                        case "6":
                            getPropMess(_shieldsMess, team);
                        case "7":
                            getPropMess(_mascotMess, team);
                        default:
                            break;
                    }
                   break;
               default:
                   break;
            }
    }
    
    private String sortTeamMess(League league){
        System.out.println(_sortMess);
        league.sortTeams();
        return league.getTeamListString();
    }
    
    private void findTheBestMess(League league, String type){
        System.out.println(_findTheBestMess);
        FootballTeam team = league.findTheBest();
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
        
    }
    
    private void findAboveAvMess(League league){
        System.out.println(_findAverageMess);
        TeamList lst = league.findAboveAverege();
        for (int i = 0; i < lst.length(); i++){
            System.out.println(lst.get(i).getName() + "\n");
        }
    }
    private FootballTeam getNameTeamMess(League league){
        System.out.println(_nameTeamMess);
        String nameTeam = scanInput();
        while(league.findTeam(nameTeam) == null){
            System.out.println(_nameTeamError);
            System.out.println(_nameMess);
            nameTeam = scanInput();
        }
        return league.findTeam(nameTeam);
    }
    
    private void mainFunMess(League league, String userSelection){
        String userInput = new String();
        do{
            System.out.println(_mainFunMess); 
            userInput = scanInput();
            switch (userInput){
                case "1":
                    System.out.println(getNameTeamMess(league).getName());
                    break;
                case "2":
                    findTheBestMess(league, _typeMess);
                    break;
                case "3":
                    findAboveAvMess(league);
                    break;
                case "4":
                    FootballTeam localTeam = getNameTeamMess(league);
                    String localSel = getEditSelectionMess(userSelection, localTeam);
                    editTeamMess(localTeam, userSelection, localSel);
                    break;
                case "5": 
                    String info = sortTeamMess(league);
                    System.out.println(info);
                    break;
                default:
                    break;
                }
        }while(!"0".equals(userInput));        
    }
    
    private String getEditSelectionMess(String type, FootballTeam team){
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
    public String scanInput(){
        String inputUser = _sc.nextLine();
        return inputUser;
    }
    
}
