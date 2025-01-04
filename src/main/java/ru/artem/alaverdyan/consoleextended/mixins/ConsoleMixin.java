package ru.artem.alaverdyan.consoleextended.mixins;

import aoh.kingdoms.history.mainGame.CFG;
import aoh.kingdoms.history.mainGame.GameValues;
import aoh.kingdoms.history.menu_element.MenuElement;
import aoh.kingdoms.history.textures.Images;
import ru.artem.alaverdyan.Mixin;
import ru.artem.alaverdyan.consoleextended.buttons.Button_ExecuteCommand;
import ru.artem.alaverdyan.injections.At;
import ru.artem.alaverdyan.injections.Inject;
import ru.artem.alaverdyan.injections.ReturnTo;

import java.util.List;

@Mixin(value = "aoh.kingdoms.history.menusInGame.InGame_Console")
public class ConsoleMixin {
    @Inject(method = "InGame_Console", constructorParameters = {boolean.class}, at = @At(value = "BY", by = 64), returnTo = @ReturnTo(to = "buttonY"))
    public int injected(List<MenuElement> menuElements, int paddingLeft, int buttonY, int menuWidth) {
        int butY = buttonY;
        menuElements.add(new Button_ExecuteCommand("", Images.gold, paddingLeft, butY, (menuWidth / 4) - paddingLeft * 2, CFG.BUTTON_HEIGHT2, GameValues.console.CONSOLE_COMMAND_GOLD));
        menuElements.add(new Button_ExecuteCommand("", Images.legacy, paddingLeft + (menuWidth / 4), butY, (menuWidth / 4) - paddingLeft * 2, CFG.BUTTON_HEIGHT2, GameValues.console.CONSOLE_COMMAND_LEGACY));
        menuElements.add(new Button_ExecuteCommand("", Images.manpower, paddingLeft + ((menuWidth / 4) * 2), butY, (menuWidth / 4) - paddingLeft * 2, CFG.BUTTON_HEIGHT2, GameValues.console.CONSOLE_COMMAND_MANPOWER));
        menuElements.add(new Button_ExecuteCommand("", Images.nuke, paddingLeft + ((menuWidth / 4) * 3), butY, (menuWidth / 4) - paddingLeft * 2, CFG.BUTTON_HEIGHT2, GameValues.console.CONSOLE_COMMAND_NUKE));
        butY += (menuElements.get(menuElements.size() - 1)).getHeight() + CFG.PADDING * 2;
        menuElements.add(new Button_ExecuteCommand("", Images.revolutionRisk, paddingLeft, butY, (menuWidth / 4) - paddingLeft * 2, CFG.BUTTON_HEIGHT2, GameValues.console.CONSOLE_COMMAND_EXPLODE));
        menuElements.add(new Button_ExecuteCommand("", Images.skull, paddingLeft + (menuWidth / 4), butY, (menuWidth / 4) - paddingLeft * 2, CFG.BUTTON_HEIGHT2, GameValues.console.CONSOLE_COMMAND_KILL_RULER));
        menuElements.add(new Button_ExecuteCommand("", Images.diplomacy, paddingLeft + ((menuWidth / 4) * 2), butY, (menuWidth / 4) - paddingLeft * 2, CFG.BUTTON_HEIGHT2, GameValues.console.CONSOLE_COMMAND_DIPLOMACY));
        menuElements.add(new Button_ExecuteCommand("", Images.advantages, paddingLeft + ((menuWidth / 4) * 3), butY, (menuWidth / 4) - paddingLeft * 2, CFG.BUTTON_HEIGHT2, GameValues.console.CONSOLE_COMMAND_ADVANTAGE));
        butY += (menuElements.get(menuElements.size() - 1)).getHeight() + CFG.PADDING * 2;
        return butY;
    }
}
