package ru.artem.alaverdyan.consoleextended;

import ru.artem.alaverdyan.PlusicAPI;
import ru.artem.alaverdyan.PlusicMod;
import ru.artem.alaverdyan.consoleextended.buttons.Button_ExecuteCommand;
import ru.artem.alaverdyan.consoleextended.mixins.ConsoleMixin;

public class ConsoleExtended extends PlusicMod {
    @Override
    public void preInit() {
        PlusicAPI.registerClass(Button_ExecuteCommand.class, this);
        PlusicAPI.registerMixin(ConsoleMixin.class);
    }
}