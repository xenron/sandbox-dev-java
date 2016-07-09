package hjapp.com.hjclass_mobile.view;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.Transformation;

public final class j extends Animation
{
  private final float a;
  private final float b;
  private final float c;
  private final float d;
  private Camera e;

  public j(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.a = paramFloat1;
    this.b = paramFloat2;
    this.c = paramFloat3;
    this.d = paramFloat4;
  }

  protected final void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    float f1 = this.a;
    float f2 = f1 + paramFloat * (this.b - f1);
    float f3 = this.c;
    float f4 = this.d;
    Camera localCamera = this.e;
    Matrix localMatrix = paramTransformation.getMatrix();
    localCamera.save();
    localCamera.rotateY(f2);
    localCamera.getMatrix(localMatrix);
    localCamera.restore();
    localMatrix.preTranslate(-f3, -f4);
    localMatrix.postTranslate(f3, f4);
  }

  public final void initialize(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.initialize(paramInt1, paramInt2, paramInt3, paramInt4);
    this.e = new Camera();
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     j
 * JD-Core Version:    0.6.2
 */