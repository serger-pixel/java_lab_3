package com.mycompany.java_lab_3.Classes;
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
    static private final String _welcomeMess = "Enter team type";
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
        System.out.println(_typeMess);
        char userSelection = scanInput().charAt(0);
        System.out.println(_nameMess);
        String userSelName = scanInput();
        System.out.println(_gamesCountMess);
        String userSelGamCnt = scanInput();
        System.out.println(_playersCountMess);
        String userSelPlaCnt = scanInput();
        System.out.println(_winCountMess);
        String userSelWinCnt = scanInput();
        TeamList teams = new TeamList(userSelection);
        switch (userSelection){
            case '1':
                System.out.println(_limTempMess);
                String userSelTem = scanInput();
                System.out.println(_goalkeepMess);
                String userSelGks = scanInput();
                System.out.println(_playersCountMess);
                String userSelSocAl = scanInput();
                
                break;
        
        }
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
