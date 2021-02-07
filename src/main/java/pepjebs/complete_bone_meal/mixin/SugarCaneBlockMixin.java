package pepjebs.complete_bone_meal.mixin;

import net.minecraft.block.*;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Implements;
import org.spongepowered.asm.mixin.Interface;
import org.spongepowered.asm.mixin.Mixin;

import java.util.Random;

@Mixin(SugarCaneBlock.class)
@Implements(@Interface(iface= Fertilizable.class, prefix = "fertilizable$"))
public class SugarCaneBlockMixin {

    public boolean fertilizable$isFertilizable(BlockView world, BlockPos pos, BlockState state, boolean isClient) {
        return true;
    }

    public boolean fertilizable$canGrow(World world, Random random, BlockPos pos, BlockState state) {
        BlockPos topMostSugarCane = getTopMostSugarCane(world, pos);
        return world.getBlockState(topMostSugarCane.add(0,1,0)).isAir() &&
                world.getBlockState(topMostSugarCane.add(0,2,0)).isAir();
    }

    public void fertilizable$grow(ServerWorld world, Random random, BlockPos pos, BlockState state){
        BlockPos topMostSugarCane = getTopMostSugarCane(world, pos);
        for (int i = 1; i < 3; i++) {
            world.setBlockState(topMostSugarCane.add(0,i,0), Blocks.SUGAR_CANE.getDefaultState());
        }
    }

    private BlockPos getTopMostSugarCane(World world, BlockPos currentSugarCane) {
        if (world.getBlockState(currentSugarCane.add(0,1,0)).isAir()) {
            return currentSugarCane;
        }
        BlockPos topMostCactus = null;
        while (topMostCactus == null) {
            BlockPos oneAbove = currentSugarCane.add(0,1,0);
            if (world.getBlockState(oneAbove).getBlock() instanceof SugarCaneBlock) {
                currentSugarCane = oneAbove;
            } else {
                topMostCactus = currentSugarCane;
            }
        }
        return topMostCactus;
    }
}
