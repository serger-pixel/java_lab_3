package main.java.com.mycompany.java_lab_3.Classes;
import java.util.regex.Pattern;

public abstract class FootballTeam {
    /**
     * Название команды
     */
    protected String _name;
    /**
     * Кол-во игроков
     */
    protected int _players;
    /**
     * Кол-во игр
     */
    protected int _gamesCount;
    /**
     * Кол-во выигранных игр
     */
    protected int _winCount;
    /**
     * Значение поля-строчки по умолчанию
     */
    static final String _defaultValueString = "None";
    /**
     * Значение поля-числа по умолчанию
     */
    static final int _defaultValueInt = 0;
    
    /**
     * Значение поля-бул по умолчанию
     */
    static final boolean _defaultValueBoolean = false;
    
    static final protected String _regString = "^[A-Z]+[a-z]*";
    
    static final protected String _regInt = "^[1-9][0-9]*";
    
    static final protected String _regBool = "(true|false){1}";
    
    static final protected int _maxPlayers = 10;
    

    /**
     * Конструктор по умолчанию
     */
    public FootballTeam() {
        _name = _defaultValueString;
        _players = _defaultValueInt;
        _gamesCount = _defaultValueInt;
        _winCount = _defaultValueInt;
    }

    /**
     * Конструктор с параментрами
     * @param name-имя команды
     * @param players - кол-во игроков
     * @param gamesCount - кол-во сыгранных игр
     * @param winCount - кол-во выигранных игр
     */
    public FootballTeam(String name, int players, int gamesCount, int winCount) {
        _name = name;
        _players = players;
        _gamesCount = gamesCount;
        _winCount = winCount;
    }
    
    public int getGamesCount(){
        return _gamesCount;
    }
    
    public String getName(){
        return _name;
    }
    
    public int getWinCount(){
        return _winCount;
    }
    
    public int getPlayers(){
        return _players;
    }
    
    public static boolean stringVer(String value){
        return Pattern.matches(_regString, value);
    }
    
    public static boolean boolVer(String value){
        return Pattern.matches(_regBool, value);
    }
    
    public static boolean intVer(String value){
        return Pattern.matches(_regInt, value);
    }
    
    public static boolean stringToBool(String value){
        if (value == "true"){
               return true;
        }
        return false;
    }
    
    public boolean setGamesCount(String value){
        if (intVer(value)){
            _gamesCount = Integer.parseInt(value);
            return true;
        }
        return false;
    }
    
    public boolean setName(String value){
        if (stringVer(value)){
            _name = value;
            return true;
        }
        return false;
    }
    
    public boolean setWinCount(String value){
        if (intVer(value) && Integer.parseInt(value) <= _gamesCount){
            _winCount = Integer.parseInt(value);
            return true;
        }
        return false;
    }
    
    public boolean setPlayers(String value){
        if (intVer(value) && Integer.parseInt(value) <= _maxPlayers){
            _players = Integer.parseInt(value);
            return true;
        }
        return false;
    }
    
    protected String createString(){
        return "Information about team:\n " + "1. Название команды:" + _name + "\n"+ 
                "2. Кол-во игр: " + _gamesCount + "\n"+
                "3. Кол-во игроков: " + _players + "\n"+
                "4. Кол-во выигранных игр: " + _winCount;
    }
    
    public String getInfo(){
        return createString();
    }
    
}
