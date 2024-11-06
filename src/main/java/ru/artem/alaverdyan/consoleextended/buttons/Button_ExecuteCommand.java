package ru.artem.alaverdyan.consoleextended.buttons;

import aoc.kingdoms.lukasz.jakowski.CFG;
import aoc.kingdoms.lukasz.jakowski.Game;
import aoc.kingdoms.lukasz.jakowski.GameValues;
import aoc.kingdoms.lukasz.jakowski.SoundsManager;
import aoc.kingdoms.lukasz.menu.Colors;
import aoc.kingdoms.lukasz.menu_element.button.ButtonIcon;
import aoc.kingdoms.lukasz.menu_element.menuElementHover.*;
import aoc.kingdoms.lukasz.menusInGame.InGame_Console;
import aoc.kingdoms.lukasz.textures.Images;

import java.util.ArrayList;
import java.util.List;

public class Button_ExecuteCommand extends ButtonIcon {
    private String executable;
    public Button_ExecuteCommand(String sText, int imageID, int nPosX, int nPosY, int nWidth, int nHeight, String executable) {
        super(sText, imageID, nPosX, nPosY, nWidth, nHeight);
        this.executable = executable;
    }

    public void actionElement() {
        InGame_Console.execute(executable);
        Game.menuManager.rebuildInGame_Console();
    }

    public void buildElementHover() {
        List<MenuElement_HoverElement> nElements = new ArrayList();
        List<MenuElement_HoverElement_Type> nData = new ArrayList();
        nData.add(new MenuElement_HoverElement_Type_TextTitle_BG(Game.lang.get("Execute command: " + executable), CFG.FONT_BOLD, Colors.HOVER_GOLD));
        nData.add(new MenuElement_HoverElement_Type_ImageTitle_BG(this.getImageID(), CFG.PADDING, 0));
        nElements.add(new MenuElement_HoverElement(nData));
        nData.clear();
        this.menuElementHover = new MenuElement_Hover(nElements, true);
    }

    public int getSFX() {
        return SoundsManager.getClickSound_CivOptions();
    }
}
