package renkin42.stuffWorthThrowing.client;

import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import renkin42.stuffWorthThrowing.CommonProxy;
import renkin42.stuffWorthThrowing.StuffWorthThrowingConfig;
import renkin42.stuffWorthThrowing.entities.EntityBrokenBrick;
import renkin42.stuffWorthThrowing.entities.EntityBrokenCSBrick;
import renkin42.stuffWorthThrowing.entities.EntityBrokenNetherBrick;
import renkin42.stuffWorthThrowing.entities.EntityBrokenSpectralBrick;
import renkin42.stuffWorthThrowing.entities.EntityCorruptedSoul;
import renkin42.stuffWorthThrowing.entities.EntityDynamite;
import renkin42.stuffWorthThrowing.entities.EntityDynamiteSnowball;
import renkin42.stuffWorthThrowing.entities.EntityFungusSpore;
import renkin42.stuffWorthThrowing.entities.EntityHateMail;
import renkin42.stuffWorthThrowing.entities.EntityHelpfulSoul;
import renkin42.stuffWorthThrowing.entities.EntityLoveLetter;
import renkin42.stuffWorthThrowing.entities.EntityPurifiedSoul;
import renkin42.stuffWorthThrowing.entities.EntityRock;
import renkin42.stuffWorthThrowing.entities.EntitySandPile;
import renkin42.stuffWorthThrowing.entities.EntityShineDust;
import renkin42.stuffWorthThrowing.entities.EntitySnowballRock;
import renkin42.stuffWorthThrowing.entities.EntitySoulSandPile;
import renkin42.stuffWorthThrowing.entities.EntitySwiftDust;
import renkin42.stuffWorthThrowing.entities.EntityTomahawk;
import renkin42.stuffWorthThrowing.entities.EntityTorturedSoul;
import renkin42.stuffWorthThrowing.items.StuffWorthThrowingItems;
import cpw.mods.fml.client.registry.RenderingRegistry;

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
            
            RenderingRegistry.registerEntityRenderingHandler(EntitySandPile.class, new RenderSnowball(StuffWorthThrowingItems.sandPile));
            RenderingRegistry.registerEntityRenderingHandler(EntitySoulSandPile.class, new RenderSnowball(StuffWorthThrowingItems.soulSandPile));
            RenderingRegistry.registerEntityRenderingHandler(EntityRock.class, new RenderSnowball(StuffWorthThrowingItems.rock));
            RenderingRegistry.registerEntityRenderingHandler(EntitySnowballRock.class, new RenderSnowball(thrownSnowballRock));
            RenderingRegistry.registerEntityRenderingHandler(EntityBrokenBrick.class, new RenderSnowball(StuffWorthThrowingItems.brokenBrick));
            RenderingRegistry.registerEntityRenderingHandler(EntityBrokenNetherBrick.class, new RenderSnowball(StuffWorthThrowingItems.brokenNetherBrick));
            RenderingRegistry.registerEntityRenderingHandler(EntityBrokenSpectralBrick.class, new RenderSnowball(StuffWorthThrowingItems.brokenSpectralBrick));
            RenderingRegistry.registerEntityRenderingHandler(EntityDynamite.class, new RenderDynamite());
            RenderingRegistry.registerEntityRenderingHandler(EntityDynamiteSnowball.class, new RenderSnowball(thrownDynamiteSnowball));
            RenderingRegistry.registerEntityRenderingHandler(EntityFungusSpore.class, new RenderSnowball(StuffWorthThrowingItems.fungusSpore));
            RenderingRegistry.registerEntityRenderingHandler(EntityPurifiedSoul.class, new RenderSnowball(StuffWorthThrowingItems.purifiedSoul));
            RenderingRegistry.registerEntityRenderingHandler(EntityBrokenCSBrick.class, new RenderSnowball(StuffWorthThrowingItems.brokenCSBrick));
            RenderingRegistry.registerEntityRenderingHandler(EntitySwiftDust.class, new RenderSnowball(StuffWorthThrowingItems.swiftDust));
            RenderingRegistry.registerEntityRenderingHandler(EntityShineDust.class, new RenderSnowball(StuffWorthThrowingItems.shineDust));
            RenderingRegistry.registerEntityRenderingHandler(EntityLoveLetter.class, new RenderPlane("loveLetter"));
            RenderingRegistry.registerEntityRenderingHandler(EntityHateMail.class, new RenderPlane("hateMail"));
            RenderingRegistry.registerEntityRenderingHandler(EntityTorturedSoul.class, new RenderTorturedSoul("torturedSoul"));
            RenderingRegistry.registerEntityRenderingHandler(EntityCorruptedSoul.class, new RenderTorturedSoul("corruptedSoul"));
            RenderingRegistry.registerEntityRenderingHandler(EntityHelpfulSoul.class, new RenderTorturedSoul("helpfulSoul"));
            RenderingRegistry.registerEntityRenderingHandler(EntityTomahawk.class, new RenderTomahawk());
            
    }

}
