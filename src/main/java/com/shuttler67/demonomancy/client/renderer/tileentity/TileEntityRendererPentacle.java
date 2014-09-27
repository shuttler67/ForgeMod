package com.shuttler67.demonomancy.client.renderer.tileentity;

import com.shuttler67.demonomancy.client.renderer.model.ModelPentacle;
import com.shuttler67.demonomancy.reference.Textures;
import com.shuttler67.demonomancy.tileentity.TileEntityPentacle;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

import static org.lwjgl.opengl.GL11.*;

public class TileEntityRendererPentacle extends TileEntitySpecialRenderer  {

    ModelPentacle modelPentacle = new ModelPentacle();
    @Override
    public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float tick) {

        if (tileEntity instanceof TileEntityPentacle)
        {
            TileEntityPentacle tileEntityPentacle = (TileEntityPentacle) tileEntity;

            if (tileEntityPentacle.level == 1)
                this.bindTexture(Textures.Model.PENTACLE_LEVEL1);

            else if (tileEntityPentacle.level == 2)
                this.bindTexture(Textures.Model.PENTACLE_LEVEL2);

            else if (tileEntityPentacle.level == 3)
                this.bindTexture(Textures.Model.PENTACLE_LEVEL3);

            else if (tileEntityPentacle.level == 4)
                this.bindTexture(Textures.Model.PENTACLE_LEVEL4);

            else if (tileEntityPentacle.level == 5)
                this.bindTexture(Textures.Model.PENTACLE_LEVEL5);
            else
                this.bindTexture(Textures.BLANK);

            glPushMatrix();

            glTranslatef((float) x + 0.5f, (float) y, (float) z + 0.5f);
            glRotatef(-tileEntityPentacle.getBlockMetadata() * 90, 0, 1, 0);

            modelPentacle.render(tileEntityPentacle.getPentacleSize(), tileEntityPentacle.getPentacleX(), tileEntityPentacle.getPentacleY(), 0.0625f);

            if (tileEntityPentacle.isCenter) {

                this.bindTexture(Textures.Model.PENTACLE_CENTER);
                modelPentacle.render(0.0625f);
            }

            glPopMatrix();
        }

    }
}
