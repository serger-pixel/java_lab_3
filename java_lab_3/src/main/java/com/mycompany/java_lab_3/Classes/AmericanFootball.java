package main.java.com.mycompany.java_lab_3.Classes;
import java.util.regex.Pattern;

/**
 * Класс Американской футбольной команды. Наследуется от класса
 * Футбольной команды
 */
public class AmericanFootball extends FootballTeam{
    
    /**
     * Тип команды (атака/защита)
     */
    private String _teamType;
    
    /**
     * Позиции команды
     */
    private String _positions;
    
    /**
     * Наличие дополнительной защиты
     */
    private boolean _extraArmor;
    
    /**
     * Регулярное выражения для проверки _extraArmor
     */
    static final String _regTeamType = "^(attack|protection)$";

    /**
     * Конструктор по умолчанию
     */
    public AmericanFootball() {
        super();
        _teamType = _defaultValueString;
        _extraArmor = _defaultValueBoolean;
        _positions = _defaultValueString;
    }
    
    /**
     * Конструктор с параметрами
     * @param name - имя команды
     * @param players - кол-во игроков
     * @param gamesCount - кол-во сыгранных игр
     * @param winCount - кол-во побед
     * @param teamType - тип команды (атака/защита)
     * @param positions - позиции команды
     * @param extraArmor - наличие дополнительной защиты
     */
    public AmericanFootball(String name, 
            int players, int gamesCount, int winCount, String teamType,
            String positions, boolean extraArmor){
        super(name, players, gamesCount, winCount);
        _teamType = teamType;
        _positions = positions;
        _extraArmor = extraArmor;
    }
    
    /**
     * Переопределённый метод получения информации о команде
     * @return информация о команде Американского футбола
     */
    @Override
    public String getInfo(){
        return createString() + "\n"+
                "5. Extra armor: " + _extraArmor + "\n"+
                "6. Team type (attack/protection): " + _teamType + "\n" +
                "7. Positions:" + _positions;
    }
    
    /**
     * Получение типа команды (атака/защита)
     * @return тип команды (атака/защита)
     */
    public String getTeamType(){
        return _teamType;
    }
    
    /**
     * Получение позиций команды
     * @return позиции команды
     */
    public String getPositions(){
        return _positions;
    }
    
    /**
     * Получение информации о наличии дополнительной защиты
     * @return информации о наличии дополнительной защиты (true/false)
     */
    public boolean getExtraArmor(){
        return _extraArmor;
    }
    
    /**
     * Проверка корректности типа команды
     * @param value - тип команды
     * @return true/false в зависимости от соответствия value типам attack или
     * defence
     */
    private boolean teamTypeVer(String value){
        return Pattern.matches(_regTeamType, value);
    }
    
    /**
     * Установка типа команды
     * @param value - тип команды
     * @return true/false в зависимости от того, прошла ли установка успешно
     */
    public boolean setTeamType(String value){
        if (teamTypeVer(value)){
            _teamType = value;
            return true;
        }
        return false;
    }
    
    /**
     * Установка позиций команды
     * @param value - позиции команды
     * @return true/false в зависимости от того, прошла ли установка успешно
     */
    public boolean setPositions(String value){
        if(stringVer(value)){
            _positions = value;
            return true;
        }
        return false;
    }
    
    /**
     * Установка информации о дополнительной защите
     * @param value - boolean - информация о доп. защите 
     * @return true/false в зависимости от того, прошла ли установка успешно
     */
    public boolean setExtraArmor(String value){
        if (boolVer(value)){
            _extraArmor = stringToBool(value);
            return true;
        }
        return false;
    }
}
