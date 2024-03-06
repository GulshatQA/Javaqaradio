package ru.netology.radio;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RadioTest {
    // тесты по работе конструкторов

    @Test
    public void testConstructor() {
        Radio radio = new Radio(20);

        Assertions.assertEquals(20, radio.getNumberOfRadio());
    }

    @Test
    public void testConstructor2() {
        Radio radio = new Radio();

        Assertions.assertEquals(10,radio.getNumberOfRadio());
    }

    // тесты по работе радиостанции

    @Test
    public void shouldGetCurrentStation() { // номер текущей радиостанции
        Radio radio = new Radio();
        radio.setCurrentStation(7);

        int expected = 7;
        int actual = radio.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSetDirectly() { // переключает при допустимых значениях
        Radio radio = new Radio();
        radio.setCurrentStation(4);

        radio.getCurrentStation();

        int expected = 4;
        int actual = radio.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSetDirectlyAboveMax() { // переключает на 0 при значении больше 9
        Radio radio = new Radio();
        radio.setCurrentStation(10);

        radio.getCurrentStation();

        int expected = 0;
        int actual = radio.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSetDirectlyBelowMin() { // переключает на 9 при значении меньше 0
        Radio radio = new Radio();
        radio.setCurrentStation(-1);

        radio.getCurrentStation();

        int expected = 9;
        int actual = radio.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSetNext() { // переключение на следующую радиостанцию
        Radio radio = new Radio();
        radio.setCurrentStation(2);

        radio.next();

        int expected = 3;
        int actual = radio.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSetPrevious() { // переключение на предыдущую радиостанцию
        Radio radio = new Radio();
        radio.setCurrentStation(8);

        radio.prev();

        int expected = 7;
        int actual = radio.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnZeroIfAboveMax() { // переключает на минимальное при нажатии next при максимальном значении
        Radio radio = new Radio();
        radio.setCurrentStation(9);

        radio.next();

        int expected = 0;
        int actual = radio.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnNineIfBelowMin() { // переключает на максимальное при нажатии prev при минимальном значении
        Radio radio = new Radio();
        radio.setCurrentStation(0);

        radio.prev();

        int expected = 9;
        int actual = radio.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    // тесты по работе с уровнем громкости

    @Test
    public void shouldGetCurrentVolume() { // текущий уровень громкости
        Radio radio = new Radio();
        radio.setCurrentVolume(34);

        int expected = 34;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldIncreaseVolume() { //прибавить громкость
        Radio radio = new Radio();
        radio.setCurrentVolume(66);

        radio.increaseVolume();

        int expected = 67;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldReduceVolume() { // убавить громкость
        Radio radio = new Radio();
        radio.setCurrentVolume(29);

        radio.reduceVolume();

        int expected = 28;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotSetAboveMax() { // громкость больше максимального значения
        Radio radio = new Radio();
        radio.setCurrentVolume(100);

        radio.increaseVolume();

        int expected = 100;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotSetBelowMin() { // громкость меньше минимального значения
        Radio radio = new Radio();
        radio.setCurrentVolume(0);

        radio.reduceVolume();

        int expected = 0;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }
}
