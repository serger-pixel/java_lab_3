package com.mycompany.java_lab_3.Classes;
import java.util.regex.Pattern;

public class EuropeanFootball extends FootballTeam{
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
                "Схема игры: " + _gameScheme + "\n"+
                "Наличие щитков на коленях: " + _shields + "\n" +
                "Маскот:" + _mascot;
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
    
    public boolean gameSchemeVer(String value){
        return Pattern.matches(_regName, value);
    }
    
    public boolean mascotVer(String value){
        return Pattern.matches(_regName, value);
    }
    
    public boolean setGameScheme(String value){
        if (gameSchemeVer(value)){
            _gameScheme = value;
            return true;
        }
        return false;
    }
    
    public boolean setShields(boolean value){
        _shields = value;
        return true;
    }
    
    public boolean setMascot(String value){
        if (mascotVer(value)){
            _mascot = value;
            return true;
        }
        return false;
    }    
}
