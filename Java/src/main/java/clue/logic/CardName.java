package clue.logic;

import java.util.List;
import java.util.ArrayList;

public enum CardName {

    GREEN("Mr. Green"),
    MUSTARD("Col. Mustard"),
    PEACOCK("Mrs. Peacock"),
    SCARLET("Miss Scarlet"),
    PLUM("Prof. Plum"),
    WHITE("Mrs. White"),
    CANDLESTICK("Candlestick"),
    KNIFE("Knife"),
    PIPE("Lead Pipe"),
    REVOLVER("Revolver"),
    ROPE("Rope"),
    WRENCH("Wrench"),
    BALL("Ball Room"),
    BILLIARD("Billiard Room"),
    CONSERVATORY("Conservatory"),
    DINING("Dining Room"),
    HALL("Hall"),
    KITCHEN("Kitchen"),
    LIBRARY("Library"),
    LOUNGE("Lounge"),
    STUDY("Study"),
    INVALID("Invalid Name");

    private String _humanReadable;

    CardName(String readable) {
        _humanReadable = readable;
    }

    public static CardName getNameEnum(String str) {
        for(CardName name: CardName.values()) {
            if(name.toString().equals(str)) {
                return name;
            }
        }
        return INVALID;
    }

    public static List<CardName> getCharacterNames() {
        List<CardName> characterNames = new ArrayList<>();

        characterNames.add(WHITE);
        characterNames.add(GREEN);
        characterNames.add(PEACOCK);
        characterNames.add(PLUM);
        characterNames.add(WHITE);
        characterNames.add(MUSTARD);

        return characterNames;
    }
    public static List<CardName> getWeaponNames() {

        List<CardName> weaponNames = new ArrayList<>();
        weaponNames.add(CANDLESTICK);
        weaponNames.add(KNIFE);
        weaponNames.add(REVOLVER);
        weaponNames.add(ROPE);
        weaponNames.add(PIPE);
        weaponNames.add(WRENCH);

        return weaponNames;
    }
    public static List<CardName> getRoomNames() {

        List<CardName> roomNames = new ArrayList<>();
        roomNames.add(BALL);
        roomNames.add(BILLIARD);
        roomNames.add(CONSERVATORY);
        roomNames.add(DINING);
        roomNames.add(HALL);
        roomNames.add(KITCHEN);
        roomNames.add(LIBRARY);
        roomNames.add(LOUNGE);
        roomNames.add(STUDY);

        return roomNames;
    }

    public static boolean isCharacter(CardName aName) {
        List<CardName> names = getCharacterNames();
        for(CardName name: names) {
            if(name.toString().equals(aName)) {
                return true;
            }
        }
        return false;
    }
    public static boolean isWeapon(CardName aName) {

        List<CardName> names = getWeaponNames();

        for(CardName name: names) {
            if(name.toString().equals(aName)) {
                return true;
            }
        }
        return false;
    }
    public static boolean isRoom(CardName aName) {

        List<CardName> names = getRoomNames();
        for(CardName name: names) {
            if(name.toString().equals(aName)) {
                return true;
            }
        }
        return false;
    }

    public String stringify() {
        return _humanReadable;
    }
}