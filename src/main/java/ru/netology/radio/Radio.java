package ru.netology.radio;
public class Radio {

    private int currentStation;
    private int currentVolume;
    private int numberOfRadio;


    public Radio() {
        this.numberOfRadio = 10;
    }

    public Radio(int numberOfRadio) {
        this.numberOfRadio = numberOfRadio;
    }

    public int getCurrentStation() {
        return currentStation;
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public int getNumberOfRadio() {
        return numberOfRadio;
    }


    public void setCurrentStation(int newCurrentStation) {
        if (newCurrentStation > numberOfRadio -1) {
            newCurrentStation = 0;
        }
        if (newCurrentStation < 0) {
            newCurrentStation = numberOfRadio -1;
        }
        currentStation = newCurrentStation;
    }

    public void setCurrentVolume(int newCurrentVolume) {
        if (newCurrentVolume > 100) {
            return;
        }
        if (newCurrentVolume < 0) {
            return;
        }
        currentVolume = newCurrentVolume;
    }

    public void next() {
        int target = currentStation + 1;
        setCurrentStation(target);
    }

    public void prev() {
        int target = currentStation - 1;
        setCurrentStation(target);
    }

    public void increaseVolume() {
        int target = currentVolume + 1;
        setCurrentVolume(target);
    }

    public void reduceVolume() {
        int target = currentVolume - 1;
        setCurrentVolume(target);
    }
}
