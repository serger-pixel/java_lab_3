package main.java.com.mycompany.java_lab_3.Classes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Pattern;

public class League {

	private String _name;
	private ArrayList<FootballTeam> _teams;
	private String _division;
        private String _country;
	private int _year;
        static final String _regYear = "^(19|20)\\d{2}$";
        static enum selections {
            american,
            beach,
            european; 
        };
        
	public League(String name, ArrayList<FootballTeam> teams, 
                String division, int year, String country) {
            _name = name;
            _teams = teams;
            _division = division;
            _country = country;
            _year = year;
            
	}

	public League() {
            _name = FootballTeam._defaultValueString;
            _division = FootballTeam._defaultValueString;
            _country = FootballTeam._defaultValueString;
            _year = FootballTeam._defaultValueInt;
	}

	public FootballTeam findTheBest() {
            FootballTeam team = _teams.get(0);
            int theBestCount = team.getWinCount();
            for (int i = 1; i< _teams.size(); i++){
                if (_teams.get(i).getWinCount() > theBestCount){
                    team = _teams.get(i);
                }
            }
            return team;
	}

	public ArrayList<FootballTeam> findAboveAverege() {
            int averageWins = FootballTeam._defaultValueInt;
            int cntTeam = _teams.size();
            for (int i = 0; i< _teams.size(); i++){
                averageWins += _teams.get(i).getGamesCount();
            }
            int aboveAverage = averageWins/cntTeam;
            ArrayList<FootballTeam> aboveAverageTeam = new ArrayList<>();
            for (int i = 0; i< _teams.size(); i++){
                if (_teams.get(i).getWinCount() > aboveAverage){
                    aboveAverageTeam.add(_teams.get(i));
                }
            }
            return aboveAverageTeam;
	}

	public void sortTeams() {
            Collections.sort(_teams, 
                    (team1, team2)-> Integer.compare(team1.getWinCount(), 
                            team2.getWinCount()));
	}

	
	public FootballTeam findTeam(String name) {
            for (int i = 0; i < _teams.size(); i++){
                if (_teams.get(i).getName() == name){
                    return _teams.get(i);
                }
            }
            return null;
	}

	public String getName() {
            return _name;
	}

	public ArrayList<FootballTeam> getTeams() {
            return _teams;
	}

	public String getDivision() {
            return _division;
	}

	public int getYear() {
            return _year;
	}
        
        public String getCountry(){
            return _country;
        }
        
        public boolean nameVer(String value){
            return Pattern.matches(FootballTeam._regName, value);
        }
        
        public boolean countryVer(String value){
            return Pattern.matches(FootballTeam._regName, value);
        }
        
        public boolean yearVer(String value){
            return Pattern.matches(_regYear, value);
        }
        
        public boolean divisonVer(String value){
            return Pattern.matches(FootballTeam._regName, value);
        }
        
	public boolean setName(String name) {
            if (nameVer(name)){
                _name = name;
                return true;
            }
            return false;
	}

	public boolean setDivision(String value) {
		if (divisonVer(value)){
                    _division = value;
                    return true;
                }
            return false;
        }

	public boolean setYear(String value) {
		if (yearVer(value)){
                    _year = Integer.parseInt(value);
                    return true;
                }
                return false;       
	}

	public boolean editTeam(String name, int type, int select, String value) {
            FootballTeam team = findTeam(name);
            if (team == null){
                return false;
            }
            switch(select){
                case 1:
                    if(team.nameVer(value)){
                        team.setName(value);
                    }
                case 2:
                    
                case 3:
                    
                case 4:
                    
                default:
                    break;
            }
            switch(type){
                case (1):
                    team = (AmericanFootball)team;
                    break;
                case (2):
                    team = (BeachFootball)team;
                    break;
                case (3):
                   team = (EuropeanFootball)team;
                   break;
               default:
                   break;
            }
            team.getInfo();
            
            return true;
	}

}