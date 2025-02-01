package kc.entityvis;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import org.lwjgl.input.Keyboard;

public class Keybinds
{
    public static KeyBinding toggleCornering;

    public static void register()
    {
        toggleCornering = new KeyBinding("Entity Visibility", Keyboard.KEY_Y, "Entity Visibility");
 
        ClientRegistry.registerKeyBinding(toggleCornering);
       
    }
}