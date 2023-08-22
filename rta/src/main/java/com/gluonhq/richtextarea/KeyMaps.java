package com.gluonhq.richtextarea;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import static java.util.Map.entry;


public class KeyMaps {
    /*
    base board sets up with just a few alt-key assignments.  Then there are four combined boards:
        italic + sans
        script + sans
        italic + blackboard
        greek + fraktur
    In each case, the first board works without special keys (except shift for capitals).  The alternate boards
    combine with special characters:
        Alt: on non-alphanumeric keys
        Shift-Alt: on non-alphabetical keys
        Ctrl-Shift-Alt: on all character keys.
    The special characters are the same with each alternate board (and so remain active in the same way on any of
    the combined boards.
     */
    enum SetMaps {
        BASE,
        ITALIC_AND_SANS,
        SCRIPT_AND_SANS,
        ITALIC_AND_BLACKBOARD,
        GREEK_AND_FRAKTUR
    }
    private static KeyMaps singletonKeyMaps;

    private Map<KeyCombination, String> keyPressedCharMap;
    private Map<Character, String> keyTypedCharMap;
    private final Map<Character, String> BASE_MAP = Collections.emptyMap();
    private final Map<KeyCombination, String> BASE_ALT_MAP = initializeBaseAltMap();
    private final Map<Character, String> ITALIC_MAP = initializeItalicMap();
    private final Map<Character, String> SCRIPT_MAP = initializeScriptMap();
    private final Map<Character, String> GREEK_MAP = initializeGreekMap();
    private final Map<KeyCombination, String> SANS_MAP = initializeSansMap();
    private final Map<KeyCombination, String> BLACKBOARD_MAP = initializeBlackboardMap();
    private final Map<KeyCombination, String> FRAKTUR_MAP = initializeFrakturMap();
    private final Map<KeyCombination, String> SPECIAL_CHARACTER_MAP = initializeSpecialCharacterMap();
    private final Map<KeyCombination, String> SPECIAL_WITH_SANS_MAP;
    private final Map<KeyCombination, String> SPECIAL_WITH_BLACKBOARD_MAP;
    private final Map<KeyCombination, String> SPECIAL_WITH_FRAKTUR_MAP;


    public static KeyMaps getInstance() {
        if (singletonKeyMaps == null) {
            singletonKeyMaps = new KeyMaps();
        }
        return singletonKeyMaps;
    }
    private KeyMaps() {
        Map<KeyCombination, String> tempMap = new HashMap();
        tempMap.putAll(SPECIAL_CHARACTER_MAP);
        tempMap.putAll(SANS_MAP);
        SPECIAL_WITH_SANS_MAP = Collections.unmodifiableMap(tempMap);
        Map<KeyCombination, String> tempMap1 = new HashMap();
        tempMap1.putAll(SPECIAL_CHARACTER_MAP);
        tempMap1.putAll(BLACKBOARD_MAP);
        SPECIAL_WITH_BLACKBOARD_MAP = Collections.unmodifiableMap(tempMap1);
        Map<KeyCombination, String> tempMap2 = new HashMap();
        tempMap2.putAll(SPECIAL_CHARACTER_MAP);
        tempMap2.putAll(FRAKTUR_MAP);
        SPECIAL_WITH_FRAKTUR_MAP = Collections.unmodifiableMap(tempMap2);

        setMaps(SetMaps.BASE);
    }

    public void setMaps(SetMaps request) {
        switch(request) {
            case BASE: {
                keyPressedCharMap = BASE_ALT_MAP;
                keyTypedCharMap = BASE_MAP;
                break;
            }
            case ITALIC_AND_SANS: {
                keyPressedCharMap = SPECIAL_WITH_SANS_MAP;
                keyTypedCharMap = ITALIC_MAP;
                break;
            }
            case SCRIPT_AND_SANS: {
                keyPressedCharMap = SPECIAL_WITH_SANS_MAP;
                keyTypedCharMap = SCRIPT_MAP;
                break;
            }
            case ITALIC_AND_BLACKBOARD: {
                keyPressedCharMap = SPECIAL_WITH_BLACKBOARD_MAP;
                keyTypedCharMap = ITALIC_MAP;
                break;
            }
            case GREEK_AND_FRAKTUR: {
                keyPressedCharMap = SPECIAL_WITH_FRAKTUR_MAP;
                keyTypedCharMap = GREEK_MAP;
                break;
            }
        }
    }

    private Map<KeyCombination, String> initializeBaseAltMap() {
        return Map.ofEntries(
                entry (new KeyCodeCombination(KeyCode.D, KeyCombination.ALT_DOWN), "\u030a"),  //combining dot
                entry (new KeyCodeCombination(KeyCode.T, KeyCombination.ALT_DOWN), "\u0303"),  //combining tilde
                entry (new KeyCodeCombination(KeyCode.L, KeyCombination.ALT_DOWN), "\u2112")   //script L
        );
    }
    private Map<Character, String> initializeItalicMap() {
        return Map.ofEntries(
                entry ('a', "\ud835\udc4e"),
                entry ('b', "\ud835\udc4f"),
                entry ('c', "\ud835\udc50"),
                entry ('d', "\ud835\udc51"),
                entry ('e', "\ud835\udc52"),
                entry ('f', "\ud835\udc53"),
                entry ('g', "\ud835\udc54"),
                entry ('h', "\u210e"),
                entry ('i', "\ud835\udc56"),
                entry ('j', "\ud835\udc57"),
                entry ('k', "\ud835\udc58"),
                entry ('l', "\ud835\udc59"),
                entry ('m', "\ud835\udc5a"),
                entry ('n', "\ud835\udc5b"),
                entry ('o', "\ud835\udc5c"),
                entry ('p', "\ud835\udc5d"),
                entry ('q', "\ud835\udc5e"),
                entry ('r', "\ud835\udc5f"),
                entry ('s', "\ud835\udc60"),
                entry ('t', "\ud835\udc61"),
                entry ('u', "\ud835\udc62"),
                entry ('v', "\ud835\udc63"),
                entry ('w', "\ud835\udc64"),
                entry ('x', "\ud835\udc65"),
                entry ('y', "\ud835\udc66"),
                entry ('z', "\ud835\udc67"),
                entry ('A', "\ud835\udc34"),
                entry ('B', "\ud835\udc35"),
                entry ('C', "\ud835\udc36"),
                entry ('D', "\ud835\udc37"),
                entry ('E', "\ud835\udc38"),
                entry ('F', "\ud835\udc39"),
                entry ('G', "\ud835\udc3a"),
                entry ('H', "\ud835\udc3b"),
                entry ('I', "\ud835\udc3c"),
                entry ('J', "\ud835\udc3d"),
                entry ('K', "\ud835\udc3e"),
                entry ('L', "\ud835\udc3f"),
                entry ('M', "\ud835\udc40"),
                entry ('N', "\ud835\udc41"),
                entry ('O', "\ud835\udc42"),
                entry ('P', "\ud835\udc43"),
                entry ('Q', "\ud835\udc44"),
                entry ('R', "\ud835\udc45"),
                entry ('S', "\ud835\udc46"),
                entry ('T', "\ud835\udc47"),
                entry ('U', "\ud835\udc48"),
                entry ('V', "\ud835\udc49"),
                entry ('W', "\ud835\udc4a"),
                entry ('X', "\ud835\udc4b"),
                entry ('Y', "\ud835\udc4c"),
                entry ('Z', "\ud835\udc4d")
        );
    }
    private Map<Character, String> initializeScriptMap() {
        return Map.ofEntries(
                entry ('a', "\ud835\udcb6"),
                entry ('b', "\ud835\udcb7"),
                entry ('c', "\ud835\udcb8"),
                entry ('d', "\ud835\udcb9"),
                entry ('e', "\u212f"),
                entry ('f', "\ud835\udcbb"),
                entry ('g', "\u210a"),
                entry ('h', "\ud835\udcbd"),
                entry ('i', "\ud835\udcbe"),
                entry ('j', "\ud835\udcbf"),
                entry ('k', "\ud835\udcc0"),
                entry ('l', "\ud835\udcc1"),
                entry ('m', "\ud835\udcc2"),
                entry ('n', "\ud835\udcc3"),
                entry ('o', "\u2134"),
                entry ('p', "\ud835\udcc5"),
                entry ('q', "\ud835\udcc6"),
                entry ('r', "\ud835\udcc7"),
                entry ('s', "\ud835\udcc8"),
                entry ('t', "\ud835\udcc9"),
                entry ('u', "\ud835\udcca"),
                entry ('v', "\ud835\udccb"),
                entry ('w', "\ud835\udccc"),
                entry ('x', "\ud835\udccd"),
                entry ('y', "\ud835\udcce"),
                entry ('z', "\ud835\udccf"),
                entry ('A', "\ud835\udc9c"),
                entry ('B', "\u212c"),
                entry ('C', "\ud835\udc9e"),
                entry ('D', "\ud835\udc9f"),
                entry ('E', "\u2130"),
                entry ('F', "\u2131"),
                entry ('G', "\ud835\udca2"),
                entry ('H', "\u210b"),
                entry ('I', "\u2110"),
                entry ('J', "\ud835\udca5"),
                entry ('K', "\ud835\udca6"),
                entry ('L', "\u2112"),
                entry ('M', "\u2133"),
                entry ('N', "\ud835\udca9"),
                entry ('O', "\ud835\udcaa"),
                entry ('P', "\ud835\udcab"),
                entry ('Q', "\ud835\udcac"),
                entry ('R', "\u211b"),
                entry ('S', "\ud835\udcae"),
                entry ('T', "\ud835\udcaf"),
                entry ('U', "\ud835\udcb0"),
                entry ('V', "\ud835\udcb1"),
                entry ('W', "\ud835\udcb2"),
                entry ('X', "\ud835\udcb3"),
                entry ('Y', "\ud835\udcb4"),
                entry ('Z', "\ud835\udcb5")
        );
    }
    private Map<Character, String> initializeGreekMap() {
        return Map.ofEntries(
                entry ('a', "\u03b1"),
                entry ('A', "\u0391"),
                entry ('b', "\u03b2"),
                entry ('B', "\u0392"),
                entry ('c', "\u03c8"),
                entry ('C', "\u03a8"),
                entry ('d', "\u03b4"),
                entry ('D', "\u0394"),
                entry ('e', "\u03b5"),
                entry ('E', "\u0395"),
                entry ('f', "\u03c6"),
                entry ('F', "\u03a6"),
                entry ('g', "\u03b3"),
                entry ('G', "\u0393"),
                entry ('h', "\u03b7"),
                entry ('H', "\u0397"),
                entry ('i', "\u03b9"),
                entry ('I', "\u0399"),
                entry ('j', "\u03be"),
                entry ('J', "\u039e"),
                entry ('k', "\u03ba"),
                entry ('K', "\u039a"),
                entry ('l', "\u03bb"),
                entry ('L', "\u039B"),
                entry ('m', "\u03bc"),
                entry ('M', "\u039c"),
                entry ('n', "\u03bd"),
                entry ('N', "\u039d"),
                entry ('o', "\u03bf"),
                entry ('O', "\u039f"),
                entry ('p', "\u03c0"),
                entry ('P', "\u03a0"),
                entry('q',""),
                entry('Q',""),
                entry ('r', "\u03c1"),
                entry ('R', "\u03a1"),
                entry ('s', "\u03c3"),
                entry ('S', "\u03a3"),
                entry ('t', "\u03c4"),
                entry ('T', "\u03a4"),
                entry ('u', "\u03b8"),
                entry ('U', "\u0398"),
                entry ('v', "\u03c9"),
                entry ('V', "\u03a9"),
                entry ('w',""),
                entry ('W',""),
                entry ('x', "\u03c7"),
                entry ('X', "\u03a7"),
                entry ('y', "\u03c5"),
                entry ('Y', "\u03a5"),
                entry ('z', "\u03b6"),
                entry ('Z', "\u0396")
        );
    }
    private Map<KeyCombination, String> initializeSansMap() {
        return Map.ofEntries(
                entry(new KeyCodeCombination(KeyCode.A, KeyCombination.ALT_DOWN), "\ud835\uddba"),
                entry(new KeyCodeCombination(KeyCode.B, KeyCombination.ALT_DOWN), "\ud835\uddbb"),
                entry(new KeyCodeCombination(KeyCode.C, KeyCombination.ALT_DOWN), "\ud835\uddbc"),
                entry(new KeyCodeCombination(KeyCode.D, KeyCombination.ALT_DOWN), "\ud835\uddbd"),
                entry(new KeyCodeCombination(KeyCode.E, KeyCombination.ALT_DOWN), "\ud835\uddbe"),
                entry(new KeyCodeCombination(KeyCode.F, KeyCombination.ALT_DOWN), "\ud835\uddbf"),
                entry(new KeyCodeCombination(KeyCode.G, KeyCombination.ALT_DOWN), "\ud835\uddc0"),
                entry(new KeyCodeCombination(KeyCode.H, KeyCombination.ALT_DOWN), "\ud835\uddc1"),
                entry(new KeyCodeCombination(KeyCode.I, KeyCombination.ALT_DOWN), "\ud835\uddc2"),
                entry(new KeyCodeCombination(KeyCode.J, KeyCombination.ALT_DOWN), "\ud835\uddc3"),
                entry(new KeyCodeCombination(KeyCode.K, KeyCombination.ALT_DOWN), "\ud835\uddc4"),
                entry(new KeyCodeCombination(KeyCode.L, KeyCombination.ALT_DOWN), "\ud835\uddc5"),
                entry(new KeyCodeCombination(KeyCode.M, KeyCombination.ALT_DOWN), "\ud835\uddc6"),
                entry(new KeyCodeCombination(KeyCode.N, KeyCombination.ALT_DOWN), "\ud835\uddc7"),
                entry(new KeyCodeCombination(KeyCode.O, KeyCombination.ALT_DOWN), "\ud835\uddc8"),
                entry(new KeyCodeCombination(KeyCode.P, KeyCombination.ALT_DOWN), "\ud835\uddc9"),
                entry(new KeyCodeCombination(KeyCode.Q, KeyCombination.ALT_DOWN), "\ud835\uddca"),
                entry(new KeyCodeCombination(KeyCode.R, KeyCombination.ALT_DOWN), "\ud835\uddcb"),
                entry(new KeyCodeCombination(KeyCode.S, KeyCombination.ALT_DOWN), "\ud835\uddcc"),
                entry(new KeyCodeCombination(KeyCode.T, KeyCombination.ALT_DOWN), "\ud835\uddcd"),
                entry(new KeyCodeCombination(KeyCode.U, KeyCombination.ALT_DOWN), "\ud835\uddce"),
                entry(new KeyCodeCombination(KeyCode.V, KeyCombination.ALT_DOWN), "\ud835\uddcf"),
                entry(new KeyCodeCombination(KeyCode.W, KeyCombination.ALT_DOWN), "\ud835\uddd0"),
                entry(new KeyCodeCombination(KeyCode.X, KeyCombination.ALT_DOWN), "\ud835\uddd1"),
                entry(new KeyCodeCombination(KeyCode.Y, KeyCombination.ALT_DOWN), "\ud835\uddd2"),
                entry(new KeyCodeCombination(KeyCode.Z, KeyCombination.ALT_DOWN), "\ud835\uddd3"),
                entry(new KeyCodeCombination(KeyCode.DIGIT0, KeyCombination.ALT_DOWN), "\ud835\udfe2"),
                entry(new KeyCodeCombination(KeyCode.DIGIT1, KeyCombination.ALT_DOWN), "\ud835\udfe3"),
                entry(new KeyCodeCombination(KeyCode.DIGIT2, KeyCombination.ALT_DOWN), "\ud835\udfe4"),
                entry(new KeyCodeCombination(KeyCode.DIGIT3, KeyCombination.ALT_DOWN), "\ud835\udfe5"),
                entry(new KeyCodeCombination(KeyCode.DIGIT4, KeyCombination.ALT_DOWN), "\ud835\udfe6"),
                entry(new KeyCodeCombination(KeyCode.DIGIT5, KeyCombination.ALT_DOWN), "\ud835\udfe7"),
                entry(new KeyCodeCombination(KeyCode.DIGIT6, KeyCombination.ALT_DOWN), "\ud835\udfe8"),
                entry(new KeyCodeCombination(KeyCode.DIGIT7, KeyCombination.ALT_DOWN), "\ud835\udfe9"),
                entry(new KeyCodeCombination(KeyCode.DIGIT8, KeyCombination.ALT_DOWN), "\ud835\udfea"),
                entry(new KeyCodeCombination(KeyCode.DIGIT9, KeyCombination.ALT_DOWN), "\ud835\udfeb"),
                entry(new KeyCodeCombination(KeyCode.A, KeyCombination.ALT_DOWN, KeyCombination.SHIFT_DOWN), "\ud835\udda0"),
                entry(new KeyCodeCombination(KeyCode.B, KeyCombination.ALT_DOWN, KeyCombination.SHIFT_DOWN), "\ud835\udda1"),
                entry(new KeyCodeCombination(KeyCode.C, KeyCombination.ALT_DOWN, KeyCombination.SHIFT_DOWN), "\ud835\udda2"),
                entry(new KeyCodeCombination(KeyCode.D, KeyCombination.ALT_DOWN, KeyCombination.SHIFT_DOWN), "\ud835\udda3"),
                entry(new KeyCodeCombination(KeyCode.E, KeyCombination.ALT_DOWN, KeyCombination.SHIFT_DOWN), "\ud835\udda4"),
                entry(new KeyCodeCombination(KeyCode.F, KeyCombination.ALT_DOWN, KeyCombination.SHIFT_DOWN), "\ud835\udda5"),
                entry(new KeyCodeCombination(KeyCode.G, KeyCombination.ALT_DOWN, KeyCombination.SHIFT_DOWN), "\ud835\udda6"),
                entry(new KeyCodeCombination(KeyCode.H, KeyCombination.ALT_DOWN, KeyCombination.SHIFT_DOWN), "\ud835\udda7"),
                entry(new KeyCodeCombination(KeyCode.I, KeyCombination.ALT_DOWN, KeyCombination.SHIFT_DOWN), "\ud835\udda8"),
                entry(new KeyCodeCombination(KeyCode.J, KeyCombination.ALT_DOWN, KeyCombination.SHIFT_DOWN), "\ud835\udda9"),
                entry(new KeyCodeCombination(KeyCode.K, KeyCombination.ALT_DOWN, KeyCombination.SHIFT_DOWN), "\ud835\uddaa"),
                entry(new KeyCodeCombination(KeyCode.L, KeyCombination.ALT_DOWN, KeyCombination.SHIFT_DOWN), "\ud835\uddab"),
                entry(new KeyCodeCombination(KeyCode.M, KeyCombination.ALT_DOWN, KeyCombination.SHIFT_DOWN), "\ud835\uddac"),
                entry(new KeyCodeCombination(KeyCode.N, KeyCombination.ALT_DOWN, KeyCombination.SHIFT_DOWN), "\ud835\uddad"),
                entry(new KeyCodeCombination(KeyCode.O, KeyCombination.ALT_DOWN, KeyCombination.SHIFT_DOWN), "\ud835\uddae"),
                entry(new KeyCodeCombination(KeyCode.P, KeyCombination.ALT_DOWN, KeyCombination.SHIFT_DOWN), "\ud835\uddaf"),
                entry(new KeyCodeCombination(KeyCode.Q, KeyCombination.ALT_DOWN, KeyCombination.SHIFT_DOWN), "\ud835\uddb0"),
                entry(new KeyCodeCombination(KeyCode.R, KeyCombination.ALT_DOWN, KeyCombination.SHIFT_DOWN), "\ud835\uddb1"),
                entry(new KeyCodeCombination(KeyCode.S, KeyCombination.ALT_DOWN, KeyCombination.SHIFT_DOWN), "\ud835\uddb2"),
                entry(new KeyCodeCombination(KeyCode.T, KeyCombination.ALT_DOWN, KeyCombination.SHIFT_DOWN), "\ud835\uddb3"),
                entry(new KeyCodeCombination(KeyCode.U, KeyCombination.ALT_DOWN, KeyCombination.SHIFT_DOWN), "\ud835\uddb4"),
                entry(new KeyCodeCombination(KeyCode.V, KeyCombination.ALT_DOWN, KeyCombination.SHIFT_DOWN), "\ud835\uddb5"),
                entry(new KeyCodeCombination(KeyCode.W, KeyCombination.ALT_DOWN, KeyCombination.SHIFT_DOWN), "\ud835\uddb6"),
                entry(new KeyCodeCombination(KeyCode.X, KeyCombination.ALT_DOWN, KeyCombination.SHIFT_DOWN), "\ud835\uddb7"),
                entry(new KeyCodeCombination(KeyCode.Y, KeyCombination.ALT_DOWN, KeyCombination.SHIFT_DOWN), "\ud835\uddb8"),
                entry(new KeyCodeCombination(KeyCode.Z, KeyCombination.ALT_DOWN, KeyCombination.SHIFT_DOWN), "\ud835\uddb9")
        );

    }
    private Map<KeyCombination, String> initializeFrakturMap() {
        return Map.ofEntries(
                entry(new KeyCodeCombination(KeyCode.A, KeyCombination.ALT_DOWN), "\ud835\udd1e"),
                entry(new KeyCodeCombination(KeyCode.B, KeyCombination.ALT_DOWN), "\ud835\udd1f"),
                entry(new KeyCodeCombination(KeyCode.C, KeyCombination.ALT_DOWN), "\ud835\udd20"),
                entry(new KeyCodeCombination(KeyCode.D, KeyCombination.ALT_DOWN), "\ud835\udd21"),
                entry(new KeyCodeCombination(KeyCode.E, KeyCombination.ALT_DOWN), "\ud835\udd22"),
                entry(new KeyCodeCombination(KeyCode.F, KeyCombination.ALT_DOWN), "\ud835\udd23"),
                entry(new KeyCodeCombination(KeyCode.G, KeyCombination.ALT_DOWN), "\ud835\udd24"),
                entry(new KeyCodeCombination(KeyCode.H, KeyCombination.ALT_DOWN), "\ud835\udd25"),
                entry(new KeyCodeCombination(KeyCode.I, KeyCombination.ALT_DOWN), "\ud835\udd26"),
                entry(new KeyCodeCombination(KeyCode.J, KeyCombination.ALT_DOWN), "\ud835\udd27"),
                entry(new KeyCodeCombination(KeyCode.K, KeyCombination.ALT_DOWN), "\ud835\udd28"),
                entry(new KeyCodeCombination(KeyCode.L, KeyCombination.ALT_DOWN), "\ud835\udd29"),
                entry(new KeyCodeCombination(KeyCode.M, KeyCombination.ALT_DOWN), "\ud835\udd2a"),
                entry(new KeyCodeCombination(KeyCode.N, KeyCombination.ALT_DOWN), "\ud835\udd2b"),
                entry(new KeyCodeCombination(KeyCode.O, KeyCombination.ALT_DOWN), "\ud835\udd2c"),
                entry(new KeyCodeCombination(KeyCode.P, KeyCombination.ALT_DOWN), "\ud835\udd2d"),
                entry(new KeyCodeCombination(KeyCode.Q, KeyCombination.ALT_DOWN), "\ud835\udd2e"),
                entry(new KeyCodeCombination(KeyCode.R, KeyCombination.ALT_DOWN), "\ud835\udd2f"),
                entry(new KeyCodeCombination(KeyCode.S, KeyCombination.ALT_DOWN), "\ud835\udd30"),
                entry(new KeyCodeCombination(KeyCode.T, KeyCombination.ALT_DOWN), "\ud835\udd31"),
                entry(new KeyCodeCombination(KeyCode.U, KeyCombination.ALT_DOWN), "\ud835\udd32"),
                entry(new KeyCodeCombination(KeyCode.V, KeyCombination.ALT_DOWN), "\ud835\udd33"),
                entry(new KeyCodeCombination(KeyCode.W, KeyCombination.ALT_DOWN), "\ud835\udd34"),
                entry(new KeyCodeCombination(KeyCode.X, KeyCombination.ALT_DOWN), "\ud835\udd35"),
                entry(new KeyCodeCombination(KeyCode.Y, KeyCombination.ALT_DOWN), "\ud835\udd36"),
                entry(new KeyCodeCombination(KeyCode.Z, KeyCombination.ALT_DOWN), "\ud835\udd37"),
                entry(new KeyCodeCombination(KeyCode.A, KeyCombination.ALT_DOWN, KeyCombination.SHIFT_DOWN), "\ud835\udd04"),
                entry(new KeyCodeCombination(KeyCode.B, KeyCombination.ALT_DOWN, KeyCombination.SHIFT_DOWN), "\ud835\udd05"),
                entry(new KeyCodeCombination(KeyCode.C, KeyCombination.ALT_DOWN, KeyCombination.SHIFT_DOWN), "\u212D"),
                entry(new KeyCodeCombination(KeyCode.D, KeyCombination.ALT_DOWN, KeyCombination.SHIFT_DOWN), "\ud835\udd07"),
                entry(new KeyCodeCombination(KeyCode.E, KeyCombination.ALT_DOWN, KeyCombination.SHIFT_DOWN), "\ud835\udd08"),
                entry(new KeyCodeCombination(KeyCode.F, KeyCombination.ALT_DOWN, KeyCombination.SHIFT_DOWN), "\ud835\udd09"),
                entry(new KeyCodeCombination(KeyCode.G, KeyCombination.ALT_DOWN, KeyCombination.SHIFT_DOWN), "\ud835\udd0a"),
                entry(new KeyCodeCombination(KeyCode.H, KeyCombination.ALT_DOWN, KeyCombination.SHIFT_DOWN), "\u210c"),
                entry(new KeyCodeCombination(KeyCode.I, KeyCombination.ALT_DOWN, KeyCombination.SHIFT_DOWN), "\u2111"),
                entry(new KeyCodeCombination(KeyCode.J, KeyCombination.ALT_DOWN, KeyCombination.SHIFT_DOWN), "\ud835\udd0d"),
                entry(new KeyCodeCombination(KeyCode.K, KeyCombination.ALT_DOWN, KeyCombination.SHIFT_DOWN), "\ud835\udd0e"),
                entry(new KeyCodeCombination(KeyCode.L, KeyCombination.ALT_DOWN, KeyCombination.SHIFT_DOWN), "\ud835\udd0f"),
                entry(new KeyCodeCombination(KeyCode.M, KeyCombination.ALT_DOWN, KeyCombination.SHIFT_DOWN), "\ud835\udd10"),
                entry(new KeyCodeCombination(KeyCode.N, KeyCombination.ALT_DOWN, KeyCombination.SHIFT_DOWN), "\ud835\udd11"),
                entry(new KeyCodeCombination(KeyCode.O, KeyCombination.ALT_DOWN, KeyCombination.SHIFT_DOWN), "\ud835\udd12"),
                entry(new KeyCodeCombination(KeyCode.P, KeyCombination.ALT_DOWN, KeyCombination.SHIFT_DOWN), "\ud835\udd13"),
                entry(new KeyCodeCombination(KeyCode.Q, KeyCombination.ALT_DOWN, KeyCombination.SHIFT_DOWN), "\ud835\udd14"),
                entry(new KeyCodeCombination(KeyCode.R, KeyCombination.ALT_DOWN, KeyCombination.SHIFT_DOWN), "\u211c"),
                entry(new KeyCodeCombination(KeyCode.S, KeyCombination.ALT_DOWN, KeyCombination.SHIFT_DOWN), "\ud835\udd16"),
                entry(new KeyCodeCombination(KeyCode.T, KeyCombination.ALT_DOWN, KeyCombination.SHIFT_DOWN), "\ud835\udd17"),
                entry(new KeyCodeCombination(KeyCode.U, KeyCombination.ALT_DOWN, KeyCombination.SHIFT_DOWN), "\ud835\udd18"),
                entry(new KeyCodeCombination(KeyCode.V, KeyCombination.ALT_DOWN, KeyCombination.SHIFT_DOWN), "\ud835\udd19"),
                entry(new KeyCodeCombination(KeyCode.W, KeyCombination.ALT_DOWN, KeyCombination.SHIFT_DOWN), "\ud835\udd1a"),
                entry(new KeyCodeCombination(KeyCode.X, KeyCombination.ALT_DOWN, KeyCombination.SHIFT_DOWN), "\ud835\udd1b"),
                entry(new KeyCodeCombination(KeyCode.Y, KeyCombination.ALT_DOWN, KeyCombination.SHIFT_DOWN), "\ud835\udd1c"),
                entry(new KeyCodeCombination(KeyCode.Z, KeyCombination.ALT_DOWN, KeyCombination.SHIFT_DOWN), "\u2128")
        );
    }
    private Map<KeyCombination, String> initializeBlackboardMap() {
        return Map.ofEntries(
                entry(new KeyCodeCombination(KeyCode.A, KeyCombination.ALT_DOWN), "\ud835\udd52"),
                entry(new KeyCodeCombination(KeyCode.B, KeyCombination.ALT_DOWN), "\ud835\udd53"),
                entry(new KeyCodeCombination(KeyCode.C, KeyCombination.ALT_DOWN), "\ud835\udd54"),
                entry(new KeyCodeCombination(KeyCode.D, KeyCombination.ALT_DOWN), "\ud835\udd55"),
                entry(new KeyCodeCombination(KeyCode.E, KeyCombination.ALT_DOWN), "\ud835\udd56"),
                entry(new KeyCodeCombination(KeyCode.F, KeyCombination.ALT_DOWN), "\ud835\udd57"),
                entry(new KeyCodeCombination(KeyCode.G, KeyCombination.ALT_DOWN), "\ud835\udd58"),
                entry(new KeyCodeCombination(KeyCode.H, KeyCombination.ALT_DOWN), "\ud835\udd59"),
                entry(new KeyCodeCombination(KeyCode.I, KeyCombination.ALT_DOWN), "\ud835\udd5a"),
                entry(new KeyCodeCombination(KeyCode.J, KeyCombination.ALT_DOWN), "\ud835\udd5b"),
                entry(new KeyCodeCombination(KeyCode.K, KeyCombination.ALT_DOWN), "\ud835\udd5c"),
                entry(new KeyCodeCombination(KeyCode.L, KeyCombination.ALT_DOWN), "\ud835\udd5d"),
                entry(new KeyCodeCombination(KeyCode.M, KeyCombination.ALT_DOWN), "\ud835\udd5e"),
                entry(new KeyCodeCombination(KeyCode.N, KeyCombination.ALT_DOWN), "\ud835\udd5f"),
                entry(new KeyCodeCombination(KeyCode.O, KeyCombination.ALT_DOWN), "\ud835\udd60"),
                entry(new KeyCodeCombination(KeyCode.P, KeyCombination.ALT_DOWN), "\ud835\udd61"),
                entry(new KeyCodeCombination(KeyCode.Q, KeyCombination.ALT_DOWN), "\ud835\udd62"),
                entry(new KeyCodeCombination(KeyCode.R, KeyCombination.ALT_DOWN), "\ud835\udd63"),
                entry(new KeyCodeCombination(KeyCode.S, KeyCombination.ALT_DOWN), "\ud835\udd64"),
                entry(new KeyCodeCombination(KeyCode.T, KeyCombination.ALT_DOWN), "\ud835\udd65"),
                entry(new KeyCodeCombination(KeyCode.U, KeyCombination.ALT_DOWN), "\ud835\udd66"),
                entry(new KeyCodeCombination(KeyCode.V, KeyCombination.ALT_DOWN), "\ud835\udd67"),
                entry(new KeyCodeCombination(KeyCode.W, KeyCombination.ALT_DOWN), "\ud835\udd68"),
                entry(new KeyCodeCombination(KeyCode.X, KeyCombination.ALT_DOWN), "\ud835\udd69"),
                entry(new KeyCodeCombination(KeyCode.Y, KeyCombination.ALT_DOWN), "\ud835\udd6a"),
                entry(new KeyCodeCombination(KeyCode.Z, KeyCombination.ALT_DOWN), "\ud835\udd6b"),
                entry(new KeyCodeCombination(KeyCode.DIGIT0, KeyCombination.ALT_DOWN), "\ud835\udfd8"),
                entry(new KeyCodeCombination(KeyCode.DIGIT1, KeyCombination.ALT_DOWN), "\ud835\udfd9"),
                entry(new KeyCodeCombination(KeyCode.DIGIT2, KeyCombination.ALT_DOWN), "\ud835\udfda"),
                entry(new KeyCodeCombination(KeyCode.DIGIT3, KeyCombination.ALT_DOWN), "\ud835\udfdb"),
                entry(new KeyCodeCombination(KeyCode.DIGIT4, KeyCombination.ALT_DOWN), "\ud835\udfdc"),
                entry(new KeyCodeCombination(KeyCode.DIGIT5, KeyCombination.ALT_DOWN), "\ud835\udfdd"),
                entry(new KeyCodeCombination(KeyCode.DIGIT6, KeyCombination.ALT_DOWN), "\ud835\udfde"),
                entry(new KeyCodeCombination(KeyCode.DIGIT7, KeyCombination.ALT_DOWN), "\ud835\udfdf"),
                entry(new KeyCodeCombination(KeyCode.DIGIT8, KeyCombination.ALT_DOWN), "\ud835\udfe0"),
                entry(new KeyCodeCombination(KeyCode.DIGIT9, KeyCombination.ALT_DOWN), "\ud835\udfe1"),
                entry(new KeyCodeCombination(KeyCode.A, KeyCombination.ALT_DOWN, KeyCombination.SHIFT_DOWN), "\ud835\udd38"),
                entry(new KeyCodeCombination(KeyCode.B, KeyCombination.ALT_DOWN, KeyCombination.SHIFT_DOWN), "\ud835\udd39"),
                entry(new KeyCodeCombination(KeyCode.C, KeyCombination.ALT_DOWN, KeyCombination.SHIFT_DOWN), "\u2102"),
                entry(new KeyCodeCombination(KeyCode.D, KeyCombination.ALT_DOWN, KeyCombination.SHIFT_DOWN), "\ud835\udd3b"),
                entry(new KeyCodeCombination(KeyCode.E, KeyCombination.ALT_DOWN, KeyCombination.SHIFT_DOWN), "\ud835\udd3c"),
                entry(new KeyCodeCombination(KeyCode.F, KeyCombination.ALT_DOWN, KeyCombination.SHIFT_DOWN), "\ud835\udd3d"),
                entry(new KeyCodeCombination(KeyCode.G, KeyCombination.ALT_DOWN, KeyCombination.SHIFT_DOWN), "\ud835\udd3e"),
                entry(new KeyCodeCombination(KeyCode.H, KeyCombination.ALT_DOWN, KeyCombination.SHIFT_DOWN), "\u210d"),
                entry(new KeyCodeCombination(KeyCode.I, KeyCombination.ALT_DOWN, KeyCombination.SHIFT_DOWN), "\ud835\udd40"),
                entry(new KeyCodeCombination(KeyCode.J, KeyCombination.ALT_DOWN, KeyCombination.SHIFT_DOWN), "\ud835\udd41"),
                entry(new KeyCodeCombination(KeyCode.K, KeyCombination.ALT_DOWN, KeyCombination.SHIFT_DOWN), "\ud835\udd42"),
                entry(new KeyCodeCombination(KeyCode.L, KeyCombination.ALT_DOWN, KeyCombination.SHIFT_DOWN), "\ud835\udd43"),
                entry(new KeyCodeCombination(KeyCode.M, KeyCombination.ALT_DOWN, KeyCombination.SHIFT_DOWN), "\ud835\udd44"),
                entry(new KeyCodeCombination(KeyCode.N, KeyCombination.ALT_DOWN, KeyCombination.SHIFT_DOWN), "\u2115"),
                entry(new KeyCodeCombination(KeyCode.O, KeyCombination.ALT_DOWN, KeyCombination.SHIFT_DOWN), "\ud835\udd46"),
                entry(new KeyCodeCombination(KeyCode.P, KeyCombination.ALT_DOWN, KeyCombination.SHIFT_DOWN), "\u2119"),
                entry(new KeyCodeCombination(KeyCode.Q, KeyCombination.ALT_DOWN, KeyCombination.SHIFT_DOWN), "\u211a"),
                entry(new KeyCodeCombination(KeyCode.R, KeyCombination.ALT_DOWN, KeyCombination.SHIFT_DOWN), "\u211d"),
                entry(new KeyCodeCombination(KeyCode.S, KeyCombination.ALT_DOWN, KeyCombination.SHIFT_DOWN), "\ud835\udd4a"),
                entry(new KeyCodeCombination(KeyCode.T, KeyCombination.ALT_DOWN, KeyCombination.SHIFT_DOWN), "\ud835\udd4b"),
                entry(new KeyCodeCombination(KeyCode.U, KeyCombination.ALT_DOWN, KeyCombination.SHIFT_DOWN), "\ud835\udd4c"),
                entry(new KeyCodeCombination(KeyCode.V, KeyCombination.ALT_DOWN, KeyCombination.SHIFT_DOWN), "\ud835\udd4d"),
                entry(new KeyCodeCombination(KeyCode.W, KeyCombination.ALT_DOWN, KeyCombination.SHIFT_DOWN), "\ud835\udd4e"),
                entry(new KeyCodeCombination(KeyCode.X, KeyCombination.ALT_DOWN, KeyCombination.SHIFT_DOWN), "\ud835\udd4f"),
                entry(new KeyCodeCombination(KeyCode.Y, KeyCombination.ALT_DOWN, KeyCombination.SHIFT_DOWN), "\ud835\udd50"),
                entry(new KeyCodeCombination(KeyCode.Z, KeyCombination.ALT_DOWN, KeyCombination.SHIFT_DOWN), "\u2124")
        );
    }
    private Map<KeyCombination, String> initializeSpecialCharacterMap() {
        return Map.ofEntries(
                entry(new KeyCodeCombination(KeyCode.BACK_QUOTE, KeyCombination.ALT_DOWN), "\u00ac"),                                                             //hammer
                entry(new KeyCodeCombination(KeyCode.MINUS, KeyCombination.ALT_DOWN), "\u25b3"),                                                                  //meta caret
                entry(new KeyCodeCombination(KeyCode.EQUALS, KeyCombination.ALT_DOWN), "\u25bd"),                                                                 //meta vee
                entry(new KeyCodeCombination(KeyCode.OPEN_BRACKET, KeyCombination.ALT_DOWN), "\u21d2"),                                                           //meta arrow
                entry(new KeyCodeCombination(KeyCode.CLOSE_BRACKET, KeyCombination.ALT_DOWN), "\u21d4"),                                                          //meta double arrow
                entry(new KeyCodeCombination(KeyCode.BACK_SLASH, KeyCombination.ALT_DOWN), "\u234a"),                                                             //meta bottom
                entry(new KeyCodeCombination(KeyCode.SEMICOLON, KeyCombination.ALT_DOWN), "\u22a2"),                                                              //proves
                entry(new KeyCodeCombination(KeyCode.QUOTE, KeyCombination.ALT_DOWN), "\u22ac"),                                                                  //not proves
                entry(new KeyCodeCombination(KeyCode.COMMA, KeyCombination.ALT_DOWN), "\u22a8"),                                                                  //entails
                entry(new KeyCodeCombination(KeyCode.PERIOD, KeyCombination.ALT_DOWN), "\u22ad"),                                                                 //not entails
                entry(new KeyCodeCombination(KeyCode.SLASH, KeyCombination.ALT_DOWN), "\u25c3\u25b9"),                                                            //replacement rule

                entry(new KeyCodeCombination(KeyCode.BACK_QUOTE, KeyCombination.ALT_DOWN, KeyCombination.SHIFT_DOWN), "\u223c"),                                  //tilde
                entry(new KeyCodeCombination(KeyCode.DIGIT1, KeyCombination.ALT_DOWN, KeyCombination.SHIFT_DOWN), "\u2227"),                                      //caret
                entry(new KeyCodeCombination(KeyCode.DIGIT2, KeyCombination.ALT_DOWN, KeyCombination.SHIFT_DOWN), "\u2228"),                                      //wedge
                entry(new KeyCodeCombination(KeyCode.DIGIT3, KeyCombination.ALT_DOWN, KeyCombination.SHIFT_DOWN), "\u2192"),                                      //arrow
                entry(new KeyCodeCombination(KeyCode.DIGIT4, KeyCombination.ALT_DOWN, KeyCombination.SHIFT_DOWN), "\u2194"),                                      //double arrow
                entry(new KeyCodeCombination(KeyCode.DIGIT5, KeyCombination.ALT_DOWN, KeyCombination.SHIFT_DOWN), "\u22a5"),                                      //bottom
                entry(new KeyCodeCombination(KeyCode.DIGIT6, KeyCombination.ALT_DOWN, KeyCombination.SHIFT_DOWN), "\u22a4"),                                      //top
                entry(new KeyCodeCombination(KeyCode.DIGIT7, KeyCombination.ALT_DOWN, KeyCombination.SHIFT_DOWN), "\u2200"),                                      //universal quantifier
                entry(new KeyCodeCombination(KeyCode.DIGIT8, KeyCombination.ALT_DOWN, KeyCombination.SHIFT_DOWN), "\u2203"),                                      //existential quantifier
                entry(new KeyCodeCombination(KeyCode.DIGIT9, KeyCombination.ALT_DOWN, KeyCombination.SHIFT_DOWN), "\u226e"),                                      //not less than
                entry(new KeyCodeCombination(KeyCode.DIGIT0, KeyCombination.ALT_DOWN, KeyCombination.SHIFT_DOWN), "\u2264"),                                      //less than or equal
                entry(new KeyCodeCombination(KeyCode.MINUS, KeyCombination.ALT_DOWN, KeyCombination.SHIFT_DOWN), "\u2270"),                                       //not less than or equal (looks bad on small font)
                entry(new KeyCodeCombination(KeyCode.EQUALS, KeyCombination.ALT_DOWN, KeyCombination.SHIFT_DOWN), "\u2260"),                                      //not equals
                entry(new KeyCodeCombination(KeyCode.OPEN_BRACKET, KeyCombination.ALT_DOWN, KeyCombination.SHIFT_DOWN), "\u301a"),                                //open double bracket
                entry(new KeyCodeCombination(KeyCode.CLOSE_BRACKET, KeyCombination.ALT_DOWN, KeyCombination.SHIFT_DOWN), "\u301b"),                               //close double bracket
                entry(new KeyCodeCombination(KeyCode.BACK_SLASH, KeyCombination.ALT_DOWN, KeyCombination.SHIFT_DOWN), "\u20eb"),                                  //double slash
                entry(new KeyCodeCombination(KeyCode.SEMICOLON, KeyCombination.ALT_DOWN, KeyCombination.SHIFT_DOWN), "\u00d7"),                                   //times
                entry(new KeyCodeCombination(KeyCode.QUOTE, KeyCombination.ALT_DOWN, KeyCombination.SHIFT_DOWN), "\u2032"),                                       //prime
                entry(new KeyCodeCombination(KeyCode.COMMA, KeyCombination.ALT_DOWN, KeyCombination.SHIFT_DOWN), "\u2191"),                                       //up arrow
                entry(new KeyCodeCombination(KeyCode.PERIOD, KeyCombination.ALT_DOWN, KeyCombination.SHIFT_DOWN), "\u2193"),                                      //down arrow
                entry(new KeyCodeCombination(KeyCode.SLASH, KeyCombination.ALT_DOWN, KeyCombination.SHIFT_DOWN), "\u00d8"),                                       //zero with slash

                entry(new KeyCodeCombination(KeyCode.BACK_QUOTE, KeyCombination.SHORTCUT_DOWN, KeyCombination.ALT_DOWN, KeyCombination.SHIFT_DOWN), "\u25fb"),    //box
                entry(new KeyCodeCombination(KeyCode.DIGIT1, KeyCombination.SHORTCUT_DOWN, KeyCombination.ALT_DOWN, KeyCombination.SHIFT_DOWN), "\u2b26"),        //diamond
                entry(new KeyCodeCombination(KeyCode.DIGIT2, KeyCombination.SHORTCUT_DOWN, KeyCombination.ALT_DOWN, KeyCombination.SHIFT_DOWN), "\u2261"),        //triple bar
                entry(new KeyCodeCombination(KeyCode.DIGIT3, KeyCombination.SHORTCUT_DOWN, KeyCombination.ALT_DOWN, KeyCombination.SHIFT_DOWN), "\u2283"),        //horseshoe
                entry(new KeyCodeCombination(KeyCode.DIGIT4, KeyCombination.SHORTCUT_DOWN, KeyCombination.ALT_DOWN, KeyCombination.SHIFT_DOWN), "\u22c0"),        //big caret
                entry(new KeyCodeCombination(KeyCode.DIGIT5, KeyCombination.SHORTCUT_DOWN, KeyCombination.ALT_DOWN, KeyCombination.SHIFT_DOWN), "\u22c1"),        //big wedge
                entry(new KeyCodeCombination(KeyCode.DIGIT6, KeyCombination.SHORTCUT_DOWN, KeyCombination.ALT_DOWN, KeyCombination.SHIFT_DOWN), "\u2135"),        //aleph
                entry(new KeyCodeCombination(KeyCode.DIGIT7, KeyCombination.SHORTCUT_DOWN, KeyCombination.ALT_DOWN, KeyCombination.SHIFT_DOWN), "\ud835\udcab"),  //powerset
                entry(new KeyCodeCombination(KeyCode.DIGIT8, KeyCombination.SHORTCUT_DOWN, KeyCombination.ALT_DOWN, KeyCombination.SHIFT_DOWN), "\u2217"),        //asterisk
                entry(new KeyCodeCombination(KeyCode.DIGIT9, KeyCombination.SHORTCUT_DOWN, KeyCombination.ALT_DOWN, KeyCombination.SHIFT_DOWN), "\u22c6"),        //star
                entry(new KeyCodeCombination(KeyCode.DIGIT0, KeyCombination.SHORTCUT_DOWN, KeyCombination.ALT_DOWN, KeyCombination.SHIFT_DOWN), "\u2205"),         //empty set
                entry(new KeyCodeCombination(KeyCode.MINUS, KeyCombination.SHORTCUT_DOWN, KeyCombination.ALT_DOWN, KeyCombination.SHIFT_DOWN), "\u00f7"),         //divides
                entry(new KeyCodeCombination(KeyCode.EQUALS, KeyCombination.SHORTCUT_DOWN, KeyCombination.ALT_DOWN, KeyCombination.SHIFT_DOWN), "\u226f"),        //not greater than
                entry(new KeyCodeCombination(KeyCode.Q, KeyCombination.SHORTCUT_DOWN, KeyCombination.ALT_DOWN, KeyCombination.SHIFT_DOWN), "\u2282"),             //proper subset
                entry(new KeyCodeCombination(KeyCode.W, KeyCombination.SHORTCUT_DOWN, KeyCombination.ALT_DOWN, KeyCombination.SHIFT_DOWN), "\u2284"),             //not proper subset
                entry(new KeyCodeCombination(KeyCode.E, KeyCombination.SHORTCUT_DOWN, KeyCombination.ALT_DOWN, KeyCombination.SHIFT_DOWN), "\u2286"),             //subset
                entry(new KeyCodeCombination(KeyCode.R, KeyCombination.SHORTCUT_DOWN, KeyCombination.ALT_DOWN, KeyCombination.SHIFT_DOWN), "\u2288"),             //not subset
                entry(new KeyCodeCombination(KeyCode.T, KeyCombination.SHORTCUT_DOWN, KeyCombination.ALT_DOWN, KeyCombination.SHIFT_DOWN), "\u2208"),             //element of
                entry(new KeyCodeCombination(KeyCode.Y, KeyCombination.SHORTCUT_DOWN, KeyCombination.ALT_DOWN, KeyCombination.SHIFT_DOWN), "\u2209"),             //not element of
                entry(new KeyCodeCombination(KeyCode.U, KeyCombination.SHORTCUT_DOWN, KeyCombination.ALT_DOWN, KeyCombination.SHIFT_DOWN), "\u222a"),             //union
                entry(new KeyCodeCombination(KeyCode.I, KeyCombination.SHORTCUT_DOWN, KeyCombination.ALT_DOWN, KeyCombination.SHIFT_DOWN), "\u22c3"),             //big union
                entry(new KeyCodeCombination(KeyCode.O, KeyCombination.SHORTCUT_DOWN, KeyCombination.ALT_DOWN, KeyCombination.SHIFT_DOWN), "\u2229"),             //intersection
                entry(new KeyCodeCombination(KeyCode.P, KeyCombination.SHORTCUT_DOWN, KeyCombination.ALT_DOWN, KeyCombination.SHIFT_DOWN), "\u22c2"),             //big intersection
                entry(new KeyCodeCombination(KeyCode.OPEN_BRACKET, KeyCombination.SHORTCUT_DOWN, KeyCombination.ALT_DOWN, KeyCombination.SHIFT_DOWN), "\u21be"),  //harpoon
                entry(new KeyCodeCombination(KeyCode.CLOSE_BRACKET, KeyCombination.SHORTCUT_DOWN, KeyCombination.ALT_DOWN, KeyCombination.SHIFT_DOWN), "\u2265"), //greater than or equal
                entry(new KeyCodeCombination(KeyCode.BACK_SLASH, KeyCombination.SHORTCUT_DOWN, KeyCombination.ALT_DOWN, KeyCombination.SHIFT_DOWN), "\u2271"),    //not greater than or equal
                entry(new KeyCodeCombination(KeyCode.A, KeyCombination.SHORTCUT_DOWN, KeyCombination.ALT_DOWN, KeyCombination.SHIFT_DOWN), "\u2248"),             //double wave
                entry(new KeyCodeCombination(KeyCode.S, KeyCombination.SHORTCUT_DOWN, KeyCombination.ALT_DOWN, KeyCombination.SHIFT_DOWN), "\u2243"),             //wave above line
                entry(new KeyCodeCombination(KeyCode.D, KeyCombination.SHORTCUT_DOWN, KeyCombination.ALT_DOWN, KeyCombination.SHIFT_DOWN), "\u2245"),             //wave above equals
                entry(new KeyCodeCombination(KeyCode.F, KeyCombination.SHORTCUT_DOWN, KeyCombination.ALT_DOWN, KeyCombination.SHIFT_DOWN), "\u2291"),             //subset
                entry(new KeyCodeCombination(KeyCode.G, KeyCombination.SHORTCUT_DOWN, KeyCombination.ALT_DOWN, KeyCombination.SHIFT_DOWN), "\u228f\u0330"),       //embedding (imperfect combining)
                entry(new KeyCodeCombination(KeyCode.H, KeyCombination.SHORTCUT_DOWN, KeyCombination.ALT_DOWN, KeyCombination.SHIFT_DOWN), "\u227a"),             //set smaller than
                entry(new KeyCodeCombination(KeyCode.J, KeyCombination.SHORTCUT_DOWN, KeyCombination.ALT_DOWN, KeyCombination.SHIFT_DOWN), "\u227a\u0332"),       //elementary submodel (immperfect combining)
                entry(new KeyCodeCombination(KeyCode.K, KeyCombination.SHORTCUT_DOWN, KeyCombination.ALT_DOWN, KeyCombination.SHIFT_DOWN), "\u227e"),             //elementary embedding
                entry(new KeyCodeCombination(KeyCode.L, KeyCombination.SHORTCUT_DOWN, KeyCombination.ALT_DOWN, KeyCombination.SHIFT_DOWN), "\u227c"),             //set less than or equal
                entry(new KeyCodeCombination(KeyCode.SEMICOLON, KeyCombination.SHORTCUT_DOWN, KeyCombination.ALT_DOWN, KeyCombination.SHIFT_DOWN), "\u3008"),     //left angle bracket
                entry(new KeyCodeCombination(KeyCode.QUOTE, KeyCombination.SHORTCUT_DOWN, KeyCombination.ALT_DOWN, KeyCombination.SHIFT_DOWN), "\u3009"),         //right angle bracket
                entry(new KeyCodeCombination(KeyCode.Z, KeyCombination.SHORTCUT_DOWN, KeyCombination.ALT_DOWN, KeyCombination.SHIFT_DOWN), "\u0305"),             //combining overline
                entry(new KeyCodeCombination(KeyCode.X, KeyCombination.SHORTCUT_DOWN, KeyCombination.ALT_DOWN, KeyCombination.SHIFT_DOWN), "\u033f"),             //combining double overline
                entry(new KeyCodeCombination(KeyCode.C, KeyCombination.SHORTCUT_DOWN, KeyCombination.ALT_DOWN, KeyCombination.SHIFT_DOWN), "\u20d7"),             //combining arrow above
                entry(new KeyCodeCombination(KeyCode.V, KeyCombination.SHORTCUT_DOWN, KeyCombination.ALT_DOWN, KeyCombination.SHIFT_DOWN), "\u0302"),             //combining hat
                entry(new KeyCodeCombination(KeyCode.B, KeyCombination.SHORTCUT_DOWN, KeyCombination.ALT_DOWN, KeyCombination.SHIFT_DOWN), "\u0338"),             //combining slash
                entry(new KeyCodeCombination(KeyCode.N, KeyCombination.SHORTCUT_DOWN, KeyCombination.ALT_DOWN, KeyCombination.SHIFT_DOWN), "\u2238"),             //dotminus
                entry(new KeyCodeCombination(KeyCode.M, KeyCombination.SHORTCUT_DOWN, KeyCombination.ALT_DOWN, KeyCombination.SHIFT_DOWN), "\u2224"),             //not factor
                entry(new KeyCodeCombination(KeyCode.COMMA, KeyCombination.SHORTCUT_DOWN, KeyCombination.ALT_DOWN, KeyCombination.SHIFT_DOWN), "\u231c"),         //left corner
                entry(new KeyCodeCombination(KeyCode.PERIOD, KeyCombination.SHORTCUT_DOWN, KeyCombination.ALT_DOWN, KeyCombination.SHIFT_DOWN), "\u231d")        //right corner
     //           entry(new KeyCodeCombination(KeyCode.SLASH, KeyCombination.SHORTCUT_DOWN, KeyCombination.ALT_DOWN, KeyCombination.SHIFT_DOWN), "")                 //none
                );
    }

    public Map<KeyCombination, String> getKeyPressedCharMap() {
        return keyPressedCharMap;
    }
    public Map<Character, String> getKeyTypedCharMap() {
        return keyTypedCharMap;
    }

}
