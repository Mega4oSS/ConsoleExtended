package ru.artem.alaverdyan.consoleextended.buttons;


import aoh.kingdoms.history.mainGame.CFG;
import aoh.kingdoms.history.mainGame.Game;
import aoh.kingdoms.history.mainGame.SoundsManager;
import aoh.kingdoms.history.menu.Colors;
import aoh.kingdoms.history.menu_element.button.ButtonIcon;
import aoh.kingdoms.history.menu_element.menuElementHover.*;
import aoh.kingdoms.history.menusInGame.InGame_Console;

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
