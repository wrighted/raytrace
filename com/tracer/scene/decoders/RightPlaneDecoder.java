package com.tracer.scene.decoders;

import com.tracer.scene.SceneBuilder;

import java.util.StringTokenizer;

public class RightPlaneDecoder extends AbstractDecoder{

    @Override
    public SceneBuilder decode(final StringTokenizer parts, final SceneBuilder sceneBuilder) {
        final float right = parseFloat(parts);
        return sceneBuilder.withRightPlane(right);
    }
}
