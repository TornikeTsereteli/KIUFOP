package AdventiunParty.adventuin;

public enum Language {
    English,
    German;

    public String getLocalizedChristmasGreeting (String greeterName){
        switch (this) {
            case English -> {
                return greeterName + "wishes you a Merry Christmas!";
            }
            case German -> {
                return "Fröhliche Weihnachten wünscht dir " + greeterName;
            }
            default -> {
                return "";
            }
        }
    }
}
