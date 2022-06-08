package pepjebs.complete_bone_meal.interfc;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;

public interface CoralFeatureMixinInterface {

    boolean generateForBlockState(
            StructureWorldAccess structureWorldAccess,
            Random random,
            BlockPos blockPos,
            BlockState blockState
    );

}
