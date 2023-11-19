package scene.decoders;

import scene.primitives.Resolution;
import scene.SceneBuilder;

import java.util.StringTokenizer;

public class ResolutionDecoder extends AbstractDecoder {

    @Override
    public SceneBuilder decode(final StringTokenizer parts, final SceneBuilder sceneBuilder) {
        final int rows = parseInt(parts);
        final int columns = parseInt(parts);

        return sceneBuilder.withResolution(new Resolution(rows, columns));
    }
}