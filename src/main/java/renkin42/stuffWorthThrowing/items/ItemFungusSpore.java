package renkin42.stuffWorthThrowing.items;

import renkin42.stuffWorthThrowing.StuffWorthThrowingConfig;
import renkin42.stuffWorthThrowing.entities.EntityFungusSpore;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemFungusSpore extends Item {

	public ItemFungusSpore(int par1, String unlocalizedName) {
		super(par1);
		setMaxStackSize(16);
		setCreativeTab(CreativeTabs.tabMisc);
		setUnlocalizedName(unlocalizedName);
	}
	
	public void registerIcons(IconRegister iconRegister) {
        itemIcon = iconRegister.registerIcon("renkin42swt:fungusSpore");
	}
	
	/**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
        if (StuffWorthThrowingConfig.itemsThrowable) {
        	if (!par3EntityPlayer.capabilities.isCreativeMode)
            {
                --par1ItemStack.stackSize;
            }

            par2World.playSoundAtEntity(par3EntityPlayer, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

            if (!par2World.isRemote)
            {
                par2World.spawnEntityInWorld(new EntityFungusSpore(par2World, par3EntityPlayer));
            }
        }

        return par1ItemStack;
    }

}