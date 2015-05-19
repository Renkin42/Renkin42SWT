package renkin42.stuffWorthThrowing.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import renkin42.stuffWorthThrowing.entities.EntityTomahawk;

public class ItemTomahawk extends ItemNormal {

    private final byte strength;

    public ItemTomahawk(String unlocalizedName, byte strength, int maxDamage) {
        super(unlocalizedName);
        this.strength = strength;
        setMaxStackSize(1);
        setCreativeTab(CreativeTabs.tabCombat);
        setMaxDamage(maxDamage);
    }

    @Override
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
        int damage = par1ItemStack.getItemDamage();
        if (!par3EntityPlayer.capabilities.isCreativeMode) {
            --par1ItemStack.stackSize;
        }

        par2World.playSoundAtEntity(par3EntityPlayer, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

        if (!par2World.isRemote) {
            par2World.spawnEntityInWorld(new EntityTomahawk(par2World, par3EntityPlayer, this.strength, this.name, damage, this));
        }

        return par1ItemStack;
    }

}
