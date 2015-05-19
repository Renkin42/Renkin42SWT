package renkin42.stuffWorthThrowing.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import renkin42.stuffWorthThrowing.StuffWorthThrowingConfig;
import renkin42.stuffWorthThrowing.entities.EntityThrowableSWT;

public class ItemThrowableSWT extends ItemNormal {
    
    private final int itemType;
    private final int effect;
    private final int effect2;
    private final String particle;

    /**
     * Used for generic throwable items. 
     * 
     * @param unlocalizedName = the item's unlocalized name
     * @param itemType = 0 for spawning souls, 1 for dual-effect items, 2 for normal 
     * debuffs, 3 for flaming bricks, 4 for bricks, 5 for rocks, 6 for buffs
     * @param effect = Potion effect. Use 0 for no effect 
     * @param effect2 = Second Potion effect, Use 0 for none. 
     * @param particle = Particle type spawned on impact
     * @param tab = Creative tab in which to place this item.
     */
    public ItemThrowableSWT(String unlocalizedName, int itemType, int effect, int effect2, String particle, CreativeTabs tab) {
        super(unlocalizedName);
        this.itemType = itemType;
        this.effect = effect;
        this.effect2 = effect2;
        this.particle = particle;
        setMaxStackSize(16);
        setCreativeTab(tab);
    }

    /**
     * Called whenever this item is equipped and the right mouse button is
     * pressed. Args: itemStack, world, entityPlayer
     */
    @Override
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
        if (StuffWorthThrowingConfig.itemsThrowable) {
            if (!par3EntityPlayer.capabilities.isCreativeMode) {
                --par1ItemStack.stackSize;
            }

            par2World.playSoundAtEntity(par3EntityPlayer, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

            if (!par2World.isRemote) {
                par2World.spawnEntityInWorld(new EntityThrowableSWT(par2World, par3EntityPlayer, this.name, this.itemType, this.effect, this.effect2, this.particle));
            }

        }

        return par1ItemStack;
    }

}
