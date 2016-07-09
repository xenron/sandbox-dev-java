package hjapp.com.alipay.android.app;

import android.os.Binder;
import android.os.Parcel;

public abstract class IAliPay$Stub extends Binder
  implements IAliPay
{
  public IAliPay$Stub()
  {
    attachInterface(this, "IAliPay");
  }

  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    switch (paramInt1)
    {
    default:
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902:
      paramParcel2.writeString("IAliPay");
      return true;
    case 1:
      paramParcel1.enforceInterface("IAliPay");
      paramParcel1.readString();
      paramParcel1.readString();
      paramParcel1.readString();
      String str2 = a();
      paramParcel2.writeNoException();
      paramParcel2.writeString(str2);
      return true;
    case 2:
      paramParcel1.enforceInterface("IAliPay");
      String str1 = b();
      paramParcel2.writeNoException();
      paramParcel2.writeString(str1);
      return true;
    case 3:
      paramParcel1.enforceInterface("IAliPay");
      IRemoteServiceCallback.Stub.a(paramParcel1.readStrongBinder());
      paramParcel2.writeNoException();
      return true;
    case 4:
    }
    paramParcel1.enforceInterface("IAliPay");
    IRemoteServiceCallback.Stub.a(paramParcel1.readStrongBinder());
    paramParcel2.writeNoException();
    return true;
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     IAliPay.Stub
 * JD-Core Version:    0.6.2
 */