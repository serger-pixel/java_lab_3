package main.java.com.mycompany.java_lab_3.Classes;
import java.util.regex.Pattern;

/**
 * 
 */
public class EuropeanFootball extends FootballTeam{
    /**
     * Регулярное выражение для проверки игровой схемы
     */
    static final String _regScheme = "^([0-9]-){2}([0-9])$";
    
    /**
     * Схема игры
     */
    private String _gameScheme;
    
    /**
     * Наличие щитков
     */
    private boolean _shields;
    
    /**
     * Имя маскота
     */
    private String _mascot;

    /**
     * Конструктор по умолчанию
     */
    public EuropeanFootball() {
        super();
        _gameScheme = _defaultValueString;
        _shields = _defaultValueBoolean;
        _mascot = _defaultValueString;
    }
    
    /**
     * Конструктор с параметрами
     * @param name - имя команды
     * @param players - кол-во игроков
     * @param gamesCount - кол-во сыгранных игр
     * @param winCount - кол-во побед
     * @param gameScheme - схема игры
     * @param shields - наличие щитков
     * @param mascot - имя маскота
     */
    public EuropeanFootball(String name, int players, int gamesCount, 
            int winCount, String gameScheme, boolean shields, String mascot){
        super(name, players, gamesCount, winCount);
        _gameScheme = gameScheme;
        _shields = shields;
        _mascot = mascot;
    }
    
    /**
     * Переопределённый метод получения информации о команде
     * @return информация о команде Европейского футбола
     */
    @Override
    public String getInfo(){
        return createString() + "\n"+
                "5. Game Scheme: " + _gameScheme + "\n"+
                "6. Knees Shields: " + _shields + "\n" +
                "7. Mascot:" + _mascot;
    }
    
    /**
     * Получение схемы игры
     * @return схема игры
     */
    public String getGameScheme(){
        return _gameScheme;
    }
    
    /**
     * Получение информации о наличии щитков
     * @return информация о наличии щитков
     */
    public boolean getShields(){
        return _shields;
    }
    
    /**
     * Получение имени маскота
     * @return имя маскота
     */
    public String getMascot(){
        return _mascot;
    }
    
    /**
     * Проверка схемы игры
     * @param value - схема игры
     * @return true/false, в зависимости от соответствия схемы шаблону
     */
    public boolean schemeVer(String value){
        return Pattern.matches(_regScheme, value);
    }
    
    /**
     * Установка схемы игры
     * @param value - схема игры
     * @return true/false в зависимости от того, прошла ли установка успешно
     */
    public boolean setGameScheme(String value){
        if (schemeVer(value)){
            _gameScheme = value;
            return true;
        }
        return false;
    }
    
    /**
     * Установка информации о наличии щитков
     * @param value - информация о наличии щитков
     * @return true/false в зависимости от того, прошла ли установка успешно
     */
    public boolean setShields(String value){
        if (boolVer(value)){
            _shields = stringToBool(value);
            return true;
        }
        return false;
    }
    
    /**
     * Установка имени маскота
     * @param value - имя маскота
     * @return true/false в зависимости от того, прошла ли установка успешно
     */
    public boolean setMascot(String value){
        if (stringVer(value)){
            _mascot = value;
            return true;
        }
        return false;
    }    
}
