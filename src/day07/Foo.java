package day07;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by tjen on 07/12/16.
 */
public class Foo {
    private List<String> interiorCharactersList = new LinkedList<>();
    private List<String> hypernetSequenceList = new LinkedList<>();

    public Foo(String ipv7) {
        final String[] split = ipv7.split("[\\]\\[]");

        for (int i = 0; i < split.length; i++) {
            if(i%2==0)
                interiorCharactersList.add(split[i]);
            else
                hypernetSequenceList.add(split[i]);
        }
    }

    public boolean supportsTLS() {
        if (!interiorCharactersIsAbba()) {
            return false;
        }

        return !hypernetSequenceContainsAbba();
    }

    private boolean interiorCharactersIsAbba() {
        return interiorCharactersList.stream()
                .filter(interiorCharacters -> {
                    for (int i = 0; i < interiorCharacters.length() - 3; i++) {
                        if (isAbba(interiorCharacters.substring(i, i + 4)))
                            return true;
                    }
                    return false;
                }).count() >= 1;

    }

    private boolean hypernetSequenceContainsAbba() {
        return hypernetSequenceList.stream()
                .filter(hypernetSequence -> {
                    //isAbba(hypernetSequence)
                    for (int i = 0; i < hypernetSequence.length() - 3; i++) {
                        if (isAbba(hypernetSequence.substring(i, i + 4)))
                            return true;
                    }
                    return false;
                })
                .count() >= 1;
    }

    private boolean isAbba(String sequence) {
        if (areAllTheSameCharacters(sequence))
            return false;
        return new StringBuilder(sequence).reverse().toString().equals(sequence);
    }

    private boolean areAllTheSameCharacters(String sequence) {
        return sequence.toCharArray()[0] == sequence.toCharArray()[1];
    }
}
