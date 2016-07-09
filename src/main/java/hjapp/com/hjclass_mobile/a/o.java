package hjapp.com.hjclass_mobile.a;

import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public final class o
{
  public static String a(String paramString1, String paramString2)
  {
    try
    {
      PKCS8EncodedKeySpec localPKCS8EncodedKeySpec = new PKCS8EncodedKeySpec(a.a(paramString2));
      PrivateKey localPrivateKey = KeyFactory.getInstance("RSA").generatePrivate(localPKCS8EncodedKeySpec);
      Signature localSignature = Signature.getInstance("SHA1WithRSA");
      localSignature.initSign(localPrivateKey);
      localSignature.update(paramString1.getBytes("utf-8"));
      String str = a.a(localSignature.sign());
      return str;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }

  public static boolean a(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      PublicKey localPublicKey = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(a.a(paramString3)));
      Signature localSignature = Signature.getInstance("SHA1WithRSA");
      localSignature.initVerify(localPublicKey);
      localSignature.update(paramString1.getBytes("utf-8"));
      boolean bool = localSignature.verify(a.a(paramString2));
      return bool;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return false;
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     o
 * JD-Core Version:    0.6.2
 */