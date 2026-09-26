package bots;

import bots.connection.BotClientPlayNetHandler;
import bots.connection.BotNetwork;
import bots.player.BotController;
import bots.player.BotPlayer;
import bots.world.BotWorld;

public class Bot {
   public BotNetwork networkManager;
   public BotWorld botWorld;
   public BotPlayer botPlayer;
   public BotController botController;
   public BotClientPlayNetHandler connection;
   public boolean collected;
   public boolean codesCollected;
   public long lastTimeCollected = 0L;

   public Bot(BotNetwork botNetwork, BotWorld botWorld, BotPlayer botPlayer, BotController botController, BotClientPlayNetHandler botClientPlayNetHandler) {
      this.networkManager = botNetwork;
      this.botWorld = botWorld;
      this.botPlayer = botPlayer;
      this.botController = botController;
      this.connection = botClientPlayNetHandler;
   }
}
