package com.mycompany.java_lab_3.Classes;
import java.util.regex.Pattern;

public class AmericanFootball extends FootballTeam{
    
    private String _teamType;
    private String _positions;
    private boolean _extraArmor;
    static final String _regTeamType = "^(attack|protection)$";
    static final protected int _maxPlayers = 11;

    public AmericanFootball() {
        super();
        _teamType = _defaultValueString;
        _extraArmor = _defaultValueBoolean;
        _positions = _defaultValueString;
    }

    public AmericanFootball(String name, 
            int players, int gamesCount, int winCount, String teamType,
            String positions, boolean extraArmor){
        super(name, players, gamesCount, winCount);
        _teamType = teamType;
        _positions = positions;
        _extraArmor = extraArmor;
    }
    
    @Override
    public String getInfo(){
        return createString() + "\n"+
                "5. Наличие доп. защиты: " + _extraArmor + "\n"+
                "6. Тип команды: " + _teamType + "\n" +
                "7. Позиции:" + _positions;
    }
    
    public String getTeamType(){
        return _teamType;
    }
    
    public String getPositions(){
        return _positions;
    }
    
    public boolean getExtraArmor(){
        return _extraArmor;
    }
    
    public boolean teamTypeVer(String value){
        return Pattern.matches(_regTeamType, value);
    }
    
    public boolean setTeamType(String value){
        if (teamTypeVer(value)){
            _teamType = value;
            return true;
        }
        return false;
    }
    
    public boolean setPositions(String value){
        _positions = value;
        return true;
    }
    
    public boolean setExtraArmor(boolean value){
        _extraArmor = value;
        return true;
    }    
}
