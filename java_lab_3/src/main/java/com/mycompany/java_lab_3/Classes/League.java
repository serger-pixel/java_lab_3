package main.java.com.mycompany.java_lab_3.Classes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Pattern;

public class League {

	private String _name;
	private TeamList _teams;
	private String _division;
        private String _country;
	private int _year;
        static final String _regYear = "^(19|20)\\d{2}$";
        static final String _regSel = "^(1|2|3)${1}";
        static enum selections {
            american,
            beach,
            european; 
        };
        public static String[][] _defaultLeagues = {
            {"SunnyLeague", "1", "Brasil", "2001"},
            {"RegbiLeague", "2", "America", "1990"},
            {"FootLeague", "3", "Germany", "1995"}
        };
        
	public League(String name, TeamList teams, 
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
            return _teams.findTheBest();
	}

	public ArrayList<FootballTeam> findAboveAverege() {
            return _teams.findAboveAverege();
	}

	public void sortTeams() {
            _teams.sortTeams();
	}

	
	public FootballTeam findTeam(String name) {
            return _teams.findTeam(name);
	}

	public String getName() {
            return _name;
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
        
        public boolean yearVer(String value){
            return Pattern.matches(_regYear, value);
        }
        
        public static boolean selVer(String value){
            return Pattern.matches(_regSel, value);
        }
        
	public boolean setName(String name) {
            if (FootballTeam.stringVer(name)){
                _name = name;
                return true;
            }
            return false;
	}

	public boolean setDivision(String value) {
		if (FootballTeam.stringVer(value)){
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
        
        public boolean setCountry(String value){
            if(FootballTeam.stringVer(value)){
                _country = value;
                return true;
            }
            return false;
        }

	public boolean editTeam(String name, String type, String select, String value) {
            FootballTeam team = findTeam(name);
            if (team == null){
                return false;
            }
            switch(select){
                case "1":
                    if(team.nameVer(value)){ //!!!!!
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
        
        public String getTeamList(){
            String info = new String();
            int select = 1;
            for(int i = 0; i < _teams.length(); i++){
                FootballTeam locTeam = _teams.get(i);
                info += select +". "+ locTeam.getName() + "\n" ;
                select++;
            }
            return info;
        }
        
        public boolean setTeams(TeamList tl){
            if(tl != null){
                _teams = tl;
                return true;
            }
            return false;
        }

}