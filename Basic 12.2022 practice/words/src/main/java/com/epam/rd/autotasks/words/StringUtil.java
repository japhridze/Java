package com.epam.rd.autotasks.words;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class StringUtil {
    public static int countEqualIgnoreCaseAndSpaces(String[] words, String sample) {
        if (sample == null || words == null || words.length == 0) {
            return 0;
        }

        int count = 0;
        sample = sample.trim();

        for (String word : words) {
            if (word == null || word.trim().isEmpty()) {
                continue;
            }
            if (word.trim().equalsIgnoreCase(sample)) {
                count++;
            }
        }

        return count;
    }

    public static String[] splitWords(String text) {
        if (text == null || text.isEmpty()) {
            return null;
        }

        String[] components = text.split("[,.;:?!\\s]+");

        List<String> wordsList = new ArrayList<>();

        for (String component : components) {
            if (!component.isEmpty()) {
                wordsList.add(component);
            }
        }

        if (wordsList.isEmpty()) {
            return null;
        }

        return wordsList.toArray(new String[0]);
    }

    public static String convertPath(String path, boolean toWin) {

        if (path == null || path.isEmpty()) {
            return null;
        }

        if (path.contains("C:") && path.indexOf("C:") != path.lastIndexOf("C:") ||
                path.contains("~") && path.indexOf("~") != path.lastIndexOf("~") ||
                path.contains("~") && path.indexOf("~") != 0 ||
                path.contains("/") && path.contains("\\") ||
                path.contains("~") && path.contains("\\") ||
                path.contains("//")) {
            return null;
        }


        boolean isUnixPath = path.startsWith("dir/") || path.startsWith("../") || path.startsWith("/") || path.startsWith("~") || !path.contains("\\");
        boolean isWindowsPath = path.startsWith("dir\\") || path.startsWith("..\\") || path.matches("[A-Za-z]:\\\\.*") || path.matches("[A-Za-z]:.*");

        System.out.println("is uxix? " + isUnixPath);
        System.out.println("is windows? " + isWindowsPath);


        if (!isUnixPath && !isWindowsPath) {
            return null;
        }

        if ((toWin && isWindowsPath) || (!toWin && isUnixPath)) {
            return path;
        }

        if (toWin) {
            if (path.startsWith("/") && path.length() > 1) {
                path = "C:" + path;
            }
            if (path.startsWith("/")&& path.length() == 1) {
                path = "C:/";
            }
            if (path.startsWith("~")) {
                path = path.replaceFirst("~", "C:\\\\User");
            }
            path = path.replace("/", "\\");
            path = path.replaceAll("/\\.\\.", "\\\\");
            path = path.replaceAll("(?<!\\\\)/(?!$)", "\\\\");
            path = path.replaceAll("\\\\{2,}", "\\\\");
        }

        if (!toWin) {
            if (path.startsWith("C:\\User")) {
                path = path.replaceFirst("C:\\\\User", "~");
            }
            if (path.startsWith("C:")) {
                path = path.replaceFirst("C:", "");
            }
            path = path.replace("\\", "/");
            path = path.replaceAll("\\\\.\\.", "/");
            path = path.replaceAll("(?<!/)/(?!$)", "/");
            path = path.replaceAll("/{2,}", "/");
        }

        return path;
    }

    public static String joinWords(String[] words) {
        if (words == null || words.length == 0) {
            return null;
        }

        StringJoiner joiner = new StringJoiner(", ", "[", "]");
        for (String word : words) {
            if (!word.isEmpty()) {
                joiner.add(word);
            }
        }

        if (joiner.length() == 2) {
            return null;
        }

        return joiner.toString();
    }

    public static void main(String[] args) {
        System.out.println("Test 1: countEqualIgnoreCaseAndSpaces");
        String[] words = new String[]{" WordS    \t", "words", "w0rds", "WOR  DS", };
        String sample = "words   ";
        int countResult = countEqualIgnoreCaseAndSpaces(words, sample);
        System.out.println("Result: " + countResult);
        int expectedCount = 2;
        System.out.println("Must be: " + expectedCount);

        System.out.println("Test 2: splitWords");
        String text = "   ,, first, second!!!! third";
        String[] splitResult = splitWords(text);
        System.out.println("Result : " + Arrays.toString(splitResult));
        String[] expectedSplit = new String[]{"first", "second", "third"};
        System.out.println("Must be: " + Arrays.toString(expectedSplit));

        System.out.println("Test 3: convertPath");
        String unixPath = "/some/unix/path";
        String convertResult = convertPath(unixPath, true);
        System.out.println("Result: " + convertResult);
        String expectedWinPath = "C:\\some\\unix\\path";
        System.out.println("Must be: " + expectedWinPath);

        System.out.println("Test 4: joinWords");
        String[] toJoin = new String[]{"go", "with", "the", "", "FLOW"};
        String joinResult = joinWords(toJoin);
        System.out.println("Result: " + joinResult);
        String expectedJoin = "[go, with, the, FLOW]";
        System.out.println("Must be: " + expectedJoin);
    }
}