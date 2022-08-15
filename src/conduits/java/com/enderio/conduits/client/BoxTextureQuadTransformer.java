package com.enderio.conduits.client;

import com.enderio.core.client.RenderUtil;
import com.mojang.math.Transformation;
import com.mojang.math.Vector3f;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.core.Vec3i;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraftforge.client.model.IQuadTransformer;
import net.minecraftforge.client.model.QuadTransformers;

public class BoxTextureQuadTransformer implements IQuadTransformer {

    private final Vec3i toSize;
    private final IQuadTransformer scaling;
    private final IQuadTransformer moveToCenter;
    public BoxTextureQuadTransformer(Vec3i toSize) {
        this.toSize = toSize;
        scaling = QuadTransformers.applying(new Transformation(null, null, new Vector3f(toSize.getX(), toSize.getY(), toSize.getZ()), null));
        moveToCenter = QuadTransformers.applying(new Transformation(new Vector3f(6.5f/16, 6.5f/16, 6.5f/16), null, null, null));
    }
    @Override
    public void processInPlace(BakedQuad quad) {
        scaling.processInPlace(quad);
        moveToCenter.processInPlace(quad);

    }

    private static TextureAtlas blockAtlas() {
        return Minecraft.getInstance().getModelManager().getAtlas(InventoryMenu.BLOCK_ATLAS);
    }

}
