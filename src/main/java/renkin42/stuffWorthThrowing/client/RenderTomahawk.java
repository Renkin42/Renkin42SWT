package renkin42.stuffWorthThrowing.client;

import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;

import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import renkin42.stuffWorthThrowing.StuffWorthThrowing;
import renkin42.stuffWorthThrowing.entities.EntityTomahawk;

public class RenderTomahawk extends Render {

    private String tomahawkTexture;
    private RenderItem renderItem;

    public RenderTomahawk() {
        super(Minecraft.getMinecraft().getRenderManager());
        shadowSize = 0.5F;
        renderItem = Minecraft.getMinecraft().getRenderItem();
    }

    public void renderTomahawk(EntityTomahawk entity, double velX, double velY, double velZ, float f, float f1) {
        float velTot = (float) MathHelper.sqrt_double(velX * velX + velY * velY + velZ * velZ);
        float pitch = entity.prevRotationPitch + (entity.rotationPitch - entity.prevRotationPitch) * f1;
        float yaw = entity.prevRotationYaw + (entity.rotationYaw - entity.prevRotationYaw) * f1 - 180.0F;
        this.tomahawkTexture = entity.getTomahawkTextureString();
        ItemStack itemStack = entity.getTomahawkItem();
        Tessellator tesselator = Tessellator.getInstance();
        GL11.glPushMatrix();
        this.bindEntityTexture(entity);
        GL11.glTranslatef((float) velX, (float) velY, (float) velZ);
        GL11.glTranslatef(.5f, .5f, .5f);
        GL11.glRotatef(yaw + 90, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(pitch, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-velTot * 50, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-.5f, -.5f, -.5f);
        renderItem.func_180454_a(itemStack, renderItem.getItemModelMesher().getItemModel(itemStack));
        GL11.glPopMatrix();

    }

    @Override
    public void doRender(Entity var1, double var2, double var4, double var6, float var8, float var9) {
        this.renderTomahawk((EntityTomahawk) var1, var2, var4, var6, var8, var9);

    }

    @Override
    protected ResourceLocation getEntityTexture(Entity var1) {
        return new ResourceLocation(StuffWorthThrowing.mod_id, this.tomahawkTexture);
    }

}
