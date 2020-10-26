package com.igor1c.portfolio.helpers;

public class HtmlHelper {
    public static String processHtmlString(String inputString) {
        StringBuffer sb = new StringBuffer();

        int listLevel = 0;
        int currentListLevel = 0;

        String lines[] = inputString.split("\n");
        String s;

        for (int i = 0; i < lines.length; i++) {
            s = lines[i];

            currentListLevel = processListLevelChange(sb, s, currentListLevel, listLevel);
            listLevel = currentListLevel;

            if (currentListLevel > 0) {
                sb.append("<li>").append(s.substring(currentListLevel)).append("</li>").append("\n");
            } else if (s.equals("")) {
                sb.append("<br/>");
            } else if (s.equals("<hr/>")) {
                sb.append("<hr/>");
            } else {
                sb.append("<p>").append(s).append("</p>").append("\n");
            }
        }

        return sb.toString();
    }

    private static int processListLevelChange(StringBuffer sb, String s, int currentListLevel, int listLevel) {
        currentListLevel = getListLevel(s);
        if (currentListLevel > listLevel) {
            openList(sb, currentListLevel - listLevel);
        }
        if (listLevel > currentListLevel) {
            closeList(sb, listLevel - currentListLevel);
        }

        return currentListLevel;
    }

    private static int getListLevel(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '*') {
                return i;
            }
        }

        return 0;
    }

    private static void openList(StringBuffer sb, int levels) {
        appendLine(sb, "<ul>", levels);
    }

    private static void closeList(StringBuffer sb, int levels) {
        appendLine(sb, "</ul>", levels);
    }

    private static void appendLine(StringBuffer sb, String line, int times) {
        for (int i = 0; i < times; i++) {
            appendLine(sb, line);
        }
    }

    private static void appendLine(StringBuffer sb, String line) {
        sb.append(line).append("\n");
    }
}
