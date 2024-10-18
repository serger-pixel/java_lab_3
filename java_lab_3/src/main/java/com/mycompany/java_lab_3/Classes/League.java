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

	public boolean editTeam(String name, String type, String select) {
            FootballTeam team = findTeam(name);
            if (team == null){
                return false;
            }

            switch(select){
                case "1":
                    UI.getDefMess(UI._nameMess, team);
                    break;
                case "2":
                    UI.getDefMess(UI._gamesCountMess, team);
                    break;
                case "3":
                    UI.getDefMess(UI._playersCountMess, team);
                    break;
                case "4":
                    UI.getDefMess(UI._winCountMess, team);
                    break;
                default:
                    break;
            }
            switch(type){
                case "1":
                    switch(select){
                        case "5":
                            UI.getDefMess(UI._goalkeepMess, team);
                        case "6":
                            UI.getDefMess(UI._limTempMess, team);
                        case "7":
                            UI.getDefMess(UI._socksMess, team);
                        default:
                            break;
                    }
                    break;
                case "2":
                    switch(select){
                        case "5":
                            UI.getDefMess(UI._extraArmorMess, team);
                        case "6":
                            UI.getDefMess(UI._teamTypeMess, team);
                        case "7":
                            UI.getDefMess(UI._positionsMess, team);
                        default:
                            break;
                    }
                    break;
                case "3":
                   switch(select){
                       case "5":
                            UI.getDefMess(UI._gameSchemeMess, team);
                        case "6":
                            UI.getDefMess(UI._shieldsMess, team);
                        case "7":
                            UI.getDefMess(UI._mascotMess, team);
                        default:
                            break;
                    }
                   break;
               default:
                   break;
            }
            
            
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