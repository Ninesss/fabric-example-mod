package net.nines.tutorialmod.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.LiteralText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/**
 * @Auther:Nines
 * @Date：2021/11/22 10:48
 */
public class StatusBlock extends Block {

    public StatusBlock(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos,
                              PlayerEntity player, Hand hand, BlockHitResult hit) {
        if(!world.isClient()){
            if(hand == Hand.MAIN_HAND){
                BlockPos playerBlockPos = player.getBlockPos();
                player.sendMessage(new LiteralText("SERVER: You are " + player.getDisplayName().getString()
                        + "at Position (" + playerBlockPos.getX() + ", " + playerBlockPos.getY() + ", " + playerBlockPos.getZ() + ")")
                        ,false);
            }
        } else {
            if (hand == Hand.MAIN_HAND) {
                player.sendMessage(new LiteralText("CLIENT: This is the Client! Main Hand!"), false);
            } else {
                player.sendMessage(new LiteralText("CLIENT: This is the Client! Off Hand!"), false);
            }
        }
        return super.onUse(state, world, pos, player, hand, hit);
    }
}
