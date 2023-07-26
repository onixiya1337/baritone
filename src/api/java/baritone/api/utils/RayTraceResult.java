/*
 * This file is part of Baritone.
 *
 * Baritone is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Baritone is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Baritone.  If not, see <https://www.gnu.org/licenses/>.
 */

package baritone.api.utils;

import com.sun.javafx.geom.Vec3d;
import net.minecraft.entity.Entity;
import baritone.api.utils.BlockPos;
import net.minecraft.util.EnumFacing;

public class RayTraceResult
{
    private BlockPos blockPos;
    public Type typeOfHit;
    public EnumFacing sideHit;
    public Vec3d hitVec;
    public Entity entityHit;

    public RayTraceResult(Vec3d hitVecIn, EnumFacing sideHitIn, BlockPos blockPosIn)
    {
        this(Type.BLOCK, hitVecIn, sideHitIn, blockPosIn);
    }

    public RayTraceResult(Vec3d hitVecIn, EnumFacing sideHitIn)
    {
        this(Type.BLOCK, hitVecIn, sideHitIn, BlockPos.ORIGIN);
    }

    public RayTraceResult(Entity entityIn)
    {
        this(entityIn, new Vec3d(entityIn.posX, entityIn.posY, entityIn.posZ));
    }

    public RayTraceResult(Type typeIn, Vec3d hitVecIn, EnumFacing sideHitIn, BlockPos blockPosIn)
    {
        this.typeOfHit = typeIn;
        this.blockPos = blockPosIn;
        this.sideHit = sideHitIn;
        this.hitVec = new Vec3d(hitVecIn.x, hitVecIn.y, hitVecIn.z);
    }

    public RayTraceResult(Entity entityHitIn, Vec3d hitVecIn)
    {
        this.typeOfHit = Type.ENTITY;
        this.entityHit = entityHitIn;
        this.hitVec = hitVecIn;
    }

    public BlockPos getBlockPos()
    {
        return this.blockPos;
    }

    public String toString()
    {
        return "HitResult{type=" + this.typeOfHit + ", blockpos=" + this.blockPos + ", f=" + this.sideHit + ", pos=" + this.hitVec + ", entity=" + this.entityHit + '}';
    }

    public static enum Type
    {
        MISS,
        BLOCK,
        ENTITY;
    }
}