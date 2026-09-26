package bots;

import bots.connection.BotNetwork;
import bots.impl.BotTapeMouse;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class BotManager {
   public static List<Bot> allBots = new CopyOnWriteArrayList();
   public static List<Bot> xyesosBots = new CopyOnWriteArrayList();
   public static List<BotTapeMouse> tapeMouseBots = new CopyOnWriteArrayList();
   public static List<BotNetwork> pendingNetworks = new CopyOnWriteArrayList();
}
