package renkin42.stuffWorthThrowing.client;

import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import renkin42.stuffWorthThrowing.CommonProxy;
import renkin42.stuffWorthThrowing.StuffWorthThrowingConfig;
import renkin42.stuffWorthThrowing.entities.EntityCorruptedSoul;
import renkin42.stuffWorthThrowing.entities.EntityDynamite;
import renkin42.stuffWorthThrowing.entities.EntityDynamiteSnowball;
import renkin42.stuffWorthThrowing.entities.EntityHateMail;
import renkin42.stuffWorthThrowing.entities.EntityHelpfulSoul;
import renkin42.stuffWorthThrowing.entities.EntityLoveLetter;
import renkin42.stuffWorthThrowing.entities.EntityPurifiedSoul;
import renkin42.stuffWorthThrowing.entities.EntitySnowballRock;
import renkin42.stuffWorthThrowing.entities.EntityThrowableSWT;
import renkin42.stuffWorthThrowing.entities.EntityTomahawk;
import renkin42.stuffWorthThrowing.entities.EntityTorturedSoul;
import renkin42.stuffWorthThrowing.items.StuffWorthThrowingItems;
import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;

public class ClientProxy extends CommonProxy {
	Item thrownSnowballRock;
	Item thrownDynamiteSnowball;
	
	@Override
    public void registerRenderers() {
            if (StuffWorthThrowingConfig.sneakySnowballs) {
            	thrownSnowballRock = Items.snowball;
            	thrownDynamiteSnowball = Items.snowball;
            } else {
            	thrownSnowballRock = StuffWorthThrowingItems.snowballRock;
            	thrownDynamiteSnowball = StuffWorthThrowingItems.dynamiteSnowball;
            }
            
            RenderManager renderManager = Minecraft.getMinecraft().getRenderManager();
            RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
            
            RenderingRegistry.registerEntityRenderingHandler(EntitySnowballRock.class, new RenderSnowball(renderManager, thrownSnowballRock, renderItem));
            RenderingRegistry.registerEntityRenderingHandler(EntityDynamite.class, new RenderDynamite());
            RenderingRegistry.registerEntityRenderingHandler(EntityDynamiteSnowball.class, new RenderSnowball(renderManager, thrownDynamiteSnowball, renderItem));
            RenderingRegistry.registerEntityRenderingHandler(EntityPurifiedSoul.class, new RenderSnowball(renderManager, StuffWorthThrowingItems.purifiedSoul, renderItem));
            RenderingRegistry.registerEntityRenderingHandler(EntityLoveLetter.class, new RenderPlane("loveLetter"));
            RenderingRegistry.registerEntityRenderingHandler(EntityHateMail.class, new RenderPlane("hateMail"));
            RenderingRegistry.registerEntityRenderingHandler(EntityTorturedSoul.class, new RenderTorturedSoul("torturedSoul"));
            RenderingRegistry.registerEntityRenderingHandler(EntityCorruptedSoul.class, new RenderTorturedSoul("corruptedSoul"));
            RenderingRegistry.registerEntityRenderingHandler(EntityHelpfulSoul.class, new RenderTorturedSoul("helpfulSoul"));
            RenderingRegistry.registerEntityRenderingHandler(EntityTomahawk.class, new RenderTomahawk());
            RenderingRegistry.registerEntityRenderingHandler(EntityThrowableSWT.class, new RenderThrowableSWT());
            
    }

}
