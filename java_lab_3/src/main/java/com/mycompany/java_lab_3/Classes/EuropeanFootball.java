package main.java.com.mycompany.java_lab_3.Classes;
import java.util.regex.Pattern;

public class EuropeanFootball extends FootballTeam{
    private String _gameScheme;
    private boolean _shields;
    private String _mascot;
    static final protected int _maxPlayers = 11;

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
        
    public boolean setGameScheme(String value){
        if (stringVer(value)){
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
