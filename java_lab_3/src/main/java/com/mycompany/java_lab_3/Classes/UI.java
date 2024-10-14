package main.java.com.mycompany.java_lab_3.Classes;
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
    /**
     * Сообщение для пользователя по умолчанию
     */
    static private final String _nameMess = "Enter Name";
    static private final String _gamesCountMess = "Enter Games count";
    static private final String _playersCuontMess = "Enter Players count";
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
