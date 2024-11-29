package com.example.shaitantaxi;

public class Region {
    private char x;
    private int y;

    public Region(char x, int y) {
        this.x = x;
        this.y = y;
    }

    public char getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public static Region fromString(String region) {
        if (region.length() < 2 || region.length() > 3) {
            throw new IllegalArgumentException("Invalid region format");
        }
        char x = region.charAt(0);
        int y = Integer.parseInt(region.substring(1));
        return new Region(x, y);
    }

    public static boolean isValidRegion(String region) {
        if (region.length() < 2 || region.length() > 3) {
            return false;
        }
        char x = region.charAt(0);
        if (x < 'A' || x > 'P') {
            return false;
        }
        try {
            int y = Integer.parseInt(region.substring(1));
            return y >= 0 && y <= 30;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Override
    public String toString() {
        return "" + x + y;
    }
}
