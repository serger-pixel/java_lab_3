package main.java.com.mycompany.java_lab_3.Classes;
import java.util.regex.Pattern;


public class EuropeanFootball extends FootballTeam{
    static final String _regScheme = "^([0-9]-){2}([0-9])$";
    private String _gameScheme;
    private boolean _shields;
    private String _mascot;

    public EuropeanFootball() {
        super();
        _gameScheme = _defaultValueString;
        _shields = _defaultValueBoolean;
        _mascot = _defaultValueString;
    }
    
    public EuropeanFootball(String name, int players, int gamesCount, 
            int winCount, String gameScheme, boolean shields, String mascot){
        super(name, players, gamesCount, winCount);
        _gameScheme = gameScheme;
        _shields = shields;
        _mascot = mascot;
    }
    
    @Override
    public String getInfo(){
        return createString() + "\n"+
                "5. Схема игры: " + _gameScheme + "\n"+
                "6. Наличие щитков на коленях: " + _shields + "\n" +
                "7. Маскот:" + _mascot;
    }
    
    public String getGameScheme(){
        return _gameScheme;
    }
    
    public boolean getShields(){
        return _shields;
    }
    
    public String getMascot(){
        return _mascot;
    }
    
    public boolean schemeVer(String value){
        return Pattern.matches(_regScheme, value);
    }
    
    public boolean setGameScheme(String value){
        if (schemeVer(value)){
            _gameScheme = value;
            return true;
        }
        return false;
    }
    
    public boolean setShields(String value){
        if (boolVer(value)){
            _shields = stringToBool(value);
            return true;
        }
        return false;
    }
    
    public boolean setMascot(String value){
        if (stringVer(value)){
            _mascot = value;
            return true;
        }
        return false;
    }    
}
