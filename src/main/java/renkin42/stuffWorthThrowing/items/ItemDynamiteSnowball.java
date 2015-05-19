package renkin42.stuffWorthThrowing.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import renkin42.stuffWorthThrowing.entities.EntityDynamiteSnowball;

public class ItemDynamiteSnowball extends ItemNormal {

    public ItemDynamiteSnowball(String unlocalizedName) {
        super(unlocalizedName);
        setMaxStackSize(16);
        setCreativeTab(CreativeTabs.tabMisc);
    }

    /**
     * Called whenever this item is equipped and the right mouse button is
     * pressed. Args: itemStack, world, entityPlayer
     */
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
        if (!par3EntityPlayer.capabilities.isCreativeMode) {
            --par1ItemStack.stackSize;
        }

        par2World.playSoundAtEntity(par3EntityPlayer, "game.tnt.primed", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

        if (!par2World.isRemote) {
            par2World.spawnEntityInWorld(new EntityDynamiteSnowball(par2World, par3EntityPlayer));
        }

        return par1ItemStack;
    }

}
