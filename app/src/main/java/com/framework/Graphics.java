package com.framework;

public interface Graphics {
    public static enum PixmapFormat {
        ARGB8888, ARGB4444, RGB565
    }

    public Pixmap newPixmap(String fileName, PixmapFormat format);

    public void clear(int color);

    public void drawPixel(int x, int y, int color);

    public void drawLine(int x, int y, int x2, int y2, int color);

    public void drawText(String text, int fontSize, int textColor);

    public void drawRect(int x, int y, int width, int height, int color);

    public void drawRectWithText(int x, int y, int width, int height, int color, String text, int textColor);

    public void myDrawRect(int x, int y, int width, int height, int color);

    public void drawPixmap(Pixmap pixmap, int x, int y, int srcX, int srcY,
                           int srcWidth, int srcHeight);

    public void drawPixmap(Pixmap pixmap, int x, int y);

    public void drawPixmap(Pixmap pixmap, int x, int y, int weight, int height);

    public int getWidth();

    public int getHeight();
}
