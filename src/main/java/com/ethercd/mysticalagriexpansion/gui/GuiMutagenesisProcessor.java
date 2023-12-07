package com.ethercd.mysticalagriexpansion.gui;

import com.ethercd.mysticalagriexpansion.MysticalAgriexpansion;
import com.ethercd.mysticalagriexpansion.te.mutagenesis.TileEntityMutagenesisProcessor;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.translation.I18n;
import org.lwjgl.opengl.GL11;

@SuppressWarnings("deprecation")
public class GuiMutagenesisProcessor extends GuiContainer {
    private static final ResourceLocation GUI = new ResourceLocation(MysticalAgriexpansion.MOD_ID, "textures/gui/mutagenesis_processor_gui.png");
    private final TileEntityMutagenesisProcessor te;

    public GuiMutagenesisProcessor(InventoryPlayer player, TileEntityMutagenesisProcessor machine){
        super(new ContainerMutagenesisProcessor(player, machine));
        te = machine;
        this.xSize = 176;
        this.ySize = 183;
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks){
        this.drawDefaultBackground();
        super.drawScreen(mouseX, mouseY, partialTicks);
        this.renderHoveredToolTip(mouseX, mouseY);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int p_146979_1_, int p_146979_2_){
        String s = I18n.translateToLocal("container.mutagenesis_processor.name");
        this.fontRenderer.drawString(s, this.xSize / 2 - this.fontRenderer.getStringWidth(s) / 2, 6, 4210752);
        this.fontRenderer.drawString(I18n.translateToLocal("container.inventory"), 8, this.ySize - 96 + 2, 4210752);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(GUI);
        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);

//        int i1 = this.getFuelBarScaled(66);
//        this.drawTexturedModalRect(k + 20, l + 84 - i1, 176, 97 - i1, 15, i1);

        if (this.te.getProgress() > 0) {
            int i2 = this.getCookProgressScaled(24);
            this.drawTexturedModalRect(k + 76, l + 42, 176, 14, i2 + 1, 16);
        }
    }

    @Override
    protected void renderHoveredToolTip(int mouseX, int mouseY) {
        super.renderHoveredToolTip(mouseX, mouseY);

//        if (mouseX > this.guiLeft + 19 && mouseX < this.guiLeft + 29 && mouseY > this.guiTop + 17 && mouseY < this.guiTop + 84) {
//            this.drawHoveringText(Utils.format(this.machine.getFuel()) + " / " + Utils.format(this.machine.getFuelCapacity()), mouseX, mouseY);
//        }

//        if (this.machine.getFuelLeft() > 0) {
//            if (mouseX > this.guiLeft + 36 && mouseX < this.guiLeft + 50 && mouseY > this.guiTop + 33 && mouseY < this.guiTop + 47) {
//                this.drawHoveringText(Utils.format(this.machine.getFuelLeft()), mouseX, mouseY);
//            }
//        }
    }

    private int getCookProgressScaled(int pixels) {
        int i = this.te.getProgress();
        int j = this.te.getOperationTime();
        return j != 0 && i != 0 ? i * pixels / j : 0;
    }
}
