package renkin42.stuffWorthThrowing.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import renkin42.stuffWorthThrowing.StuffWorthThrowing;

public class ItemNormal extends Item {

    public final String name;

    public ItemNormal(String unlocalizedName) {
        this.name = unlocalizedName;
        setMaxStackSize(64);
        setCreativeTab(CreativeTabs.tabMaterials);
        setUnlocalizedName(StuffWorthThrowing.MOD_ID + "_" + name);
    }

}
