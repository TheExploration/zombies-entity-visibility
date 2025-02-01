package kc.entityvis;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityArmorStand;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.scoreboard.Score;
import net.minecraft.scoreboard.ScoreObjective;
import net.minecraft.scoreboard.ScorePlayerTeam;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.common.network.FMLNetworkEvent;
import net.minecraftforge.fml.relauncher.ReflectionHelper;
import org.lwjgl.opengl.GL11;

import java.lang.reflect.Field;
import java.util.*;

public class EventListener {

    public static volatile boolean ZHFState = false;


    @SubscribeEvent
    public void onKeyInput(InputEvent.KeyInputEvent event)
    {
        if (Keybinds.toggleCornering.isPressed())
        {
            ZHFState = !ZHFState;
            Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("Toggled Entity Visibility to "+(ZHFState ? "on" : "off")));
        }

    }


    
    @SubscribeEvent
    public void onRenderLiving(RenderLivingEvent.Pre event) {
        if(ZHFState && event.entity != null) {
            double distSq = event.entity.getDistanceSqToEntity(Minecraft.getMinecraft().thePlayer);
            if (distSq < 2.25) {
                event.setCanceled(true);
            }
        }
    }

}
