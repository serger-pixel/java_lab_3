package main.java.com.mycompany.java_lab_3.Classes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Pattern;
import static main.java.com.mycompany.java_lab_3.Classes.UI._extraArmorMess;
import static main.java.com.mycompany.java_lab_3.Classes.UI._gameSchemeMess;
import static main.java.com.mycompany.java_lab_3.Classes.UI._gamesCountMess;
import static main.java.com.mycompany.java_lab_3.Classes.UI._goalkeepMess;
import static main.java.com.mycompany.java_lab_3.Classes.UI._limTempMess;
import static main.java.com.mycompany.java_lab_3.Classes.UI._mascotMess;
import static main.java.com.mycompany.java_lab_3.Classes.UI._nameMess;
import static main.java.com.mycompany.java_lab_3.Classes.UI._playersCountMess;
import static main.java.com.mycompany.java_lab_3.Classes.UI._positionsMess;
import static main.java.com.mycompany.java_lab_3.Classes.UI._shieldsMess;
import static main.java.com.mycompany.java_lab_3.Classes.UI._socksMess;
import static main.java.com.mycompany.java_lab_3.Classes.UI._teamTypeMess;
import static main.java.com.mycompany.java_lab_3.Classes.UI._winCountMess;

public class League {
        /**
         * Имя лиги
         */
	private String _name;
        /**
         * Список команд
         */
	private TeamList _teams;
        /**
         * Номер дивизиона
         */
	private String _division;
        /**
         * Название страны
         */
        private String _country;
        /**
         * Год проведения
         */
	private int _year;
        /**
         * Регулярное выражения для проверки года
         */
        static final String _regYear = "^(19|20)\\d{2}$";
        /**
         * Регулярное выражения для проверки выбора типа команды
         */
        static final String _regSel = "^(1|2|3)${1}";
        
        /**
         * Набор данных про лиги
         */
        public static String[][] _defaultLeagues = {
            {"SunnyLeague", "1", "Brasil", "2001"},
            {"RegbiLeague", "2", "America", "1990"},
            {"FootLeague", "3", "Germany", "1995"}
        };
        
        /**
         * 
         * @param name - имя лиги
         * @param teams - список команд
         * @param division - номер дивизиона 
         * @param year - год
         * @param country - страна
         */
	public League(String name, TeamList teams, 
                String division, int year, String country) {
            _name = name;
            _teams = teams;
            _division = division;
            _country = country;
            _year = year;
            
	}

        /**
         * Конструктор по умолчанию
         */
	public League() {
            _name = FootballTeam._defaultValueString;
            _division = FootballTeam._defaultValueString;
            _country = FootballTeam._defaultValueString;
            _year = FootballTeam._defaultValueInt;
	}

        /**
         * Поиск лучшей команды
         * @return команда
         */
	public FootballTeam findTheBest() {
            return _teams.findTheBest();
	}
        
        /**
         * Поиск команд лиги,у которых кол-во побед выше, чем среднее значение
         * @return команда
         */
	public TeamList findAboveAverege() {
            return _teams.findAboveAverege();
	}

        /**
         * Сортировка команд лиги
         */
	public void sortTeams() {
            _teams.sortTeams();
	}

        /**
         * Поиск команды из лиги
         * @param name - имя команды
         * @return команда
         */
	public FootballTeam findTeam(String name) {
            return _teams.findTeam(name);
	}

        /**
         * Возвращение имени лиги
         * @return имя лиги
         */
	public String getName() {
            return _name;
	}
        
        /**
         * Возвращение номера дивизиона
         * @return номер дивизиона
         */
	public String getDivision() {
            return _division;
	}

        /**
         * Возвращение года лиги
         * @return год
         */
	public int getYear() {
            return _year;
	}
        
        /**
         * Возвращение название страна
         * @return название страны
         */
        public String getCountry(){
            return _country;
        }
        
        /**
         * Проверка года
         * @param value - значение года
         * @return результат проверки
         */
        private boolean yearVer(String value){
            return Pattern.matches(_regYear, value);
        }
        
        /**
         * Проверка выбора типа команды
         * @param value - значение типа команды
         * @return результат проверки
         */
        public static boolean selVer(String value){
            return Pattern.matches(_regSel, value);
        }
        
        /**
         * Устанвка имени лиги
         * @param name - имя лиги
         * @return результат успешности установки
         */
	public boolean setName(String name) {
            if (FootballTeam.stringVer(name)){
                _name = name;
                return true;
            }
            return false;
	}

        /**
         * Устанвка номера дивизиона
         * @param value - номер дивизиона
         * @return результат успешности установки
         */
	public boolean setDivision(String value) {
		if (FootballTeam.intVer(value)){
                    _division = value;
                    return true;
                }
            return false;
        }
        
        /**
         * Установка года лиги
         * @param value - значение года
         * @return результат успешности установки
         */
	public boolean setYear(String value) {
		if (yearVer(value)){
                    _year = Integer.parseInt(value);
                    return true;
                }
                return false;       
	}
        
        /**
         * Установка названия страны
         * @param value - название страны
         * @return результат успешности установки
         */
        public boolean setCountry(String value){
            if(FootballTeam.stringVer(value)){
                _country = value;
                return true;
            }
            return false;
        }
        
        /**
         * Получение списка-строчки имен команд
         * @return список-строчку имен команд
         */
        public String getTeamListString(){
            String info = new String();
            int select = 1;
            for(int i = 0; i < _teams.length(); i++){
                FootballTeam locTeam = _teams.get(i);
                info += select +". "+ locTeam.getName() + "\n" ;
                select++;
            }
            return info;
        }
        
        /**
         * Установка команд лиги
         * @param tl - команда
         * @return результат успешности установки
         */
        public boolean setTeams(TeamList tl){
            if(tl != null){
                _teams = tl;
                return true;
            }
            return false;
        }
        
        /**
         * Установка полей по селектору выбора
         * @param mess - сообщение для ввода определенного поля
         * @param userInput - пользовательский ввод
         * @param team - команда
         * @param type - тип команды
         * @return успешность установки поля
         */
        public static boolean selPropVer(String mess, String userInput, FootballTeam team, 
            String type){
        boolean verification = FootballTeam._defaultValueBoolean;
        AmericanFootball amerTeam = null;
        BeachFootball beachTeam = null;
        EuropeanFootball europTeam = null;
        switch (type){
            case "2":
                amerTeam = (AmericanFootball)team;
                break;
            case "1":
                beachTeam = (BeachFootball)team;
                break;
            case "3":
                europTeam = (EuropeanFootball)team;
                break;
            default:
                break;
        }
        switch (mess){
            case _limTempMess:
                verification = beachTeam.setLimitTemperature(userInput);
                break;
            case _goalkeepMess:
                verification = beachTeam.setGoalkeeperForm(userInput);
                break;
            case _socksMess:
                verification = beachTeam.setSocksAllowed(userInput);
                break;
            case _teamTypeMess:
                verification = amerTeam.setTeamType(userInput);
                break;
            case _positionsMess:
                verification = amerTeam.setPositions(userInput);
                break;
            case _extraArmorMess:
                verification = amerTeam.setExtraArmor(userInput);
                break;
            case _gameSchemeMess:
                verification = europTeam.setGameScheme(userInput);
                break;
            case _mascotMess:
                verification = europTeam.setMascot(userInput);
                break;
            case _shieldsMess:
                verification = europTeam.setShields(userInput);
                break;
            default:
                break;
        }
        return verification;
    }
    
    /**
     * Установка полей по селектору выбора
     * @param mess - сообщение для ввода определенного поля
     * @param userInput - пользовательский ввод
     * @param team - команда
     * @return успешность установки поля
     */
    public static boolean selPropVer(String mess, String userInput, FootballTeam team){
        boolean verification = FootballTeam._defaultValueBoolean;
        switch (mess){
            case _nameMess:
                verification = team.setName(userInput);
                break;
            case _gamesCountMess:
                verification = team.setGamesCount(userInput);
                break;
            case _playersCountMess:
                verification = team.setPlayers(userInput);
                break;
            case _winCountMess:
                verification = team.setWinCount(userInput);
                break;
            default:
                break;
        }
        return verification;
    }
    
}