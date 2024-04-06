package fr.univlille.info.G3.utils;

import fr.univlille.iutinfo.cam.player.perception.ICellEvent.CellInfo;

public class Utils {
    
    public static int addition(int x, int y) {
        return x + y;
    }

    public static char getCellChar(CellInfo cellInfo) {
        if(cellInfo == null) {
            return '?';
        }
        switch (cellInfo) {
            case EMPTY:
                return ' ';
            case HUNTER:
                return 'H';
            case MONSTER:
                return 'M';
            case WALL:
                return '#';
            case EXIT:
                return '*';
        }
        return '¢';
    }
}
