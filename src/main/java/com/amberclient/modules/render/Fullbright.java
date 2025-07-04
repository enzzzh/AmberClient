package com.amberclient.modules.render;

import com.amberclient.utils.Module;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;

public class Fullbright extends Module {
    private static final MinecraftClient mc = MinecraftClient.getInstance();
    private double originalGamma = 1.0D;
    public static double fullbrightGamma = 10.0D;

    public Fullbright() {
        super("Fullbright", "Maximizes brightness", "Render");
    }

    @Override
    protected void onEnable() {
        if (mc.options != null) {
            originalGamma = mc.options.getGamma().getValue();
            mc.options.getGamma().setValue(fullbrightGamma);
        }
        if (mc.player != null) {
            mc.player.sendMessage(
                    Text.literal("§4[§cAmberClient§4] §c§l" + getName() + " §r§cenabled"), true);
        }
    }

    @Override
    protected void onDisable() {
        if (mc.options != null) {
            mc.options.getGamma().setValue(originalGamma);
        }
        if (mc.player != null) {
            mc.player.sendMessage(
                    Text.literal("§4[§cAmberClient§4] §c§l" + getName() + " §r§cdisabled"), true);
        }
    }
}