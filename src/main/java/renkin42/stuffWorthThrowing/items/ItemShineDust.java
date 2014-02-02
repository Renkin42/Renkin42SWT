package renkin42.stuffWorthThrowing.items;

import renkin42.stuffWorthThrowing.StuffWorthThrowingConfig;
import renkin42.stuffWorthThrowing.entities.EntityShineDust;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemShineDust extends Item {

	public ItemShineDust(String unlocalizedName) {
		setMaxStackSize(16);
		setCreativeTab(CreativeTabs.tabMisc);
		setUnlocalizedName(unlocalizedName);
	}
	
	public void registerIcons(IIconRegister iconRegister) {
        itemIcon = iconRegister.registerIcon("renkin42swt:shineDust");
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
                par2World.spawnEntityInWorld(new EntityShineDust(par2World, par3EntityPlayer));
            }
        }

        return par1ItemStack;
    }

}
