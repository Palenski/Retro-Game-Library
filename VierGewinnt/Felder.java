package VierGewinnt;


public class Felder {     //Hier befinden sich die einzelnen Felder als Objekte

    private char feldPosition;      //Zu jedem gibt es im folgenden Set und Get Methoden um aus dem Hauptspiel darauf zuzugreifen
    private int reihePosition;
    private int status;

    public Felder() {
        feldPosition = ' ';
        reihePosition = 0;
        status = 0;
    }

    public Felder(char neueFeldPosition, int neueReihePosition) {
        feldPosition = neueFeldPosition;
        reihePosition = neueReihePosition;
    }

    public void setFeldPosition(char neueFeldPosition) {     
        feldPosition = neueFeldPosition;
    }

    public void setReihePosition(int neueReihePosition) {
        reihePosition = neueReihePosition;
    }

    public void setAllePosition(char neueFeldPosition, int neueReihePosition) {
        feldPosition = neueFeldPosition;
        reihePosition = neueReihePosition;
    }

    public void setFeldStatus(int neuerStatus) {
        status = neuerStatus;
    }

    public int getFeldStatus() {
        return status;
    }

    public char getFeldPosition() {
        return feldPosition;
    }

    public int getReihePosition() {
        return reihePosition;
    }
}
