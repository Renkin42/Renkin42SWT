package renkin42.stuffWorthThrowing;

import renkin42.stuffWorthThrowing.blocks.StuffWorthThrowingBlocks;
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
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.relauncher.Side;
import net.minecraftforge.common.config.Configuration;

@Mod(modid = StuffWorthThrowing.MOD_ID, version = StuffWorthThrowing.VERSION)
public class StuffWorthThrowing {

    public static final String MOD_ID = "renkin42swt";
    public static final String VERSION = "1710.1180.2.0";

    static int startEntityId = 256;

    public static Configuration config;

    // The instance of your mod that Forge uses.
    @Instance("renkin42swt")
    public static StuffWorthThrowing instance;

    // Says where the client and server 'proxy' code is loaded.
    @SidedProxy(clientSide = "renkin42.stuffWorthThrowing.client.ClientProxy", serverSide = "renkin42.stuffWorthThrowing.CommonProxy")
    public static CommonProxy proxy;

    @EventHandler
    @SuppressWarnings("ResultOfObjectAllocationIgnored")
    public void preInit(FMLPreInitializationEvent event) {
        config = new Configuration(event.getSuggestedConfigurationFile());

        new StuffWorthThrowingConfig();
        StuffWorthThrowingItems.registerItems();
        new StuffWorthThrowingBlocks();
    }

    @EventHandler
    @SuppressWarnings("ResultOfObjectAllocationIgnored")
    public void load(FMLInitializationEvent event) {
        
        if (event.getSide() == Side.CLIENT) {
            StuffWorthThrowingItems.registerItemModels();
        }

        new StuffWorthThrowingRecipes();

        EntityRegistry.registerModEntity(EntitySnowballRock.class, "snowballRock", 211, this, 64, 1, true);
        EntityRegistry.registerModEntity(EntityTorturedSoul.class, "torturedSoul", 212, this, 32, 1, true);
        EntityRegistry.registerModEntity(EntityDynamite.class, "dynamite", 213, this, 64, 1, true);
        EntityRegistry.registerModEntity(EntityDynamiteSnowball.class, "dynamiteSnowball", 214, this, 64, 1, true);
        EntityRegistry.registerModEntity(EntityCorruptedSoul.class, "corruptedSoul", 215, this, 32, 1, true);
        EntityRegistry.registerModEntity(EntityHelpfulSoul.class, "helpfulSoul", 216, this, 32, 1, true);
        EntityRegistry.registerModEntity(EntityPurifiedSoul.class, "purifiedSoul", 217, this, 64, 1, true);
        EntityRegistry.registerModEntity(EntityLoveLetter.class, "loveLetter", 218, this, 64, 1, true);
        EntityRegistry.registerModEntity(EntityHateMail.class, "hateMail", 219, this, 64, 1, true);
        EntityRegistry.registerModEntity(EntityTomahawk.class, "tomahawk", 220, this, 64, 1, true);
        EntityRegistry.registerModEntity(EntityThrowableSWT.class, "thrownItem", 221, this, 64, 1, true);

        EntityList.addMapping(EntityTorturedSoul.class, "tortured_soul", getUniqueEntityId(), 0x007f60, 0x1a4139);
        EntityList.addMapping(EntityCorruptedSoul.class, "corrupted_soul", getUniqueEntityId(), 0xb33c3c, 0x491818);
        EntityList.addMapping(EntityHelpfulSoul.class, "helpful_soul", getUniqueEntityId());

        if (StuffWorthThrowingConfig.spawnTorturedSouls) {
            EntityRegistry.addSpawn(EntityTorturedSoul.class, 1, 1, 1, EnumCreatureType.MONSTER, BiomeGenBase.swampland);
            EntityRegistry.addSpawn(EntityCorruptedSoul.class, 1, 1, 1, EnumCreatureType.MONSTER, BiomeGenBase.hell);
        }

        proxy.registerRenderers();
    }

    @SuppressWarnings("unchecked")
    public static int getUniqueEntityId() {
        do {
            startEntityId++;
        } while (EntityList.getStringFromID(startEntityId) != null);
        return startEntityId;
    }

}
