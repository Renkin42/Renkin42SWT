package renkin42.stuffWorthThrowing.client;

import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import renkin42.stuffWorthThrowing.StuffWorthThrowing;
import renkin42.stuffWorthThrowing.entities.EntityThrowableSWT;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderThrowableSWT extends Render {

	private String textureString;
	
	public RenderThrowableSWT() {
            super(Minecraft.getMinecraft().getRenderManager());
	}

	public void renderItem(EntityThrowableSWT entity, double velX, double velY, double velZ, float f, float f1) {
            this.textureString = entity.getTextureString();
            GL11.glPushMatrix();
            GL11.glTranslatef((float)velX, (float)velY, (float)velZ);
            GL11.glEnable(GL12.GL_RESCALE_NORMAL);
            GL11.glScalef(0.5F, 0.5F, 0.5F);
            this.bindEntityTexture(entity);
            Tessellator tessellator = Tessellator.getInstance();
            this.drawItem(tessellator);
            GL11.glDisable(GL12.GL_RESCALE_NORMAL);
            GL11.glPopMatrix();
	}
	
	@Override
	public void doRender(Entity var1, double var2, double var4, double var6, float var8, float var9) {
		renderItem((EntityThrowableSWT)var1, var2, var4, var6, var8, var9);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity var1) {
		return new ResourceLocation(StuffWorthThrowing.mod_id, this.textureString);
	}
	
	private void drawItem(Tessellator tessellator) {
		GL11.glRotatef(180.0F - this.renderManager.playerViewY, 0.0F, 1.0F, 0.0F);
        GL11.glRotatef(-this.renderManager.playerViewX, 1.0F, 0.0F, 0.0F);
        WorldRenderer worldRenderer = tessellator.getWorldRenderer();
        worldRenderer.startDrawingQuads();
        worldRenderer.func_178980_d(0.0F, 1.0F, 0.0F); //Set Normal
        worldRenderer.addVertexWithUV(-0.5D, -0.25D, 0.0D, 0.0D, 1.0D);
        worldRenderer.addVertexWithUV(0.5D, -0.25D, 0.0D, 1.0D, 1.0D);
        worldRenderer.addVertexWithUV(0.5D, 0.75D, 0.0D, 1.0D, 0.0D);
        worldRenderer.addVertexWithUV(-0.5D, 0.75D, 0.0D, 0.0D, 0.0D);
        tessellator.draw();
	}

}
