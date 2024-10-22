package main.java.com.mycompany.java_lab_3.Classes;
import java.util.regex.Pattern;

/**
 * Класс команды по пляжному футболу. Является наследником класса футбольной
 * команды
 */
public class BeachFootball extends FootballTeam{
    
    /**
     * Максимальная температура поля
     */
    private int _limitTemperature;
    
    /**
     * Форма вратаря
     */
    private String _goalkeeperForm;
    
    /**
     * Информация об использовании носков
     */
    private boolean _socksAllowed;
    
    /**
     * Регулярное выражение для проверки формы вратаря
     */
    static final String _regGoalkeeperForm = "^(shorts|pants)${1}";
    
    /**
     * Регулярное выражение для проверки максимальной температуры поля 
     */
    static final String _regLimitTemperature = "^[2-4][0-9]${2}";
    
    /**
     * Конструктор по умолчанию
     */
    public BeachFootball() {
        super();
        _limitTemperature = _defaultValueInt;
        _goalkeeperForm = _defaultValueString;
        _socksAllowed = _defaultValueBoolean;
    }
    
    /**
     * Конструктор с параметрами
     * @param name - имя команды
     * @param players - кол-во игроков
     * @param gamesCount - кол-во сыгранных игр
     * @param winCount - кол-во побед
     * @param limitTemperature - максимальная температура поля
     * @param goalkeeperForm - форма вратаря
     * @param socksAllowed - наличие носков
     */
    public BeachFootball(String name, int players, int gamesCount, int winCount,
            int limitTemperature, String goalkeeperForm, boolean socksAllowed) {
        super(name, players, gamesCount, winCount);
        _limitTemperature = limitTemperature;
        _goalkeeperForm = goalkeeperForm;
        _socksAllowed = socksAllowed;
    }
    
    /**
     * Переопределённый метод получения информации о команде
     * @return информация о команде Пляжного футбола
     */
    @Override
    public String getInfo(){
        return createString() + "\n"+
                "5. Goalkeeper's uniform: " + _goalkeeperForm + "\n"+
                "6. Max field temperature: " + _limitTemperature + "\n" +
                "7. Socks allowed " + _socksAllowed;
    }
    
    /**
     * Получение максимальной температуры поля
     * @return максимальная температура поля
     */
    public int getLimitTemperature(){
        return _limitTemperature;
    }
    
    /**
     * Получение формы вратаря
     * @return форма вратаря
     */
    public String getGoalkeeperForm(){
        return _goalkeeperForm;
    }
    
    /**
     * Получение информации о наличии носков
     * @return информация о наличии носков (true/false)
     */
    public boolean getSocksAllowed(){
        return _socksAllowed;
    }
    
    /**
     * Проверка максимальной температуры поля
     * @param value - максимальная температура поля
     * @return true/false в зависимости от того, прошло ли value проверку
     */
    private boolean limitTemperatureVer(String value){
        return Pattern.matches(_regLimitTemperature, value);
    }
    
    /**
     * Проверка формы вратаря
     * @param value - форма вратаря
     * @return true/false в зависимости от того, соответствует ли value 
     * shorts или pants
     */
    private boolean goalkeeperVer(String value){
        return Pattern.matches(_regGoalkeeperForm, value);
    }
    
    /**
     * Установка максимальной температуры поля
     * @param value - максимальная температура поля
     * @return true/false в зависимости от того, прошла ли установка успешно
     */
    public boolean setLimitTemperature(String value){
        if (limitTemperatureVer(value)){
            _limitTemperature = Integer.parseInt(value);
            return true;
        }
        return false;
    }
    
    /**
     * Установка информации о наличии носков 
     * @param value - информация о наличии носков
     * @return true/false в зависимости от того, прошла ли установка успешно
     */
    public boolean setSocksAllowed(String value){
        if (boolVer(value)){
            _socksAllowed = stringToBool(value);
            return true;
        }
        return false;
    }
    
    /**
     * Установка формы вратаря
     * @param value - форма вратаря
     * @return true/false в зависимости от того, прошла ли установка успешно
     */
    public boolean setGoalkeeperForm(String value){
        if (goalkeeperVer(value)){
            _goalkeeperForm = value;
            return true;
        }
        return false;
    }
}
