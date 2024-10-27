package main.java.com.mycompany.java_lab_3.Classes;
import java.util.regex.Pattern;
import java.util.Scanner;

/**
 * класс интерфейса
 */
public class UI {
    /**
     *  Сообщение для пользователя
     */
    private String _message; 
    /*
     *  Объект сканера
     */
    public Scanner _sc; 
    /**
     * Соощение для ввода имени лиги
     */
    static public final String _nameMess = "Enter Name";
    /**
     * Уведомление о сортировке
     */
    static public final String _sortMess = "Teams are sorted";
    /**
     * Уведомление о лучшей команды
     */
    static public final String _findTheBestMess = "The best team";
    /**
     * Соощение для ввода имени команды
     */
    static public final String _nameTeamMess = "Enter team name";
    /**
     * Уведомления для вывода команд
     */
    static public final String _findAverageMess = "Teams: ";
    /**
     * Суведомление о не нахождении имени
     */
    static public final String _nameTeamError ="This name is not found";
    /**
     * Соощение для ввода количества игр команды
     */
    static public final String _gamesCountMess = "Enter Games count";
    /**
     * Соощение для ввода количества игроков в команде
     */
    static public final String _playersCountMess = "Enter Players count";
    /**
     * Соощение для ввода количества выигранных игр в команде
     */
    static public final String _winCountMess = "Enter Wins count";
    /**
     * Соощение для ввода предельной температуры пляжного футбола
     */
    static public final String _limTempMess = "Enter Limit Temperature";
    /**
     * Соощение для ввода формы вратаря пляжного футбола
     */
    static public final String _goalkeepMess = "Enter Goalkeeper's form";
    /**
     * Соощение для ввода информации о наличии носков пляжного футбола
     */
    static public final String _socksMess = "Enter 'true' if socks allowed"
            + "and 'false' if not";
    /**
     * Соощение для ввода типа команды амерекансого футбола
     */
    static public final String _teamTypeMess = "Enter Team Type";
    /**
     * Соощение для ввода позиции команды амерекансого футбола
     */
    static public final String _positionsMess = "Enter Positions";
    /**
     * Соощение для ввода информации о наличии доп защиты команды амерекансого футбола
     */
    static public final String _extraArmorMess = "Is Extra Armor needed? "
            + "(true/false)";
    /**
     * Соощение для ввода схемы команды европейского футбола
     */
    static public final String _gameSchemeMess = "Enter Game Scheme";
    /**
     * Соощение для ввода информации о наличии щитков команды европейского футбола
     */
    static public final String _shieldsMess = "Are Shields needed?"
            + " (true/false)";
    /**
     * Соощение для ввода маскота команды европейского футбола
     */
    static public final String _mascotMess = "Enter Mascot";
    /**
     * Начальное сообщение
     */
    static public final String _welcomeMess = "Enter team type(1/2/3)";
    /**
     *   Сообщение об ошибке
     */
    static public final String _errorMess = "ERROR";
    /**
     * Типы команд
     */
    static public final String _typeMess = "1. Beach football" + "\n"
            + "2. American football" + "\n"
            + "3. European football";
    /**
     * Сообщение, содержащее основные функции
     */
    static public final String _mainFunMess =
            "1. Find the best \n" +
            "2. Find teams that have win cnt > average win cnt \n" +
            "3. Edit team \n" +
            "4. Sort teams \n" +
            "0. Exit"; 
    
    /**
     * Конструктор по умолчанию 
     */
    public UI() {
        _sc = new Scanner(System.in);
    }
    
    /**
     * Запуск приложения
     */
    public void startApplication(){
        FootballTeam team = null;
        System.out.println(_welcomeMess);
        String userSelection = (getSelMess(_welcomeMess));
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
        System.out.println(_nameMess);
        getPropMess(_nameMess, team);
        System.out.println(_gamesCountMess);
        getPropMess(_gamesCountMess, team);
        System.out.println(_playersCountMess);
        getPropMess(_playersCountMess, team);
        System.out.println(_winCountMess);
        getPropMess(_winCountMess, team);
        TeamList teams = new TeamList(userSelection);
        switch (userSelection){
            case "1":
                System.out.println(_limTempMess);
                getPropMess(_limTempMess, (BeachFootball)team, userSelection);
                System.out.println(_goalkeepMess);
                getPropMess(_goalkeepMess, (BeachFootball)team, userSelection);
                System.out.println(_socksMess);
                getPropMess(_socksMess, (BeachFootball)team, userSelection);
                break;
            case "2": 
                System.out.println(_positionsMess);
                getPropMess(_positionsMess, (AmericanFootball)team, userSelection);
                System.out.println(_teamTypeMess);
                getPropMess(_teamTypeMess, (AmericanFootball)team, userSelection);
                System.out.println(_extraArmorMess);
                getPropMess(_extraArmorMess, (AmericanFootball)team, userSelection);
                break;
            case "3": 
                System.out.println(_mascotMess);
                getPropMess(_mascotMess, (EuropeanFootball)team, userSelection);
                System.out.println(_gameSchemeMess);
                getPropMess(_gameSchemeMess, (EuropeanFootball)team, userSelection);
                System.out.println(_shieldsMess);
                getPropMess(_shieldsMess, (EuropeanFootball)team, userSelection);
                break;
            default: 
                break;
        }
        teams.add(team);
        league.setTeams(teams);
        mainFunMess(league, userSelection);
        
    }
    
    /**
     * Проверка ввода поля
     * @param mess сообщение
     * @param team команда
     * @param type тип команды
     */
    public void getPropMess(String mess, FootballTeam team, String type){
        boolean verification = League.selPropVer(mess, scanInput(), team, type);
        while (!verification){
            System.out.println(_errorMess);
            System.out.println(mess);
            verification = League.selPropVer(mess, scanInput(), team, type);//1
        }
    }
    
    /**
     * роверка ввода поля
     * @param mess сообщение
     * @param team команда
     */
    public void getPropMess(String mess, FootballTeam team){
        boolean verification = League.selPropVer(mess, scanInput(), team);
        while (!verification){
            System.out.println(_errorMess);
            System.out.println(mess);
            verification = League.selPropVer(mess, scanInput(), team);
        }
    }
    
    /**
     * Проверка выбора типа команды
     * @param mess - сообщение
     * @return выбор пользователя
     */
    public String getSelMess(String mess){
        String userInput = scanInput();
        while(!League.selVer(userInput)){
            System.out.println(_errorMess);
            System.out.println(mess);
            userInput = scanInput();
        }
        return userInput;           
    }
    
        /**
     * Редактирование команды
     * @param team команда
     * @param type тип команды
     * @param select выбор пользователя для редактирования
     * @return
     */
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
                            getPropMess(_goalkeepMess, team, type);
                            break;
                        case "6":
                            getPropMess(_limTempMess, team, type);
                            break;
                        case "7":
                            getPropMess(_socksMess, team, type);
                        default:
                            break;
                    }
                    break;
                case "2":
                    switch(select){
                        case "5":
                            getPropMess(_extraArmorMess, team, type);
                            break;
                        case "6":
                            getPropMess(_teamTypeMess, team, type);
                            break;
                        case "7":
                            getPropMess(_positionsMess, team, type);
                            break;
                        default:
                            break;
                    }
                    break;
                case "3":
                   switch(select){
                       case "5":
                            getPropMess(_gameSchemeMess, team, type);
                            break;
                        case "6":
                            getPropMess(_shieldsMess, team, type);
                            break;
                        case "7":
                            getPropMess(_mascotMess, team, type);
                            break;
                        default:
                            break;
                    }
                   break;
               default:
                   break;
            }
    }
    
    /**
     * Возращает строчку-список отсортированных команд
     * @param league лига
     * @return список команд
     */
    private String sortTeamMess(League league){
        league.sortTeams();
        return league.getTeamListString();
    }
    
    /**
     * Возращает информацию о лучшей команде
     * @param league  лига
     * @param type  тип команды
     * @return информация о команде
     */
    private String findTheBestMess(League league, String type){
        String info = new String();
        FootballTeam team = league.findTheBest();
        switch(type){
            case "1":
                info = ((BeachFootball)team).getInfo();
                break;
            case "2":
                info = ((AmericanFootball)team).getInfo();
                break; 
            case "3":
                info = ((EuropeanFootball)team).getInfo();
                break;
            default:
                break;
        }
        return info;
        
    }
    
    /**
     * Поиск команд с кол-вом побед выше среднего значения
     * @param league лига
     * @return список-строчка команд
     */
    private String findAboveAvMess(League league){
        String info = new String();
        TeamList lst = league.findAboveAverege();
        for (int i = 0; i < lst.length(); i++){
            info+= lst.get(i).getName()+", ";
        }
        return info;
    }
    
    /**
     * Поиск команды по имени
     * @param league лига
     * @return команда
     */
    private FootballTeam getNameTeamMess(League league){
        String nameTeam = scanInput();
        while(league.findTeam(nameTeam) == null){
            System.out.println(_nameTeamError);
            System.out.println(_nameMess);
            nameTeam = scanInput();
        }
        return league.findTeam(nameTeam);
    }
    
    /**
     * Осуществление главных функций программы
     * @param league лига
     * @param userSelection тип команды
     */
    private void mainFunMess(League league, String userSelection){
        String userInput = new String();
        do{
            System.out.println(_mainFunMess); 
            userInput = scanInput();
            switch (userInput){
                case "1":
                    System.out.println(_findTheBestMess);
                    System.out.println(findTheBestMess(league, userSelection) + "\n");
                    break;
                case "2":
                    System.out.println(_findAverageMess);
                    System.out.println(findAboveAvMess(league));
                    break;
                case "3":
                    System.out.println(_nameMess);
                    FootballTeam localTeam = getNameTeamMess(league);
                    String localSel = getEditSelectionMess(userSelection, localTeam);
                    editTeamMess(localTeam, userSelection, localSel);
                    System.out.println(getInfoTeam(userSelection, localTeam) + "\n");
                    break;
                case "4":
                    System.out.println(_sortMess);
                    System.out.println(sortTeamMess(league));
                    break;
                default:
                    break;
                }
        }while(!"0".equals(userInput));        
    }
    
    /**
     * Создание строчки с информацией о команде
     * @param type тип команды
     * @param team команда
     * @return строчка с информацией
     */
    private String getInfoTeam(String type, FootballTeam team){
        String info = new String();
        switch(type){
                case "1":
                    info = (((BeachFootball)team).getInfo());
                    break;
                case "2":
                    info = (((AmericanFootball)team).getInfo());
                    break;
                case "3":
                    info = (((EuropeanFootball)team).getInfo());;
                    break;
                default:
                    break;
        }
        return info;
    }
    
    /**
     * Вывод сообщений для редактирования команды
     * @param type тип команды
     * @param team команда
     * @return выбор пользователя
     */
    private String getEditSelectionMess(String type, FootballTeam team){
        System.out.println("Select a field that you want to change:");
        System.out.println(getInfoTeam(type, team));
        String select = new String();
        select = scanInput();
        while(!Pattern.matches("^([1-7])$", select)){
            System.out.println(getInfoTeam(type, team));
            System.out.println("Select from 1 to 7");
            select = scanInput();
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
