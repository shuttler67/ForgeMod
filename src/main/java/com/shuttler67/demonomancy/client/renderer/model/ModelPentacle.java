package com.shuttler67.demonomancy.client.renderer.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.PositionTextureVertex;
import net.minecraft.client.model.TexturedQuad;
import net.minecraft.client.renderer.Tessellator;

public class ModelPentacle extends ModelBase {

    public static final int textureWidth = 945;
    public static final int textureHeight = 945;
    private static final PositionTextureVertex[] vertices = {new PositionTextureVertex(8, 0.1F, 8, 0.0F, 8.0F), new PositionTextureVertex(-8, 0.1F, 8F, 0.0F, 0.0F), new PositionTextureVertex(-8, 0.1F, -8, 0.0F, 0.0F), new PositionTextureVertex(8, 0.1F, -8, 0.0F, 8.0F)};

    private TexturedQuad[][] threebythree;
    private TexturedQuad[][] fivebyfive;
    private TexturedQuad[][] sevenbyseven;
    private TexturedQuad[][] ninebynine;
    private TexturedQuad all;

    public ModelPentacle() {

        threebythree = new TexturedQuad[3][3];
        fivebyfive = new TexturedQuad[5][5];
        sevenbyseven = new TexturedQuad[7][7];
        ninebynine = new TexturedQuad[9][9];

        all = new TexturedQuad(vertices, 0, 0, textureWidth, textureHeight, textureWidth, textureHeight);
        all.flipFace();

        for (int size=3; size<=9; size += 2) {
            for (int x = 0; x < size; ++x) {
                for (int y = 0; y < size; ++y) {
                    TexturedQuad texturedQuad = new TexturedQuad(vertices, textureWidth/size * x, textureHeight/size * y, textureWidth/size * (x+1), textureHeight/size * (y+1), textureWidth, textureHeight);
                    texturedQuad.flipFace();

                    getListFromPentacleSize(size)[x][y] = texturedQuad;
                }
            }
        }
    }

    public void render( int pentacleSize ,int x, int y, float scale) {

        getListFromPentacleSize(pentacleSize)[x][y].draw(Tessellator.instance, scale);
    }

    public void render(float scale) {
        all.draw(Tessellator.instance, scale);
    }

    private TexturedQuad[][] getListFromPentacleSize( int pentacleSize) {
        if (pentacleSize == 3) {
            return threebythree;
        } else if (pentacleSize == 5) {
            return fivebyfive;
        } else if (pentacleSize == 7) {
            return sevenbyseven;
        } else if (pentacleSize == 9) {
            return ninebynine;
        }
        return null;
    }

}
