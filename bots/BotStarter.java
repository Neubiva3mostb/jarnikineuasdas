package bots;

import bots.connection.BotClientLoginNetHandler;
import bots.connection.BotNetwork;
import com.mojang.authlib.GameProfile;
import java.net.InetAddress;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.network.ProtocolType;
import net.minecraft.network.handshake.client.CHandshakePacket;
import net.minecraft.network.login.client.CLoginStartPacket;

public class BotStarter {
   public static void run(String string, String ip) {
      (new Thread(() -> {
         try {
            GameProfile gameProfile = new GameProfile(null, string);
            BotNetwork botNetwork = BotNetwork.createNetworkManagerAndConnect(InetAddress.getByName(ip), 25565, false);
            BotManager.pendingNetworks.add(botNetwork);
            botNetwork.setNetHandler(new BotClientLoginNetHandler(botNetwork, Minecraft.getInstance(), (Screen)null, (status) -> {
            }, string));
            botNetwork.sendPacket(new CHandshakePacket(ip, 25565, ProtocolType.LOGIN));
            Thread.sleep(500L);
            botNetwork.sendPacket(new CLoginStartPacket(gameProfile));
         } catch (Exception var4) {
            var4.printStackTrace();
         }

      })).start();
   }

   public static void run(String string, String ip, int port) {
      (new Thread(() -> {
         try {
            GameProfile gameProfile = new GameProfile(null, string);
            BotNetwork botNetwork = BotNetwork.createNetworkManagerAndConnect(InetAddress.getByName(ip), port, false);
            BotManager.pendingNetworks.add(botNetwork);
            botNetwork.setNetHandler(new BotClientLoginNetHandler(botNetwork, Minecraft.getInstance(), (Screen)null, (status) -> {
            }, string));
            botNetwork.sendPacket(new CHandshakePacket(ip, port, ProtocolType.LOGIN));
            Thread.sleep(500L);
            botNetwork.sendPacket(new CLoginStartPacket(gameProfile));
         } catch (Exception var5) {
            var5.printStackTrace();
         }

      })).start();
   }
}
