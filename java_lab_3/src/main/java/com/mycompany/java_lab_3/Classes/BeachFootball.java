package main.java.com.mycompany.java_lab_3.Classes;
import java.util.regex.Pattern;

public class BeachFootball extends FootballTeam{
    
    private int _limitTemperature;
    private String _goalkeeperForm;
    private boolean _socksAllowed;
    static final String _regGoalkeeperForm = "^(shorts|pants)${1}";
    static final String _regLimitTemperature = "^[2-4][0-9]${2}";
    static final protected int _maxPlayers = 5;

    public BeachFootball() {
        super();
        _limitTemperature = _defaultValueInt;
        _goalkeeperForm = _defaultValueString;
        _socksAllowed = _defaultValueBoolean;
    }
    
    public BeachFootball(String name, int players, int gamesCount, int winCount,
            int limitTemperature, String goalkeeperForm, boolean socksAllowed) {
        super(name, players, gamesCount, winCount);
        _limitTemperature = limitTemperature;
        _goalkeeperForm = goalkeeperForm;
        _socksAllowed = socksAllowed;
    }
    
    @Override
    public String getInfo(){
        return createString() + "\n"+
                "5. Форма вратаря: " + _goalkeeperForm + "\n"+
                "6. Максимальная температура поля: " + _limitTemperature + "\n" +
                "7. Наличие носков: " + _socksAllowed;
    }
    
    public int getLimitTemperature(){
        return _limitTemperature;
    }
    
    public String getGoalkeeperForm(){
        return _goalkeeperForm;
    }
    
    public boolean getSocksAllowed(){
        return _socksAllowed;
    }
    
    public boolean limitTemperatureVer(String value){
        return Pattern.matches(_regLimitTemperature, value);
    }
    
    public boolean goalkeeperVer(String value){
        return Pattern.matches(_regGoalkeeperForm, value);
    }
    
    public boolean setLimitTemperature(String value){
        if (limitTemperatureVer(value)){
            _limitTemperature = Integer.parseInt(value);
            return true;
        }
        return false;
    }
    
    public boolean setSocksAllowed(boolean value){
        _socksAllowed = value;
        return true;
    }
    
    public boolean setGoalkeeperForm(String value){
        if (goalkeeperVer(value)){
            _goalkeeperForm = value;
            return true;
        }
        return false;
    }
}
