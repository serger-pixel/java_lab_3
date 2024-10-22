package main.java.com.mycompany.java_lab_3.Classes;
import java.util.regex.Pattern;

/**
 * Класс Футбольной команды
 */
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
     * Кол-во сыгранных игр
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
    
    /**
     * Регулярное выражение для проверки строк
     */
    static final protected String _regString = "^[A-Z]+[a-z]*";
    
    /**
     * Регулярное выражение для проверки введённых целочисленных значений
     */
    static final protected String _regInt = "^[1-9][0-9]*";
    
    /**
     * Регулярное выражение для проверки введённых логических значений
     */
    static final protected String _regBool = "(true|false){1}";
    
    /**
     * Максимальное кол-во игроков в команде
     */
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
    
    /**
     * Получение кол-ва сыгранных игр
     * @return кол-во сыгранных игр
     */
    public int getGamesCount(){
        return _gamesCount;
    }
    
    /**
     * Получение названия команды
     * @return название команды
     */
    public String getName(){
        return _name;
    }
    
    /**
     * Получение ко-ва побед
     * @return кол-во побед
     */
    public int getWinCount(){
        return _winCount;
    }
    
    /**
     * Получение кол-ва игроков
     * @return кол-во игроков
     */
    public int getPlayers(){
        return _players;
    }
    
    /**
     * Проверка корректности введённой строки
     * @param value - строка
     * @return информация о корректности строки (true/false)
     */
    public static boolean stringVer(String value){
        return Pattern.matches(_regString, value);
    }
    
    /**
     * Проверка корректности введённого логического значения
     * @param value - логическое значение
     * @return true/false в зависимости от соответствия value "true" 
     * или "false"
     */
    public static boolean boolVer(String value){
        return Pattern.matches(_regBool, value);
    }
    
    /**
     * Проверка введённого целочисленного значения
     * @param value - целочисленное значение
     * @return информация о корректности введённого целочисленного значения
     */
    public static boolean intVer(String value){
        return Pattern.matches(_regInt, value);
    }
    
    /**
     * Перевод строки в логическое значение
     * @param value - строка
     * @return логическое значение
     */
    public static boolean stringToBool(String value){
        if (value == "true"){
               return true;
        }
        return false;
    }
    
    /**
     * Установка кол-ва игр
     * @param value - кол-во игр
     * @return true/false в зависимости от того, прошла ли установка успешно
     */
    public boolean setGamesCount(String value){
        if (intVer(value)){
            _gamesCount = Integer.parseInt(value);
            return true;
        }
        return false;
    }
    
    /**
     * Установка названия команды
     * @param value - название команды
     * @return true/false в зависимости от того, прошла ли установка успешно
     */
    public boolean setName(String value){
        if (stringVer(value)){
            _name = value;
            return true;
        }
        return false;
    }
    
    /**
     * Установка кол-ва побед
     * @param value - кол-во побед
     * @return true/false в зависимости от того, прошла ли установка успешно
     */
    public boolean setWinCount(String value){
        if (intVer(value) && Integer.parseInt(value) <= _gamesCount){
            _winCount = Integer.parseInt(value);
            return true;
        }
        return false;
    }
    
    /**
     * Установка кол-ва игроков
     * @param value - кол-во игроков
     * @return true/false в зависимости от того, прошла ли установка успешно
     */
    public boolean setPlayers(String value){
        if (intVer(value) && Integer.parseInt(value) <= _maxPlayers){
            _players = Integer.parseInt(value);
            return true;
        }
        return false;
    }
    
    /**
     * Создание строчки с инвормацией о команде
     * @return строчка с информацией о команде
     */
    protected String createString(){
        return "Information about team:\n " + "1. Name:" + _name + "\n"+ 
                "2. Games count: " + _gamesCount + "\n"+
                "3. Players count: " + _players + "\n"+
                "4. Win games count: " + _winCount;
    }
    
    /**
     * Получение информации о команде
     * @return информация о команде
     */
    public String getInfo(){
        return createString();
    }
    
}
