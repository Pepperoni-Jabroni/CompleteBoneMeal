package pepjebs.complete_bone_meal.interfc;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.StructureWorldAccess;

import java.util.Random;

public interface CoralFeatureMixinInterface {

    boolean generateForBlockState(
            StructureWorldAccess structureWorldAccess,
            Random random,
            BlockPos blockPos,
            BlockState blockState
    );

}
