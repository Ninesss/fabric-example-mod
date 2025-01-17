package net.nines.tutorialmod.item.custom;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.nines.tutorialmod.util.ModTags;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Objects;

/**
 * @Auther:Nines
 * @Date：2021/11/21 23:21
 */
public class DowsingRodItem extends Item {
    public DowsingRodItem(Settings settings){
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        if(context.getWorld().isClient){
            BlockPos positionClicked = context.getBlockPos();
            PlayerEntity player = Objects.requireNonNull(context.getPlayer());
            boolean foundBlock = false;

            for(int i = 0; i <= positionClicked.getY(); i++){
                Block blockBelow = context.getWorld().getBlockState(positionClicked.down(i)).getBlock();
                if(isValuableBlock(blockBelow)){
                    outputValuableCoordinates(blockBelow, positionClicked.add(0,-i,0), player);
                    foundBlock = true;
                    break;
                }
            }
            if(!foundBlock){
                player.sendMessage(new LiteralText("Didn't find any valuable below"), false);
            }
        }
        context.getStack().damage(1, context.getPlayer(),
                (player) -> player.sendToolBreakStatus(player.getActiveHand()));
        return super.useOnBlock(context);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if(Screen.hasShiftDown()){
       } else{
            tooltip.add(new TranslatableText("tooltip.tutorialmod.dowsing_rod"));
        }

        super.appendTooltip(stack, world, tooltip, context);
    }

    private boolean isValuableBlock(Block block){
        return block.getDefaultState().isIn(ModTags.Blocks.VALUABLE_BLOCKS);
    }

    private void outputValuableCoordinates(Block blockFound, BlockPos pos, PlayerEntity player){
        player.sendMessage(new LiteralText("Found"
                + blockFound.asItem().getName().getString() + "at ("
                + pos.getX() + "," + pos.getY() + "," + pos.getZ() + ")"), false);
    }
}
