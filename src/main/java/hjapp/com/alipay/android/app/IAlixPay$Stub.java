package hjapp.com.alipay.android.app;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class IAlixPay$Stub extends Binder
  implements IAlixPay
{
  public IAlixPay$Stub()
  {
    attachInterface(this, "IAlixPay");
  }

  public static IAlixPay a(IBinder paramIBinder)
  {
    if (paramIBinder == null)
      return null;
    IInterface localIInterface = paramIBinder.queryLocalInterface("IAlixPay");
    if ((localIInterface != null) && ((localIInterface instanceof IAlixPay)))
      return (IAlixPay)localIInterface;
    return new a(paramIBinder);
  }

  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    switch (paramInt1)
    {
    default:
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902:
      paramParcel2.writeString("IAlixPay");
      return true;
    case 1:
      paramParcel1.enforceInterface("IAlixPay");
      String str2 = a(paramParcel1.readString());
      paramParcel2.writeNoException();
      paramParcel2.writeString(str2);
      return true;
    case 2:
      paramParcel1.enforceInterface("IAlixPay");
      String str1 = a();
      paramParcel2.writeNoException();
      paramParcel2.writeString(str1);
      return true;
    case 3:
      paramParcel1.enforceInterface("IAlixPay");
      a(IRemoteServiceCallback.Stub.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 4:
    }
    paramParcel1.enforceInterface("IAlixPay");
    b(IRemoteServiceCallback.Stub.a(paramParcel1.readStrongBinder()));
    paramParcel2.writeNoException();
    return true;
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     IAlixPay.Stub
 * JD-Core Version:    0.6.2
 */