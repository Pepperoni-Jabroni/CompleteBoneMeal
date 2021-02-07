package pepjebs.complete_bone_meal.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.block.Fertilizable;
import net.minecraft.block.NetherWartBlock;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Implements;
import org.spongepowered.asm.mixin.Interface;
import org.spongepowered.asm.mixin.Mixin;

import java.util.Random;

@Mixin(NetherWartBlock.class)
@Implements(@Interface(iface= Fertilizable.class, prefix = "fertilizable$"))
public class NetherWartBlockMixin {

    public boolean fertilizable$isFertilizable(BlockView world, BlockPos pos, BlockState state, boolean isClient) {
        return true;
    }

    public boolean fertilizable$canGrow(World world, Random random, BlockPos pos, BlockState state) {
        return true;
    }

    public void fertilizable$grow(ServerWorld world, Random random, BlockPos pos, BlockState state){
        int growth = random.nextInt(2) + 1;
        int currentAge = state.get(NetherWartBlock.AGE);
        state = state.with(NetherWartBlock.AGE, Math.min(currentAge + growth, 3));
        world.setBlockState(pos, state, 2);
    }
}