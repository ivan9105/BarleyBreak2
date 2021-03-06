package com.barleybreak.screen;

import com.barleybreak.screen.help.HelpScreen;
import com.barleybreak.util.Assets;
import com.barleybreak.util.Settings;
import com.framework.Game;
import com.framework.Screen;
import com.framework.Graphics;
import com.framework.Input.TouchEvent;
import com.framework.Input.KeyEvent;

import java.util.List;

/**
 * Created by Иван on 02.06.2015.
 */
public class MainMenuScreen extends Screen {
    public MainMenuScreen(Game game) {
        super(game);
    }

    @Override
    public void update(float deltaTime) {
        Graphics g = game.getGraphics();
        List<TouchEvent> touchEvents = game.getInput().getTouchEvents();
        List<KeyEvent> keyEvents = game.getInput().getKeyEvents();

        int len = touchEvents.size();
        for (int i = 0; i < len; i++) {
            TouchEvent event = touchEvents.get(i);
            if (inBounds(event, 0, g.getHeight() - 64, 64, 64)) {
                Settings.soundEnabled = !Settings.soundEnabled;
                if (Settings.soundEnabled)
                    Assets.click.play(1);
            }
            if (inBounds(event, 64, 180, 192, 60)) {
                game.setScreen(new GameScreen(game));
                if (Settings.soundEnabled)
                    Assets.click.play(1);
                return;
            }
            if (inBounds(event, 64, 180 + 60, 192, 60)) {
                game.setScreen(new HighscoreScreen(game));
                if (Settings.soundEnabled)
                    Assets.click.play(1);
                return;
            }
            if (inBounds(event, 64, 180 + 120, 192, 60)) {
                game.setScreen(new HelpScreen(game));
                if (Settings.soundEnabled)
                    Assets.click.play(1);
                return;
            }
            if (inBounds(event, 64, 180 + 180, 192, 60)) {
                game.exit();
            }
        }
    }

    @Override
    public void present(float deltaTime) {
        Graphics g = game.getGraphics();

        g.drawPixmap(Assets.background, 0, 0);
        g.drawPixmap(Assets.logo, 32, 20);
        g.drawPixmap(Assets.mainMenu, 64, 180);
        if (Settings.soundEnabled)
            g.drawPixmap(Assets.buttons, 0, 416, 0, 0, 64, 64);
        else
            g.drawPixmap(Assets.buttons, 0, 416, 64, 0, 64, 64);
    }

    @Override
    public void pause() {
        Settings.save(game.getFileIO());
    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }

    private boolean inBounds(TouchEvent event, int x, int y, int width, int height) {
        if (event.x > x && event.x < x + width - 1 &&
                event.y > y && event.y < y + height - 1) {
            return true;
        } else {
            return false;
        }
    }
}
