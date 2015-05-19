package renkin42.stuffWorthThrowing.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.potion.Potion;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;
import renkin42.stuffWorthThrowing.StuffWorthThrowing;

public class StuffWorthThrowingItems {

    public static ItemNormal sandPile;
    public static ItemNormal soulSandPile;
    public static ItemNormal rock;
    public static ItemNormal snowballRock;
    public static ItemNormal ectoplasm;
    public static ItemNormal spectralBrick;
    public static ItemNormal brokenBrick;
    public static ItemNormal brokenNetherBrick;
    public static ItemNormal brokenSpectralBrick;
    public static ItemNormal dynamite;
    public static ItemNormal dynamiteSnowball;
    public static ItemNormal fungusSpore;
    public static ItemNormal corruptedEctoplasm;
    public static ItemNormal corruptedSpectralBrick;
    public static ItemNormal brokenCSBrick;
    public static ItemNormal purifiedSoul;
    public static ItemNormal swiftDust;
    public static ItemNormal shineDust;
    public static ItemNormal loveLetter;
    public static ItemNormal hateMail;
    public static ItemNormal tomahawkWooden;
    public static ItemNormal tomahawkStone;
    public static ItemNormal tomahawkIron;
    public static ItemNormal tomahawkGold;
    public static ItemNormal tomahawkDiamond;
    
    public static void registerItems() {
        sandPile = new ItemThrowableSWT("sandPile", 2, Potion.blindness.getId(), 0, "crit", CreativeTabs.tabMaterials);
        soulSandPile = new ItemThrowableSWT("soulSandPile", 0, Potion.blindness.getId(), Potion.wither.getId(), "magicCrit", CreativeTabs.tabMaterials);
        rock = new ItemThrowableSWT("rock", 5, 0, 0, "smoke", CreativeTabs.tabMaterials);
        snowballRock = new ItemSnowballRock("snowballRock");
        ectoplasm = new ItemNormal("ectoplasm");
        spectralBrick = new ItemNormal("spectralBrick");
        brokenBrick = new ItemThrowableSWT("brokenBrick", 4, 0, 0, "smoke", CreativeTabs.tabMisc);
        brokenNetherBrick = new ItemThrowableSWT("brokenNetherBrick", 3, 0, 0, "smoke", CreativeTabs.tabMisc);
        brokenSpectralBrick = new ItemThrowableSWT("brokenSpectralBrick", 4, 0, Potion.weakness.getId(), "smoke", CreativeTabs.tabMisc);
        dynamite = new ItemDynamite("dynamite");
        dynamiteSnowball = new ItemDynamiteSnowball("dynamiteSnowball");
        fungusSpore = new ItemThrowableSWT("fungusSpore", 1, Potion.poison.getId(), Potion.moveSlowdown.getId(), "magicCrit", CreativeTabs.tabMisc);
        corruptedEctoplasm = new ItemNormal("corruptedEctoplasm");
        corruptedSpectralBrick = new ItemNormal("corruptedSpectralBrick");
        brokenCSBrick = new ItemThrowableSWT("brokenCSBrick", 4, Potion.wither.getId(), 0, "crit", CreativeTabs.tabMisc);
        purifiedSoul = new ItemPurifiedSoul("purifiedSoul");
        swiftDust = new ItemThrowableSWT("swiftDust", 6, Potion.moveSpeed.getId(), 0, "magicCrit", CreativeTabs.tabMisc);
        shineDust = new ItemThrowableSWT("shineDust", 6, Potion.nightVision.getId(), 0, "crit", CreativeTabs.tabMisc);
        loveLetter = new ItemLoveLetter("loveLetter");
        hateMail = new ItemHateMail("hateMail");
        tomahawkWooden = new ItemTomahawk("tomahawkWood", (byte) 5, 59);
        tomahawkStone = new ItemTomahawk("tomahawkStone", (byte) 7, 131);
        tomahawkIron = new ItemTomahawk("tomahawkIron", (byte) 9, 250);
        tomahawkGold = new ItemTomahawk("tomahawkGold", (byte) 10, 32);
        tomahawkDiamond = new ItemTomahawk("tomahawkDiamond", (byte) 13, 1561);
        
        GameRegistry.registerItem(sandPile, sandPile.name);
        GameRegistry.registerItem(soulSandPile, soulSandPile.name);
        GameRegistry.registerItem(rock, rock.name);
        GameRegistry.registerItem(snowballRock, snowballRock.name);
        GameRegistry.registerItem(ectoplasm, ectoplasm.name);
        GameRegistry.registerItem(spectralBrick, spectralBrick.name);
        GameRegistry.registerItem(brokenBrick, brokenBrick.name);
        GameRegistry.registerItem(brokenNetherBrick, brokenNetherBrick.name);
        GameRegistry.registerItem(brokenSpectralBrick, brokenSpectralBrick.name);
        GameRegistry.registerItem(dynamite, dynamite.name);
        GameRegistry.registerItem(dynamiteSnowball, dynamiteSnowball.name);
        GameRegistry.registerItem(fungusSpore, fungusSpore.name);
        GameRegistry.registerItem(corruptedEctoplasm, corruptedEctoplasm.name);
        GameRegistry.registerItem(corruptedSpectralBrick, corruptedSpectralBrick.name);
        GameRegistry.registerItem(brokenCSBrick, brokenCSBrick.name);
        GameRegistry.registerItem(purifiedSoul, purifiedSoul.name);
        GameRegistry.registerItem(swiftDust, swiftDust.name);
        GameRegistry.registerItem(shineDust, shineDust.name);
        GameRegistry.registerItem(loveLetter, loveLetter.name);
        GameRegistry.registerItem(hateMail, hateMail.name);
        GameRegistry.registerItem(tomahawkWooden, tomahawkWooden.name);
        GameRegistry.registerItem(tomahawkStone, tomahawkStone.name);
        GameRegistry.registerItem(tomahawkIron, tomahawkIron.name);
        GameRegistry.registerItem(tomahawkGold, tomahawkGold.name);
        GameRegistry.registerItem(tomahawkDiamond, tomahawkDiamond.name);
    }
    
    public static void registerItemModels() {
        registerSWTItemModel(sandPile);
        registerSWTItemModel(soulSandPile);
        registerSWTItemModel(rock);
        registerSWTItemModel(snowballRock);
        registerSWTItemModel(ectoplasm);
        registerSWTItemModel(spectralBrick);
        registerSWTItemModel(brokenBrick);
        registerSWTItemModel(brokenNetherBrick);
        registerSWTItemModel(brokenSpectralBrick);
        registerSWTItemModel(dynamite);
        registerSWTItemModel(dynamiteSnowball);
        registerSWTItemModel(fungusSpore);
        registerSWTItemModel(corruptedEctoplasm);
        registerSWTItemModel(corruptedSpectralBrick);
        registerSWTItemModel(brokenCSBrick);
        registerSWTItemModel(purifiedSoul);
        registerSWTItemModel(swiftDust);
        registerSWTItemModel(shineDust);
        registerSWTItemModel(loveLetter);
        registerSWTItemModel(hateMail);
        registerSWTItemModel(tomahawkWooden);
        registerSWTItemModel(tomahawkStone);
        registerSWTItemModel(tomahawkIron);
        registerSWTItemModel(tomahawkGold);
        registerSWTItemModel(tomahawkDiamond);
    }
    
    private static void registerSWTItemModel(ItemNormal item) {
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(StuffWorthThrowing.MOD_ID + item.name, "inventory"));
    }

}
