package raytrace.scene.objects;

import Jama.Matrix;
import raytrace.scene.primitives.Ray;
import raytrace.scene.primitives.Vector;
import raytrace.scene.util.MyUtils;

import java.awt.*;

public abstract class AbstractSceneObject implements ISceneObject {

    protected AbstractSceneObject(final String name, final Color color, final Vector position, final Vector coefficients, final float specular) {
        mName = name;
        mColor = color;
        mPosition = position;
        mCoefficients = coefficients;
        mSpecular = specular;
    }

    private final String mName;
    private final Color mColor;
    private final Vector mPosition;
    private final Vector mCoefficients;
    private final float mSpecular;

    public Vector specularColour(final Ray light, final Vector intensity, final Matrix point) {
        final Matrix l = light.asVector();
        final Matrix n = normal(point);
        final Matrix r = n.times(2 * MyUtils.dot(n, l)).minus(l);
        final Matrix v = MyUtils.normalize(point.times(-1));

        return intensity.times(mCoefficients.z()).times(Math.pow(Math.max(MyUtils.dot(r, v), 0), mSpecular)).times(255);
    }

    public Vector ambientColour() {
        return new Vector(mColor).times(mCoefficients.x());
    }

    public Vector diffuseColour(final Ray light, final Matrix point, final Vector intensity) {
        final Matrix l = light.asVector();
        final Matrix n = normal(point);
        final double dot  = Math.max(MyUtils.dot(n, l), 0);

        return new Vector(mColor).times(intensity).times(dot).times(mCoefficients.y());
    }
}